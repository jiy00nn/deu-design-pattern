/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.BookDto;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import view.SEARCHBOOK;

/**
 *
 * @author wndgk
 */
public class IteratorBookSearch {

    SearchIterator bsearchiterator;
    ArrayList<BookDto> booklist = new ArrayList<>();
    SEARCHBOOK search = new SEARCHBOOK();

    public IteratorBookSearch(SearchIterator bsearchiterator) {
        this.bsearchiterator = bsearchiterator;
    }

    public ArrayList printList() {
        Iterator msiterator = (Iterator) bsearchiterator.search();
        System.out.println("Book Info");
        System.out.println("==================");
        printList(msiterator);        
        return booklist;                
    }

    private void printList(Iterator iterator) {             
        while (iterator.hasNext()) {
            BookDto bookdto = (BookDto) iterator.next();            
            booklist.add(new BookDto(bookdto.getId(), bookdto.getTitle(), bookdto.getGenre(), bookdto.getAuthor(), bookdto.getStatus(), bookdto.getCount()));                
//            booklist.add("제목 : " + bookdto.getTitle() + " 장르 : " + bookdto.getGenre() + " 저자 : " + bookdto.getAuthor() + " 대여여부 : " + bookdto.getStatus() + " 수량 : " + bookdto.getCount());                
//            System.out.println("Book Id : " + bookdto.getId().toString());
//            System.out.println("Book Title : " + bookdto.getTitle());
//            System.out.println("Book Genre : " + bookdto.getGenre());
//            System.out.println("Book Author : " + bookdto.getAuthor());
//            System.out.println("Book Status : " + bookdto.getStatus());
//            System.out.println("Book Count : " + bookdto.getCount());
//            System.out.println("==================");
        }
    }
}
