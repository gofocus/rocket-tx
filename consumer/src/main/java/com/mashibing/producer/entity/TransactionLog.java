package com.mashibing.producer.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * transaction_log
 * @author 
 */
@Data
public class TransactionLog implements Serializable {
    /**
     * 事务ID
     */
    private String id;

    /**
     * 业务标识
     */
    private String business;

    /**
     * 对应业务表中的主键
     */
    private String foreignKey;

    private static final long serialVersionUID = 1L;
}