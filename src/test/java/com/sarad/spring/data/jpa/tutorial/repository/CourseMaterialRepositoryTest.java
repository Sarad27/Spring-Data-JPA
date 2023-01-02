package com.sarad.spring.data.jpa.tutorial.repository;

import com.sarad.spring.data.jpa.tutorial.entity.Course;
import com.sarad.spring.data.jpa.tutorial.entity.CourseMaterial;
import com.sarad.spring.data.jpa.tutorial.entity.Student;
import com.sarad.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course =
                Course.builder()
                        .title("DSA")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.google.com")
                        .course(course)
                        .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList =
                courseMaterialRepository.findAll();

        System.out.println("courseMaterialList = " + courseMaterialList);

    }



}