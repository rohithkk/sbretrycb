package com.kodakandla;

import org.springframework.stereotype.Service;

@Service
public class HystricCBService implements HelloService{

	@Override
	public String sayHellloWithRetryOnFailure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sayHelloBreakingOnRepeatedFailure() {
		// TODO Auto-generated method stub
		return null;
	}

}
