package com.eomcs.lms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
//Web MVC : @Controller 후 @RequestMapping("주소") 붙여주기
@Controller
public class BoardListController {
  
  BoardDao boardDao;
  
  public BoardListController(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
  @RequestMapping("/board/list")
  public String execute(
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Board> list = boardDao.findAll();
    request.setAttribute("list", list);
    response.setContentType("text/html;charset=UTF-8");

    return "/board/list.jsp";
  }
} 



