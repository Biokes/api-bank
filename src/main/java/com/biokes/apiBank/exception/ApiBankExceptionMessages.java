package com.biokes.apiBank.exception;

import lombok.Getter;

@Getter
public enum ApiBankExceptionMessages {
    INVALID_MAPPING("Unable to fetch data due to invalid mapping");
    ApiBankExceptionMessages(String message){
        this.message = message;
    }
    final String message;
}
