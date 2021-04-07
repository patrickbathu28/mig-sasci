package com.prefeitura.mig.sasci.config

import com.prefeitura.mig.sasci.constants.RabbitMq
import org.springframework.amqp.core.*
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {

    private val XDLE = "x-dead-letter-exchange"
    private val XDLRK = "x-dead-letter-routing-key"

    @Bean
    fun jsonMessageConverter(): MessageConverter? = Jackson2JsonMessageConverter()

    @Bean
    fun mbiExchange(): TopicExchange? = TopicExchange(RabbitMq.MBI_EXCHENGE)

    @Bean
    fun migExchange(): TopicExchange? = TopicExchange(RabbitMq.MIG_EXCHENGE)

    @Bean
    fun sasciCepQueue(): Queue? =
        QueueBuilder.durable(RabbitMq.SASCI_CEP_QUEUE).withArgument(XDLE, "")
            .withArgument(XDLRK, RabbitMq.SASCI_CEP_DLQ).build()

    @Bean
    fun sasciCepQueueDlq(): Queue? = QueueBuilder.durable(RabbitMq.SASCI_CEP_DLQ).build()


    @Bean
    fun bindings(): Declarables? =
        Declarables(
            Binding(RabbitMq.SASCI_CEP_QUEUE,
                Binding.DestinationType.QUEUE,
                RabbitMq.MIG_EXCHENGE,
                RabbitMq.SASCI_CEP_ROUTING_KEY,
                null
            )
        )
}