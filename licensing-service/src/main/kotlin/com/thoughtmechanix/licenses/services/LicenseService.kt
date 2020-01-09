package com.thoughtmechanix.licenses.services

import com.thoughtmechanix.licenses.config.ServiceConfig
import com.thoughtmechanix.licenses.model.License
import org.springframework.stereotype.Service


@Service
class LicenseService(var config: ServiceConfig) {
    fun getLicense(organizationId: String, licenseId: String): License {
        return License().withId(licenseId)
                .withProductName("Teleco")
                .withLicenseType("Seat")
                .withOrganizationId(organizationId)
                .withComment(config.getExampleProperty())
    }
}