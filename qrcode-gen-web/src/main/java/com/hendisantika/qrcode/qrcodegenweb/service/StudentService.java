package com.hendisantika.qrcode.qrcodegenweb.service;

import com.hendisantika.qrcode.qrcodegenweb.model.Student;
import com.hendisantika.qrcode.qrcodegenweb.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-qrcode-gen
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/24/23
 * Time: 06:54
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

}
