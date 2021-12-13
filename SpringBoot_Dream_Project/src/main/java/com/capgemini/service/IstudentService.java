package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.model.Student;

public interface IstudentService {
	public Integer saveStudent(Student s);
	public List<Student> getAllStudents();
	public Optional<Student> getOneStudent(Integer id);
	public boolean isExist(Integer id);
	public void deleteStudent(Integer id);

}
