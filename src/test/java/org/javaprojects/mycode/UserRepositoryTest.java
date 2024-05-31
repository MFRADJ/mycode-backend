//package org.javaprojects.mycode;
//
//import org.javaprojects.mycode.user.User;
//import org.javaprojects.mycode.user.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@ActiveProfiles("test")
//public class UserRepositoryTest {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Test
//    public void testFindByEmail() {
//        User user = new User();
//        user.setFirstName("John");
//        user.setLastName("Doe");
//        user.setEmail("john.doe@example.com");
//        user.setPassword("password");
//        userRepository.save(user);
//
//        User foundUser = userRepository.findByEmail("john.doe@example.com").orElse(null);
//        assertNotNull(foundUser);
//        assertEquals("John", foundUser.getFirstName());
//        assertEquals("Doe", foundUser.getLastName());
//    }
//}
