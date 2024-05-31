package org.javaprojects.mycode.course;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "subsections")
public class SubSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int duration; // duration in minutes
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @OneToOne(mappedBy = "subSection", cascade = CascadeType.ALL)
    private ContentSubsection contentsubsection;
}