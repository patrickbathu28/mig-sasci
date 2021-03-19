package com.prefeitura.mig.sasci.dtos

data class PessoaFisicaDTO(
    var nome: String? = null,
    var rg: String? = null,
    var cpf: String? = null
) : CidadaoDTO()


