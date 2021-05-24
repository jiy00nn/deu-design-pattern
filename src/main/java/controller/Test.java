/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dto.Bookdto;

public class Test {
    public static void main(String[] args) {
     BookDto bookDto=new BookDto();
     BookData bookData = new BookData();

    Manager_book manager_book=new Manager_book(bookData); //관리자
    Rent_book rent_book=new Rent_book(bookData); //대여
    Return_book return_book=new Return_book(bookData);//반납
    bookData.setMeasurements(bookDto.getId(),bookDto.getTitle(),bookDto.getGenre(),bookDto.getAuthor(),bookDto.getStatus(),bookDto.getCount());
    }
    
}