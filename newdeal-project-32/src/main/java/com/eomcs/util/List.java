package com.eomcs.util;

// util의 호출규칙을 인터페이스로 정의해보자
public interface List<E> {

  E[] toArray(E[] a); // 인터페이스 앞에 아무것도 없으면 public abstract 숨어있다는말

  void add(E obj);

  E get(int index);

  E set(int index, E obj);

  E remove(int index);

  int size();

}
