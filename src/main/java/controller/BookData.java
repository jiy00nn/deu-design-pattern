/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.*;
import dto.BookDto; 

public class BookData implements Subject {

  public BookData() {
    observers = new ArrayList<>();
  }

  private List<Observer> observers;
    private UUID id;
    private String title;
    private String genre;
    private String author;
    private String status;
    private int count;
  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    int index = observers.indexOf(o);
    if (index >= 0) {
      observers.remove(o);
    }
  }

  /**
   * 상태를 모든 observer 들에게 알려주는 역할을 한다.
   */
  @Override
  public void notifyObservers() {
    observers.stream()
        .forEach(observer -> observer.update(id,title,genre, author, status,count));
  }

  public void measurementsChanged() {
    notifyObservers();
  }


  public void setMeasurements(UUID id, String title, String genre,String author,String status,int count) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.status = status;
        this.count = count;
    measurementsChanged();
  }

}