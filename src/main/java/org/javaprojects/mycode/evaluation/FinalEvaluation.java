package org.javaprojects.mycode.evaluation;

import jakarta.persistence.*;
import org.javaprojects.mycode.course.Course;

@Entity
public class FinalEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
