/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import dto.BookDto;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author wndgk
 */
public class BookStatus {   
    private Status statu;    
    
    public void setStatu(Status statu) {
        this.statu = statu;
    }
    
    public boolean status(UUID user_number, UUID book_id, Date rental_date, Date return_date){
        return statu.status(user_number,  book_id, rental_date, return_date);
    }
}
