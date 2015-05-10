import com.network.service.MessageService;
import com.network.service.PlaceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageService messageService = context.getBean(MessageService.class);

        System.out.println(messageService.getConversation(1,2));










    }
}
