package com.network.service.impl;

import com.network.dao.ContactDao;
import com.network.dao.entity.Contact;
import com.network.model.ContactDTO;
import com.network.service.ContactService;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactDao contactDao;

    public ContactServiceImpl() {}

    public ContactDao getContactDao() {
        return contactDao;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    @Transactional
    public void createContact(String firstName, String lastName, LocalDate birthDate){
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthDate(birthDate);
        contactDao.addContact(contact);
    }

    @Override
    @Transactional
    public void removeContact(long contactId){
        contactDao.deleteContact(contactId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContacts(){
        return convertListContactToListContactDTO(contactDao.getAllContacts());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getFriendsList(long contactId){
        return convertListContactToListContactDTO(contactDao.getFriendsList(contactId));
    }

    @Override
    @Transactional
    public void addFriendship(long contactId, long friendId){
        contactDao.addFriendship(contactId, friendId);
    }

    @Override
    @Transactional
    public void removeFriendship(long contactId, long friendId){
        contactDao.removeFriendship(contactId, friendId);
    }


    @Override
    public List<ContactDTO> convertListContactToListContactDTO(List<Contact> contactList){
        List<ContactDTO> contactDTOList = new ArrayList<ContactDTO>();
        ContactDTO contactDTO;
        for (Contact contact : contactList) {
            contactDTO = convertContactToContactDTO(contact);
            contactDTOList.add(contactDTO);
        }
        return contactDTOList;
    }


    private ContactDTO convertContactToContactDTO(Contact contact){
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.setId(contact.getId());
        contactDTO.setFirstName(contact.getFirstName());
        contactDTO.setLastName(contact.getLastName());
        contactDTO.setBirthDate(contact.getBirthDate());

        return contactDTO;
    }





}
