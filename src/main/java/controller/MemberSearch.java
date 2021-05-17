/**
 * @packageName     : controller
 * @filewName       : MemberSearch.java
 * @author          : Junghan Park
 * @date            : 2021.05.17
 * @description     : Strategy 패턴 설계.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.17       Junghan Park   search() 매개변수 추가 및 내용 수정
 */
package controller;

public class MemberSearch implements SearchStrategy{
    @Override
    public void search(String id, String name){
        MemberSearchIterator msearchiterator = new MemberSearchIterator(id, name);
        IteratorMemberSearch iteratormembersearch = new IteratorMemberSearch(msearchiterator);
        iteratormembersearch.printList();        
    }
}
