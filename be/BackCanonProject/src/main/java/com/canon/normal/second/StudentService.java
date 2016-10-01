package com.canon.normal.second;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentService {

	private Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	public Student findStudentByid(Integer studId) {
		logger.debug("Select Student by Id: {}", studId);
		SqlSession sqlSession = MyBatisSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentbyId(studId);
		} finally {
			sqlSession.close();
		}
	}
	
	public void createStudent(Student student) {
		SqlSession sqlSession = MyBatisSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}
}
