package com.zero.service;

import com.zero.entity.ProductCategory;

import java.util.List;

/**
 * Created by asd on 2019/8/15.
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
