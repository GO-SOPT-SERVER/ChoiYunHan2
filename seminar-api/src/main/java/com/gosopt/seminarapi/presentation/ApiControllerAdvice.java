package com.gosopt.seminarapi.presentation;

import com.gosopt.seminardomain.global.common.exception.common.BadRequestException;
import com.gosopt.seminardomain.global.common.exception.common.InternalServerErrorException;
import com.gosopt.seminardomain.global.common.exception.common.NotFoundException;
import com.gosopt.seminardomain.global.common.exception.common.UnAuthorizedException;
import com.gosopt.seminardomain.global.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponse<?> handleUnAuthorizedException(UnAuthorizedException e) {
        return ApiResponse.failure(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<?> handleNotFoundException(NotFoundException e ) {
        return ApiResponse.failure(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<?> handleBadRequestException(BadRequestException e) {
        return ApiResponse.failure(e.getStatus(), e.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<?> handleInternalServerErrorException(InternalServerErrorException e) {
        return ApiResponse.failure(e.getStatus(), e.getMessage());
    }
}
