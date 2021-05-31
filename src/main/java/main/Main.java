/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.BookController;
import controller.BookRental;
import controller.BookStatus;
import controller.Managing;
import controller.ManagingFactory;
import controller.ReturnBook;
import controller.UserController;
import dao.BookDao;
import dao.UserDao;
import dto.BookDto;
import dto.UserDto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.UUID;
import view.TestView;

/**
 *
 * @author mkaid
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        BookRental rental = new BookRental();
        ReturnBook returnbook = new ReturnBook();
        BookStatus bookstatus = new BookStatus();
        BookDao bookdao = new BookDao();
        UserDao userdao = new UserDao();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        Date date = new Date(cal.getTimeInMillis());
        UUID userid = userdao.user.get(1).getUser_number();
        UUID bookid = bookdao.book.get(1).getId();        
              
//        System.out.println(date);
        cal.add(Calendar.DATE, +6);
        Date date2 = new Date(cal.getTimeInMillis());                
//        System.out.println(date2);
//        bookstatus.setStatu(rental);
//        bookstatus.status(userid, bookid, date, date2);
        bookstatus.setStatu(returnbook);
        bookstatus.status(userid, bookid, date, date2);
//        System.out.println(fm.format(date));
//        System.out.println(fm.format(date2));

        
    }
}
