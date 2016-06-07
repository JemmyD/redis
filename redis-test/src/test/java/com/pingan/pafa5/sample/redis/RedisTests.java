package com.pingan.pafa5.sample.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pingan.pafa.papp.test.BaseSARTest;
import com.pingan.pafa.papp.test.SARContextConfiguration;
import com.pingan.pafa.redis.Redis;
import com.pingan.pafa.redis.RedisCommands;
import com.pingan.pafa.redis.cache.RedisCache;

@SARContextConfiguration(sarList="pafa5_sample_redis")
public class RedisTests  extends BaseSARTest{


	@Autowired
	@Qualifier("sample_redis")
	private Redis redis;
	
	@Test
	public void test1(){
		RedisCommands commands=redis.getCommands();
		byte[] key="pafa5_sample.msg".getBytes();
		byte[] value="hello,world!".getBytes();
		commands.set(key, value);
		commands.expire(key, 20);
		logger.info("Message="+new String(commands.get(key)));
	}
	
	@Test
	public void test2(){
		RedisCache<String> cache=redis.loadCache("pafa5_sample", String.class);
		cache.set("msg", "hello,world!", 20);
		logger.info("Message="+cache.get("msg"));
	}
	
}
