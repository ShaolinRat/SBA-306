package models;

import javax.persistence.*;
//import lombok.*;
//import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Course is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'course' in the database. A Course object contains fields that represent course
 * information and a mapping of 'courses' that indicate an inverse or referencing side
 * of the relationship. Implement Lombok annotations to eliminate boilerplate code.
 */
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Setter
//@Getter
//@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "course")
@Entity
public class Course {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    int id;
//    @NonNull
    @Column(length = 50, name = "name")
    String name;
//    @NonNull
    @Column(length = 50, name="instructor")
    String instructor;

//    @ToString.Exclude
    @ManyToMany(mappedBy = "courses", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST},fetch = FetchType.EAGER)
    Set<Student> students = new LinkedHashSet<>();
    
    public Course() {}
    public Course(String name, String instructor) {
    	super();
    	this.name = name;
    	this.instructor = instructor;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && name.equals(course.name) && instructor.equals(course.instructor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, instructor);
    }
    
    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            student.getCourses().add(this);
        }
    }
}