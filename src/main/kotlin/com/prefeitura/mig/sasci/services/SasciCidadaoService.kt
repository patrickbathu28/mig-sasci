package com.prefeitura.mig.sasci.services

import com.prefeitura.mig.sasci.client.SasciClient
import com.prefeitura.mig.sasci.constants.RabbitMq
import com.prefeitura.mig.sasci.dtos.CidadaoDTO
import org.springframework.stereotype.Service

@Service
class SasciCidadaoService ( val sasciClient: SasciClient) : BaseService() {

    fun saveSasci(cidadaoDTO: CidadaoDTO) : String? {
        print("SasciCidadaoService.saveSasci - start - ${cidadaoDTO}")
        cidadaoDTO._id = sasciClient.create(cidadaoDTO)

        var body : String? = parseObjectToJson(cidadaoDTO)

        if (!body.isNullOrBlank()) {
            sendMIG(RabbitMq.MIMG_CEP_ROUTING_KEY, body)
        }

        print("SasciCidadaoService.saveSasci - end")
        return  cidadaoDTO._id
    }

    fun updateCepSasci(cidadaoDTO: CidadaoDTO){
        print("SasciCidadaoService.updateCepSasci - start - id:  ${cidadaoDTO._id}")
        sasciClient.update( cidadaoDTO, cidadaoDTO._id )
        print("SasciCidadaoService.updateCepSasci - end")
    }

}