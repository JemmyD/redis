package com.pingan.pafa5.sample.redis;

import com.paic.pafa.biz.dto.BaseDTO;

public class UserDTO extends BaseDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int age;
	
	public UserDTO(){}
	
	public UserDTO(String name,int age){
		this.name=name;
		this.age=age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
