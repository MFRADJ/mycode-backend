package org.javaprojects.mycode.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contentsubsections")
public class ContentSubSectionController {

    @Autowired
    private ContentSubSectionService contentSubSectionService;

    @PostMapping
    public ResponseEntity<ContentSubsection> createContentSubSection(@RequestBody ContentSubsection contentSubSection) {
        ContentSubsection savedContentSubSection = contentSubSectionService.saveContentSubSection(contentSubSection);
        return ResponseEntity.ok(savedContentSubSection);
    }
}
