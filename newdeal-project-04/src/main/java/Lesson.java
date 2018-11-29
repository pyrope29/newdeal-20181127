import java.sql.Date;

//새 데이터 타입
//새로운 종류의 메모리를 구성하는 설계도
public class Lesson {
  int no;
  String title; //new라고 하면 그때 heap이란 영역에 메모리 만들라는 소리(static은 미리)
  String contents;  //데이터를 개별적으로 다뤄야하는 경우엔 instance 변수로
  Date startDate;
  Date endDate;
  int totalHours;
  int dayHours;
}
