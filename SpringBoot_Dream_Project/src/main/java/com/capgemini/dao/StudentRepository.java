package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
