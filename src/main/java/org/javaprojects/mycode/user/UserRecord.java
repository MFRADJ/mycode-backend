package org.javaprojects.mycode.user;

import org.javaprojects.mycode.roles.Role;

import java.util.Set;

public record UserRecord(Long id, String firstName, String lastName, String email, Set<Role> roles) {
}
