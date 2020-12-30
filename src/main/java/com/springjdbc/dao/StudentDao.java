package com.springjdbc.dao;

import java.util.List;

import com.springjdbc.entity.Student;

public interface StudentDao {
	public int insert(Student student);
	public int edit(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);//To extract a single row
	public List<Student>getAllStudents(); //To extract all records
	

}
