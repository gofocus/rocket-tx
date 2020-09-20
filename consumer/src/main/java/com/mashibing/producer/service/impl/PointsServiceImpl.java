package com.mashibing.producer.service.impl;

import com.mashibing.producer.dao.TblPointsDao;
import com.mashibing.producer.entity.OrderBase;
import com.mashibing.producer.entity.TblPoints;
import com.mashibing.producer.service.PointsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PointsServiceImpl implements PointsService {

    @Autowired
    TblPointsDao pointsMapper;

    @Override
    public void increasePoints(OrderBase order) {
        
        //入库之前先查询，实现幂等
//        if (pointsMapper.getByOrderNo(order.getOrderNo())>0){
//            log.info("积分添加完成，订单已处理。{}",order.getOrderNo());
//        }else{
            TblPoints points = new TblPoints();
            points.setUserId(1l);
            points.setOrderNo("wo");
            points.setPoints(10);
            points.setRemarks("商品消费共10元，获得积分"+points.getPoints());
            pointsMapper.insert(points);
            log.info("已为订单号码{}增加积分。",points.getOrderNo());
//        }
    }
}