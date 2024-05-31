package org.javaprojects.mycode.professor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaprojects.mycode.course.Course;
import org.javaprojects.mycode.user.User;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "professors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends User {

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<Course> courses;

}
