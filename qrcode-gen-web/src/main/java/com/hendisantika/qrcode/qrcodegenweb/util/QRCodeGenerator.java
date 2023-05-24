package com.hendisantika.qrcode.qrcodegenweb.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.hendisantika.qrcode.qrcodegenweb.model.Student;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-qrcode-gen
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 5/24/23
 * Time: 06:47
 * To change this template use File | Settings | File Templates.
 */
public class QRCodeGenerator {
    public static void generateQRCode(Student student) throws WriterException, IOException {
        String userHomeDir = System.getProperty("user.home");
        String qrCodePath = "/Users/hendisantika/Desktop/QRCode";
        String qrCodeName = qrCodePath + student.getFirstName() + student.getId() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(
                "ID: " + student.getId() + "\n" +
                        "Firstname: " + student.getFirstName() + "\n" +
                        "Lastname: " + student.getLastName() + "\n" +
                        "Email: " + student.getEmail() + "\n" +
                        "Mobile: " + student.getMobile(), BarcodeFormat.QR_CODE, 400, 400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }
}
