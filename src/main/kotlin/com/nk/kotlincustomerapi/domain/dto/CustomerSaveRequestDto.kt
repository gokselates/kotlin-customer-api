package com.nk.kotlincustomerapi.domain.dto

import java.util.UUID

data class CustomerSaveRequestDto (
    val id: UUID?,
    val name: String,
    val surname: String,
    val email: String,
    val age: Int?
)
