package org.javaprojects.mycode.roles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javaprojects.mycode.user.User;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

//    public Role(String name) {
//        this.name = name;
//    }
//    public void removeAllUsersFromRole(){
//        if (this.getUsers() != null){
//            List<User> usersInRole = this.getUsers().stream().toList();
//            usersInRole.forEach(this::removeUserFromRole);
//        }
//    }
//    public void removeUserFromRole(User user) {
//        user.getRoles().remove(this);
//        this.getUsers().remove(user);
//    }
//    public void assignUserToRole(User user){
//        user.getRoles().add(this);
//        this.getUsers().add(user);
//    }

}