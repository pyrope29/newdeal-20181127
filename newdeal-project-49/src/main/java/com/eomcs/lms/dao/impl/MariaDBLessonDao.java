package com.eomcs.lms.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;

public class MariaDBLessonDao implements LessonDao{
  SqlSessionFactory sqlSessionFactory;

  public MariaDBLessonDao(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public List<Lesson> findAll() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Lesson findByNo(int no) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int insert(Lesson lesson) throws Exception {

    try (SqlSession sqlSession = sqlSessionFactory.openSession();){
      int count = sqlSession.insert("LessonDao.insert", lesson);
      sqlSession.commit();
      return count;
    }
  
  }

  @Override
  public int update(Lesson lesson) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(int no) throws Exception {
    // TODO Auto-generated method stub
    return 0;
  }

  

}
