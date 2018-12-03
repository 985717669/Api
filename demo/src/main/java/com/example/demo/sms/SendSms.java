package com.example.demo.sms;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author fengjf
 * @Desc 短信服务
 **/

public class SendSms {

    private String URL="dysmsapi.aliyuncs.com"; // 阿里短信验证码url

    private String ACCESS_ID="LTAIrEv8URC1EymP"; // 阿里账号app key


    private String ACCESS_KEY="OZ8seK2tYRSo3AsvDGak30xgIsZQrq"; // 阿里账号app secret

    private String PRODUCT="Dysmsapi"; // 短信签名

    private String SIGN_NAME="微兔科技"; // 短信签名

    private String TID_DEFAULT="SMS_79005066"; // 默认短信模板号

    private String TID_CAPTCHA_REGISTER="SMS_78975068"; // 注册短信模板号

    private Logger logger = LoggerFactory.getLogger(SendSms.class);

    /**
     * 阿里短信验证码
     *
     * @param mobile 手机号
     * @param type   模板类型——
     *               0: 通用验证码
     *               1: 注册验证码
     *               2: 修改密码验证码
     *               3: 注册成功短信通知(商家注册)
     *               4: 注册成功短信通知(店铺注册)
     *               5: 服务商提现申请
     *               6: 服务商添加提现账户
     *               7: 服务商授权手机号更改
     */
    public void send(String mobile, Integer type, String content) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_ID, ACCESS_KEY);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, URL);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(SIGN_NAME);

        switch (type) {
            case 0:    // 默认短信模板
                //必填:短信模板-可在短信控制台中找到
                request.setTemplateCode(TID_DEFAULT);
                //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
                request.setTemplateParam("{\"code\":\"" + content + "\"}");
                break;
            case 1:    // // 注册验证码短信模板
                request.setTemplateCode(TID_CAPTCHA_REGISTER);
                request.setTemplateParam("{\"code\":\"" + content + "\"}");
                break;
        }
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        String returnCode = sendSmsResponse.getCode();
        if (returnCode != null && returnCode.equals("OK")) {
            logger.info("短信发送成功! [" +content + "] >>>>>>>>>>> " + mobile);
            return;
        } else {
            logger.error("短信发送失败! 错误信息:" + sendSmsResponse.getCode() + "=" + sendSmsResponse.getMessage());
        }
    }


}
