package com.pingan.pafa5.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.paic.pafa.biz.services.BaseServices;
import com.pingan.pafa.redis.counter.RedisInteger;
import com.pingan.pafa.redis.queue.ConsumeListener;

@Component("queueSampleListener")
public class QueueSampleListener extends BaseServices  implements ConsumeListener<UserDTO> {
	
	@Autowired
	private RedisInteger redisInteger;

	@Override
	public void onReceiveMessages(UserDTO user) {
		int size=redisInteger.increment();
		if(logger.isInfoEnabled()){
			logger.info("consume data size="+size+",user="+user.getName());
		}
	}

	public RedisInteger getRedisInteger() {
		return redisInteger;
	}

	public void setRedisInteger(RedisInteger redisInteger) {
		this.redisInteger = redisInteger;
	}
	
	

}
