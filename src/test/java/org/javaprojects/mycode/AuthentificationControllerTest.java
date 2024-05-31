//package org.javaprojects.mycode;
//
//import org.javaprojects.mycode.auth.AuthentificationController;
//import org.javaprojects.mycode.auth.AuthentifictionService;
//import org.javaprojects.mycode.auth.RegistrationRequest;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
////@ExtendWith(SpringExtension.class)
////@WebMvcTest(AuthentificationController.class)
//public class AuthentificationControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private AuthentifictionService service;
//
//    @Test
//    public void shouldAcceptRegistration() throws Exception {
//        RegistrationRequest request = new RegistrationRequest("firstN", "lastN", "email", "password", "password");
//        doNothing().when(service).register(request);
//
//        mockMvc.perform(post("/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"email\":\"user@example.com\",\"password\":\"Password123\",\"firstName\":\"User\",\"lastName\":\"Lastname\"}"))
//                .andExpect(status().isAccepted());
//    }
//
//    @Test
//    public void shouldReturnBadRequestForInvalidRequest() throws Exception {
//        mockMvc.perform(post("/auth/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"email\":\"\",\"password\":\"\",\"firstName\":\"\",\"lastName\":\"\"}"))
//                .andExpect(status().isBadRequest());
//    }
//}
