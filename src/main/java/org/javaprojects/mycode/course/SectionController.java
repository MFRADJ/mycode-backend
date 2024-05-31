package org.javaprojects.mycode.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @PostMapping
    public ResponseEntity<Section> createSection(@RequestBody Section section) {
        Section savedSection = sectionService.saveSection(section);
        return ResponseEntity.ok(savedSection);
    }
}