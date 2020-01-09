package com.thoughtmechanix.licenses.controllers

import com.thoughtmechanix.licenses.model.License
import com.thoughtmechanix.licenses.services.LicenseService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/v1/organizations/{organizationId}/licenses"])
class LicenseServiceController(var licenseService: LicenseService) {

    @GetMapping("/{licenseId}")
    fun getLicense(@PathVariable organizationId: String,
                   @PathVariable("licenseId") licenseId: String): License {
        return licenseService.getLicense(organizationId, licenseId)
    }
}