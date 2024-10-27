package com.rajIt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajIt.binding.Course;
import com.rajIt.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public String upsert(Course course) {

		 courseRepository.save(course);
		return "success";
	}

	@Override
	public Course getById(Integer cid) {
		Optional<Course> findById = courseRepository.findById(cid);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Course> getAllCourse() {
		List<Course> findAll = courseRepository.findAll();
		return findAll;
	}

	@Override
	public String deleteById(Integer cid) {
		if (courseRepository.existsById(cid)) {
			courseRepository.deleteById(cid);
			return "delete Success";
		} else {
			return "No recordFound";
		}
	}

}
