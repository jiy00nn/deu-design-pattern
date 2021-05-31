
package dao;

import dto.BookDto;
import db.DBConnection;
import dto.UserDto;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class BookDao {

    private static BookDao bookDao;
    private final DBConnection db = DBConnection.getInstance();
    public ArrayList<BookDto> book = new ArrayList<>();
    public BookDao() {
        SelectData();
    }

    public static BookDao getInstance() {
        if (bookDao == null) {
            bookDao = new BookDao();
        }
        return bookDao;
    }
    
    // 책의 정보를 입력하기위한 메소드
    public void InputData(UUID id, String title, String genre, String author, String status, int count) { //추가기능        
        Connection conn = db.connectDB();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO BOOK (id, title, genre, author, status, count) VALUES (?,?,?,?,?,?)");
        try {
            pstm = conn.prepareStatement(sql.toString());

            pstm.setString(1, id.toString());
            pstm.setString(2, title);
            pstm.setString(3, genre);
            pstm.setString(4, author);
            pstm.setString(5, status);
            pstm.setInt(6, count);

            System.out.println(pstm);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (pstm != null) try {
                pstm.close();
            } catch (Exception e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }

    }
    
    // 책의 정보를 가져오기위한 베소드
    public void SelectData() {
        Connection conn = db.connectDB();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM BOOK");

        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try {
            pstm = conn.prepareStatement(sql.toString());
            rs = pstm.executeQuery();

            while (rs.next()) {
                book.add(new BookDto(UUID.fromString(rs.getString("id")), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (pstm != null) try {
                pstm.close();
            } catch (Exception e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
    
    // 책의 전체적인 정보를 수정하기위한 메소드
    public int ModifyBook() {
        int result = 0;

        Connection conn = db.connectDB();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        StringBuffer sql = new StringBuffer();
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("수정할 id를 입력하세요:");
            int modify_id = sc.nextInt();
            System.out.print("수정할 항목을 선택하세요. 1.제목 2.장르 3.저자 4.상태 5.수량");
            String input = sc.nextLine();
            switch (input) {
                case "1":
                    System.out.println("수정할 제목을 입력하세요:");
                    String modify_title = sc.nextLine();
                    sql.append("UPDATE Book SET title = ? WHERE id=?");
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.setString(1, modify_title);
                    pstm.setInt(2, modify_id);
                    break;
                case "2":
                    System.out.println("수정할 장르를 입력하세요:");
                    String modify_genre = sc.nextLine();
                    sql.append("UPDATE Book SET genre = ? WHERE id=?");
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.setString(1, modify_genre);
                    pstm.setInt(2, modify_id);
                    break;
                case "3":
                    System.out.println("수정할 저자를 입력하세요:");
                    String modify_author = sc.nextLine();
                    sql.append("UPDATE Book SET author = ? WHERE id=?");
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.setString(1, modify_author);
                    pstm.setInt(2, modify_id);
                    break;
                case "4":
                    System.out.println("수정할 상태를 입력하세요:");
                    String modify_status = sc.nextLine();
                    sql.append("UPDATE Book SET status = ? WHERE id=?");
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.setString(1, modify_status);
                    pstm.setInt(2, modify_id);
                    break;
                case "5":
                    System.out.println("수정할 상태를 입력하세요:");
                    String modify_count = sc.nextLine();
                    sql.append("UPDATE Book SET count = ? WHERE id=?");
                    pstm = conn.prepareStatement(sql.toString());
                    pstm.setString(1, modify_count);
                    pstm.setInt(2, modify_id);
                    break;
                default:
                    System.out.println("수정할 정보를 다시 확인하세요");
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (pstm != null) try {
                pstm.close();
            } catch (Exception e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }

        return result;
    }
    
    // 책의 대여 상태를 수정하기위한 메소드
    public void UpdateData(UUID id, String status, int count) {
        int result = 0;
        Connection conn = db.connectDB();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE BOOK SET status = ?, count = ? WHERE id =?");

        // 기능 생성시 아래와 같은 구조를 사용하여 close()를 해주어야 합니다.
        try {
            pstm = conn.prepareStatement(sql.toString());

            pstm.setString(1, status);
            pstm.setInt(2, count);
            pstm.setString(3, id.toString());

            result = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) try {
                rs.close();
            } catch (Exception e) {
            }
            if (pstm != null) try {
                pstm.close();
            } catch (Exception e) {
            }
            if (conn != null) try {
                conn.close();
            } catch (Exception e) {
            }
        }
    }
}
