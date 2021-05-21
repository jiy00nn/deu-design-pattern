package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


  import java.io.DataOutputStream;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author ysj62
 */
public class Client2{
    public static void main(String[] arg)
    {
        Socket socket = null;            //Server와 통신하기 위한 Socket
        DataInputStream in = null;        //Server로부터 데이터를 읽어들이기 위한 입력스트림
        BufferedReader in2 = null;        //키보드로부터 읽어들이기 위한 입력스트
        DataOutputStream out = null;    
        
        try {

            socket = new Socket("192.168.42.1",10002);    //서버로 접속
             System.out.print("서버 접속 완료");
            in = new DataInputStream(socket.getInputStream());            
            in2 = new BufferedReader(new InputStreamReader(System.in)); 
            out = new DataOutputStream(socket.getOutputStream());        

            //채팅에 사용 할 닉네임을 입력받음
            System.out.print("이름을 입력하세요 : ");
            String data = in2.readLine();            
            
            //서버로 닉네임을 전송
            out.writeUTF(data);               
            //사용자가 채팅 내용을 입력 및 서버로 전송하기 위한 쓰레드 생성 및 시작
            Thread th = new Thread(new Send(out));
            th.start();
        }catch(IOException e) {}
        try {
            //클라이언트의 메인 쓰레드는 서버로부터 데이터 읽어들이는 것만 반복.
            while(true)
            {
                String str2 = in.readUTF();        
                System.out.println(str2);
            }
        }catch(IOException e) {}
    }
}