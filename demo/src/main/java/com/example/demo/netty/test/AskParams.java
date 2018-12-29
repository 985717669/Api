package com.example.demo.netty.test;

import lombok.Data;

import java.io.Serializable;

/**
 * Author fengjf
 * Desc
 */
@Data
public class AskParams implements Serializable {
    private static final long serialVersionUID = 5587604130586256842L;
    private String auth;
    private String content;

}
