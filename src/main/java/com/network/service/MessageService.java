package com.network.service;

import com.network.model.MessageDTO;

import java.util.List;

public interface MessageService {

    void storeMessage(long contactFromId, long contactToId, String content);
    List<MessageDTO> getConversation(long contactFromId, long contactToId);
}
