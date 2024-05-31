package org.javaprojects.mycode.seance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaprojects.mycode.course.Course;
import org.javaprojects.mycode.professor.Professor;
import org.javaprojects.mycode.student.Student;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;

    private String url;
    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;
}
