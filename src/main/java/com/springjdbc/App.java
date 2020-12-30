package com.springjdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	// System.out.println( "Hello World!" );
    			ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);

    			System.out.println("Testing: applicationContext loaded...");

    			StudentDao studentDao = applicationContext.getBean("studentDao", StudentDao.class);

    			// Insert new Record
//    	    	Student student = new Student();
//    	    	student.setName("Ramanjeet");
//    	    	student.setAddress("Toronto");
//    	    	int result = studentDao.insert(student);
//    	    	System.out.println("Number of records inserted : " + result);

    			// Update Record
//    	    	Student std = new Student();
//    	    	std.setId(1);
//    	    	std.setName("Samriddha");
//    	    	std.setAddress("Nepal");
//    	    	int result = studentDao.edit(std);
//    	    	System.out.println("Number of Records updated : " + result);

    			// Delete Operation
//    	    	int studentId = 1;
//    	    	int result = studentDao.delete(studentId);
//    	    	System.out.println("Number of deleted records : " + result);

    			// Select operation for single record
//    	    	Student student = new Student();
//    	    	student = studentDao.getStudent(3);
//    	    	System.out.println(student);

    			// Select operation for all Students
    			List<Student> listStudents = studentDao.getAllStudents();
    			for (Student std : listStudents) {
    				System.out.println(std);
    			}

    			//applicationContext.close();
    }
}
