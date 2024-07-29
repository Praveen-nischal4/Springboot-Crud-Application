package com.springproject;

import java.util.List;

import com.springboot.dao.StudentDAO;
import com.springboot.entity.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboot","com.springboot.entity","com.springboot.dao"})
@EntityScan(basePackages = "com.springboot.entity")
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		
		return  runner -> {
			
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
		};
	}


	/*
	 * private void deleteStudent(StudentDAO studentDAO) {
	 * 
	 * int StudentId =7;
	 * System.out.println("Deleting student with id : "+StudentId);
	 * 
	 * studentDAO.delete(StudentId); }
	 */

	/*
	 * private void updateStudent(StudentDAO studentDAO) {
	 * 
	 * int studentId =1; System.out.println("Getting student with Id : "+studentId);
	 * 
	 * Student myStudent = studentDAO.findById(studentId);
	 * myStudent.setFirstname("Rituraj"); myStudent.setLastname("Mishra"); //finally
	 * update studentDAO.update(myStudent);
	 * 
	 * //dispaly updated student
	 * System.out.println("Update Student Detail : "+myStudent);
	 * 
	 * }
	 */

	/*
	 * private void queryForStudentsByLastName(StudentDAO studentDAO) {
	 * 
	 * List<Student> myList = studentDAO.findByLastName("Singh");
	 * 
	 * for(Student newList :myList) { System.out.println(newList); }
	 * 
	 * }
	 */

	/*
	 * private void queryForStudents(StudentDAO studentDAO) {
	 * 
	 * List<Student> myList = studentDAO.findAll(); //get the list of students
	 * 
	 * for(Student stuList : myList) { System.out.println(stuList +"/n"); } }
	 */

	/*
	 * private void readStudent(StudentDAO studentDAO) {
	 * 
	 * System.out.println("create new Students object");
	 * 
	 * Student student = new Student("Lovina","Kashyap","kashyaplovina2@gmail.com");
	 * studentDAO.save(student);
	 * 
	 * int stu_id = student.getId();
	 * System.out.println("Saved Student : Generated Id :"+stu_id);
	 * 
	 * Student myStudent = studentDAO.findById(stu_id);
	 * System.out.println("Student Found : "+myStudent); }
	 */

	
	  private void createMultipleStudents(StudentDAO studentDAO) {
	  
	  System.out.println("Creating student object......"); 
	  Student tempStudent = new Student("Raju" ,"Gullu","billaraju44@gmail.com"); 
	  Student tempStudent2 = new Student("Simran" ,"Desai","desaisimran5@gmail.com");
	  Student tempStudent3 = new Student("Ranveer" ,"Singh","singh.ranveer3@gmail.com"); 
	  Student tempStudent4 = new Student("Ravi" ,"Mishra","mishra.raavi@gmail.com");
	  
	  studentDAO.save(tempStudent); studentDAO.save(tempStudent2);
	  studentDAO.save(tempStudent3); studentDAO.save(tempStudent4);
	  
	  }
	 

	/*
	 * private void createStudent(StudentDAO studentDAO) {
	 * 
	 * System.out.println("Creating student object......"); Student tempStudent =
	 * new Student("Monika" ,"Gaur","gaurm944@gmail.com");
	 * 
	 * studentDAO.save(tempStudent);
	 * 
	 * System.out.println("Saved Student :"+tempStudent.getId()); }
	 */

}
