package org.javaprojects.mycode.student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaprojects.mycode.course.Course;
import org.javaprojects.mycode.evaluation.Choice;
import org.javaprojects.mycode.evaluation.FinalEvaluation;
import org.javaprojects.mycode.evaluation.Question;
import org.javaprojects.mycode.evaluation.Quiz;
import org.javaprojects.mycode.seance.Seance;
import org.javaprojects.mycode.user.User;


import java.util.List;


@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student extends User {
    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @ManyToMany
    @JoinTable(name = "student_seance", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "live_session_id"))
    private List<Seance> seances;

    @ManyToMany
    @JoinTable(name = "student_quiz", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private List<Quiz> quizzes;

    @ManyToMany
    @JoinTable(name = "student_question", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question> questions;

    @ManyToMany
    @JoinTable(name = "student_choice", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "choice_id"))
    private List<Choice> choices;

    @ManyToMany
    @JoinTable(name = "student_final_evaluation", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "final_evaluation_id"))
    private List<FinalEvaluation> finalEvaluations;

}