package com.network;

import com.network.dao.ContactDao;
import com.network.dao.HobbyDao;
import com.network.dao.PlaceDao;
import com.network.model.Contact;
import com.network.service.JavaContactService;
import com.network.service.JavaContactServiceImpl;
import org.joda.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class JavaContactServiceTest {

    @Mock
    private ContactDao mockContactDao;

    @Mock
    private HobbyDao mockHobbyDao;

    @Mock
    private PlaceDao mockPlaceDao;

    @InjectMocks
    private JavaContactService service = new JavaContactServiceImpl();

    @BeforeClass
    public static void beforeClassMessage(){
        System.out.println("Starting tests");
    }

    @Test
    public void testCreateContact(){
        String firstName = "Mike";
        String lastName = "Smith";
        LocalDate birthDate = new LocalDate(1967, 9, 11);
        Contact contact = new Contact();
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthDate(birthDate);

        service.createContact(firstName, lastName, birthDate);
        verify(mockContactDao).addContact(contact);

    }

    @AfterClass
    public static void afterClassMessage(){
        System.out.println("Tests are over.Have fun!");
    }









}
