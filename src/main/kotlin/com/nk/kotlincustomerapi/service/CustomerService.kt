package com.nk.kotlincustomerapi.service

import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService (
    private val customerRepository: CustomerRepository
){

    fun getAllCustomers(): List<Customer>{
        return customerRepository.findAll().toList()
    }
}