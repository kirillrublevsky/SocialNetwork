package com.network.service.impl;

import com.network.dao.HobbyDao;
import com.network.dao.entity.Hobby;
import com.network.model.ContactDTO;
import com.network.model.HobbyDTO;
import com.network.service.ContactService;
import com.network.service.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HobbyServiceImpl implements HobbyService {

    @Autowired
    private HobbyDao hobbyDao;

    @Autowired
    private ContactService contactService;

    public HobbyServiceImpl() {}

    public HobbyDao getHobbyDao() {
        return hobbyDao;
    }

    public void setHobbyDao(HobbyDao hobbyDao) {
        this.hobbyDao = hobbyDao;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    @Transactional
    public void addHobby(String title, String description){
        Hobby hobby = new Hobby();
        hobby.setTitle(title);
        hobby.setDescription(description);
        hobbyDao.addHobby(hobby);
    }

    @Override
    @Transactional
    public void removeHobby(long hobbyId){
        hobbyDao.deleteHobby(hobbyId);
    }


    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContactsWithHobby(long hobbyId){
        return contactService.convertListContactToListContactDTO(hobbyDao.getAllContactsWithHobby(hobbyId));
    }

    @Override
    @Transactional
    public void addHobbyToContact(long hobbyId, long contactId){
        hobbyDao.addHobbyToContact(hobbyId, contactId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HobbyDTO> getAllHobbies(){
        return convertListHobbyToListHobbyDTO(hobbyDao.getAllHobbies());
    }



    private HobbyDTO convertHobbyToHobbyDTO(Hobby hobby){
        HobbyDTO hobbyDTO = new HobbyDTO();
        hobbyDTO.setId(hobby.getId());
        hobbyDTO.setTitle(hobby.getTitle());
        hobbyDTO.setDescription(hobby.getDescription());

        return hobbyDTO;
    }

    private List<HobbyDTO> convertListHobbyToListHobbyDTO(List<Hobby> hobbyList){
        List<HobbyDTO> hobbyDTOList = new ArrayList<HobbyDTO>();
        HobbyDTO hobbyDTO;
        for (Hobby hobby : hobbyList) {
            hobbyDTO = convertHobbyToHobbyDTO(hobby);
            hobbyDTOList.add(hobbyDTO);
        }
        return hobbyDTOList;
    }

}
