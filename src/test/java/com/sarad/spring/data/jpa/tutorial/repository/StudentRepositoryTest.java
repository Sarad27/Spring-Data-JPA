package com.sarad.spring.data.jpa.tutorial.repository;

import com.sarad.spring.data.jpa.tutorial.entity.Guardian;
import com.sarad.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().
                emailId("sarad@gmail.com")
                .firstName("Sarad")
                .lastName("Subedi")
//                .guardianName("Sam")
//                .guardianEmail("sam@gmail.com")
//                .guardianMobile("123456789")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("percy@gmail.com")
                .name("Percy")
                .mobile("987654321")
                .build();

        Student student = Student.builder().
                emailId("samuel@gmail.com")
                .firstName("Samuel")
                .lastName("Jackson")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("Sarad");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("Sa");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Percy");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("sarad@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("sarad@gmail.com");
        System.out.println("First Name = " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("sarad@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("sarad@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void updateStudentNameByEmailId(){
        studentRepository.updateStudentNameByEmailId("Updated Name","sarad@gmail.com");
    }

}