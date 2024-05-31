package org.javaprojects.mycode.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentSubSectionService {
    @Autowired
    private ContentSubsectionRepository contentSubSectionRepository;

    public ContentSubsection saveContentSubSection(ContentSubsection contentSubSection) {
        return contentSubSectionRepository.save(contentSubSection);
    }
}
