package com.pingan.pafa5.sample.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pingan.pafa.papp.test.BaseSARTest;
import com.pingan.pafa.papp.test.SARContextConfiguration;
import com.pingan.pafa.redis.counter.RedisInteger;

@SARContextConfiguration(sarList="pafa5_sample_redis")
public class RedisCounterTests extends BaseSARTest{
	//全局计数器
	@Autowired
	@Qualifier("sample_counter")
	private RedisInteger redisInteger;
	
	@Test
	public void test(){
		redisInteger.increment();
		redisInteger.increment();
		redisInteger.add(3);
		redisInteger.decrement();
		logger.info("value="+redisInteger.decrement());
	}
	
}
