package com.mashibing.producer.service;

import com.mashibing.producer.entity.OrderBase;

public interface PointsService {

    public void increasePoints(OrderBase order);
}