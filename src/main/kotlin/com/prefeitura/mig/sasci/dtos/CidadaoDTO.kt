package com.prefeitura.mig.sasci.dtos

import org.springframework.data.annotation.Id

data class CidadaoDTO(

    var nome: String? = null,
    var rg: String? = null,
    var cpf: String? = null,
    var email: String? = null,
    var endereco: List<EnderecoDTO>? = null

)


