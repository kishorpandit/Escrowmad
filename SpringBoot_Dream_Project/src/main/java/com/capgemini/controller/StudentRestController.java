package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Message;
import com.capgemini.model.Student;
import com.capgemini.service.IstudentService;

@RestController
@RequestMapping("/rest/student")
@CrossOrigin("http://localhost:4200")
public class StudentRestController {

	@Autowired
	private IstudentService service;

	@PostMapping("/save")
	public ResponseEntity<Message> saveStudent(@RequestBody Student student) {
		ResponseEntity<Message> resp = null;
		Logger log = org.slf4j.LoggerFactory.getLogger(StudentRestController.class);
		try {
			log.info("About to call service");
			Integer id = service.saveStudent(student);
			resp = new ResponseEntity<Message>(new Message("Success", id + "-saved"), HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("Fail", "Unable to Save"), HttpStatus.OK);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllStudent() {
		ResponseEntity<?> resp = null;
		try {
			List<Student> list = service.getAllStudents();
			if (list != null && !list.isEmpty())
				resp = new ResponseEntity<List<Student>>(list, HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("unable to fatch Data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<?> getoneStudent(@PathVariable Integer id) {
		ResponseEntity<?> resp = null;
		try {
			Optional<Student> oneStudent = service.getOneStudent(id);
			if (oneStudent.isPresent())
				resp = new ResponseEntity<Student>(oneStudent.get(), HttpStatus.OK);
			else
				resp = new ResponseEntity<String>("No Data Found", HttpStatus.OK);
		} catch (Exception e) {
			resp = new ResponseEntity<String>("Unable to fatch data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@GetMapping("/remove/{id}")
	public ResponseEntity<Message> deleteStudent(@PathVariable Integer id) {
		ResponseEntity<Message> resp = null;
		try {
			boolean exist = service.isExist(id);
			if (exist) {
				service.deleteStudent(id);

				resp = new ResponseEntity<Message>(new Message("Success", id + "-Removed"), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<Message>(new Message("Fail", id + "-Not Exist"), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("Fail", "Unable to Delete"),
					HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	@PutMapping("/update")
	public ResponseEntity<Message> updateStudent(@RequestBody Student student) {
		ResponseEntity<Message> resp = null;
		try {
			boolean exist = service.isExist(student.getStdId());
			if (exist) {
				service.saveStudent(student);
				resp = new ResponseEntity<Message>(new Message("ok", student.getStdId() + "-Updated"), HttpStatus.OK);
			} else {
				resp = new ResponseEntity<Message>(new Message("ok", student.getStdId() + "-Not Exist"),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<Message>(new Message("ok", "Unable to Update"), HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

}
