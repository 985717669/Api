package com.example.demo.netty.test;

import lombok.Data;

import java.io.Serializable;

/**
 * Author fengjf
 * Desc
 */

@Data
public abstract class BaseMsg implements Serializable {
    private static final long serialVersionUID = -3702700975656877242L;

    private MsgType type;
    //必须唯一，否者会出现channel调用混乱
    private String clientId;

    //初始化客户端id
    public BaseMsg() {
        this.clientId = Constants.getClientId();
    }

}
