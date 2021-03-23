package com.prefeitura.mig.sasci.utils
import com.fasterxml.jackson.core.JsonProcessingException
import org.springframework.stereotype.Service
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
class Utils {

    fun toString( obj : String) {
        var result : String? = null
        try {
            result =  ObjectMapper().writeValueAsString(obj);
        } catch ( e : JsonProcessingException ) {
            result = super.toString();
        }
    }
}