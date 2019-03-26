package com.richy.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @descr：key-value类型测试
 * @author： Richy
 * @time：下午11:30:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class RedisStringTest {

	@Autowired
	private RedisTemplate redisTemplate;	
	
	/**
	 * @descr：
	 *  测试设置一个值
	 * @time：下午11:31:51
	 */
	@Test
	public void setValue(){
		redisTemplate.boundValueOps("name").set("springDataRedis");		
	}	
	
	/**
	 * @descr：
	 *   获取值
	 * @time：下午11:32:05
	 */
	@Test
	public void getValue(){
		String str = (String) redisTemplate.boundValueOps("name").get();
		System.out.println(str);
	}	
}
