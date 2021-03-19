package com.prefeitura.mig.sasci.dtos

import org.springframework.data.annotation.Id

open class CidadaoDTO(

    var endereco: List<EnderecoDTO>? = null,
    var email: String? = null,

)


