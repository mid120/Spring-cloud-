package com.hystrix;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker //没有这个dashBorad就不能显示 出现  Unable to connect to Command Metric Stream.
public class HystrixApplication {
  /**
   * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
   * @return restTemplate
   */
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public IRule ribbonRule() {
    return new AvailabilityFilteringRule();
  }

  public static void main(String[] args) {
    SpringApplication.run(HystrixApplication.class, args);
  }
}