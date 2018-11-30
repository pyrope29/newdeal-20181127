package com.eomcs.lms.handler;

import java.util.Scanner;

public class ByeCommand implements Command {

  Scanner keyboard;

  public ByeCommand(Scanner keyboards) {
    this.keyboard = keyboards;
  }

  public void excute() {
    System.out.println("이름은?");
    String name = keyboard.nextLine();

    System.out.println(name + " 님 안녕히 가십시오~");
  }

}
