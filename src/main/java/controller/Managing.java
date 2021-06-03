/**
 * @packageName     : controller
 * @filewName       : Managing.java
 * @author          : Junghan Park
 * @date            : 2021.05.17
 * @description     : Strategy 패턴 설계.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.17       Junghan Park   search() 매개변수 추가
 */
package controller;

import dao.UserDao;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author wndgk
 */
public abstract class Managing {
    private String name;
    
    ArrayList list = new ArrayList();
    public Managing(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public ArrayList Search(String str){
        BookSearchIterator booksearchiterator = new BookSearchIterator(str);
        IteratorBookSearch iteratorbooksearch = new IteratorBookSearch(booksearchiterator);
        list =iteratorbooksearch.printList();        
        return list;   
//        return searchStrategy.Search(id, name);
    }    
    
    public boolean modify(UUID id, String pw, String name){
        UserDao userdao = new UserDao();
        boolean result = false;
        for(int i = 0; i < userdao.user.size(); i++){
            if(userdao.user.get(i).getUser_number().toString().equals(id.toString())){
                userdao.UpdateData(id, pw, name);        
                result = true;
                break;
            }            
        }        
        return result;
    }       
}
