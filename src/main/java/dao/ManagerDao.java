/**
 * @packageName     : dao
 * @filewName       : ManagerDao.java
 * @author          : Jiyoon Bak
 * @date            : 2021.05.10
 * @description     : DB를 사용해 관리자 데이터를 조회하거나 조작한다.
 * =======================================================
 *      DATE         AUTHOR          NOTE
 * -------------------------------------------------------
 * 2021.05.10       JiYoon Bak      최초 생성
 * 2021.05.13       JiYoon Bak      기능 추가...
 */
package dao;

import dto.ManagerDto;
import db.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

/**
 * DB를 사용해 Manager Table의 데이터를 조회하거나 조작하는 기능을 구현한 클래스
 */
public class ManagerDao {
    private final DBConnection db = DBConnection.getInstance();
    
    public ManagerDao() { super(); }
    
    public void add(ManagerDto manager) throws SQLException {
        
        //SQL 문장 생성
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO MANAGER (manager_number, id, password, name) VALUES (?,?,?,?)");
        
        try(Connection conn = db.connectDB()){
            try(PreparedStatement pstm = conn.prepareStatement(sql.toString())){
                pstm.setString(1, manager.getManagerNumber().toString());
                pstm.setString(2, manager.getId());
                pstm.setString(3, manager.getPassword());
                pstm.setString(4, manager.getName());

                pstm.executeUpdate();
            }
        }
        
    };

    public List<ManagerDto> getAll() throws SQLException {
        
        List<ManagerDto> manager_list;
        manager_list = new ArrayList<>();
        
        //SQL 문장 생성
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM MANAGER");
        
        try(Connection conn = db.connectDB()){
            try(Statement stmt = conn.createStatement()){
                try(ResultSet rs = stmt.executeQuery(sql.toString())){
                    while(rs.next()) {
                        ManagerDto manager = new ManagerDto();
                        manager.setManagerNumber(UUID.fromString(rs.getString("manager_number")));
                        manager.setId(rs.getString("id"));
                        manager.setPassword(rs.getString("password"));
                        manager.setName(rs.getString("name"));
                        manager_list.add(manager);
                    }
                }
            }
        }
        
        return manager_list;
    };
    
    public void update() {};
    
    public void delete(UUID manager_number) throws SQLException {
        
        //SQL 문장 생성
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM MANAGER where manager_number = ?");
        
        try(Connection conn = db.connectDB()){
            try(PreparedStatement pstm = conn.prepareStatement(sql.toString())){
                pstm.setString(1, manager_number.toString());
                pstm.executeUpdate();
            }
        }
        
    };
    
}