package com.zero.repository;


import com.zero.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryTests {

	@Autowired
	private ProductCategoryRepository repository;
	@Test
	public void contextLoads() {
		ProductCategory productCategory = repository.findOne(2);
		productCategory.setCategoryType(4);
		repository.save(productCategory);
		System.out.println(productCategory.toString());
	}

	@Test
	public void save() {
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryId(2);
		productCategory.setCategoryName("CN");
		productCategory.setCategoryType(2);
		repository.save(productCategory);
	}

	@Test
	@Transactional
	public void save2() {
		ProductCategory productCategory = new ProductCategory("EN",5);
		ProductCategory result = repository.save(productCategory);
		Assert.assertNotNull(result);
		Assert.assertNotEquals(null,result);
	}

	@Test
	public void findByCategoryTypeIn() {
		List<Integer> list = Arrays.asList(1,2,5,8);
		repository.findByCategoryTypeIn(list);
	}
}
