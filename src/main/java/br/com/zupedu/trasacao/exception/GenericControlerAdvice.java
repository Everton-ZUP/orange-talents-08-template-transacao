package br.com.zupedu.trasacao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestControllerAdvice
public class GenericControlerAdvice {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ReturnError> validacaoExection(ResponseStatusException exception){
       ReturnError returnError = new ReturnError();
       returnError.addErrorField("","",exception.getReason(),"",exception.getStatus().toString());
       logger.error("Erro "+exception.getReason()+" "+exception.getStatus());
       return new ResponseEntity(returnError, exception.getStatus());
    }
}
