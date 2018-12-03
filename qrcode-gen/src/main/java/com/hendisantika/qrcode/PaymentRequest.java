package com.hendisantika.qrcode;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : qrcodegen
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2018-12-04
 * Time: 03:51
 * To change this template use File | Settings | File Templates.
 */

@Data
public class PaymentRequest {
    private String userName;
    private String mobileNo;
    private String accountType;
    private String accountNo;
}
