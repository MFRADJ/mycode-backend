package org.javaprojects.mycode.message;

import org.javaprojects.mycode.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageMapper {


    private UserMapper userMapper;

    public MessageDTO toDto(Message message) {
        MessageDTO dto = new MessageDTO();
        dto.setId(message.getId());
        dto.setSender(userMapper.toDto(message.getSender()));
        dto.setRecipient(userMapper.toDto(message.getRecipient()));
        dto.setContent(message.getContent());
        return dto;
    }
}
