package com.thoughtmechanix.organization.services

import com.thoughtmechanix.organization.config.ServiceConfig
import com.thoughtmechanix.organization.model.Organization
import org.springframework.stereotype.Service


@Service
class OrganizationService(var config: ServiceConfig) {

    fun getOrganization(organizationId: String): Organization {
        val organization = Organization()
        organization.id = organizationId
        organization.contactEmail = "org.ml@mail.ru"
        organization.contactName = "Contact"
        organization.name = "My Organization"
        organization.contactPhone = "+123"

        return organization
    }
}