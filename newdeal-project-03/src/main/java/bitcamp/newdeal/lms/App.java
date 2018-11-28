package bitcamp.newdeal.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    final int DEFAULT_SIZE = 20;          //변수값 변경 불가능
    int[] no = new int[DEFAULT_SIZE];
    String[] title = new String[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];
    Date[] startDate = new Date[DEFAULT_SIZE];
    Date[] endDate = new Date[DEFAULT_SIZE];
    int[] totalHours = new int[DEFAULT_SIZE];
    int[] dayHours = new int[DEFAULT_SIZE];

    int len=0;

    Scanner keyIn = new Scanner(System.in);

    for(int i=0; i<DEFAULT_SIZE; i++) {

      System.out.println("번호? ");
      no[i] = Integer.parseInt(keyIn.nextLine());
      System.out.println("수업명? ");
      title[i] = keyIn.nextLine();
      System.out.println("내용? ");
      contents[i] = keyIn.nextLine();
      System.out.println("강의 시작일? ");
      startDate[i] = Date.valueOf(keyIn.nextLine());

      System.out.println("강의 종료일? ");
      endDate[i] = Date.valueOf(keyIn.nextLine());
      System.out.println("총강의시간? ");
      totalHours[i] = Integer.parseInt(keyIn.nextLine());

      System.out.println("일강의시간? ");
      dayHours[i]  = Integer.parseInt(keyIn.nextLine());

      len++;    //카운터 증가

      System.out.printf("계속하시겠습니까? (Y/N) ");
      String input = keyIn.nextLine();
      if(input.equals("")||input.equalsIgnoreCase("y")) {//엔터나 대소문자 구별x
        continue;  //반복문으로 다시 돌아가기 
      }
      break;
    }
    keyIn.close();

    for(int i=0; i<len; i++) {
      System.out.printf("%d, %d, %s~%d, %d\n",
          no[i],title[i], contents[i], startDate[i], endDate[i],  totalHours[i],
          dayHours[i]          );
      
 /*     System.out.println("번호 : " + no[i]);
      System.out.printf("수업명 : %s\n", title[i]);
      System.out.printf("내용 : %s\n", contents[i]);
      System.out.printf("시작일 : %s\n", startDate[i]);
      System.out.printf("종료일 : %s\n", endDate[i]);
      System.out.printf("총수업시간 : %s\n", totalHours[i]);
      System.out.printf("일수업시간 : %s\n", dayHours[i]);*/
    }
  }
}
