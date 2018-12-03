package com.example.demo.es.transport;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @Author fengjf
 * @Desc
 **/
@Data
public class Good {
    String goodsName;
    BigDecimal goodsPrice;
    String goodsUser;
    Date goodsTime;
}
