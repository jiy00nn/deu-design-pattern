/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import dto.BookDto;
import java.util.UUID;

/**
 *
 * @author wndgk
 */
public class BookRental implements Status{
    BookDao bookdao = new BookDao();
    BookDto bookdto = new BookDto();       
    
    @Override
    public void status(){
        
    }
}
