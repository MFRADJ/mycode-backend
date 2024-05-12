package org.javaprojects.mycode.profil;

import jakarta.persistence.*;
import lombok.Data;
import org.javaprojects.mycode.user.User;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "profiles")
public class Profile {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    // Other profile fields...

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}