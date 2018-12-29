package com.example.demo.netty.test;

/**
 * Author fengjf
 * Desc
 */
public class ReplyClientBody extends ReplyBody {
    private static final long serialVersionUID = -7811554301399782513L;
    private String clientInfo;

    public ReplyClientBody(String clientInfo) {
        this.clientInfo = clientInfo;
    }

}
