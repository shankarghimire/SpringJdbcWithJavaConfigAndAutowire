package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entity.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public int insert(Student student) {
	  	//Insert Query
    	String query = "Insert into tblStudent(name,address)Values(?,?)";
    	int r = this.jdbcTemplate.update(query, student.getName(), student.getAddress());
		return r;
	}


	@Override
	public int edit(Student student) {
		
		//Update query
		String query = "update tblStudent set name=?, address=? where id=?";
		int r = this.jdbcTemplate.update(query,student.getName(), student.getAddress(), student.getId());
		return r;
	}


	@Override
	public int delete(int studentId) {
		
		//Delete operation
		String query = "Delete from tblStudent where id=?";
		int r = this.jdbcTemplate.update(query,studentId);
		return r;
	}


	@Override
	public Student getStudent(int studentId) {
		//Getting a single record
		String query = "Select * from tblStudent where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId);
		
		return student;
	}


	@Override
	public List<Student> getAllStudents() {
	
		//Selecting multiple students
		String query = "Select * from tblStudent";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		List<Student> listStudents = this.jdbcTemplate.query(query, rowMapper);
		
		return listStudents;
	}



}
