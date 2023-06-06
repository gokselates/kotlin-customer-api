package com.nk.kotlincustomerapi.domain

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "Customer")
class Customer (
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val Id: UUID,
    @Column(name = "name") val name: String,
    @Column(name="surname") val surname: String,
    @Column(name="email") val email: String? = null
)