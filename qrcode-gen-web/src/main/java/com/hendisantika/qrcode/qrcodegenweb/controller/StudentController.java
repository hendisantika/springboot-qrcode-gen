package com.hendisantika.qrcode.qrcodegenweb.controller;

import com.google.zxing.WriterException;
import com.hendisantika.qrcode.qrcodegenweb.model.Student;
import com.hendisantika.qrcode.qrcodegenweb.service.StudentService;
import com.hendisantika.qrcode.qrcodegenweb.util.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-qrcode-gen
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/24/23
 * Time: 06:55
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws IOException, WriterException {
        List<Student> students = studentService.getStudents();
        if (students.size() != 0) {
            for (Student student : students) {
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
}
