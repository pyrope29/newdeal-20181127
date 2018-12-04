package com.eomcs.lms;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.dao.impl.MariaDBBoardDao;
import com.eomcs.lms.dao.impl.MariaDBLessonDao;
import com.eomcs.lms.dao.impl.MariaDBMemberDao;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.HelloCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LoginCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberAddCommand;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();

  public static void main(String[] args) throws Exception {
    String resource = "com/eomcs/lms/conf/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    //MemberHandler memberHandler = new MemberHandler(keyboard, new LinkedList<>());
    BoardDao boardDao = new MariaDBBoardDao(sqlSessionFactory);//의존성주입
    MemberDao memberDao = new MariaDBMemberDao(sqlSessionFactory);//의존성주입
    LessonDao lessonDao = new MariaDBLessonDao(sqlSessionFactory);//의존성주입
    
    HashMap<String,Command> commandMap = new HashMap<>();
      //board command
    commandMap.put("/board/list", 
        new BoardListCommand(keyboard, boardDao));//의존성주입
    commandMap.put("/board/detail", 
        new BoardDetailCommand(keyboard, boardDao));
    commandMap.put("/board/add", 
        new BoardAddCommand(keyboard, boardDao));
    commandMap.put("/board/update", 
        new BoardUpdateCommand(keyboard, boardDao));
    commandMap.put("/board/delete", 
        new BoardDeleteCommand(keyboard, boardDao));
    commandMap.put("hello", new HelloCommand(keyboard));
      //member command
    commandMap.put("/auth/login", new LoginCommand(keyboard, memberDao));
    commandMap.put("/member/detail", 
        new MemberDetailCommand(keyboard, memberDao));
    commandMap.put("/member/add", 
        new MemberAddCommand(keyboard, memberDao));
    
    
      //lesson command
    commandMap.put("/lesson/add", 
        new LessonAddCommand(keyboard, lessonDao));
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 처리 중 오류 발생!");
        }
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();

      } else if (command.equals("history2")) {
        printCommandHistory2();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); 
    }

    keyboard.close();
  }

  private static void printCommandHistory() {
    Iterator<String> iterator = commandHistory.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static void printCommandHistory2() {
    Iterator<String> iterator = commandHistory2.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
