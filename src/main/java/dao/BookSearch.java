/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author wndgk
 */
public class BookSearch implements SearchStrategy{
    @Override
    public void search(){
        System.out.println("Search book");
    }
}
