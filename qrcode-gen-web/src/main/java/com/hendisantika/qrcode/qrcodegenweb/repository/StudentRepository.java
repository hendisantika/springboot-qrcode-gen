package com.hendisantika.qrcode.qrcodegenweb.repository;

import com.hendisantika.qrcode.qrcodegenweb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-qrcode-gen
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/24/23
 * Time: 06:53
 * To change this template use File | Settings | File Templates.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
