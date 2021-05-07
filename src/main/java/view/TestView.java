/**
 * @packageName     : view
 * @filewName       : TestVeiw.java
 * @author          : Jiyoon Bak
 * @date            : 2021.05.07
 * @description     : MVC Pattern을 이용하기 위한 Test View이다.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.07       JiYoon Bak      최초 생성
 */
package view;

import dto.UserDto;

/**
 * MVC 패턴을 구현하기 위한 임시 View입니다.
 */
public class TestView {
    
    public TestView() {}
    
    public void printUserDetails(UserDto user){
        System.out.println("UserName : " + user.getName());
        System.out.println("UserID : " + user.getId());
    }
}
