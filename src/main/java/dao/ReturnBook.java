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
public class ReturnBook implements Status {
        private static ReturnBook retu = new ReturnBook();

    private ReturnBook() {

    }

    // 싱글턴 적용
    public static ReturnBook getInstance() {
        return retu;
    }

    @Override
    public void rent_button_pushed(BookStatus book) {
        System.out.println("Rental Book");
        book.setState(BookRental.getInstance());
    }

    @Override
    public void retu_button_pushed(BookStatus book) {
        System.out.println("No Response");
    }
}
