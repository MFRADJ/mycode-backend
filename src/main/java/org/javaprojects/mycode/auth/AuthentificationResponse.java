package org.javaprojects.mycode.auth;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthentificationResponse {
    private String token;
}
