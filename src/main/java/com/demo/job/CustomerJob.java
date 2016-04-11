package com.demo.job;

import org.springframework.stereotype.Component;

@Component("customerJob")
public class CustomerJob {

	public void execute() {
		System.out.println("running...");
	}
	
}
