package org.javaprojects.mycode.user;



import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public Userdto toDto(User user) {
        Userdto dto = new Userdto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setAccountLocked(user.isAccountLocked());
        dto.setEnabled(user.isEnabled());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        dto.setRoles(user.getRoles().stream()
                .map(role -> role.getName())
                .collect(Collectors.toList()));
        return dto;
    }
}
