package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand implements Command {
  
  Scanner keyboard;
  LessonDao lessonDao;
  
  public LessonAddCommand(Scanner keyboard,LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }
  
  public void execute() {
    try {
      Lesson lesson = new Lesson();

      System.out.print("번호? ");
      lesson.setNo(Integer.parseInt(keyboard.nextLine()));

      System.out.print("수업명? ");
      lesson.setTitle(keyboard.nextLine());
      System.out.print("설명? ");
      lesson.setContents(keyboard.nextLine());

      System.out.print("시작일? ");
      String dates = keyboard.nextLine();
      Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dates);
      lesson.setStartDate(date);
      
      System.out.print("종료일? ");
      String dates2 = keyboard.nextLine();
      Date date2 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(dates2);
      lesson.setEndDate(date2);
      
      System.out.print("총수업시간? ");
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));      
      System.out.print("일수업시간? ");
      lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));      
      System.out.println("입력했습니다!");
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
