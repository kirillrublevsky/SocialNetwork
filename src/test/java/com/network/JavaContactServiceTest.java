//package com.network;
//
//import com.network.dao.ContactDao;
//import com.network.dao.HobbyDao;
//import com.network.dao.PlaceDao;
//import com.network.model.Contact;
//import com.network.model.Hobby;
//import com.network.model.Place;
//import com.network.service.JavaContactService;
//import com.network.service.JavaContactServiceImpl;
//import org.joda.time.LocalDate;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Spy;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.Set;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.core.IsEqual.equalTo;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
//import static org.mockito.Matchers.eq;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.verify;
//
//@RunWith(MockitoJUnitRunner.class)
//public class JavaContactServiceTest {
//
//    @Mock
//    private ContactDao mockContactDao;
//
//    @Mock
//    private HobbyDao mockHobbyDao;
//
//    @Mock
//    private PlaceDao mockPlaceDao;
//
//    @InjectMocks
//    private JavaContactService service = new JavaContactServiceImpl();
//
//    @BeforeClass
//    public static void beforeClassMessage(){
//        System.out.println("Starting tests");
//    }
//
//    @Test
//    public void testCreateContactCausesAddContact(){
//        Contact contact = new Contact();
//        String firstName = "Mike";
//        String lastName = "Smith";
//        LocalDate birthDate = new LocalDate(1967, 9, 11);
//        contact.setFirstName(firstName);
//        contact.setLastName(lastName);
//        contact.setBirthDate(birthDate);
//
//        service.createContact(firstName, lastName, birthDate);
//        verify(mockContactDao).addContact(eq(contact));
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testCreateContactWithEmptyFirstName(){
//        String lastName = "Smith";
//        LocalDate birthDate = new LocalDate(1967, 9, 11);
//
//        service.createContact(null, lastName, birthDate);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testCreateContactWithEmptyLastName(){
//        String firstName = "Mike";
//        LocalDate birthDate = new LocalDate(1967, 9, 11);
//
//        service.createContact(firstName, null, birthDate);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testCreateContactWithEmptyBirthDate(){
//        String firstName = "Mike";
//        String lastName = "Smith";
//
//        service.createContact(firstName, lastName, null);
//    }
//
//    @Test
//    public void testAddHobbyCausesAddHobby(){
//        Contact contact = new Contact();
//        String title = "soccer";
//        String description = "Playing soccer is cool!";
//        Hobby hobby = new Hobby();
//        hobby.setTitle(title);
//        hobby.setDescription(description);
//
//        service.addHobby(contact, title, description);
//        verify(mockHobbyDao).addHobby(eq(hobby));
//    }
//
////    @Test
////    public void testAddHobbyCausesContactGetHobbies(){
////        String title = "soccer";
////        String description = "Playing soccer is cool!";
////        Contact contact = new Contact();
////        Contact spyContact = spy(contact);
////
////        service.addHobby(spyContact, title, description);
////        verify(spyContact).getHobbies();
////    }
//
//    @Test
//    public void testAddHobbyAddsHobbyToContact(){
//        String title = "soccer";
//        String description = "Playing soccer is cool!";
//        Hobby hobby = new Hobby();
//        hobby.setTitle(title);
//        hobby.setDescription(description);
//
//        Set<Hobby> hobbies = new HashSet<Hobby>();
//        hobbies.add(hobby);
//
//        Contact contact = new Contact();
//        Contact spyContact = spy(contact);
//        service.addHobby(spyContact, title, description);
//
//        assertThat(hobbies, is(equalTo(spyContact.getHobbies())));
//
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testAddHobbyEmptyContactCausesNullPointerException(){
//        String title = "soccer";
//        String description = "Playing soccer is cool!";
//
//        service.addHobby(null, title, description);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddHobbyEmptyTitleCausesIllegalArgumentException(){
//        String description = "Playing soccer is cool!";
//        Contact contact = new Contact();
//
//        service.addHobby(contact, null, description);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddHobbyEmptyDescriptionCausesIllegalArgumentException(){
//        String title = "soccer";
//        Contact contact = new Contact();
//
//        service.addHobby(contact, title, null);
//    }
//
//    @Test
//    public void testAddPlaceCausesAddPlace(){
//        Contact contact = new Contact();
//        String title = "Beijing";
//        String description = "Beijing is the capital of China";
//        double longitude = 10;
//        double latitude = 30;
//        Place place = new Place();
//        place.setTitle(title);
//        place.setDescription(description);
//        place.setLatitude(latitude);
//        place.setLongitude(longitude);
//
//        service.addPlace(contact, title, description, longitude, latitude);
//        verify(mockPlaceDao).addPlace(eq(place));
//    }
//
////    @Test
////    public void testAddPlaceCausesContactGetPlaces(){
////        String title = "Beijing";
////        String description = "Beijing is the capital of China";
////        double longitude = 10;
////        double latitude = 30;
////        Contact contact = new Contact();
////        Contact spyContact = spy(contact);
////
////        service.addPlace(spyContact, title, description, longitude, latitude);
////        verify(spyContact).getPlaces();
////    }
//
//    @Test
//    public void testAddPlaceAddsPlaceToContact(){
//        String title = "Beijing";
//        String description = "Beijing is the capital of China";
//        double longitude = 10;
//        double latitude = 30;
//        Place place = new Place();
//        place.setTitle(title);
//        place.setDescription(description);
//        place.setLatitude(latitude);
//        place.setLongitude(longitude);
//
//        Set<Place> places = new HashSet<Place>();
//        places.add(place);
//
//        Contact contact = new Contact();
//        Contact spyContact = spy(contact);
//        service.addPlace(spyContact, title, description, longitude, latitude);
//
//        assertThat(places, is(equalTo(spyContact.getPlaces())));
//
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testAddPlaceEmptyContactCausesNullPointerException(){
//        String title = "Beijing";
//        String description = "Beijing is the capital of China";
//        double longitude = 10;
//        double latitude = 30;
//
//        service.addPlace(null, title, description, longitude, latitude);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddPlaceEmptyTitleCausesIllegalArgumentException(){
//        String description = "Beijing is the capital of China";
//        double longitude = 10;
//        double latitude = 30;
//        Contact contact = new Contact();
//
//        service.addPlace(contact, null, description, longitude, latitude);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddPlaceEmptyDescriptionCausesIllegalArgumentException(){
//        String title = "Beijing";
//        double longitude = 10;
//        double latitude = 30;
//        Contact contact = new Contact();
//
//        service.addPlace(contact, title, null, longitude, latitude);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddPlaceEmptyLongitudeCausesIllegalArgumentException(){
//        String title = "Beijing";
//        String description = "Beijing is the capital of China";
//        double latitude = 30;
//        Contact contact = new Contact();
//
//        service.addPlace(contact, title, description, 0, latitude);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void testAddPlaceEmptyLatitudeCausesIllegalArgumentException(){
//        String title = "Beijing";
//        String description = "Beijing is the capital of China";
//        double longitude = 10;
//        Contact contact = new Contact();
//
//        service.addPlace(contact, title, description, longitude, 0);
//    }
//
//    @Test
//    public void testAddFriendShipCausesAddFriendship(){
//        Contact contact = new Contact();
//        Contact friend = new Contact();
//
//        service.addFriendship(contact, friend);
//        verify(mockContactDao).addFriendship(contact, friend);
//    }
//
//    @Ignore
//    @Test(expected = NullPointerException.class)
//    public void testAddFriendshipEmptyContactCausesNullPointerException(){
//        Contact contact = new Contact();
//        Contact friend = new Contact();
//
//        service.addFriendship(null, friend);
//    }
//
//    @Test
//    public void testGetFriendsListCausesGetFriends(){
//        Contact contact = new Contact();
//        Contact spyContact = spy(contact);
//
//        service.getFriendsList(spyContact);
//        verify(spyContact).getFriends();
//    }
//
//    @Test(expected = NullPointerException.class)
//    public void testGetFriendsListEmptyContactCausesNullPointerException(){
//        service.getFriendsList(null);
//    }
//
//    @Test
//    public void testGetFriendsListForNotEmptyList(){
//        Contact jim = new Contact();
//        Contact rob = new Contact();
//        service.addFriendship(jim, rob);
//
//        ArgumentCaptor<Contact> firstContactCaptor = ArgumentCaptor.forClass(Contact.class);
//        ArgumentCaptor<Contact> secondContactCaptor = ArgumentCaptor.forClass(Contact.class);
//        verify(mockContactDao).addFriendship(firstContactCaptor.capture(), secondContactCaptor.capture());
//
//        Contact jimCaptor = firstContactCaptor.getValue();
//        Contact robCaptor = secondContactCaptor.getValue();
//
//        assertThat(jimCaptor, is(equalTo(jim)));
//        assertThat(robCaptor, is(equalTo(rob)));
//    }
//
//
//    @AfterClass
//    public static void afterClassMessage(){
//        System.out.println("Tests are over.Have fun!");
//    }
//
//
//
//
//
//
//
//
//
//}
