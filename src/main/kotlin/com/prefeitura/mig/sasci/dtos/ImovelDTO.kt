package com.prefeitura.mig.sasci.dtos

data class ImovelDTO (
    var areaConstruida : Double? = null,
    var areaTotalTerreno : Double? = null,
    var valorVenalTerreno : Double,
    var valorVenalConstrucao: Double,
    var valorVenalImovel : Double

)
