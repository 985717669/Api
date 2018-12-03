package com.example.demo.sms;

import com.aliyuncs.exceptions.ClientException;

/**
 * @Author fengjf
 * @Desc 测试阿里云发送短信验证码
 **/

public class AliSmsTest {
    public static void main(String[] args) {
        SendSms duanxin = new SendSms();
        try {
            duanxin.send("17737552970", 0, "123123");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
