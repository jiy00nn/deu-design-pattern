/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDao;
import dto.BookDto;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
/**
 *
 * @author wndgk
 */
public class BookSearchIterator implements SearchIterator{
    BookDao bookdao = new BookDao();
    ArrayList<BookDto> bookdtols = new ArrayList<>();
    String str;

    
    public BookSearchIterator(String str){
        this.str = str;      
        check(str);
    }
    
    public void check(String str){
        boolean result = false;
        for(int i = 0; i < bookdao.book.size(); i++){
            if(str.equals(bookdao.book.get(i).getTitle()) || str.equals(bookdao.book.get(i).getAuthor()) || str.equals(bookdao.book.get(i).getId().toString())){
                bookdtols.add(new BookDto(bookdao.book.get(i).getId(), bookdao.book.get(i).getTitle(), bookdao.book.get(i).getGenre(), bookdao.book.get(i).getAuthor(), bookdao.book.get(i).getStatus(), bookdao.book.get(i).getCount()));
                result = true;
            }    
        }        
        
        if(!result){
            JOptionPane.showMessageDialog(null, "일치하는 제목이 없습니다.");
        }
    }
    
    @Override 
    public Iterator search(){
        return bookdtols.iterator();
    }
}
