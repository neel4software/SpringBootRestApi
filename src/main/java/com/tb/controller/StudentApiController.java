package com.tb.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tb.model.Student;

@RestController
@RequestMapping("student")
public class StudentApiController {

	// In prod this should be handled with database
	Map<Integer, Student> studentData = new HashMap<>();

	/* Adding a resource */
	@PostMapping("/")
	private int add(@RequestBody Student student) {
		studentData.put(student.getId(), student);
		return student.getId();
	}

	/* Updating a resource */
	@PutMapping("/")
	private int update(@RequestBody Student student) {
		studentData.put(student.getId(), student);
		return student.getId();
	}

	/* Getting a resource */
	@GetMapping("/{id}")
	private Student get(@PathVariable int id) {
		return studentData.get(id);
	}

	/* Getting a list of resources */
	@GetMapping("/")
	private Collection<Student> list() {
		return studentData.values();
	}

	/* Deleting a resource */
	@DeleteMapping("/{id}")
	private Student delete(@PathVariable int id) {
		return studentData.remove(id);
	}

}
