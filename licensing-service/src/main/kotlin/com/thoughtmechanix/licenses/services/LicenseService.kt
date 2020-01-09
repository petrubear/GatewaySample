package com.thoughtmechanix.licenses.services

import com.thoughtmechanix.licenses.clients.OrganizationDiscoveryClient
import com.thoughtmechanix.licenses.config.ServiceConfig
import com.thoughtmechanix.licenses.model.License
import com.thoughtmechanix.licenses.model.Organization
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service


@Service
class LicenseService(var config: ServiceConfig, var organizationDiscoveryClient: OrganizationDiscoveryClient) {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(LicenseService::class.java)
    }

    fun getLicense(organizationId: String, licenseId: String): License {

        val organization: Organization = getOrganizationFromService(organizationId)

        return License().withId(licenseId)
                .withProductName("Teleco")
                .withLicenseType("Seat")
                .withLicenseMax(1)
                .withLicenseAllocated(0)
                .withOrganizationId(organizationId)
                .withOrganizationName(organization.name ?: "Default Organization Name")
                .withContactEmail(organization.contactEmail ?: "Default Mail")
                .withContactName(organization.contactName ?: "Default contact name")
                .withContactPhone(organization.contactPhone ?: "Default contact phone")
                .withComment(config.getExampleProperty())
    }

    private fun getOrganizationFromService(organizationId: String): Organization {
        logger.debug("===> calling org service")
        return organizationDiscoveryClient.getOrganization(organizationId) ?: getOrganization(organizationId)
    }

    private fun getOrganization(organizationId: String): Organization {
        val organization = Organization()
        organization.id = organizationId
        organization.contactEmail = "LocalContact"
        organization.contactName = "LocalName"
        organization.name = "LocalOrganization"
        organization.contactPhone = "LocalNumber"

        return organization
    }
}