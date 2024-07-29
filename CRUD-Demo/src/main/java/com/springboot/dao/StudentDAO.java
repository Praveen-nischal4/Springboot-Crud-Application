package com.springboot.dao;

import java.util.List;

import com.springboot.entity.Student;

public interface StudentDAO {

	public void save(Student theStudent);
	public Student findById(int id);
	public List<Student> findAll();
	public List<Student> findByLastName(String lastName);
	public void update(Student myStu);
	public void delete(int id);
}
