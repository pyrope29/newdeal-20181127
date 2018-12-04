package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public interface BoardDao {
   List<Board> findAll() throws Exception;

    public Board findByNo(int no) throws Exception;

    public int insert(Board board) throws Exception;
    
    public int update(Board board) throws Exception;
    
    public int delete(int no) throws Exception;
}