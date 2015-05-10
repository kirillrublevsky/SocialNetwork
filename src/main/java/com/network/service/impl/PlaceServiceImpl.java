package com.network.service.impl;

import com.network.dao.PlaceDao;
import com.network.dao.entity.Place;
import com.network.model.ContactDTO;
import com.network.model.PlaceDTO;
import com.network.service.ContactService;
import com.network.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDao placeDao;

    @Autowired
    private ContactService contactService;

    public PlaceServiceImpl() {}

    public PlaceDao getPlaceDao() {
        return placeDao;
    }

    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    public ContactService getContactService() {
        return contactService;
    }

    public void setContactService(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    @Transactional
    public void addPlace(String title, String description, double longitude, double latitude){
        Place place = new Place();
        place.setTitle(title);
        place.setDescription(description);
        place.setLongitude(longitude);
        place.setLatitude(latitude);
        placeDao.addPlace(place);
    }

    @Override
    @Transactional
    public void removePlace(long placeId){
        placeDao.deletePlace(placeId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactDTO> getAllContactsWithPlace(long placeId){
        return contactService.convertListContactToListContactDTO(placeDao.getAllContactsWithPlace(placeId));
    }

    @Override
    @Transactional
    public void addPlaceToContact(long placeId, long contactId){
        placeDao.addPlaceToContact(placeId, contactId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlaceDTO> getAllPlaces(){
        return convertListPlaceToListPlaceDTO(placeDao.getAllPlaces());
    }



    private PlaceDTO convertPlaceToPlaceDTO(Place place){
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(place.getId());
        placeDTO.setTitle(place.getTitle());
        placeDTO.setDescription(place.getDescription());
        placeDTO.setLongitude(place.getLongitude());
        placeDTO.setLatitude(place.getLatitude());

        return placeDTO;
    }

    private List<PlaceDTO> convertListPlaceToListPlaceDTO(List<Place> placeList){
        List<PlaceDTO> placeDTOList = new ArrayList<PlaceDTO>();
        PlaceDTO placeDTO;
        for (Place place : placeList) {
            placeDTO = convertPlaceToPlaceDTO(place);
            placeDTOList.add(placeDTO);
        }
        return placeDTOList;
    }

}
