package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;

@Service
public class StudentManagementConsoleImpl implements StudentManagement {

    private final UserInputService scannerService;
    private final StudentDAO studentdao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDAO studentdao) {
        this.scannerService = scannerService;
        this.studentdao = studentdao;
    }

    @Override
    public Student create() {
        System.out.print("Enter name:");
        return save(new Student(scannerService.getString()));
    }

    @Override
    public Student save(Student student) {
        return studentdao.save(student);
    }

    @Override
    public Student find(int id) throws RuntimeException {
        return studentdao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = studentdao.find(id);
        studentdao.delete(id);
        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentdao.findAll();
    }

    @Override
    public Student edit(Student student) {
        //throw NoImpl("This is not implemented yet");

        Student person = find(student.getId());
        System.out.print("New name:");
        String in = scannerService.getString();
        person.setName(in);
        return person;
    }
}
