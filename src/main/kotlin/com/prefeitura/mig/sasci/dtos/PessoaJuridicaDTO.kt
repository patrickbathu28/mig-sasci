package com.prefeitura.mig.sasci.dtos

data class PessoaJuridicaDTO(
    var razao: String? = null,
    var ie: String? = null,
    var cnpj: String? = null
) : CidadaoDTO()


