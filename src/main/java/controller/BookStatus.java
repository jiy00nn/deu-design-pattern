/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import dto.BookDto;
import java.util.UUID;
import view.TestView;

/**
 *
 * @author wndgk
 */
public class BookStatus {   
    private Status statu;    
    
    public void setStatu(Status statu) {
        this.statu = statu;
    }
    
    public void status(){
        statu.status();
    }
}
