package com.richy.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @descr：Redis的set类型数据
 * @author： Richy
 * @time：下午10:35:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class RedisSetTest {

	@Autowired
	private RedisTemplate redisTemplate;
	
	/**
	 * @descr：set类型数据存入值
	 * 
	 * @time：下午10:36:10
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void setAddTest() {
		System.out.println(redisTemplate);
		redisTemplate.boundSetOps("shuhan").add("刘备");
		redisTemplate.boundSetOps("shuhan").add("关羽");
		redisTemplate.boundSetOps("shuhan").add("张飞");
		System.out.println("操作成功");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
