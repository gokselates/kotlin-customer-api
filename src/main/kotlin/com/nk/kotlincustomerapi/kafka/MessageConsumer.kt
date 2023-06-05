package com.nk.kotlincustomerapi.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class MessageConsumer {
    @KafkaListener(topics = arrayOf("create-customer"), groupId = "nk")
    fun listen(message: String) {
        println("Received message: $message")
    }
}