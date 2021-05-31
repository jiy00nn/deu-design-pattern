/**
 * @packageName     : dao
 * @filewName       : UserDao.java
 * @author          : Jiyoon Bak
 * @date            : 2021.05.06
 * @description     : DB를 사용해 사용자 데이터를 조회하거나 조작한다.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.01       JiYoon Bak      최초 생성
 * 2021.05.13       Junghan Park   SelectData, Inputdata메소드 추가 ArrayList 추가
 */
package dao;

import dto.UserDto;
import db.DBConnection;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * DB를 사용해 User Table의 데이터를 조회하거나 조작하는 기능을 구현한 클래스
 */
public class UserDao {
    private static UserDao userDao;
    private final DBConnection db = DBConnection.getInstance();
    public ArrayList<UserDto> user = new ArrayList<>();     //데이터베이스에 들어있는 값들을 UserDto 객체형식으로 ArrayList에 저장하기 위한 ArrayList
    
    public UserDao() {
        SelectData();       
    }
    
    public static UserDao getInstance(){
        if(userDao == null){
            userDao = new UserDao();
        }
        return userDao;
    }
    
    /**
     * User 테이블에 데이터를 넣기 위한 메소드
     * DB 사용 예시를 위해 만든 메소드로 삭제해도 무방
     * @return result Insert문 성공시 1을 실패시 0을 반환
    **/
//    public int InsertData(UserDto user){
//        // result 수행 결과
//        int result = 0;
//        // DB 연결을 한 connection 객체
//        Connection conn = db.connectDB();
//        // SQL구문을 실행시키는 기능을 갖는 객체
//        PreparedStatement pstm = null;
//        // 쿼리를 실행한 결과를 받을 수 있다.
//        ResultSet rs = null;
//        
//        //SQL 문장 생성
//        StringBuffer sql = new StringBuffer();
//        sql.append("INSERT INTO USER (user_number, id, password, name) VALUES (?,?,?,?)");
//        
//        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
//        try{
//            pstm = conn.prepareStatement(sql.toString());
//            
//            pstm.setInt(1, user.getUserNumber());
//            pstm.setString(2, user.getId());
//            pstm.setString(3, user.getPassword());
//            pstm.setString(4, user.getName());
//            
//            result = pstm.executeUpdate();
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            if (rs != null) try { rs.close(); } catch(Exception e) {}
//            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
//            if (conn != null) try { conn.close(); } catch(Exception e) {}
//        }
//        
//        return result;
//    }
    
    public void SelectData(){       //데이터베이스에 입력되어있는 값을 ArrayList형식으로 불러오는 메소드
        Connection conn = db.connectDB();        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM USER");
        
        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try{
            pstm = conn.prepareStatement(sql.toString());
            rs = pstm.executeQuery();
            
            while(rs.next()){
                user.add(new UserDto(UUID.fromString(rs.getString("user_number")), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
    }
    
    public void InputData(UUID user_number, String id, String password, String name){    //데이버베이스에 값을 입력하기 위한 메소드
        int result = 0;
        Connection conn = db.connectDB();
        // SQL구문을 실행시키는 기능을 갖는 객체
        PreparedStatement pstm = null;
        // 쿼리를 실행한 결과를 받을 수 있다.
        ResultSet rs = null;
        
        //SQL 문장 생성
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO USER (user_number, id, password, name) VALUES (?,?,?,?)");
        
        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try{
            pstm = conn.prepareStatement(sql.toString());
            
            pstm.setString(1, user_number.toString());
            pstm.setString(2, id);
            pstm.setString(3, password);
            pstm.setString(4, name);
            
            result = pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
    }
    
    public void UpdateData(UUID user_number, String password, String name){
        int result = 0;
        Connection conn = db.connectDB();        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE USER SET password = ?, name = ? WHERE user_number =?");
        
        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try{
            pstm = conn.prepareStatement(sql.toString());            
            
            pstm.setString(1, password);
            pstm.setString(2, name);
            pstm.setString(3, user_number.toString());
            
           result = pstm.executeUpdate();                      
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
    }
}
