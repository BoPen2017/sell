package com.zero.repository;

import com.zero.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1598746");
        orderDetail.setOrderId("111222");
        orderDetail.setProductIcon("http://www.baidu.com");
        orderDetail.setProductId("111222");
        orderDetail.setProductName("Peking Duck");
        orderDetail.setProductPrice(new BigDecimal(3.3));
        orderDetail.setProductQuantity(2);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOrOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrOrderId("111222");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

}