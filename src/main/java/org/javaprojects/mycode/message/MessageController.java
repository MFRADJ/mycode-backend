package org.javaprojects.mycode.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageMapper messageMapper;

    @PostMapping("/send")
    public ResponseEntity<MessageDTO> sendMessage(@RequestBody MessageDTO messageDto) {
        Message message = messageService.sendMessage(messageDto);
        return ResponseEntity.ok(messageMapper.toDto(message));
    }

    @GetMapping("/recipient/{recipientId}")
    public ResponseEntity<List<MessageDTO>> getMessagesForRecipient(@PathVariable Long recipientId) {
        List<MessageDTO> messageDtos = messageService.getMessagesForRecipient(recipientId);
        return ResponseEntity.ok(messageDtos);
    }
}