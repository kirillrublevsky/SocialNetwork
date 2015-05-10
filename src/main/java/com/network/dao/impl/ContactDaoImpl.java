package com.network.dao.impl;

import com.network.dao.ContactDao;
import com.network.dao.entity.Contact;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ContactDaoImpl() {}

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createQuery("FROM Contact").list();
    }

    @Override
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    public void deleteContact(long contactId) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE Contact WHERE id = :contactId");
        query.setParameter("contactId", contactId);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getFriendsList(long contactId){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT c FROM Contact c JOIN c.contacts s WHERE s.id = :contactId");
        query.setParameter("contactId", contactId);
        return query.list();
    }


    @Override
    public void addFriendship(long contactId, long friendId){
        Session session = sessionFactory.getCurrentSession();
        Contact contact = (Contact) session.load(Contact.class, contactId);
        Contact friend = (Contact) session.load(Contact.class, friendId);
        contact.getContacts().add(friend);
        friend.getContacts().add(contact);
        session.update(contact);
        session.update(friend);
    }

    @Override
    public void removeFriendship(long contactId, long friendId){
        Session session = sessionFactory.getCurrentSession();
        Contact contact = (Contact) session.load(Contact.class, contactId);
        Contact friend = (Contact) session.load(Contact.class, friendId);
        contact.getContacts().remove(friend);
        friend.getContacts().remove(contact);
        session.update(contact);
        session.update(friend);
    }

}
