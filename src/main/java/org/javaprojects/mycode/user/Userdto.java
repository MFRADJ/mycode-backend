package org.javaprojects.mycode.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Userdto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String lastLoginDate;
    private String createdDate;
    private String lastModifiedDate;
    private String roles;
    private String status;
    private String profile;
    private String authorities;

}
