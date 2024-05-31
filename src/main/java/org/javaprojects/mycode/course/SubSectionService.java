package org.javaprojects.mycode.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubSectionService {
    @Autowired
    private SubSectionRepository subSectionRepository;

    public SubSection saveSubSection(SubSection subSection) {
        return subSectionRepository.save(subSection);
    }
}
