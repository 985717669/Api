package com.example.demo.netty.test;

import lombok.Data;

/**
 * Author fengjf
 * Desc
 */
@Data
public class Constants {
    private static String clientId;

    public static String getClientId() {
        return clientId;
    }

    public static void setClientId(String clientId) {
        Constants.clientId = clientId;
    }

}
