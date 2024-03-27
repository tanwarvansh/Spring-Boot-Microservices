package com.example.OrderService.external.decoder;

import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

import com.example.OrderService.exception.CustomException;
import com.example.OrderService.external.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@Log4j2
public class CustomErrorDecoder implements ErrorDecoder{
	@Override
	public Exception decode(String methodKey, Response response) {
		ObjectMapper objMapper = new ObjectMapper();	
        log.info("::{}",response.request().url());
        log.info("::{}",response.request().headers());      
			try {
				ErrorResponse errorResponse = objMapper.readValue(response.body().asInputStream(),
						ErrorResponse.class);
				
				return new CustomException(errorResponse.getErrorMessage() ,
	                    errorResponse.getErrorCode(),
	                    response.status());
			}  catch (IOException e) {
				  throw  new CustomException("Internal Server Error",
		                    "INTERNAL_SERVER_ERROR",
		                    500);
			}						
	}

}
