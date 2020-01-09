package com.thoughtmechanix.licenses.clients

import com.thoughtmechanix.licenses.model.Organization
import org.springframework.cloud.client.ServiceInstance
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class OrganizationDiscoveryClient(var discoveryClient: DiscoveryClient) {
    fun getOrganization(organizationId: String): Organization? {
        val restTemplate = RestTemplate()
        val serviceInstances: List<ServiceInstance> = discoveryClient.getInstances("organizationservice")
        if (serviceInstances.isEmpty()) return null

        val serviceUrl = serviceInstances[0].uri.toString() + "/v1/organizations/" + organizationId
        val restExchange: ResponseEntity<Organization> = restTemplate.exchange(serviceUrl, HttpMethod.GET, null,
                Organization::class.java, organizationId)
        return restExchange.body
    }
}