package com.nk.kotlincustomerapi.repository

import com.nk.kotlincustomerapi.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository : JpaRepository<Customer, Long> {
}