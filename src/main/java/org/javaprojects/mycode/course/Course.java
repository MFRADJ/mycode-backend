package org.javaprojects.mycode.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaprojects.mycode.evaluation.FinalEvaluation;
import org.javaprojects.mycode.evaluation.Quiz;
import org.javaprojects.mycode.professor.Professor;
import org.javaprojects.mycode.seance.Seance;
import org.javaprojects.mycode.student.Student;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;


    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
//    @ManyToMany
//    @JoinTable(
//            name = "course_student",
//            joinColumns = @JoinColumn(name = "course_id"),
//            inverseJoinColumns = @JoinColumn(name = "student_id")
////    )
//    private List<Student> students;

    @OneToMany(mappedBy = "course")
    private List<Seance> seances;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Section> sections;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private FinalEvaluation finalEvaluation;
}
