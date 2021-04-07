package com.prefeitura.mig.sasci.listeners;

import com.prefeitura.mig.sasci.constants.RabbitMq
import com.prefeitura.mig.sasci.dtos.CidadaoDTO
import com.prefeitura.mig.sasci.services.SasciCidadaoService
import lombok.extern.slf4j.Slf4j
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.amqp.support.AmqpHeaders
import org.springframework.messaging.handler.annotation.Header
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class MigSasciListener ( val sasciCidadaoService: SasciCidadaoService ) {

	@RabbitListener(queues = [RabbitMq.SASCI_CEP_QUEUE])
	fun sasciCep(@Payload cidadao: CidadaoDTO?) {
		print("MigSasciListener.sasciCep - cidadao: [${cidadao}] ")

		if (cidadao != null) {
			sasciCidadaoService.updateCepSasci(cidadao)
		}

		print("MigSasciListener.sasciCep - end")
	}

	@RabbitListener(queues = [RabbitMq.SASCI_CEP_DLQ])
	fun sasciCepDead(@Payload cidadao: CidadaoDTO?) {
		print("MigSasciListener.sasciCepDead - cidadao: [${cidadao}] ")

		print("MigSasciListener.sasciCepDead - end")
	}

}
