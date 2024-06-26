package org.javaprojects.mycode.seance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findByStudentId(Long studentId);

}
