package com.user.module.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
	    int timeout = 120000;
	    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
	      new HttpComponentsClientHttpRequestFactory();
	    clientHttpRequestFactory.setConnectTimeout(timeout);
	    clientHttpRequestFactory.setReadTimeout(timeout);
	    return clientHttpRequestFactory;
	}

@Bean
public RestTemplate restTemplate() {
	
	RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
	/*HttpComponentsClientHttpRequestFactory  client = (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
	client.setConnectTimeout(120000);
	client.setReadTimeout(120000);*/
	return restTemplate;
}
}
