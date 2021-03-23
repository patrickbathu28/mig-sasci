package com.prefeitura.mig.sasci.dtos

import com.prefeitura.mig.sasci.dtos.CidadaoDTO

data class PessoaFisicaDTO(
    var nome: String? = null,
    var rg: String? = null,
    var cpf: String? = null
) : CidadaoDTO()


