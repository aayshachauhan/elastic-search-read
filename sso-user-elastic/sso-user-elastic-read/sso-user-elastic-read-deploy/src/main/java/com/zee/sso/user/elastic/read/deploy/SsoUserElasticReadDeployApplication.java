package com.zee.sso.user.elastic.read.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.zshop.sso.user.elastic.read.*", "com.zshop.commons.exception.*","com.zshop.common.elastic.*"})
@EnableAutoConfiguration
public class SsoUserElasticReadDeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoUserElasticReadDeployApplication.class, args);
	}

}
