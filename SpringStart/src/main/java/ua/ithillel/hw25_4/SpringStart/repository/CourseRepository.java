package ua.ithillel.hw25_4.SpringStart.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ua.ithillel.hw25_4.SpringStart.model.Course;

@Repository
public class CourseRepository implements CrudRepository<Course> {

	@Override
	public List<Course> findAll() {
		List<Course> courses = new ArrayList<>();
		Course first = new Course(1, "first title", "first descr", "first link");
		courses.add(first);
		return courses;
	}

}
