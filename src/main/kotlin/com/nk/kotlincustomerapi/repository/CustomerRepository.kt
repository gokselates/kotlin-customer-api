package com.nk.kotlincustomerapi.repository

import com.nk.kotlincustomerapi.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CustomerRepository : JpaRepository<Customer, UUID> {
}