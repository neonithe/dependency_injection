package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.data_access.UserInputService;
import se.lexicon.models.Student;

public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        System.out.println(studentDAO.save(new Student("Mattias")));

        context.close();

        AnnotationConfigApplicationContext context2 =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        UserInputService userInputService = context2.getBean(UserInputService.class);

        System.out.println(userInputService.getString());

        context2.close();

    }
}
