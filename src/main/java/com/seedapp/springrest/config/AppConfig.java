package com.seedapp.springrest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = { "com.seedapp.springrest.domain", "com.seedapp.springrest.service" })
@Profile("default")
public class AppConfig {

	@Autowired
	private Environment env;

}
