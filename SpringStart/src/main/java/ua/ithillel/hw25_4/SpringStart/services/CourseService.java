package ua.ithillel.hw25_4.SpringStart.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ua.ithillel.hw25_4.SpringStart.model.Course;
import ua.ithillel.hw25_4.SpringStart.repository.CourseRepository;

@Service
public class CourseService implements CrudService<Course> {

	private CourseRepository courseRepository;
	
	public CourseService(CourseRepository repository) {
		courseRepository = repository;
	}

	@Override
	public List<Course> list() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	@Override
	public Course create(Course t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Course> get(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void update(Course t, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Course t) {
		// TODO Auto-generated method stub
		
	}

}
