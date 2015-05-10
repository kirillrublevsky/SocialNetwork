package com.network.dao.impl;

import com.network.dao.HobbyDao;
import com.network.dao.entity.Contact;
import com.network.dao.entity.Hobby;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HobbyDaoImpl implements HobbyDao {

    @Autowired
    private SessionFactory sessionFactory;

    public HobbyDaoImpl() {}

    @Override
    @SuppressWarnings("unchecked")
    public List<Hobby> getAllHobbies() {
        return sessionFactory.getCurrentSession().createQuery("FROM Hobby").list();
    }

    @Override
    public void addHobby(Hobby hobby) {
        sessionFactory.getCurrentSession().save(hobby);
    }

    @Override
    public void deleteHobby(long hobbyId){
        Query query = sessionFactory.getCurrentSession().createQuery(
                "DELETE Hobby WHERE id = :hobbyId");
        query.setParameter("hobbyId", hobbyId);
        query.executeUpdate();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Contact> getAllContactsWithHobby(long hobbyId) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "SELECT c FROM Contact c JOIN c.hobbies h WHERE h.id = :hobbyId");
        query.setParameter("hobbyId", hobbyId);
        return query.list();
    }

    @Override
    public void addHobbyToContact(long hobbyId, long contactId) {
        Session session = sessionFactory.getCurrentSession();
        Hobby hobbyLoaded = (Hobby) session.load(Hobby.class, hobbyId);
        Contact contactLoaded = (Contact) session.load(Contact.class, contactId);
        contactLoaded.getHobbies().add(hobbyLoaded);
        session.update(contactLoaded);
    }
}
