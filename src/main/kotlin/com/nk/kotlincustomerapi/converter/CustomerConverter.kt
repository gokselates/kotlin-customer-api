package com.nk.kotlincustomerapi.converter

import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.domain.dto.CustomerDto
import org.springframework.stereotype.Component
import java.util.*

@Component
class CustomerConverter {


    fun convertCustomerDto(customerDto: CustomerDto) : Customer {

        return Customer(
            customerDto.id,
            customerDto.name,
            customerDto.surname,
            customerDto.email
        )

    }
}
