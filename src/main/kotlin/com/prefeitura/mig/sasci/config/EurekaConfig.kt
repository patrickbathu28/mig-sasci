package com.prefeitura.mig.sasci.config

import com.netflix.discovery.EurekaClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class EurekaConfig {

    @Autowired
    private val eurekaClient: EurekaClient? = null

    fun serviceUrl(): String? {
        val instance = eurekaClient!!.getNextServerFromEureka("STORES", false)
        return instance.homePageUrl
    }


}