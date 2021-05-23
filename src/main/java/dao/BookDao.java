
package dao;

import dto.BookDto;
import db.DBConnection;
import dto.UserDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookDao {
    private static BookDao bookDao;
    private final DBConnection db = DBConnection.getInstance();
    public ArrayList<BookDto> book = new ArrayList<>(); 
     public BookDao() {
          
    }
         public static BookDao getInstance(){
        if(bookDao == null){
            bookDao = new BookDao();
        }
        return bookDao;
    }
         
    public int UpdataData(int id, String title, String genre, String author, String status, int count ){ //추가기능
 
        int result = 0;
        Connection conn = db.connectDB();
        PreparedStatement pstm = null;
        ResultSet rs = null;
     
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO Book (id, title, genre, author, status,count) VALUES (?,?,?,?.?,?)");
        System.out.println(id);
        try{
            pstm = conn.prepareStatement(sql.toString());
            
             pstm.setInt(1, id);
             pstm.setString(2, title);
             pstm.setString(3, genre);
             pstm.setString(4, author);
             pstm.setString(5, status);
             pstm.setInt(6, count);

            result = pstm.executeUpdate();
            if (result > 0) {
                System.out.println(result + "개의 행이 추가되었습니다.");
            }else {
                System.out.println("실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
        return result;
    }
    
    
    
  public int ModifyBook(){
        int result = 0;
            Connection conn = db.connectDB();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        StringBuffer sql = new StringBuffer();
        Scanner sc= new Scanner(System.in);
      
        try{
            
            System.out.println("수정할 id를 입력하세요:");
            int modify_id=sc.nextInt();
            System.out.print("수정할 항목을 선택하세요. 1.제목 2.장르 3.저자 4.상태 5.수량");
            String input = sc.nextLine();
            switch(input){
            case "1":
            System.out.println("수정할 제목을 입력하세요:");
            String modify_title = sc.nextLine();
            sql.append("UPDATE Book SET title = ? WHERE id=?");
            pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, modify_title);
            pstm.setInt(2,modify_id);
            break;
            case "2":
            System.out.println("수정할 장르를 입력하세요:");
            String modify_genre = sc.nextLine();
            sql.append("UPDATE Book SET genre = ? WHERE id=?");
            pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, modify_genre);
            pstm.setInt(2,modify_id);
            break;
            case "3":
            System.out.println("수정할 저자를 입력하세요:");
            String modify_author = sc.nextLine();
            sql.append("UPDATE Book SET author = ? WHERE id=?");
            pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, modify_author);
            pstm.setInt(2,modify_id);
            break;
            case "4":
            System.out.println("수정할 상태를 입력하세요:");
            String modify_status = sc.nextLine();
            sql.append("UPDATE Book SET status = ? WHERE id=?");
            pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, modify_status);
            pstm.setInt(2,modify_id);
            break;
            case "5":
            System.out.println("수정할 수량을 입력하세요:");
            String modify_conut = sc.nextLine();
            sql.append("UPDATE Book SET count = ? WHERE id=?");
            pstm = conn.prepareStatement(sql.toString());
            pstm.setString(1, modify_conut);
            pstm.setInt(2,modify_id);
            break;
                 default:
            System.out.println("수정할 정보를 다시 확인하세요");
            break;
            }
            result = pstm.executeUpdate();
            if (result > 0) {
                System.out.println(result + "개의 행이 수정되었습니다.");
            }else {
                System.out.println("실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (pstm != null) try { pstm.close(); } catch(Exception e) {}
            if (conn != null) try { conn.close(); } catch(Exception e) {}
        }
        
        return result;
    }
  
}
  
  
  
  
  
  
  
  
  
  