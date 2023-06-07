package com.nk.kotlincustomerapi.controller

import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.domain.dto.CustomerResponseDto
import com.nk.kotlincustomerapi.domain.dto.CustomerSaveRequestDto
import com.nk.kotlincustomerapi.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/customer")
class CustomerController(
    private val customerService: CustomerService
) {

    @GetMapping("")
    fun getAllCustomers(): ResponseEntity<List<Customer>> {

        val customerList = customerService.getAllCustomers()
        return ResponseEntity<List<Customer>>(customerList, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable(value = "id") id: UUID): ResponseEntity<CustomerResponseDto> {

        return customerService.getCustomerById(id)
    }

    @PostMapping("/save")
    fun createCustomer(@RequestBody customerSaveRequestDto: CustomerSaveRequestDto): ResponseEntity<Customer> {

        return ResponseEntity<Customer>(customerService.createCustomer(customerSaveRequestDto), HttpStatus.OK)
    }
}