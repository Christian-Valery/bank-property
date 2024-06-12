package com.evaluation.bankProperty.controller;

import com.evaluation.bankProperty.model.ApiError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LogManager.getLogger(CustomRestExceptionHandler.class);
    private static final String ERREUR = "Erreur : {}";

    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getMethod());
        builder.append(" method is not supported for this request. Supported methods are ");
        ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

        ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED, ex.getLocalizedMessage(), builder.toString());
        ApiError apiError1 = new ApiError(Integer.toString(HttpStatus.METHOD_NOT_ALLOWED.value()), ex.getLocalizedMessage() );
        log.error(ERREUR, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError1, new HttpHeaders(), apiError.getStatus());
    }

    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append(ex.getContentType());
        builder.append(" media type is not supported. Supported media types are ");
        ex.getSupportedMediaTypes().forEach(t -> builder.append(t + ", "));

        ApiError apiError = new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, ex.getLocalizedMessage(), builder.substring(0, builder.length() - 2));
        ApiError apiError1 = new ApiError(Integer.toString(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()), ex.getLocalizedMessage() );
        log.error(ERREUR, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError1, new HttpHeaders(), apiError.getStatus());
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = new ArrayList<>();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
            errorMessage.append( error.getDefaultMessage() ) ;
            errorMessage.append(" et ") ;
        }
        String erreur = errorMessage.toString();
        erreur = erreur.substring(0, (errorMessage.length())-4  );
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        ApiError apiError1 = new ApiError(Integer.toString(HttpStatus.BAD_REQUEST.value()), erreur);
        log.error(ERREUR, erreur);
        return handleExceptionInternal(ex, apiError1, headers, apiError.getStatus(), request);
    }

    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = ex.getParameterName() + " parameter is missing";

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
        ApiError apiError1 = new ApiError(Integer.toString(HttpStatus.BAD_REQUEST.value()), ex.getLocalizedMessage() );
        log.error(ERREUR, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError1, new HttpHeaders(), apiError.getStatus());
    }
}
