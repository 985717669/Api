package com.example.demo.netty.test;

import lombok.Data;

/**
 * Author fengjf
 * Desc
 */
@Data
public class ReplyMsg extends BaseMsg {
    private static final long serialVersionUID = 4178160854389991675L;
    public ReplyMsg() {
        super();
        setType(MsgType.REPLY);
    }
    private ReplyBody body;
}
