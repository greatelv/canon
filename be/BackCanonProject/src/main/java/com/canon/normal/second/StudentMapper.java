package com.canon.normal.second;

import java.util.List;

public interface StudentMapper {

		List<Student> findAllStudents();
		Student findStudentbyId(Integer id);
		void insertStudent(Student student);
}
