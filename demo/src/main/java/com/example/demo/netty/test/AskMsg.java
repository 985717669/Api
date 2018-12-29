package com.example.demo.netty.test;

import lombok.Data;

/**
 * Author fengjf
 * Desc
 */
@Data
public class AskMsg extends BaseMsg {
    private static final long serialVersionUID = -301973238489291095L;
    public AskMsg() {
        super();
        setType(MsgType.ASK);
    }
    private AskParams params;
}
