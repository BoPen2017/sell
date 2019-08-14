package com.zero.repository;

import com.zero.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by asd on 2019/8/14.
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
