/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnection;
import dto.CheckoutBookDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wndgk
 */
public class CheckoutBookDao {
    private static CheckoutBookDao checkoutbookdao;
    private final DBConnection db = DBConnection.getInstance();
    public ArrayList<CheckoutBookDto> checkout = new ArrayList<>();     //데이터베이스에 들어있는 값들을 UserDto 객체형식으로 ArrayList에 저장하기 위한 ArrayList
    SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
    public CheckoutBookDao() {
        SelectData();       
    }
    
    public static CheckoutBookDao getInstance(){
        if(checkoutbookdao == null){
            checkoutbookdao = new CheckoutBookDao();
        }
        return checkoutbookdao;
    }
    
    
    public void SelectData(){       //데이터베이스에 입력되어있는 값을 ArrayList형식으로 불러오는 메소드
        Connection conn = db.connectDB();        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM CHECKOUTBOOK");
        
        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try{
            pstm = conn.prepareStatement(sql.toString());
            rs = pstm.executeQuery();
            
            while(rs.next()){
                checkout.add(new CheckoutBookDto(UUID.fromString(rs.getString("user_number")), UUID.fromString(rs.getString(2)), fm.parse(rs.getString(3)), fm.parse(rs.getString(4))));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException ex) {
            Logger.getLogger(CheckoutBookDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
    }
    
    public void InputData(UUID user_number, UUID book_id, Date rental_date, Date return_date){    //데이버베이스에 값을 입력하기 위한 메소드
        int result = 0;
        Connection conn = db.connectDB();
        // SQL구문을 실행시키는 기능을 갖는 객체
        PreparedStatement pstm = null;
        // 쿼리를 실행한 결과를 받을 수 있다.
        ResultSet rs = null;
        
        //SQL 문장 생성
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO CHECKOUTBOOK (user_number, book_id, rental_date, return_date) VALUES (?,?,?,?)");
        
        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try{
            pstm = conn.prepareStatement(sql.toString());
            
            pstm.setString(1, user_number.toString());
            pstm.setString(2, book_id.toString());
            pstm.setDate(3, new java.sql.Date(rental_date.getTime()));
            pstm.setDate(4, new java.sql.Date(return_date.getTime()));         
            
            result = pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
    }
    
    public void DeleteData(UUID user_number, UUID book_id){
        int result = 0;
        Connection conn = db.connectDB();
        // SQL구문을 실행시키는 기능을 갖는 객체
        PreparedStatement pstm = null;
        // 쿼리를 실행한 결과를 받을 수 있다.
        ResultSet rs = null;
        
        //SQL 문장 생성
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM CHECKOUTBOOK WHERE user_number = ? AND book_id = ?");
        
        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try{
            pstm = conn.prepareStatement(sql.toString());
            
            pstm.setString(1, user_number.toString());
            pstm.setString(2, book_id.toString());        
            
            
            result = pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
    }
    
    public void UpdateData(UUID user_number, UUID book_id, Date rental_date, Date return_date){
        int result = 0;
        Connection conn = db.connectDB();        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE CHECKOUTBOOK SET rental_date = ?, return_date = ? WHERE user_number =? AND bookid = ?");
        
        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try{
            pstm = conn.prepareStatement(sql.toString());            
            
            pstm.setString(1, rental_date.toString());
            pstm.setString(2, return_date.toString());
            pstm.setString(3, user_number.toString());
            pstm.setString(4, book_id.toString());
            
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
