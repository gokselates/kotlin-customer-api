package com.nk.kotlincustomerapi.controller

import com.nk.kotlincustomerapi.domain.Customer
import com.nk.kotlincustomerapi.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}