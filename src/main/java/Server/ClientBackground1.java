/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.ClientGui1;
import java.net.Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
 
public class ClientBackground1 {
 
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ClientGui1 gui;
    private String msg;
    private String nickName;
 
    public final void setGui1(ClientGui1 gui) {
        this.gui = gui;
    }
 
    public void connet() {
        try {
            socket = new Socket("192.168.42.1", 7777);
            System.out.println("서버 연결됨.");
 
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            out.writeUTF(nickName);
            System.out.println("클라이언트 : 메시지 전송완료");
            while (in != null) {
                msg = in.readUTF();
                gui.appendMsg(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connet();
    }
 
    public void sendMessage(String msg2) {
        try {
            out.writeUTF(msg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void setNickname(String nickName) {
        this.nickName = nickName;
    }
 
}

