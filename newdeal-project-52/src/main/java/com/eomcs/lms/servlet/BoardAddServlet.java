<<<<<<< HEAD
   package com.eomcs.lms.servlet;
=======
package com.eomcs.lms.servlet;
>>>>>>> work

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Member;

@WebServlet("/board/add")
public class BoardAddServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
<<<<<<< HEAD

  BoardDao boardDao;
  LessonDao lessonDao;

=======
  
  BoardDao boardDao;
  LessonDao lessonDao;
  
>>>>>>> work
  @Override
  public void init() {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext()
<<<<<<< HEAD
        .getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class);
    this.lessonDao = iocContainer.getBean(LessonDao.class);
  }

=======
                                 .getAttribute("iocContainer");
    this.boardDao = iocContainer.getBean(BoardDao.class);
    this.lessonDao = iocContainer.getBean(LessonDao.class);
  }
  
>>>>>>> work
  @Override
  protected void doGet(
      HttpServletRequest request, 
      HttpServletResponse response)
<<<<<<< HEAD
          throws ServletException, IOException {

    HttpSession session = request.getSession();

    Member loginUser = (Member) session.getAttribute("loginUser");
=======
      throws ServletException, IOException {
    
    HttpSession session = request.getSession();
    Member loginUser = (Member) session.getAttribute("loginUser");
    
>>>>>>> work
    List<Map<String,Object>> lessons = 
        lessonDao.findByParticipantNo(loginUser.getNo());
    
    request.setAttribute("lessons", lessons);
<<<<<<< HEAD
=======
    
>>>>>>> work
    RequestDispatcher rd = request.getRequestDispatcher(
        "/board/form.jsp");
    rd.forward(request, response);
  }
<<<<<<< HEAD

=======
  
>>>>>>> work
  @Override
  protected void doPost(
      HttpServletRequest request, 
      HttpServletResponse response)
<<<<<<< HEAD
          throws ServletException, IOException {

    try {
      Board board = new Board();
      board.setContents(request.getParameter("contents"));

      Member loginUser = 
          (Member) request.getSession().getAttribute("loginUser");
      board.setWriterNo(loginUser.getNo());

      board.setLessonNo(Integer.parseInt(
          request.getParameter("lessonNo")));

      boardDao.insert(board);

      response.sendRedirect("list");

=======
      throws ServletException, IOException {
    
    try {
      Board board = new Board();
      board.setContents(request.getParameter("contents"));
      
      Member loginUser = 
          (Member) request.getSession().getAttribute("loginUser");
      board.setWriterNo(loginUser.getNo());
      
      board.setLessonNo(Integer.parseInt(
          request.getParameter("lessonNo")));
      
      boardDao.insert(board);
      
      response.sendRedirect("list");
    
>>>>>>> work
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
<<<<<<< HEAD
}
=======
}








>>>>>>> work
