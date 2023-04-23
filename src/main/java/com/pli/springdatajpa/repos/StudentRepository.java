package com.pli.springdatajpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pli.springdatajpa.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
