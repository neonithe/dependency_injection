package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDAOListImpl implements StudentDAO{

    private List<Student> studentList = new ArrayList<>();

    @Override
    public Student save(Student student) {
        if(studentList.contains(student)){
            studentList.add(student);
        }
        return student;
    }

    @Override
    public Student find(int id) {
        for(Student student : studentList){
            if(student.getId() == id){
                return student;
            }
        }
        throw new RuntimeException("Cannot find"+id);
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void delete(int id) {
        Student delete = find(id);
        studentList.remove(delete);
    }
}
