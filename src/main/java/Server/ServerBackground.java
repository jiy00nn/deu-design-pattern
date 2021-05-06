/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import Server.ServerGui;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
public class ServerBackground {

    private ServerSocket serverSocket;
    private Socket socket;
    private ServerGui gui;
    private String msg;
 

    private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();
 
    public final void setGui(ServerGui gui) {
        this.gui = gui;
    }
 
    public void setting() throws IOException {
        Collections.synchronizedMap(clientsMap); // 이걸 교통정리 해줍니다^^
        serverSocket = new ServerSocket(7777);
        while (true) {
            /** XXX 01. 첫번째. 서버가 할일 분담. 계속 접속받는것. */
            System.out.println("서버 대기중...");
            socket = serverSocket.accept(); // 먼저 서버가 할일은 계속 반복해서 사용자를 받는다.
            System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
           
            Receiver receiver = new Receiver(socket);
            receiver.start();
        }
    }
 
    public static void main(String[] args) throws IOException {
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
    }
 
    // 맵의내용(클라이언트) 저장과 삭제
    public void addClient(String nick, DataOutputStream out) throws IOException {
        sendMessage(nick + "님이 접속하셨습니다.");
        clientsMap.put(nick, out);
    }
 
    public void removeClient(String nick) {
        sendMessage(nick + "님이 나가셨습니다.");
        clientsMap.remove(nick);
    }
 
    // 메시지 내용 전파
    public void sendMessage(String msg) {
        Iterator<String> it = clientsMap.keySet().iterator();
        String key = "";
        while (it.hasNext()) {
            key = it.next();
            try {
                clientsMap.get(key).writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // -----------------------------------------------------------------------------
    class Receiver extends Thread {
        private DataInputStream in;
        private DataOutputStream out;
        private String nick;
 
        public Receiver(Socket socket) throws IOException {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            nick = in.readUTF();
            addClient(nick, out);
        }
 
        public void run() {
            try {
                while (in != null) {
                    msg = in.readUTF();
                    sendMessage(msg);
                    gui.appendMsg(msg);
                }
            } catch (IOException e) {
                removeClient(nick);
            }
        }
    }
}


