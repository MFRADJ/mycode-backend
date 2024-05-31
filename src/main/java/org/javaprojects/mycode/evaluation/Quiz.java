package org.javaprojects.mycode.evaluation;

import jakarta.persistence.*;
import org.javaprojects.mycode.course.Course;
import org.javaprojects.mycode.student.Student;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    @ManyToMany(mappedBy = "quizzes")
    private List<Student> students;
}
