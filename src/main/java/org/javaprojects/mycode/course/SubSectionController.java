package org.javaprojects.mycode.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subsections")
public class SubSectionController {

    @Autowired
    private SubSectionService subSectionService;

    @PostMapping
    public ResponseEntity<SubSection> createSubSection(@RequestBody SubSection subSection) {
        SubSection savedSubSection = subSectionService.saveSubSection(subSection);
        return ResponseEntity.ok(savedSubSection);
    }
}