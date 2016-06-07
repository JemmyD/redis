package com.pingan.pafa5.sample.redis;

import javax.annotation.Resource;

import org.junit.Test;

import com.pingan.pafa.papp.test.BaseSARTest;
import com.pingan.pafa.papp.test.SARContextConfiguration;
import com.pingan.pafa.redis.queue.RedisQueue;

@SARContextConfiguration(sarList="pafa5_sample_redis")
public class RedisQueueTests  extends BaseSARTest{

	@Resource(name="sample_queue")
	private RedisQueue<UserDTO> redisQueue;
	
	@Test
	public void test() throws Exception{
		redisQueue.push(new UserDTO("nangua",16));
		redisQueue.push(new UserDTO("zhangsan",16));
		redisQueue.push(new UserDTO("lisi",16));
		//消费者线程池会延迟30秒启动
		logger.info("Push message completed.");
		System.in.read();
	}

}
