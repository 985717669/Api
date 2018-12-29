package com.example.demo.netty.test;

import lombok.Data;

/**
 * Author fengjf
 * Desc
 */
@Data
public class ReplyServerBody extends ReplyBody {
    private static final long serialVersionUID = 4268730819788815370L;

    private String serverInfo;
    public ReplyServerBody(String serverInfo) {
        this.serverInfo = serverInfo;
    }

}
