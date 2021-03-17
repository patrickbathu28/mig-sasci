package com.prefeitura.mig.sasci.dtos

data class EnderecoDTO (

    var cep: String? = null,
    var logradouro: String? = null,
    var bairro : String? = null,
    var localidade : String? = null,
    var uf : String? = null,
    var ddd : String? = null,
    var ibge : String? = null

)
