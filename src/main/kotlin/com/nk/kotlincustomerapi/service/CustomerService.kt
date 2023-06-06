package com.nk.kotlincustomerapi.service

import com.nk.kotlincustomerapi.converter.CustomerConverter
import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.domain.dto.CustomerDto
import com.nk.kotlincustomerapi.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository,
    private val customerConverter: CustomerConverter
){

    fun getAllCustomers(): List<Customer>{

        return customerRepository.findAll().toList()
    }

    fun createCustomer(customerDto: CustomerDto): Customer {

        val customer = customerConverter.convertCustomerDto(customerDto)
        return customerRepository.save(customer)
    }
}