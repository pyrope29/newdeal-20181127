package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class BoardList {
  static final int LENGTH = 10;

  private Board[] list;
  private int size = 0;

  public BoardList() {
    this.list = new Board[LENGTH];
  }
  
  public BoardList(int initialCapacity) {
    if(initialCapacity > LENGTH) {
      this.list = new Board[initialCapacity];
    } else {
      this.list = new Board[LENGTH];
    }
  }

  public Board[] toArray() {
    return Arrays.copyOf(list, size);
  }

  public void add(Board board) {
    if (size >= list.length) {
      int oldLength = list.length;
      int newCapacity = (int) (oldLength + (oldLength * 0.5));
      list = Arrays.copyOf(list, newCapacity);
      
    }
    list[size++] = board;
  }
}
