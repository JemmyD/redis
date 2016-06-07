package com.pingan.pafa5.sample.redis;

import org.junit.Test;

import com.pingan.pafa.papp.test.BaseSARTest;
import com.pingan.pafa.papp.test.SARContextConfiguration;



@SARContextConfiguration(sarList="pafa5_sample_redis",protocols="jetty")
public class SARTests extends BaseSARTest{

	
	@Test
	public void iz() throws Throwable{
		
		System.in.read();
	}
	
}
