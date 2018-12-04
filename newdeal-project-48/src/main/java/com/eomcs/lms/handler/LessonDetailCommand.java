package com.eomcs.lms.handler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonDetailCommand implements Command {

  Scanner keyboard;

  public LessonDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  public void execute() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

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
          "select title,cont,sdt,edt,tot_hr,day_hr"
              + " from lesson"
              + " where lno=" + no);

      if (rs.next()) {
        System.out.printf("수업명: %s\n", rs.getString("title"));
        System.out.printf("설명: %s\n", rs.getString("cont"));
        System.out.printf("기간: %s ~ %s\n",rs.getDate("sdt"), rs.getDate("edt"));
        System.out.printf("총수업시간: %d\n", rs.getInt("tot_hr"));
        System.out.printf("일수업시간: %d\n", rs.getInt("day_hr"));
      } else {
        System.out.println("해당 수업을 찾을 수 없습니다.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
