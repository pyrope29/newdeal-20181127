package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao{

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {

    DriverManager.registerDriver(new Driver());

    try ( // MariaDB JDBC 드라이버(java.sql.Driver) 구현체를 로딩
        // DBMS에 연결하기
        Connection con = DriverManager.getConnection(
            "jdbc:mariadb://localhost:3306/pyrope29", 
            "pyrope29", "1111");

        // SQL 전송을 담당할 객체를 준비
        PreparedStatement stmt = con.prepareStatement(
            "select mno,name,email,photo from member "
                +" where email=? and pwd =?");
        ){

      stmt.setString(1, email);
      stmt.setString(2, password);

      // try 안 try 문
      try( ResultSet rs = stmt.executeQuery()){
        // dbms에서 한 개의 레코드를 가져온다.
        if (rs.next()) {

          Member member = new Member();
          member.setNo(rs.getInt("mno"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPhoto(rs.getString("photo"));

          return member;
        } else {
          return null;

        }
      }
    }

  }
}
