package com.zero.service;

import com.zero.dto.OrderDTO;

/**
 * Created by asd on 2019/9/4.
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid,String orderId);
}
