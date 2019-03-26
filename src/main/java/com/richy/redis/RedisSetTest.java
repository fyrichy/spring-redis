package com.richy.redis;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @descr：Redis的set类型数据,类似set
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
		redisTemplate.boundSetOps("shuhan").add("liubei");
		redisTemplate.boundSetOps("shuhan").add("guanyu");
		redisTemplate.boundSetOps("shuhan").add("zhangfei");
		System.out.println("操作成功");
	}
	
	/**
	 * @descr：
	 * 测试删除key
	 * @time：下午11:24:21
	 */
	@Test
	public void setDelTest() {
		redisTemplate.delete("shuhan");
	}
	
	/**
	 * @descr：
	 * 获取值
	 * @time：下午11:27:02
	 */
	@Test
	public void getTest() {
		Set<String> set = redisTemplate.boundSetOps("shuhan").members();
		for(String s:set) {
			System.out.println(s);
		}
	}
	
	/**
	 * @descr：
	 * 	测试删除某一个值
	 * @time：下午11:28:55
	 */
	@Test
	public void delValueTest() {
		redisTemplate.boundSetOps("shuhan").remove("liubei");
		Set<String> set = redisTemplate.boundSetOps("shuhan").members();
		for(String s:set) {
			System.out.println(s);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
