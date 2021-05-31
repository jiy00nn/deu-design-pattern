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
/**
 *
 * @author wndgk
 */
public class BookSearchIterator implements SearchIterator{
    BookDao bookdao = new BookDao();
    ArrayList<BookDto> bookdtols = new ArrayList<>();
    String id;
    String name;
    
    public BookSearchIterator(String id, String name){
        this.id = id;
        this.name = name;
        check(id, name);
    }
    
    public void check(String id, String name){
        for(int i = 0; i < bookdao.book.size(); i++){
            if(id.equals(bookdao.book.get(i).getTitle())){
                bookdtols.add(new BookDto(bookdao.book.get(i).getId(), bookdao.book.get(i).getTitle(), bookdao.book.get(i).getGenre(), bookdao.book.get(i).getAuthor(), bookdao.book.get(i).getStatus(), bookdao.book.get(i).getCount()));
            }    
        }        
    }
    
    @Override 
    public Iterator search(){
        return bookdtols.iterator();
    }
}
