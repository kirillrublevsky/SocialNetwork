package com.network.dao;

import com.network.dao.entity.Message;

import java.util.List;

public interface MessageDao {

    void storeMessage(long contactFromId, long contactToId, String content);
    List<Message> getConversation(long contactFromId, long contactToId);
}
