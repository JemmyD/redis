package com.pingan.pafa5.sample.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.paic.pafa.biz.services.BaseServices;
import com.paic.pafa.job.TimerJob;
import com.pingan.pafa.redis.lock.RedisLock;
import com.pingan.pafa.redis.lock.RedisLockFactory;

@Component
public class RedisLockSample extends BaseServices{

	@Autowired
	@Qualifier("lock_factory")
	private RedisLockFactory lockFactory;
	
	//定时任务会延迟30秒启动
	@TimerJob(repeatInterval="2000")
	public  void execute(){
		RedisLock lock=lockFactory.getLock("SampleJob");
		lock.execute(new Runnable() {
			
			@Override
			public void run() {
				logger.info("任务执行。。。。");
			}
		});
		/*if(lock.tryLock()){
			try{
				logger.info("任务执行。。。。");
			}finally{
				lock.unlock();
			}
		}*/
	}
}
