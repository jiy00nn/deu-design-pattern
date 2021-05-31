/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


/**
 *
 * @author wndgk
 */
public class ManagingFactory {
    public Managing getManaging(String usertype){
        if(usertype == null){
            return null;
        }
        else if(usertype.equalsIgnoreCase("User")){
            Managing user = new User(usertype);            
            return user;
        }        
        return null;
    }
}
