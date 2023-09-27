/*******************************************************************************
 * 
 * Autor: autor@axpe.com
 * 
 * © Axpe Consulting S.L. 2022. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.axpe.example.presentation.exceptions.handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.axpe.example.service.exceptions.ContentNotFoundException;
import com.axpe.example.service.exceptions.ErrorMailValidation;
import com.axpe.example.service.exceptions.ErrorMessage;
import com.axpe.example.service.exceptions.ErrorView;
import com.axpe.example.service.exceptions.KConstantsError;
import com.axpe.example.service.exceptions.TypeErrorEnum;

/**
 * Manejador de excepciones para el API
 * 
 * @author autor@axpe.com
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	ErrorView errors = null;
	
	@ExceptionHandler(ContentNotFoundException.class)
	public ResponseEntity<?> contentNotFoundException(HttpServletResponse response) {
		return customHandleExceptionInternal(HttpStatus.NOT_FOUND, KConstantsError.ErrorMessages.NOT_FOUND, KConstantsError.ErrorDescriptions.NOT_FOUND, TypeErrorEnum.ERROR);
    }
	
	@ExceptionHandler(ErrorMailValidation.class)
	public ResponseEntity<?> errorMailValidation(HttpServletResponse response) {
		return customHandleExceptionInternal(HttpStatus.NOT_ACCEPTABLE, KConstantsError.ErrorMessages.MAIL_ERROR, KConstantsError.ErrorDescriptions.MAIL_ERROR, TypeErrorEnum.ERROR);
    }
	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<?> badRequestException(HttpServletResponse response) {
		return customHandleExceptionInternal(HttpStatus.BAD_REQUEST, KConstantsError.ErrorMessages.BAD_REQUEST, KConstantsError.ErrorDescriptions.BAD_REQUEST, TypeErrorEnum.ERROR);
    }
	
	@ExceptionHandler(UnprocessableEntity.class)
	public ResponseEntity<?> unprocessableEntityException(HttpServletResponse response) {
		return customHandleExceptionInternal(HttpStatus.UNPROCESSABLE_ENTITY, KConstantsError.ErrorMessages.UNPROCESSABLE_ENTITY, KConstantsError.ErrorDescriptions.UNPROCESSABLE_ENTITY, TypeErrorEnum.ERROR);
    }
	
	@ExceptionHandler(InternalServerError.class)
	public ResponseEntity<?> serverErrorException(HttpServletResponse response) {
		return customHandleExceptionInternal(HttpStatus.INTERNAL_SERVER_ERROR, KConstantsError.ErrorMessages.INTERNAL_SERVER_ERROR, KConstantsError.ErrorDescriptions.INTERNAL_SERVER_ERROR, TypeErrorEnum.ERROR);
    }
	
	@ExceptionHandler(HttpClientErrorException.class)
	public ResponseEntity<?> authorizationServiceException(HttpServletResponse response) {
		return customHandleExceptionInternal(HttpStatus.UNAUTHORIZED, KConstantsError.ErrorMessages.INCORRECT_AUTHORIZATION, KConstantsError.ErrorDescriptions.INCORRECT_AUTHORIZATION, TypeErrorEnum.ERROR);
    }
	
//	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return ResponseEntity.status(status.value()).body(errors);
	}
	
	private ResponseEntity<Object> customHandleExceptionInternal(HttpStatus status, String errorMessage, String errorDescription, TypeErrorEnum typeError) {
		ErrorView error = ErrorView.builder().message(new ErrorMessage(KConstantsError.General.RESOURCES + status.getReasonPhrase(), errorMessage, typeError, errorDescription)).build();
		return ResponseEntity.status(status.value()).body(error);
	}

}