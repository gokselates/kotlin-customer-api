package com.nk.kotlincustomerapi.domain.dto

import java.util.UUID

class CustomerResponseDto {
    var id: UUID? =null
    var name: String? = null
    var surname: String? = null
    var email: String? = null
    var message: String? = null

    class Builder {
        private var dialog: CustomerResponseDto = CustomerResponseDto()
        fun id(id: UUID?) = apply { dialog.id = id }
        fun name(name: String) = apply { dialog.name = name }
        fun surname(surname: String) = apply { dialog.surname = surname }
        fun email(email: String?) = apply { dialog.email = email }
        fun message(message: String) = apply { dialog.message = message }

        fun build() = dialog
    }
}