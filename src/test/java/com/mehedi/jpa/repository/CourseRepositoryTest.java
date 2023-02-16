package com.mehedi.jpa.repository;

import com.mehedi.jpa.JpaApplication;
import com.mehedi.jpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest( classes = JpaApplication.class)
class CourseRepositoryTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepository;

	@Test
	void findByIdCourse() {
		Course course = courseRepository.findById(10002L);
		assertEquals(10002, course.getId());
	}

	@Test
	@DirtiesContext
	void deleteByIdCourses() {
		courseRepository.deleteById(10001L);
		assertNull(courseRepository.findById(10001L));
	}

	@Test
	@DirtiesContext
	void updateCourse() {
		Course course = courseRepository.findById(10001L);
		assertEquals("Learn JPA", course.getName());

		course.setName("Learn JPA - updated");
		Course updatedCourse = courseRepository.save(course);

		assertEquals("Learn JPA - updated", updatedCourse.getName());
	}
	@Test
	@DirtiesContext
	void saveCourse() {
		String courseName = "Learning Hibernate";
		Course course = courseRepository.save(new Course(courseName));
		assertEquals(courseName, course.getName());
	}

}
