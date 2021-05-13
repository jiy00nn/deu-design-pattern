/**
 * @packageName     : controller
 * @filewName       : UserController.java
 * @author          : Jiyoon Bak
 * @date            : 2021.05.07
 * @description     : 
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.01       JiYoon Bak      최초 생성
 * 2021.05.13       Junghan Park   Login, Signup 메소드 추가
 */
package controller;

import dto.UserDto;
import dao.UserDao;
import view.TestView;

/**
 * Controller 예시입니다..
 */
public class UserController {
    private UserDto userdto;
    private UserDao userdao;
    private TestView view;
    
    public UserController(UserDto userdto, UserDao userdao, TestView view) {
        this.userdto = userdto;
        this.userdao = userdao;
    }
    
    public void updateView(){
        view.printUserDetails(userdto);
    }
    
    public boolean Login(){
        boolean result = false;
        //입력받은 값과 데이터베이스의 값을 비교하기위한 for문
        for(int i = 0; i < userdao.user.size(); i++){
            if(userdto.getId().equals(userdao.user.get(i).getId()) && userdto.getPassword().equals(userdao.user.get(i).getPassword())){
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    public boolean Signup(){
        boolean result = true;
        int num = 1;
        
        if(!(userdao.user.isEmpty())){      //데이터베이스가 공백인지 확인하기 위한 조건문
            for(int i = 0; i < userdao.user.size(); i++){   //입력받은 아이디가 이미 사용중인지 확인하기 위한 for문
                if(userdto.getId().equals(userdao.user.get(i).getId())){
                    result = false;
                    System.out.println("This ID is already in use.");
                    break;
                }
            }
            if(result){     //입력받은 아이디가 사용가능한 아이디일 경우
                num = userdao.user.size() + 1;
                userdao.InputData(num, userdto.getId(), userdto.getPassword(), userdto.getName());
                System.out.println("Singup success");
            }
        }
        else{            //데이터베이스가 공백일 경우
            userdao.InputData(num, userdto.getId(), userdto.getPassword(), userdto.getName());
            System.out.println("Singup success");
        }
        
        return result;
    }
}
