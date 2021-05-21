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
public class BookStatus {
    private Status status;

    // 생성자 : 형광등은 항상 꺼진 상태로 초기화
    public BookStatus() {
        status = ReturnBook.getInstance();
    }

    public void setState(Status status) {
        this.status = status;
    }

    // 켜짐 작업 위임
    public void rent_button_pushed() {
        status.rent_button_pushed(this);
    }

    // 꺼짐 작업 위임
    public void retu_button_pushed() {
        status.retu_button_pushed(this);
    }
}
