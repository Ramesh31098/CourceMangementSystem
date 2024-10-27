package com.rajIt.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajIt.binding.Course;
import com.rajIt.service.CourseService;
import com.rajIt.service.CourseServiceImpl;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@PostMapping("/course")
	public ResponseEntity<String> createCourse(@RequestBody Course course) {
		String status = courseService.upsert(course);
		return new ResponseEntity<>(status, HttpStatus.CREATED.OK);
	}

	@GetMapping("/course/{cid}")
	public ResponseEntity<Course> getCoursebyId(@PathVariable Integer cid) {
		Course course = courseService.getById(cid);
		return new ResponseEntity<>(course, HttpStatus.OK);
	}


	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> allCourse = courseService.getAllCourse();
		return new ResponseEntity<List<Course>>(allCourse, HttpStatus.OK);
	}

	@PutMapping("/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course) {

		String staus = courseService.upsert(course);
		return new ResponseEntity<String>(staus, HttpStatus.OK);
	}
@DeleteMapping("/course/{cid}")
	public ResponseEntity<String> deleteById(@PathVariable Integer cid) {
		String status = courseService.deleteById(cid);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
}
