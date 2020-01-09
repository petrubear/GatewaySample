package com.thoughtmechanix.licenses.model

class License {

    //@Id
    //@Column(name = "license_id", nullable = false)
    private var licenseId: String? = null

    //@Column(name = "organization_id", nullable = false)
    private var organizationId: String? = null

    @Transient
    private var organizationName = ""

    @Transient
    private var contactName = ""

    @Transient
    private var contactPhone = ""

    @Transient
    private var contactEmail = ""

    //@Column(name = "product_name", nullable = false)
    private var productName: String? = null

    //@Column(name = "license_type", nullable = false)
    private var licenseType: String? = null

    //@Column(name = "license_max", nullable = false)
    private var licenseMax: Int? = null

    //@Column(name = "license_allocated", nullable = false)
    private var licenseAllocated: Int? = null

    //@Column(name = "comment")
    private var comment: String? = null


    fun getLicenseMax(): Int? {
        return licenseMax
    }

    fun setLicenseMax(licenseMax: Int?) {
        this.licenseMax = licenseMax
    }

    fun getLicenseAllocated(): Int? {
        return licenseAllocated
    }

    fun setLicenseAllocated(licenseAllocated: Int?) {
        this.licenseAllocated = licenseAllocated
    }


    fun getLicenseId(): String? {
        return licenseId
    }

    fun setLicenseId(licenseId: String?) {
        this.licenseId = licenseId
    }

    fun getOrganizationId(): String? {
        return organizationId
    }

    fun setOrganizationId(organizationId: String?) {
        this.organizationId = organizationId
    }

    fun getProductName(): String? {
        return productName
    }

    fun setProductName(productName: String?) {
        this.productName = productName
    }

    fun getLicenseType(): String? {
        return licenseType
    }

    fun setLicenseType(licenseType: String?) {
        this.licenseType = licenseType
    }

    fun getComment(): String? {
        return comment
    }

    fun setComment(comment: String?) {
        this.comment = comment
    }

    fun getOrganizationName(): String? {
        return organizationName
    }

    fun setOrganizationName(organizationName: String) {
        this.organizationName = organizationName
    }

    fun getContactName(): String? {
        return contactName
    }

    fun setContactName(contactName: String) {
        this.contactName = contactName
    }

    fun getContactPhone(): String? {
        return contactPhone
    }

    fun setContactPhone(contactPhone: String) {
        this.contactPhone = contactPhone
    }

    fun getContactEmail(): String? {
        return contactEmail
    }

    fun setContactEmail(contactEmail: String) {
        this.contactEmail = contactEmail
    }

    fun withId(id: String?): License {
        setLicenseId(id)
        return this
    }

    fun withOrganizationId(organizationId: String?): License {
        setOrganizationId(organizationId)
        return this
    }

    fun withProductName(productName: String?): License {
        setProductName(productName)
        return this
    }

    fun withLicenseType(licenseType: String?): License {
        setLicenseType(licenseType)
        return this
    }

    fun withLicenseMax(licenseMax: Int?): License {
        setLicenseMax(licenseMax)
        return this
    }

    fun withLicenseAllocated(licenseAllocated: Int?): License {
        setLicenseAllocated(licenseAllocated)
        return this
    }

    fun withComment(comment: String?): License {
        setComment(comment)
        return this
    }

    fun withOrganizationName(organizationName: String): License {
        setOrganizationName(organizationName)
        return this
    }

    fun withContactName(contactName: String): License {
        setContactName(contactName)
        return this
    }

    fun withContactPhone(contactPhone: String): License {
        setContactPhone(contactPhone)
        return this
    }

    fun withContactEmail(contactEmail: String): License {
        setContactEmail(contactEmail)
        return this
    }
}