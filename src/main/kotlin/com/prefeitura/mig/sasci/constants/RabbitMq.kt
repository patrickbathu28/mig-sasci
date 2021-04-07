package com.prefeitura.mig.sasci.constants

object RabbitMq {

    //MIG Topic
    const val MIG_EXCHENGE = "mig.exchenge"

    //MBI Topic
    const val  MBI_EXCHENGE= "mbi.exchenge"

    //Prefix to queue names in msc-sasci
    private const val QUEUE_NAME_PREFIX = "sasci."

    //Suffix to deadletter queue names
    private const val DEAD = ".dead"

    //Routes where msc-sasci is a producer
    const val MSC_IMPOSTO_ROUTING_KEY = "msc-imposto"
    const val MIMG_CEP_ROUTING_KEY = "mimg-cep"

    //Routes where msc-sasci is a listener
    const val SASCI_CEP_ROUTING_KEY = "sasci-cep"
    const val SASCI_IMPOSTO_ROUTING_KEY = "sasci-imposto"

    //Queues
    const val SASCI_CEP_QUEUE = QUEUE_NAME_PREFIX + SASCI_CEP_ROUTING_KEY
    const val MSC_IMPOSTO_QUEUE = QUEUE_NAME_PREFIX + SASCI_IMPOSTO_ROUTING_KEY

    //Deadletter queues
    const val SASCI_CEP_DLQ = SASCI_CEP_QUEUE + DEAD
    const val MSC_IMPOSTO_DLQ = MSC_IMPOSTO_QUEUE + DEAD

}