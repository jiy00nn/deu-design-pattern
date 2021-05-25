package dao;

import dto.BookDto;
import java.util.Scanner;
/**
 *
 * @author wndgk
 */
public class BookManagement implements ManagementStrategy{
   
   
    @Override
    public void update(){
        System.out.println("Update book");
    //추가insert into 도서 기부받았을때 추가 하는 식
    }
    
 
    @Override
    public void modify(){
        BookDao bookDao = new BookDao();
        bookDao.ModifyBook();
        System.out.println("Modify book");//수정 update set//값이 있는지 확인
    }
}