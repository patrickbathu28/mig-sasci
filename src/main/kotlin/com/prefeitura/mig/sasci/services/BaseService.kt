package com.prefeitura.mig.sasci.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.prefeitura.mig.sasci.constants.RabbitMq
import com.prefeitura.mig.sasci.dtos.CidadaoDTO
import org.springframework.amqp.rabbit.core.RabbitTemplate

open class BaseService ( val rabbitTemplate: RabbitTemplate? = null,
                    val objectMapper: ObjectMapper? = null ) {


    fun sendMBI(routingKey: String, body: String)  =
        rabbitTemplate!!.convertAndSend(RabbitMq.MBI_EXCHENGE, routingKey, body)

    fun sendMIG(routingKey: String, body: String) =
        rabbitTemplate!!.convertAndSend(RabbitMq.MIG_EXCHENGE, routingKey, body)

    fun <T> parseObjectToJson(payload : T): String? = objectMapper?.writeValueAsString(payload)



}