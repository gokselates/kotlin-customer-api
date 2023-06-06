package com.nk.kotlincustomerapi.domain.dto

import java.util.UUID

data class CustomerDto (
    val id: String,
    val name: String,
    val surname: String,
    val email: String,
    val age: Int?
)
