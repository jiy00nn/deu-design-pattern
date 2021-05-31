/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import dao.CheckoutBookDao;
import dto.BookDto;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author wndgk
 */
public interface Status {
    BookDao bookdao = new BookDao();
    BookDto bookdto = new BookDto();
    BookController bookcontroller = new BookController(bookdto, bookdao);
    CheckoutBookDao chekout = new CheckoutBookDao();
    public boolean status(UUID user_number, UUID book_id, Date rental_date, Date return_date);
}
