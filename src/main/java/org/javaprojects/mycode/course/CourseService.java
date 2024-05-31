package org.javaprojects.mycode.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesByProfessorId(Long professorId) {
        return courseRepository.findByProfessorId(professorId);
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
