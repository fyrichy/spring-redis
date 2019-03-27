package com.richy.redis;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @descrp：测试hash类型
 * @author：FyRichy
 * @time：2019年3月27日下午5:08:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-redis.xml")
public class RedisHashTest {

	@Autowired
	private RedisTemplate redisTemplate;
	
	
	@Test
	public void testHash() {
		redisTemplate.boundHashOps("namehash").put("a", "唐僧");
		redisTemplate.boundHashOps("namehash").put("b", "悟空");
		redisTemplate.boundHashOps("namehash").put("c", "八戒");
		redisTemplate.boundHashOps("namehash").put("d", "沙僧");
	}
	
	/**
	 * @descrp：
	 * @author：FyRichy
	 * @time：2019年3月27日下午5:10:59
	 */
	@Test
	public void testHashGet() {
		Set<String> keys = redisTemplate.boundHashOps("namehash").keys();
		for(String key:keys) {
			System.out.println(key+"=="+redisTemplate.boundHashOps("namehash").get(key));
		}
	}
}
