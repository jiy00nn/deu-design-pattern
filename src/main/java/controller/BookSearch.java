/**
 * @packageName     : controller
 * @filewName       : BookSearch.java
 * @author          : Junghan Park
 * @date            : 2021.05.17
 * @description     : Strategy 패턴 설계.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.17       Junghan Park   search() 매개변수 추가
 */
package controller;

public class BookSearch implements SearchStrategy{
    @Override
    public void search(String id, String name){
        System.out.println("Search book");
    }
}
