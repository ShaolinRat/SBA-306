package utils;

import models.Course;
import models.Student;
import services.CourseServices;
import services.StudentServices;

/**
 * CommandLine is a Utility class that runs each time the application
 * executes. It performs a common routine by creating and persisting
 * student objects to the 'student' table and course objects to the
 * 'course' table.
 */
public class CmdLine {
    private CmdLine(){
        // Utility classes should not have public constructors
    }
    private static final String PASSWORD = "password";

    /**
     * Creates and persist student object to the 'student' table and
     * course objects to the 'course' table
     */
    public static void addData(){
        StudentServices studentService = new StudentServices();
        CourseServices courseService = new CourseServices();
        studentService.createStudent(new Student("reema@gmail.com", "reema brown", PASSWORD));
        studentService.createStudent(new Student("annette@gmail.com", "annette allen", PASSWORD));
        studentService.createStudent(new Student("anthony@gmail.com", "anthony gallegos", PASSWORD));
        studentService.createStudent(new Student("ariadna@gmail.com", "ariadna ramirez", PASSWORD));
        studentService.createStudent(new Student("bolaji@gmail.com", "bolaji saibu", PASSWORD));
        studentService.createStudent(new Student("shirese@gmail.com", "shirese smith", PASSWORD));

        courseService.createCourse(new Course("Java", "Roger Boaitey"));
        courseService.createCourse(new Course("Frontend", "William Roales"));
        courseService.createCourse(new Course("JPA", "Jafer Alhaboubi"));
        courseService.createCourse(new Course("Spring Framework", "LaTonya Lewis"));
        courseService.createCourse(new Course("SQL", "Ezra Williams"));
        courseService.createCourse(new Course("GitHub", "Igor Adulyan"));
        courseService.createCourse(new Course("Web Services", "Raheem Abolfathzadeh"));
        courseService.createCourse(new Course("Microservices", "Eric Heilig"));


    }
}