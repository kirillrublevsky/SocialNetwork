package com.network.dao;

import com.network.model.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactDaoImpl implements ContactDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ContactDaoImpl() {}

    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createQuery("FROM contact").list();
    }

    @Override
    public void addContact(Contact contact) {

    }

    @Override
    public void deleteContact(Contact contact) {


    }

//    @Override
//    public void addFriendship(Contact contact, Contact friend){
//        contact.getFriends().add(friend);
//        friend.getFriends().add(contact);
//    }
//
//    @Override
//    public void removeFriendship(Contact contact, Contact friend){
//        contact.getFriends().remove(friend);
//        friend.getFriends().remove(contact);
//    }

}
