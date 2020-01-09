package com.thoughtmechanix.licenses.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class ServiceConfig {
    @Value("\${example.property}")
    private val exampleProperty = ""

    fun getExampleProperty(): String {
        return exampleProperty
    }
}