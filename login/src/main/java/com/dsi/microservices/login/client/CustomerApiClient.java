package com.dsi.microservices.login.client;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dsi.microservices.login.ClientRemoteConfig;

@FeignClient(
		url="http://customer-dsi-svc:8082", 
		name = "customer-dsi-svc",
		configuration = ClientRemoteConfig.class)
public interface CustomerApiClient {
	
	@RequestMapping(method = GET, value = "/api/v1/customers/{email}/{password}")
	CustomerDto findByEmailAndPassword(@PathVariable("email") String email, 
			@PathVariable("password")String password );

}
