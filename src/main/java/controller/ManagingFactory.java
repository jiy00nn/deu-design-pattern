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
            user.setSearchStrategy(new BookSearch());
            user.setManagementStrategy(new MemberManagement());
            return user;
        }
        else if(usertype.equalsIgnoreCase("Book Manager")){
            Managing bmanager = new Manager(usertype);
            bmanager.setSearchStrategy(new BookSearch());                
            bmanager.setManagementStrategy(new BookManagement());
            return bmanager;
        }     
        else if(usertype.equalsIgnoreCase("Member Manager")){
            Managing mmanager = new Manager(usertype);
            mmanager.setSearchStrategy(new MemberSearch());
            mmanager.setManagementStrategy(new MemberManagement());
            return mmanager;
        }     
        return null;
    }
}
