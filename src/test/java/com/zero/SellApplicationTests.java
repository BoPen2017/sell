package com.zero;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
//@Data
public class SellApplicationTests {

//	private final Logger logger = LoggerFactory.getLogger(SellApplicationTests.class);
	@Test
	public void contextLoads() {
		String name = "test";
		String pass =  "123456";
		log.debug("debug...");
		log.info("info..."+name+"\t"+pass);
		log.info("name:{},pass:{}",name,pass);
		log.error("error...");
		log.warn("warn...");
	}

}
