package com.eomcs.lms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*") //모든 요청 이전 필터 실행하겠단 뜻
public class CharacterEncodingFilter implements Filter{

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    //미리 실행되어야할 메소드를 필터에 추가
    request.setCharacterEncoding("UTF-8");
    
    //이 필터 다음에 또 다른 필터가 있다면 그 필터를 실행하며,
    //없다면 원래 목적지인 서블릿을 실행한다는 뜻
    chain.doFilter(request, response);
    
    
  }
  
}
