package com.thoughtmechanix.licenses.controllers

import com.thoughtmechanix.licenses.model.License
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LicenseServiceController {

    @GetMapping("/v1/organizations/{organizationId}/licenses/{licenseId}")
    fun getLicense(@PathVariable organizationId: String,
                   @PathVariable("licenseId") licenseId: String): License {
        return License().withId(licenseId)
                .withProductName("Teleco")
                .withLicenseType("Seat")
                .withOrganizationId(organizationId)
    }
}