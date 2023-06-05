package com.nk.kotlincustomerapi.kafka

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class MessageProducer (
    private val kafkaTemplate: KafkaTemplate<String, String>? = null
){

    fun sendMessage(topic: String, message: String?) {
        kafkaTemplate?.send(topic, message)
    }
}