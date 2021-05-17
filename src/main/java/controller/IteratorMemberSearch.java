/**
 * @packageName     : controller
 * @filewName       : IteratorMemberSearch.java
 * @author          : Junghan Park
 * @date            : 2021.05.17
 * @description     : Iterator 패턴 설계. 사용자 내용 출력을 위한 클래스
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.17       Junghan Park   최초 생성
 */
package controller;

import dto.UserDto;
import java.util.Iterator;

public class IteratorMemberSearch {
    SearchIterator msearchiterator;
    
    public IteratorMemberSearch(SearchIterator msearchiterator){
        this.msearchiterator = msearchiterator;
    }
    
    public void printList(){
        Iterator miterator = (Iterator) msearchiterator.search();
        System.out.println("User Info");
        System.out.println("==================");
        printList(miterator);
    }
    
    private void printList(Iterator iterator){
        while(iterator.hasNext()){
            UserDto userdto =  (UserDto) iterator.next();                
            System.out.println("User Number : " + userdto.getUserNumber());
            System.out.println("User ID : " + userdto.getId());
            System.out.println("User Name : " + userdto.getName());
            System.out.println("==================");
        }
    }
}
