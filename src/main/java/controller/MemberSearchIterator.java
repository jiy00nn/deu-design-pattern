/**
 * @packageName     : controller
 * @filewName       : MemberSearchIterator.java
 * @author          : Junghan Park
 * @date            : 2021.05.17
 * @description     : Iterator 패턴 설계. 사용자 내용 저장
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.17       Junghan Park   최초 생성
 */
package controller;

import dao.UserDao;
import dto.UserDto;
import java.util.ArrayList;
import java.util.Iterator;

public class MemberSearchIterator implements SearchIterator{
    UserDao userdao = new UserDao();
    ArrayList<UserDto> userdtols = new ArrayList<>();
    String id;
    String name;
    
    public MemberSearchIterator(String id, String name){
        this.id = id;
        this.name = name;
        check(id, name);
    }
    
    public void check(String id, String name){      // 입력한 내용과 db내용 비교하여 일치하는 내용만 새로 저장
        for(int i = 0; i < userdao.user.size(); i++){
            if(id.equals(userdao.user.get(i).getId()) || name.equals(userdao.user.get(i).getName())){
                userdtols.add(new UserDto(userdao.user.get(i).getUserNumber(), userdao.user.get(i).getId(), userdao.user.get(i).getPassword(), userdao.user.get(i).getName()));
            }    
        }        
    }
    //새로 저장한 내용을 Iterator 형식으로 반환
    @Override 
    public Iterator search(){
        return userdtols.iterator();
    }
}
