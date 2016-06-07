package com.pingan.pafa5.sample.redis;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import com.pingan.pafa.papp.test.BaseSARTest;
import com.pingan.pafa.papp.test.SARContextConfiguration;

@SARContextConfiguration(sarList="pafa5_sample_redis")
public class RedisMapTests  extends BaseSARTest{

	
	@Resource(name="sample_globalMap")
	private Map<String,UserDTO> redisMap;
	
	@Test
	public void test(){
		redisMap.put("id_2", new UserDTO("nangua",32));
		logger.info("name="+redisMap.get("id_2").getName());
	}
}
