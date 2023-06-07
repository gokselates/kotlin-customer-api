package com.nk.kotlincustomerapi.service

import com.nk.kotlincustomerapi.converter.CustomerConverter
import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.domain.dto.CustomerSaveRequestDto
import com.nk.kotlincustomerapi.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository,
    private val customerConverter: CustomerConverter
){

    fun getAllCustomers(): List<Customer> = customerRepository.findAll().toList()

    fun createCustomer(customerSaveRequestDto: CustomerSaveRequestDto): Customer {

        val customer = customerConverter.convertCustomerDto(customerSaveRequestDto)
        return customerRepository.save(customer)
    }



}