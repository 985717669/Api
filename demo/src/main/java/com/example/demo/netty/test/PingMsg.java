package com.example.demo.netty.test;

/**
 * Author fengjf
 * Desc
 */
public class PingMsg extends BaseMsg {
    private static final long serialVersionUID = 4005674414953621802L;
    public PingMsg() {
        super();
        setType(MsgType.PING);
    }

}
