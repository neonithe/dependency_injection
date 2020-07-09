package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

public class App 
{
    public static void main( String[] args )
    {
      /*  AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDAO studentDAO = context.getBean(StudentDAO.class);

        System.out.println(studentDAO.save(new Student("Mattias")));

        context.close();*/

   /*     AnnotationConfigApplicationContext context2 =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        UserInputService userInputService = context2.getBean(UserInputService.class);

        context2.close(); */

        AnnotationConfigApplicationContext context3 =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentManagement studentManagement = context3.getBean(StudentManagement.class);
        Student created = studentManagement.create();
        System.out.println(created);

    }
}
