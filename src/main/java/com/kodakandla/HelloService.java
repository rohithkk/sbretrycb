package com.kodakandla;

public interface HelloService {

	public String sayHellloWithRetryOnFailure();
	public String sayHelloBreakingOnRepeatedFailure() ;
	
}
