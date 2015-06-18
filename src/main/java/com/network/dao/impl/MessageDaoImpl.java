package com.network.dao.impl;

import com.network.dao.MessageDao;
import com.network.dao.entity.Contact;
import com.network.dao.entity.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    public MessageDaoImpl() {}

    @Override
    public void storeMessage(long contactFromId, long contactToId, String content){
        Session session = sessionFactory.getCurrentSession();
        Contact contactFrom = (Contact) session.load(Contact.class, contactFromId);
        Contact contactTo = (Contact) session.load(Contact.class, contactToId);
        Message message = new Message();
        message.setFromContact(contactFrom);
        message.setToContact(contactTo);
        message.setContent(content);
        session.save(message);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Message> getConversation(long contactOneId, long contactTwoId){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT m FROM Message m WHERE (m.fromContact.id = :contactOneId AND m.toContact.id = :contactTwoId)" +
                        " AND (m.fromContact.id = :contactTwoId AND m.toContact.id = :contactOneId)");
        query.setParameter("contactOneId", contactOneId);
        query.setParameter("contactTwoId", contactTwoId);
        return query.list();
    }


}
