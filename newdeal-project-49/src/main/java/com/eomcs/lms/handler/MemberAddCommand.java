package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand implements Command{
  Scanner scan;
  MemberDao memberDao;

  public MemberAddCommand(Scanner scan, MemberDao memberDao) {
    this.scan=scan;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {

    try {
      Member member = new Member();

      System.out.println("이름? ");
      member.setName(scan.nextLine());

      System.out.println("이메일? ");
      member.setEmail(scan.nextLine());

      System.out.println("비밀번호? ");
      member.setPassword(scan.nextLine());

      System.out.println("사진? ");
      member.setPhoto(scan.nextLine());

      System.out.println("전화번호? ");
      member.setTel(scan.nextLine());

      int count = memberDao.insertMember(member);

      System.out.println("count!!!! : " + count);
      if(count >0) {

        System.out.println("회원가입이 완료되었습니다.");
      } else {
        System.out.println("회원가입이 실패했습니다.");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
