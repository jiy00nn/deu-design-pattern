/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.UUID;
public interface Observer {
    public void update(UUID id, String title, String genre,String author,String status,int count); //주체에서 데이터의 변경사항을 전달 받기 위한 메서드
}
