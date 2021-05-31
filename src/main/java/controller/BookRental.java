/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author wndgk
 */
public class BookRental implements Status {

    @Override
    public boolean status(UUID user_number, UUID book_id, Date rental_date, Date return_date) {
        boolean result = false;
        
        if (!bookdao.book.isEmpty()) {
            for (int i = 0; i < bookdao.book.size(); i++) {
                if (bookdao.book.get(i).getId().toString().equals(book_id.toString())) {
                    if (bookdao.book.get(i).getStatus().equals("True")) {
                        bookdao.book.get(i).setStatus("False");
                        bookdao.book.get(i).setCount(0);
                        bookdao.UpdateData(bookdao.book.get(i).getId(), bookdao.book.get(i).getStatus(), bookdao.book.get(i).getCount());
                        result = true;                        
                        break;
                    }
                }
            }
            if (result) {
                chekout.InputData(user_number, book_id, rental_date, return_date);
                System.out.println("success to rental");
            }
        }
        return result;
    }
}
