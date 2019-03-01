package com.kodakandla;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Resource(name="springCBService")
	HelloService service;
	
	@GetMapping("/hello")
	public String getHello() {
		//return service.sayHelllo();
		return service.sayHelloBreakingOnRepeatedFailure();
	}
}
