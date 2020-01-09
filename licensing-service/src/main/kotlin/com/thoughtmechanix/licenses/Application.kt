package com.thoughtmechanix.licenses

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
class Application {
    @LoadBalanced
    @Bean
    fun getRestTemplate(): RestTemplate {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
