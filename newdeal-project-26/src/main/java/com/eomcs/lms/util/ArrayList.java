package com.eomcs.lms.util;

import java.util.Arrays;
import com.eomcs.lms.domain.Board;

public class ArrayList<whatType> {
  final int DEFAULT_CAPACITY = 10;
  Object[] list; // 자바의 모든 객체를 담을 수있도록 object형
  int size = 0;

  public ArrayList() {
    list = new Board[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  public whatType[] toArray(whatType[] a) {
    if(a.length < size ) {
      return (whatType[]) Arrays.copyOf(list, size, a.getClass());
    }
    System.arraycopy(list, 0, a, 0, size);
    if (a.length > size)
      a[size] = null;
    
    return a;
  }

  public void add(whatType item) { // member,board,lesson list 다받기위한 item
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size++] = item;
  }

  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }
}
