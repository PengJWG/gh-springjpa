package com.pli.springdatajpa;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pli.springdatajpa.entities.Student;
import com.pli.springdatajpa.repos.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringdatajpaApplicationTests {
	
	@Autowired
	private StudentRepository repository;

	@Test
	void testSaveStudent() {
		Student entity = new Student();
		entity.setId(1l);
		entity.setName("Otto");
		entity.setTestScore(100);
		repository.save(entity);
		
		Student savedStudent = repository.findById(1l).get();
		assertNotNull(savedStudent);
	}
	
	@Test
	void testDeleteStudent() {
		Student entity = new Student();
		entity.setId(2l);
		entity.setName("Mike");
		entity.setTestScore(100);
		repository.save(entity);
		repository.deleteById(2l);
		
		Student deletedStudent = repository.findById(2l).orElse(null);
		assertNull(deletedStudent);
	}
	
	@Test
	void testUpdateStudent() {
		Student entity = new Student();
		entity.setId(3l);
		entity.setName("Lisa");
		entity.setTestScore(100);
		repository.save(entity);
		
		Student savedStudent = repository.findById(3l).get();
		savedStudent.setTestScore(85);
		repository.save(savedStudent);
		
		savedStudent = repository.findById(3l).get();
		assertEquals(85, savedStudent.getTestScore());
	}


}
