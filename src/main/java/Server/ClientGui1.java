/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
 
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
 
public class ClientGui1 extends JFrame implements ActionListener {
 
    private static final long serialVersionUID = 1L;
    private JTextArea jta = new JTextArea(40, 25);
    private JTextField jtf = new JTextField(25);
    private ClientBackground1 client = new ClientBackground1();
    private static String nickName;
 
    public ClientGui1() {
 
        add(jta, BorderLayout.CENTER);
        add(jtf, BorderLayout.SOUTH);
        jtf.addActionListener(this);
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(800, 100, 400, 600);
        setTitle("클라이언트");
 
        client.setGui1(this);
        client.setNickname(nickName);
        client.connet();
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("당신의 닉네임부터 설정하세요 : ");
        nickName = scanner.nextLine();
        scanner.close();
 
        new ClientGui1();
 
    }
 
    @Override
   
    public void actionPerformed(ActionEvent e) {
        String msg = nickName + ":" + jtf.getText() + "\n";
        client.sendMessage(msg);
        jtf.setText("");
    }
 
    public void appendMsg(String msg) {
        jta.append(msg);
    }
 
}