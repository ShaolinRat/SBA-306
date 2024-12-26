package models;

import javax.persistence.*;
//import lombok.*;
//import lombok.experimental.FieldDefaults;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Student is a POJO, configured as a persistent class that represents (or maps to) a table
 * name 'student' in the database. A Student object contains fields that represent student
 * login credentials and a join table containing a registered student's email and course(s)
 * data. The Student class can be viewed as the owner of the bi-directional relationship.
 * Implement Lombok annotations to eliminate boilerplate code.
 */
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Setter@Getter@ToString
//@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student")
@Entity
public class Student {
//    @NonNull
    @Id @Column(length = 50,name = "email")
    String email;
//    @NonNull
    @Column(length = 50, nullable = false, name = "name")
    String name;
//    @NonNull
    @Column(length = 50,name = "password")
    String password;

//    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_email"),
            inverseJoinColumns = @JoinColumn(name = "courses_id"))
     Set<Course> courses = new LinkedHashSet<>();

    /**
     * Method takes-in a course object as an argument,
     * adds it to course list, then adds
     * the current student(this) object
     * to the students list.
     * @param c
     */
    public void addCourse(Course c){
        courses.add(c);
        c.getStudents().add(this);


    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return email.equals(student.email) && name.equals(student.name) && password.equals(student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password);
    }


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}

	public Student() {}
	public Student(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Course> getCourses() {
		return courses;
	}


	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}