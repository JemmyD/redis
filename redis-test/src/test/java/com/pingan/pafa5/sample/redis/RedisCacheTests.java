package com.pingan.pafa5.sample.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.pingan.pafa.papp.test.BaseSARTest;
import com.pingan.pafa.papp.test.SARContextConfiguration;
import com.pingan.pafa.redis.cache.RedisCache;

@SARContextConfiguration(sarList="pafa5_sample_redis")
public class RedisCacheTests  extends BaseSARTest {


	@Autowired
	@Qualifier("sample_cache")
	private RedisCache<UserDTO> cache;

	@Test
	public void test(){
		cache.set("id_1", new UserDTO("nangua",18),30);
		logger.info("name="+cache.get("id_1").getName());
	}

}
