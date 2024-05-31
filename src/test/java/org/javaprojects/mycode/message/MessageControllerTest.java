package org.javaprojects.mycode.message;


import org.javaprojects.mycode.security.JwtService;
import org.javaprojects.mycode.user.Userdto;

import org.javaprojects.mycode.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageService messageService;

    @MockBean
    private MessageMapper messageMapper;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private JwtService jwtService;

//    @BeforeEach
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(new MessageController(messageService))
//                .build();
//    }

    @Test
    public void testSendMessage() throws Exception {
        Userdto senderDto = new Userdto();
        senderDto.setId(2L);
        senderDto.setFirstName("John");
        senderDto.setLastName("Doe");
        senderDto.setEmail("john.doe@example.com");

        Userdto recipientDto = new Userdto();
        recipientDto.setId(3L);
        recipientDto.setFirstName("Jane");
        recipientDto.setLastName("Smith");
        recipientDto.setEmail("jane.smith@example.com");

        MessageDTO messageDto = new MessageDTO();
        messageDto.setSender(senderDto);
        messageDto.setRecipient(recipientDto);
        messageDto.setContent("Hello Jane!");
//        messageDto.setTimestamp(LocalDateTime.now());

        when(messageService.sendMessage(any(MessageDTO.class))).thenReturn(new Message());
        when(messageMapper.toDto(any(Message.class))).thenReturn(messageDto);

        mockMvc.perform(post("/api/messages/send")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"sender\":{\"id\":2}, \"recipient\":{\"id\":3}, \"content\":\"Hello Jane!\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sender.id").value(2))
                .andExpect(jsonPath("$.recipient.id").value(3))
                .andExpect(jsonPath("$.content").value("Hello Jane!"));
    }

    @Test
    public void testGetMessagesForRecipient() throws Exception {
        Userdto senderDto = new Userdto();
        senderDto.setId(2L);
        senderDto.setFirstName("John");
        senderDto.setLastName("Doe");
        senderDto.setEmail("john.doe@example.com");

        Userdto recipientDto = new Userdto();
        recipientDto.setId(3L);
        recipientDto.setFirstName("Jane");
        recipientDto.setLastName("Smith");
        recipientDto.setEmail("jane.smith@example.com");

        MessageDTO messageDto = new MessageDTO();
        messageDto.setSender(senderDto);
        messageDto.setRecipient(recipientDto);
        messageDto.setContent("Hello Jane!");
//        messageDto.setTimestamp(LocalDateTime.now());
//
        when(messageService.getMessagesForRecipient(3L)).thenReturn(Collections.singletonList(messageDto));

        mockMvc.perform(get("/api/messages/recipient/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sender.id").value(2))
                .andExpect(jsonPath("$[0].recipient.id").value(3))
                .andExpect(jsonPath("$[0].content").value("Hello Jane!"));
    }
}