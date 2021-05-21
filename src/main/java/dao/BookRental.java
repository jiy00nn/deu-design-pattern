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
public class BookRental implements Status {
        private static BookRental rent = new BookRental();

    public BookRental() {

    }

    // 싱글턴 적용
    public static BookRental getInstance() {
        return rent;
    }

    @Override
    public void rent_button_pushed(BookStatus book) {
        System.out.println("No Response");
    }

    @Override
    public void retu_button_pushed(BookStatus book) {
        book.setState(ReturnBook.getInstance());
        System.out.println("Return Book");
    }
}
