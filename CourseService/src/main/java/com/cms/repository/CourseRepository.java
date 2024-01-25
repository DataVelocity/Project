package com.cms.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cms.model.Course;

@Repository
@Component
public interface CourseRepository extends MongoRepository<Course,String> {
//    Course findByCourseId(String courseId);
  Optional<Course> findByCourseId(String courseId);

}
