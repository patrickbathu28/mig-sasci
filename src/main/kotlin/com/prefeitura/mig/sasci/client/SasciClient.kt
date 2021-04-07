package com.prefeitura.mig.sasci.client

import com.prefeitura.mig.sasci.dtos.CidadaoDTO
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FeignClient(name = "sasci", url = "https://livros-firebase-66a75.firebaseio.com")
interface SasciClient {

    @GetMapping(path = ["/sasci/cidadao/{id}.json"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun getCidadaoFindId(@PathVariable("id") id: String?): String?

    @GetMapping(path = ["/sasci/cidadao/{id}.json"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun getCidadaoALL(): String?

    @PostMapping(path = ["/sasci/cidadao.json"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody cidadao: CidadaoDTO): String?

    @PutMapping(path = ["/sasci/cidadao/{id}.json"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody cidadao: CidadaoDTO, @PathVariable("id") id: String?): String?

    @DeleteMapping(path = ["/sasci/cidadao/{id}.json"], consumes= [MediaType.APPLICATION_JSON_VALUE])
    fun delete(@PathVariable("id") id: String?): String?

}