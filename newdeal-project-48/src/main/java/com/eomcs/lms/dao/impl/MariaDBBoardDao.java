package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class MariaDBBoardDao implements BoardDao{
  public List<Board> findAll() throws Exception{

    // MariaDB JDBC 드라이버(java.sql.Driver) 구현체를 로딩
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/pyrope29", 
        "pyrope29", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "select bno, cont, cdt, view from board");
        ResultSet  rs = stmt.executeQuery();){
      ArrayList<Board> list = new ArrayList<>();

      while (rs.next()) {
        Board board = new Board();
        board.setNo(rs.getInt("bno"));
        board.setContents(rs.getString("cont"));
        board.setCreatedDate(rs.getDate("cdt"));
        board.setViewCount(rs.getInt("view"));
        list.add(board);
      }
      return list;
    } 
  }
  public Board findByNo(int no) throws Exception {

    DriverManager.registerDriver(new Driver());
    try ( // MariaDB JDBC 드라이버(java.sql.Driver) 구현체를 로딩
        // DBMS에 연결하기
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/pyrope29", 
            "pyrope29", "1111");

        // SQL 전송을 담당할 객체를 준비
        PreparedStatement stmt = con.prepareStatement(
            "select bno, cont, cdt, view, mno, lno"
                + " from board"
                + " where bno=?");){
      stmt.setInt(1, no);

      try( ResultSet rs = stmt.executeQuery();){

        if (rs.next()) {
          Board board = new Board();
          board.setNo(rs.getInt("bno"));
          board.setContents(rs.getString("cont"));

          board.setViewCount(rs.getInt("view"));
          board.setCreatedDate(rs.getDate("cdt"));
          board.setWriterNo(rs.getInt("mno"));
          board.setLessonNo(rs.getInt("lno"));
          return board;
        } else {
          return null;
        }
      }
    }
  }

  public int insert(Board board) throws Exception{
    DriverManager.registerDriver(new Driver());
    try (
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/pyrope29", 
            "pyrope29", "1111");
        PreparedStatement stmt = con.prepareStatement("insert into board(cont,mno,lno)values(?,?,?)");
        ) {
      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getWriterNo());
      stmt.setInt(3, board.getLessonNo());

      return stmt.executeUpdate();
    }
  }

  public int update(Board board) throws Exception{ 
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/pyrope29", 
          "pyrope29", "1111");
      stmt = con.prepareStatement("update board set cont=? where bno=?");

      stmt.setString(1, board.getContents());
      stmt.setInt(2, board.getNo());
      // SQL을 서버에 전송 
      return stmt.executeUpdate();

      /*} catch (Exception e) {   예외뜨면 호출자에게 던질거라 캐치 필요업삳
      e.printStackTrace();
       */} finally {
         try {stmt.close();} catch (Exception e) {}
         try {con.close();} catch (Exception e) {}
       }
  }

  public int delete(int no) throws Exception{ 
    Connection con = null;
    PreparedStatement stmt = null;

    try {
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/pyrope29", 
          "pyrope29", "1111");
      stmt = con.prepareStatement("delete from board where bno=?");
      stmt.setInt(1, no);
      return stmt.executeUpdate();

    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
