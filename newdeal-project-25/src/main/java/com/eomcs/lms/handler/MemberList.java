package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberList {
  static final int LENGTH = 10;
  Member[] members;
  
  public MemberList() {
    members = new Member[LENGTH];
  }

}
