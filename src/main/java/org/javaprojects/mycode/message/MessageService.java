package org.javaprojects.mycode.message;

import lombok.RequiredArgsConstructor;
import org.javaprojects.mycode.message.MessageDTO;
import org.javaprojects.mycode.message.MessageMapper;
import org.javaprojects.mycode.user.User;
import org.javaprojects.mycode.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {


    private MessageRepository messageRepository;


    private UserRepository userRepository;

    private MessageMapper messageMapper;

    @Transactional
    public Message sendMessage(MessageDTO messageDto) {
        User sender = userRepository.findById(messageDto.getSender().getId())
                .orElseThrow(() -> new IllegalArgumentException("Sender not found"));
        User recipient = userRepository.findById(messageDto.getRecipient().getId())
                .orElseThrow(() -> new IllegalArgumentException("Recipient not found"));

        Message message = new Message();
        message.setSender(sender);
        message.setRecipient(recipient);
        message.setContent(messageDto.getContent());
        message.setTimestamp(java.time.LocalDateTime.now());

        return messageRepository.save(message);
    }

    public List<MessageDTO> getMessagesForRecipient(Long recipientId) {
        List<Message> messages = messageRepository.findByRecipientId(recipientId);
        return messages.stream()
                .map(messageMapper::toDto)
                .collect(Collectors.toList());
    }
}
