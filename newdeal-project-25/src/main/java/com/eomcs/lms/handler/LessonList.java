package com.eomcs.lms.handler;

import java.util.Arrays;
import com.eomcs.lms.domain.Lesson;

public class LessonList {
  static final int LENGTH = 10;
  private Lesson[] list;
  private int size = 0;
  
  public LessonList() {
    this.list =  new Lesson[LENGTH];
  }
  
  public LessonList(int initialCapacity) {  
    if(initialCapacity > LENGTH)
      this.list = new Lesson[initialCapacity];
    else
      this.list = new Lesson[LENGTH];
  }
  
  public Lesson[] toArray() {
    return Arrays.copyOf(list, size);
  }
  
  public void add(Lesson lesson) {
    if(size >= list.length) {
      int oldLength = list.length;
      int newCapacity = oldLength+(int)(oldLength*0.5);
      list = Arrays.copyOf(list,newCapacity);
    }
    list[size] = lesson;
    size++;    
    //=list[size++] = lesson;
     
    //전위 연산자, 후위연산자
/*    int i=10;
    i=++i;          
    System.out.print(i);
    i=i++;          
    System.out.print(i);*/
   
  }
}
