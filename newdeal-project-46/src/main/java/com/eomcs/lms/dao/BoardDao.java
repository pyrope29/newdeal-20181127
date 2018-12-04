package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Board;

public class BoardDao {
  public List<Board> findAll() throws Exception{

    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      // MariaDB JDBC 드라이버(java.sql.Driver) 구현체를 로딩
      DriverManager.registerDriver(new Driver());
      
      // DBMS에 연결하기
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/pyrope29", 
          "pyrope29", "1111");
      
      // SQL 전송을 담당할 객체를 준비
      stmt = con.createStatement();
      
      // SQL을 서버에 전송 => 서버에서 결과를 가져올 일을 할 객체를 리턴
      rs = stmt.executeQuery(
          "select bno, cont, cdt, view from board");
      
      List<Board> list = new ArrayList();
      
      // dbms에서 한 개의 레코드를 가져온다.
      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        list.add(board);
      }
    
    } catch (Exception e) {
      throw e;
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    return null;
  
  }

}
