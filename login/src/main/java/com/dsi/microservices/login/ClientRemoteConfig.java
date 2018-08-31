package com.dsi.microservices.login;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dsi.microservices.login.api.LoginException;

import feign.codec.ErrorDecoder;
import static feign.FeignException.errorStatus;

@Configuration
public class ClientRemoteConfig {
	private static final Logger logger = LoggerFactory.getLogger(ClientRemoteConfig.class);
	
	@Bean
	public ErrorDecoder errorDecoder() {
		return (methodKey, response) -> {
			InputStream initialStream;
			byte[] targetArray;
			String result = "";
			try {
				initialStream = response.body().asInputStream();
				targetArray = new byte[initialStream.available()];
				initialStream.read(targetArray);
				result = new String(targetArray);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (response.status() >= 400 && response.status() <= 499) {
				logger.info("EXCEPCION LOGIN: " + result);
				return new LoginException(String.valueOf(response.status()), result);
			}
			if (response.status() >= 500 && response.status() <= 599) {
				logger.info("RUNTIME EXCEPCION LOGIN: " + result);
				return new RuntimeException(response.reason());
			}
			return errorStatus(methodKey, response);
		};
	}

}
