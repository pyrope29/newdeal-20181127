package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDetailCommand implements Command {
  Scanner keyboard;
  MemberDao memberDao;

  public MemberDetailCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {

      System.out.print("이메일? ");
      String email = keyboard.nextLine();

      System.out.print("비밀번호? ");
      String password = keyboard.nextLine();

      Member member = memberDao.findByEmailPassword(email, password);

      if(member!=null) {
        System.out.printf("번호: %d\n", member.getNo());
        System.out.printf("이름: %s\n", member.getName());
        System.out.printf("이메일: %s\n", member.getEmail());
        System.out.printf("사진: %s\n", member.getPhoto());
      } else {
        System.out.println("해당 정보가 없습니다");
      }
    }catch(Exception e) {
      e.printStackTrace();

    }
  }

}
