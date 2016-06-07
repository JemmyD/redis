package com.pingan.pafa5.sample.redis;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paic.pafa.web.BaseController;
import com.pingan.pafa.papp.esa.ResponseModel;
import com.pingan.pafa.redis.queue.RedisQueue;

@Controller
public class QueueProducerController extends BaseController {

	@Resource(name="sample_queue")
	private RedisQueue<UserDTO> sampleQueue;
	//http://localhost/queue/produce-msg?name=nangua&age=18
	@RequestMapping("/queue/produce-msg")
	@ResponseBody
	public ResponseModel handleReuqest(UserDTO userDTO){
		if(logger.isInfoEnabled()){
			logger.info("name="+userDTO.getName());
		}
		sampleQueue.push(userDTO);
		return new ResponseModel("0","处理成功。");
	}


	public RedisQueue<UserDTO> getSampleQueue() {
		return sampleQueue;
	}


	public void setSampleQueue(RedisQueue<UserDTO> sampleQueue) {
		this.sampleQueue = sampleQueue;
	}
	
	
}
