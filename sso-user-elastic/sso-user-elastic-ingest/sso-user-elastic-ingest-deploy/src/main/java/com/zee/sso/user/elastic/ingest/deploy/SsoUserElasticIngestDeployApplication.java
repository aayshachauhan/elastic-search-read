package com.zee.sso.user.elastic.ingest.deploy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({ "com.zee.sso.user.*", "com.zshop.commons.exception.*"  ,"com.zshop.common.elastic.*"})
@EnableAutoConfiguration
@Slf4j
public class SsoUserElasticIngestDeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoUserElasticIngestDeployApplication.class, args);
	}

}
