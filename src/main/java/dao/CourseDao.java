package dao;

import models.Course;

import java.util.List;

/**
 * The CourseI interface declares abstract methods and
 * is implemented by other classes to provide services for a course.
 */
public interface CourseDao {
    void createCourse(Course course);
    Course getCourseById(int courseId);
    List<Course> getAllCourses();

}