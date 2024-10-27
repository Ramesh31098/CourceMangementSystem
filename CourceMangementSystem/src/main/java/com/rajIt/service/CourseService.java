package com.rajIt.service;

import java.util.List;

import com.rajIt.binding.Course;

public interface CourseService {
	 public String upsert(Course course); 
	 public Course getById(Integer cid);
	 public List<Course> getAllCourse();
	  public String deleteById( Integer cid) ;
 
		
	
	

}
