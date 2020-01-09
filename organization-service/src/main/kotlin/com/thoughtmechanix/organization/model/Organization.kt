package com.thoughtmechanix.organization.model

import java.io.Serializable

class Organization : Serializable {
    var id: String? = null
    var name: String? = null
    var contactName: String? = null
    var contactEmail: String? = null
    var contactPhone: String? = null
}

