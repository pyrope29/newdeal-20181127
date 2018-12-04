package com.eomcs.lms.handler;

import java.util.List;
import java.util.Scanner;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.impl.MariaDBBoardDao;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {
  SqlSessionFactory sqlSessionFactory;
  Scanner keyboard;
  BoardDao boardDao;

  public BoardListCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  public void execute() {

    try {
      List<Board> list = boardDao.findAll();

      // dbms에서 한 개의 레코드를 가져온다.
      for (Board board : list) {
        System.out.printf("%3d, %-20s, %s, %d\n",
        board.getNo(),
        board.getContents(),
        board.getCreatedDate(),
        board.getViewCount());

      }
      
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}



