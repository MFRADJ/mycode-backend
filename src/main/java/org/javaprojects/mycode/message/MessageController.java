package org.javaprojects.mycode.message;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {


    private MessageService messageService;

    @GetMapping("/recipient/{recipientId}")
    public List<Message> getMessagesByRecipientId(@PathVariable Long recipientId) {
        return messageService.getMessagesByRecipientId(recipientId);
    }


    @GetMapping("/sender/{senderId}")
    public List<Message> getMessagesBySenderId(@PathVariable Long senderId) {
        return messageService.getMessagesBySenderId(senderId);
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);
    }
}

