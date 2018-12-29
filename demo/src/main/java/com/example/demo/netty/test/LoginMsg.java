package com.example.demo.netty.test;

import lombok.Data;

/**
 * Author fengjf
 * Desc
 */
@Data
public class LoginMsg  extends BaseMsg{
    private static final long serialVersionUID = -853675252209720208L;
    private String userName;
    private String password;
    public LoginMsg() {
        super();
        setType(MsgType.LOGIN);
    }

}
