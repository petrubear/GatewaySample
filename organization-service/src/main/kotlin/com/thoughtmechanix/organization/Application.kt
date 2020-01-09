package com.thoughtmechanix.organization

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.context.config.annotation.RefreshScope

@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
