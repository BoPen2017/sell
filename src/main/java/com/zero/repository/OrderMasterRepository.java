package com.zero.repository;

import com.zero.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by asd on 2019/8/28.
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findBuyerOpenid(String buyerOpenid, Pageable pageable);
}
