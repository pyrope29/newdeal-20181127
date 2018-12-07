package com.eomcs.lms;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
//WebApplicationInitializer 구현체는 웹 애플리케이션이 시작될때 실행됨
public class MyWebApplicationInitializer implements WebApplicationInitializer {

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {
    //이 메서드가 호출될 때 할일
    //1) 프론트 컨트롤러가 사용할 Spring IoC Container를 준비한다
    // Load Spring web application configuration
    AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
    ac.register(AppConfig.class);
    ac.refresh();
    
    System.out.println("웹 애플리케이션이 시작됨!");
    // AppConfig 클래스가 메모리에 로딩되어 있지 않다면,
    // Spring IoC 컨테이너 준비하기
    AnnotationConfigApplicationContext iocContainer = 
        new AnnotationConfigApplicationContext(AppConfig.class);
    
    System.out.println(iocContainer.getBeanDefinitionCount());
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      System.out.printf("%s ===> %s\n", name, 
          iocContainer.getBean(name).getClass().getName());
    }

    //2) 프론트 컨트롤러(DispatcherServlet)를 서블릿 컨테이너에 등록한다
    // =>프론트 컨트로럴를 생성할 때 이 객체가 사용할 SPring IoC 컨테이너를 알려준다
    DispatcherServlet servlet = new DispatcherServlet(ac);
    
    //=>서블릿 컨테이너에 위에서 만든 프론트 컨트롤러 서블릿을 등록한다
    ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
    
    // => 등록한 서블릿에 정보를 설정한다
    // - 웹 애플리케이션이 시작될때, 프론트 컨트롤러를 생성하라고 지정한다
    registration.setLoadOnStartup(1);
    
    // - 프론트 컨트롤러의 URL을 지정한다
    registration.addMapping("/app/*");
  }

}
