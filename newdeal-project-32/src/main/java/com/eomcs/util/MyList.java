package com.eomcs.util;

//ArrayList와 LinkedList의 호출 규칙을 정리한 MyList 인터페이스를 만들어보자
public interface MyList<E> {
  E[] toArray(E[] a);
  
  void add(E obj);
  
  E get(int index);
  
  E set(int index, E obj);
  
  E remove(int index);
  
  public abstract int size();
  
}
