package com.eomcs.util;

public class QueueIterator<E> implements Iterator{
  Queue<E> queue;
  int size;
  int count;
  
  public QueueIterator(Queue<E> queue){
    this.queue = queue;
    this.size = queue.size();   //값을꺼내면 사라져버리니까 queue를 갖고있장
  }
  

  @Override
  public boolean hasNext() {
    return this.count < queue.size();
  }

  @Override
  public Object next() {
    this.count++;
    return queue.poll();
  }

}
