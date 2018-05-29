package com.boot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
/**整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker，主要目的还是简化配置**/
public class GatewayzuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayzuulApplication.class).web(true).run(args);
		System.out.println("====GatewayzuulApplication start successful==========");
	}
}

