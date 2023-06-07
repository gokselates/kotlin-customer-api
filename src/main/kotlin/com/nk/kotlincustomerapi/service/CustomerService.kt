package com.nk.kotlincustomerapi.service

import com.nk.kotlincustomerapi.converter.CustomerConverter
import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.domain.dto.CustomerResponseDto
import com.nk.kotlincustomerapi.domain.dto.CustomerSaveRequestDto
import com.nk.kotlincustomerapi.kafka.MessageProducer
import com.nk.kotlincustomerapi.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomerService (
    private val customerRepository: CustomerRepository,
    private val customerConverter: CustomerConverter,
    private val messageProducer: MessageProducer
){

    fun getAllCustomers(): List<Customer> = customerRepository.findAll().toList()

    fun createCustomer(customerSaveRequestDto: CustomerSaveRequestDto): Customer {

        val customer = customerConverter.convertCustomerDto(customerSaveRequestDto)
        val createdCustomer = customerRepository.save(customer)

       messageProducer.sendMessage("created-customer", createdCustomer.Id.toString())

        return createdCustomer
    }

    fun getCustomerById(id: UUID): ResponseEntity<CustomerResponseDto>{

        var customer = customerRepository.findById(id)

        if (customer.isEmpty){

            return ResponseEntity(CustomerResponseDto(null,"","",null,"Bulunamadı"), HttpStatus.NOT_FOUND)
        }

        val createdCustomer = customerConverter.convertCustomerResponseDto(customer)

        return ResponseEntity(createdCustomer, HttpStatus.OK)
    }

}