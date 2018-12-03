package com.hendisantika.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by IntelliJ IDEA.
 * Project : qrcodegen
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2018-12-04
 * Time: 03:52
 * To change this template use File | Settings | File Templates.
 */
public class QRCodeGenerator {
    private static String QRCODE_PATH = "/tmp/QRCODE-SERVER/";

    public static void main(String[] args) throws Exception {
        QRCodeGenerator codeGenerator = new QRCodeGenerator();
        /*
         * System.out.println( codeGenerator.writeQRCode(new
         * PaytmRequestBody("Javatechie", "1234567890", "Personal", "acc23457612")));
         */
        System.out.println(codeGenerator.readQRCode(QRCODE_PATH + "Angular.png"));
    }

    public String writeQRCode(PaymentRequest paytmRequestBody) throws Exception {
        String qrcode = QRCODE_PATH + paytmRequestBody.getUserName() + "-QRCODE.png";
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(
                paytmRequestBody.getUserName() + "\n" + paytmRequestBody.getAccountNo() + "\n"
                        + paytmRequestBody.getAccountType() + "\n" + paytmRequestBody.getMobileNo(),
                BarcodeFormat.QR_CODE, 350, 350);
        Path path = FileSystems.getDefault().getPath(qrcode);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
        return "QRCODE is generated successfully....";
    }

    public String readQRCode(String qrcodeImage) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(new File(qrcodeImage));
        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        return result.getText();

    }
}
