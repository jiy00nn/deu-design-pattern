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
    
    public UserController(UserDto userdto, TestView view) {
        this.userdto = userdto;
        this.userdao = userdao;
    }
    
    public void updateView(){
        view.printUserDetails(userdto);
    }
}
