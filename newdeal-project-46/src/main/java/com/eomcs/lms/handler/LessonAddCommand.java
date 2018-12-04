package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand implements Command {
  
  Scanner keyboard;
  
  public LessonAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void execute() {
    Connection con = null;
    Statement stmt = null;
    
    try {

      Lesson lesson = new Lesson();

      System.out.print("번호? ");
      String no = keyboard.nextLine();

      System.out.print("수업명? ");
      String title= keyboard.nextLine();

      System.out.print("설명? ");
      String contents= keyboard.nextLine();

      System.out.print("시작일? ");
      String startDate= keyboard.nextLine();
      
      System.out.print("종료일? ");
      String endDate= keyboard.nextLine();
      
      System.out.print("총수업시간? ");
      String totalHours = keyboard.nextLine();
      
      System.out.print("일수업시간? ");
      String dayHours = keyboard.nextLine();
      
    
 
      DriverManager.registerDriver(new Driver());
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/pyrope29", 
          "pyrope29", "1111");
      stmt = con.createStatement();
      
      // SQL을 서버에 전송 
      stmt.executeUpdate("insert into lesson(lno,title,cont,sdt,edt,tot_hr,day_hr)"
          + " values('" + no + "',"
          + title + ","
          + contents + ","
          + startDate + ","
          + endDate + ","
          + totalHours + ","
          + dayHours + ")");    
      
      System.out.println("입력했습니다!");
    
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }
}
