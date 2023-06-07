package com.nk.kotlincustomerapi.converter

import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.domain.dto.CustomerSaveRequestDto
import org.springframework.stereotype.Component

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
}
