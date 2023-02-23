package com.mehedi.jpa.repository;

import com.mehedi.jpa.entity.Course;
import com.mehedi.jpa.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            em.persist(course);
        } else {
            em.merge(course);
        }
        return course;
    }


    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void addReviewsForCourse(Long courseId, List<Review> reviews){
        Course course = findById(courseId);
        for (Review review: reviews) {
            course.addReviews(review);
            review.setCourse(course);
            em.persist(review);
        }
    }
}
