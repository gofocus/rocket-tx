package com.mashibing.producer.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * order_base
 * @author 
 */
@Data
public class OrderBase implements Serializable {
    private Integer id;

    private String orderNo;

    private static final long serialVersionUID = 1L;
}