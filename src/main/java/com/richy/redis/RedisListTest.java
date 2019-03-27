package com.richy.redis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @descrp：测试List类型数据
 * @author：FyRichy
 * @time：2019年3月27日下午5:05:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class RedisListTest {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void testList() {
		redisTemplate.boundListOps("list").rightPush("a");
		redisTemplate.boundListOps("list").rightPush("b");
		redisTemplate.boundListOps("list").rightPush("c");
		redisTemplate.boundListOps("list").rightPush("d");
		redisTemplate.boundListOps("list").rightPush("e");
	}
	
	@Test
	public void testListGet() {
		List<String> list = redisTemplate.boundListOps("list").range(0, -1);
		for(String s:list) {
			System.out.println(s);
		}
	}
}
