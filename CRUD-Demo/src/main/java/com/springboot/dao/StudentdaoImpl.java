package com.springboot.dao;

import java.util.List;

import com.springboot.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentdaoImpl implements StudentDAO {

	private EntityManager entityManager;
	
	@Autowired
	public StudentdaoImpl(EntityManager theEntityManager)                //constructor injection
	{
		entityManager = theEntityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		
		TypedQuery<Student> myQuery = entityManager.createQuery("FROM Student order by lastname",Student.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastName) {
		
		TypedQuery<Student> myQuery = entityManager.createQuery("from Student where lastname =:data",Student.class);
		myQuery.setParameter("data", lastName);
		return myQuery.getResultList();
	}

	@Override
	@Transactional
	public void update(Student myStu) {
		
		entityManager.merge(myStu);
		
	}

	@Override
	@Transactional
	public void delete(int id) {

		/*
		 * Student myStudent = entityManager.find(Student.class, id);
		 * entityManager.remove(myStudent);
		 */
		
	}

}
