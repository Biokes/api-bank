package com.biokes.apiBank.exception;

import lombok.Getter;

@Getter
public enum ApiBankExceptionMessages {
    SOMETHING_WENT_WRONG("Something went wrong"),
    INVALID_MAPPING("Unable to fetch data due to invalid mapping");
    ApiBankExceptionMessages(String message){
        this.message = message;
    }
    final String message;
}
