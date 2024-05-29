package org.javaprojects.mycode.student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaprojects.mycode.course.Course;
import org.javaprojects.mycode.user.User;


import java.util.Set;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User {
    @OneToMany(mappedBy = "student")
    private Set<Course> courses;

}