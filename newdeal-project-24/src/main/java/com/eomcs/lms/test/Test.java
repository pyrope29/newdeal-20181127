package com.eomcs.lms.test;

public class Test {
  public static void main(String[] args) {
    Patient p1 = new Patient();
  /*  p1.name="홍!!!";
    p1.age=2040;
    p1.weight=744;
    p1.height=1942;
  
     System.out.println(p1.name);
     게터세터로 제대로 입력하게 시키자
     */
    
    //프로퍼티를 쓰면 인위적조작 막고, 데이터의 결함을 방지한다.(객체지향-캡슐화)
    //일관성을 위해 항상 게터세터를 만들자
    
    //
     
     p1.set_name("홍길동");
     p1.set_age(20);
     p1.set_height(63);
     p1.set_weight(124);
   
      System.out.println(p1.get_name());
  }

}
