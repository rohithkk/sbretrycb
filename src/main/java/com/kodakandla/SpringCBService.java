package com.kodakandla;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class SpringCBService implements HelloService{

	@Retryable(
			value = {TestExceptionOne.class, TestExceptionTwo.class},
			maxAttempts = 3,
			backoff = @Backoff(delay=3000)
			)
	public String sayHellloWithRetryOnFailure() {
		
		double rand = Math.random();

		System.out.println("Trying the service. rand = " + rand);
		
		if(rand > 0.66) {
			return "rand = " + rand;
		}else if(rand > 0.33 && rand <= 0.66)
			throw new TestExceptionTwo("service threw exception");
		
		throw new TestExceptionOne("service threw exception");
	}
	
	@CircuitBreaker(
			 value = TestExceptionOne.class,
			 maxAttempts = 3,
			 openTimeout = 10000,
			 resetTimeout = 10000
			)
	public String sayHelloBreakingOnRepeatedFailure() {
		
		double rand = Math.random();

		System.out.println("rand = " + rand);
		
		if(rand > 0.85) {
			return "rand = " + rand;
		}
		
		throw new TestExceptionOne("service threw exception");
	}
	
	@Recover
	public String recoverFromFailure(TestExceptionOne e) {
		System.out.println("hit the first recover method");
		return "recovering from first kind of failure.";
	}
	
	@Recover
	public String recoverFromAnotherFailure(TestExceptionTwo e) {
		return "recovering from second kind of failure";
	}
}
