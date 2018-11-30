package com.eomcs.lms.util;

import java.util.Arrays;

public class MyArrayList<whatType> {
  final int DEFAULT_CAPACITY = 10;
  Object[] list; //board, Lesson, Member 다 담을 수 있도록 Object[] 배열을 쓴다
   int size = 0;
   
   public MyArrayList() {
     list = new Object[DEFAULT_CAPACITY];
   }
   
   public MyArrayList(int initialCapacity) {    //일단 size를 생성한 후, 그보다 큰 배열이 들어올 경우 늘리는것!
     if(initialCapacity > DEFAULT_CAPACITY) {
       list = new Object[initialCapacity];
     } else {
       list = new Object[DEFAULT_CAPACITY];
     }
   }
   
   public whatType[] toArray(whatType[] a) {
     if(a.length < size) {
       return (whatType[]) Arrays.copyOf(list, size, a.getClass());
     }
     System.arraycopy(list, 0, a, 0, size);
     if(a.length >size) {
       a[size] =null;
     }
       return a;
     
   }
   
   public void add(whatType item) {
     if(size>=list.length) {
       int oldCapacity = list.length;
       int newCapacity = oldCapacity + (oldCapacity >> 1);
       list = Arrays.copyOf(list, newCapacity);
       
     }
     list[size++] = item;
   }
   
   public int size() {
     return this.size;
   }
  

}
