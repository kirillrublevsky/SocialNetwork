package com.network.service.impl;

import com.network.dao.MessageDao;
import com.network.dao.entity.Message;
import com.network.model.MessageDTO;
import com.network.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    public MessageServiceImpl() {
    }

    public MessageDao getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    @Override
    @Transactional
    public void storeMessage(long contactFromId, long contactToId, String content){
        messageDao.storeMessage(contactFromId, contactToId, content);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MessageDTO> getConversation(long contactFromId, long contactToId){
        return convertListMessageToListMessageDTO(messageDao.getConversation(contactFromId, contactToId));
    }


    private List<MessageDTO> convertListMessageToListMessageDTO(List<Message> messageList){
        List<MessageDTO> messageDTOList = new ArrayList<MessageDTO>();
        MessageDTO messageDTO;
        for (Message message : messageList) {
            messageDTO = convertMessageToMessageDTO(message);
            messageDTOList.add(messageDTO);
        }
        return messageDTOList;
    }

    private MessageDTO convertMessageToMessageDTO(Message message){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setId(message.getId());
        messageDTO.setDate(message.getDate());
        messageDTO.setFromContact(message.getFromContact());
        message.setToContact(message.getToContact());
        message.setContent(message.getContent());

        return messageDTO;
    }


}
