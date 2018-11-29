import java.sql.Date;

//클래스로 새 데이터 타입을 만들자
//클래스의 정의 중 하나: 새로운 종류의 메모리를 구성하는 설계도
public class Lesson {
  int no;
  String title; //=new String 할 때, heap이란 영역에 메모리가 만들어진다(static은 이미 만들어짐)
  String contents;  //데이터를 개별적으로 다뤄야하는 경우엔 static 아닌 이렇게 instance 변수로 사용하자
  Date startDate;
  Date endDate;
  int totalHours;
  int dayHours;
}
