import com.network.dao.ContactDao;
import com.network.dao.ContactDaoImpl;
import com.network.dao.HobbyDao;
import com.network.dao.HobbyDaoImpl;
import com.network.model.Contact;
import com.network.model.Hobby;
import com.network.service.JavaContactServiceImpl;
import org.joda.time.LocalDate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        JavaContactServiceImpl service = context.getBean("javaContactService", JavaContactServiceImpl.class);

        Contact stark = service.createContact("Eddard", "Stark", new LocalDate(1227, 4, 10));
        service.addHobby(stark, "hiking", "Hiking in all the mountains of the world!");
        service.addHobby(stark, "bikes", "I like travelling by bike");
        service.addPlace(stark, "London", "The capital of Great Britain", 23, 3456);

        Contact scott = context.getBean("scott", Contact.class);
        service.addFriendship(stark, scott);
        System.out.println("Bon Scott has friends: " + service.getFriendsList(scott));


        Hobby bikes = context.getBean("bikes", Hobby.class);
        HobbyDao hobbyDao = context.getBean("hobbyDao", HobbyDaoImpl.class);
        ContactDao contactDao = context.getBean("contactDao", ContactDaoImpl.class);
        System.out.println("All contacts with hobby 'bikes':");
        System.out.println(hobbyDao.getAllContactsWithHobby(bikes));





    }
}
