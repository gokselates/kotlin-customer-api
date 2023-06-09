package com.nk.kotlincustomerapi.converter

import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.domain.dto.CustomerResponseDto
import com.nk.kotlincustomerapi.domain.dto.CustomerSaveRequestDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class CustomerConverter {


    fun convertCustomerDto(customerSaveRequestDto: CustomerSaveRequestDto) : Customer {

        return Customer(
            customerSaveRequestDto.id,
            customerSaveRequestDto.name,
            customerSaveRequestDto.surname,
            customerSaveRequestDto.email
        )

    }

    fun convertCustomerResponseDto(customerResponseOptinal: Optional<Customer>) : CustomerResponseDto {

        return CustomerResponseDto.Builder()
            .id(customerResponseOptinal.get().Id)
            .name(customerResponseOptinal.get().name)
            .surname(customerResponseOptinal.get().surname)
            .email(customerResponseOptinal.get().email)
            .message("")
            .build()
    }
}
