package com.prefeitura.mig.sasci.controller


import com.prefeitura.mig.sasci.utils.Utils
import com.prefeitura.mig.sasci.client.SasciClient
import com.prefeitura.mig.sasci.dtos.CidadaoDTO
import com.prefeitura.mig.sasci.dtos.PessoaFisicaDTO
import com.prefeitura.mig.sasci.dtos.PessoaJuridicaDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(value = "SasciController", description = "Restful APIs related to Sasci")
@RestController
class SasciController (val sasciClient: SasciClient, val util: Utils ) {

    @ApiOperation(value = "List all Cidadão")
    @GetMapping("/v1/cidadao/all", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getAll(): ResponseEntity<String> = ResponseEntity.status(HttpStatus.OK).body(sasciClient?.getCidadaoALL())

    @ApiOperation(value = "Get Cidadão find id")
    @GetMapping("/v1/cidadao/{id}", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun getFindId(@PathVariable("id") id: String): ResponseEntity<String> = ResponseEntity.status(HttpStatus.OK).body(sasciClient?.getCidadaoFindId(id))

    @ApiOperation(value = "Create PF")
    @PostMapping("/v1/cidadao/pf", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createPF(@RequestBody cidadaoDTO: PessoaFisicaDTO) = ResponseEntity.status(HttpStatus.CREATED).body(sasciClient?.create(cidadaoDTO))

    @ApiOperation(value = "Create PJ")
    @PostMapping("/v1/cidadao/pj", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createPJ(@RequestBody cidadaoDTO: PessoaJuridicaDTO) = ResponseEntity.status(HttpStatus.CREATED).body(sasciClient?.create(cidadaoDTO))

    @ApiOperation(value = "Update Cidadão for id")
    @PutMapping("/v1/cidadao/{id}", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun update(@RequestBody cidadaoDTO: CidadaoDTO, @PathVariable("id") id: String) = ResponseEntity.status(HttpStatus.CREATED).body(sasciClient?.update(cidadaoDTO, id))

    @ApiOperation(value = "Delete Cidadão")
    @DeleteMapping("/v1/cidadao/{id}", produces= arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun delete(@PathVariable("id") id: String?) = ResponseEntity.status(HttpStatus.OK).body(sasciClient?.delete(id))

}