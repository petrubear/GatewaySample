package com.thoughtmechanix.gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
