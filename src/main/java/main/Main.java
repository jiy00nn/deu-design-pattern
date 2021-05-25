/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.BookController;
import controller.Managing;
import controller.ManagingFactory;
import controller.UserController;
import dao.BookDao;
import dao.UserDao;
import dto.BookDto;
import dto.UserDto;
import java.util.Scanner;
import java.util.UUID;
import view.TestView;

/**
 *
 * @author mkaid
 */
public class Main {

    public static void main(String[] args) {        
        BookDao bookdao = new BookDao();
        UserDao userdao = new UserDao();
//        BookDto bookdto= new BookDto(UUID.randomUUID(), "tiltle", "genre", "author", "status", 1);
//        
//        BookController bookcontrol = new BookController(bookdto, bookdao);
        
        bookdao.InputData(UUID.randomUUID(), "tiltle", "genre", "author", "status", 1);
        
    }
}
