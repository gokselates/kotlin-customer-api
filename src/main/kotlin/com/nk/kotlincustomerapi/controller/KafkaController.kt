package com.nk.kotlincustomerapi.controller

import com.nk.kotlincustomerapi.kafka.MessageProducer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/kafka")
internal class KafkaController (
    private val messageProducer: MessageProducer
){

    @PostMapping("/send")
    fun sendMessage(@RequestParam("message") message: String): String {
        messageProducer!!.sendMessage("create-customer", message)
        return "Message sent: $message"
    }
}