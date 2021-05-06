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
public class BookManagement implements ManagementStrategy{
    @Override
    public void update(){
        System.out.println("Update book");
    }
    
    @Override
    public void modify(){
        System.out.println("Modify book");
    }
}
