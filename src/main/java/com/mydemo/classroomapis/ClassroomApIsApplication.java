package com.mydemo.classroomapis;

import com.mydemo.classroomapis.Entity.Parent;
import com.mydemo.classroomapis.Entity.Student;
import com.mydemo.classroomapis.Entity.Subject;
import com.mydemo.classroomapis.Entity.Teacher;
import com.mydemo.classroomapis.Repository.ParentRepository;
import com.mydemo.classroomapis.Repository.StudentRepository;
import com.mydemo.classroomapis.Repository.SubjectRepository;
import com.mydemo.classroomapis.Repository.TeacherRepository;
import com.mydemo.classroomapis.Security.PasswordConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ClassroomApIsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassroomApIsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PasswordConfig passwordConfig, ParentRepository parentRepository, StudentRepository studentRepository, TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        return args -> {

            Parent parent = new Parent();
            parent.setUsername("linda");
            parent.setPassword(passwordConfig.passwordEncoder().encode("password"));
            parent.setRole("PARENT");
            parent.setParentName("Linda");
            parent.setParentAddress("123 Main St");
            parent.setParentPhone("1234567890");

            Teacher teacher = new Teacher();
            teacher.setUsername("tom");
            teacher.setPassword(passwordConfig.passwordEncoder().encode("password"));
            teacher.setRole("TEACHER");
            teacher.setTeacherName("Tom");

            Student student = new Student();
            student.setUsername("annasmith");
            student.setPassword(passwordConfig.passwordEncoder().encode("password"));
            student.setRole("STUDENT");
            student.setStudentName("Anna Smith");
            student.setStudentPhone("1234567890");


            Subject subject = new Subject();
            subject.setSubjectName("Math");
            subject.setSubjectDescription("Mathematics");
            subjectRepository.save(subject);

            // Associate teacher with subject
            teacher.setSubject(subject);
            subject.setTeacher(teacher);

            // Associate student with subject
            student.setSubjects(List.of(subject));
            subject.setStudents(List.of(student));

            // Associate parent with student
            student.setParent(parent);
            parent.setStudents(List.of(student));

            // Associate teacher with student
            student.setTeachers(List.of(teacher));
            teacher.setStudents(List.of(student));

            // Save parent, student, and teacher
            parentRepository.save(parent);
            teacherRepository.save(teacher);
            subjectRepository.save(subject);
            studentRepository.save(student);
        };
    }

}
