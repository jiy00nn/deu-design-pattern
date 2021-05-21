/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author anime
 */
public class Client {
            public static void main(String[] args) {
        BookStatus book = new BookStatus();

        book.retu_button_pushed();  // 반응 없음
        book.rent_button_pushed();   //대출
        book.rent_button_pushed();   // 반응 없음
        book.retu_button_pushed();  // 반납
    }
}
