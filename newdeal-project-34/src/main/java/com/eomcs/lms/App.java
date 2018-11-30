package com.eomcs.lms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDatailCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.ByeCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static Queue<String> commandHistory2 = new LinkedList<>();

  public static void main(String[] args) {
    //과제 : 커맨드패턴으로 두개핸들러분리시키자
    LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(keyboard, new LinkedList<>());
    
    ArrayList<Board> boards = new ArrayList<>();

    HashMap<String, Command> commandMap = new HashMap<>();
    
    commandMap.put("/board/list", new BoardListCommand(keyboard, boards));
    commandMap.put("/board/detail", new BoardDatailCommand(keyboard, boards));
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boards));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boards));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boards));
    commandMap.put("bye", new ByeCommand(keyboard));
    
    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);
      
      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        
        try {
          commandHandler.excute();
        } catch(Exception e) {
          System.out.println("시스템을 멈추지 않고 고고고고");
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
