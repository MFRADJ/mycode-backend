package org.javaprojects.mycode.course;

import org.javaprojects.mycode.professor.Professor;
import org.javaprojects.mycode.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<Course>> getCoursesByProfessor(@PathVariable Long professorId) {
        List<Course> courses = courseService.getCoursesByProfessorId(professorId);
        return ResponseEntity.ok(courses);
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Optional<Professor> professorOpt = professorRepository.findById(course.getProfessor().getId());
        if (!professorOpt.isPresent()) {
            return ResponseEntity.badRequest().build(); // Or handle the error as needed
        }
        course.setProfessor(professorOpt.get());
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }
}