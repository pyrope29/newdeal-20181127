package com.eomcs.util;

public class MyArrayList<T> implements MyList<T> {
  private static final int DEFAULT_CAPACITY = 10;
  private Object[] elementData;
  private int size=0;

  public MyArrayList() {
    elementData = new Object[DEFAULT_CAPACITY];
  }
  
  public MyArrayList(int initialCapacity) {
    if(initialCapacity>DEFAULT_CAPACITY) {
      elementData = new Object[initialCapacity];
        
    } else {
      elementData = new Object[DEFAULT_CAPACITY];
    }
  }
  
  @Override
  public T[] toArray(T[] a) {
    if(a.length<size) {
      
    } else {
      
    }
    return null;
  }

  @Override
  public void add(T obj) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public T get(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T set(int index, T obj) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return 0;
  }

}
