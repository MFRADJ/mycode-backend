package org.javaprojects.mycode.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {

    private SectionRepository sectionRepository;

    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }
}
