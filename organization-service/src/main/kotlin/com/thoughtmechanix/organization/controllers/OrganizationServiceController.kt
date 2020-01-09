package com.thoughtmechanix.organization.controllers

import com.thoughtmechanix.organization.model.Organization
import com.thoughtmechanix.organization.services.OrganizationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/v1/organizations/"])
class OrganizationServiceController(var organizationService: OrganizationService) {

    @GetMapping("/{organizationId}")
    fun getOrganization(@PathVariable organizationId: String): Organization {
        return organizationService.getOrganization(organizationId)
    }
}