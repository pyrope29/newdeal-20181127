package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardDeleteCommand implements Command {
  List<Board> list;
  Scanner keyboard;

  public BoardDeleteCommand(Scanner keyboard, List<Board> list) {
    this.list = list;
    this.keyboard = keyboard;

  }

  private int indexOfBoard(int no) {
    for (int i = 0; i < list.size(); i++) {
      Board b = list.get(i);
      if (b.getNo() == no)
        return i;
    }
    return -1;
  }

  public void excute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    int index = indexOfBoard(no);
    if (index == -1) {
      System.out.println("해당 게시글을 찾을 수 없습니다.");
      return;
    }
    
    list.remove(index);
    
    System.out.println("게시글을 삭제했습니다.");
  }
}
