package com.prefeitura.mig.sasci.dtos

import com.prefeitura.mig.sasci.dtos.CidadaoDTO

data class PessoaJuridicaDTO(
    var razao: String? = null,
    var ie: String? = null,
    var cnpj: String? = null
) : CidadaoDTO()


