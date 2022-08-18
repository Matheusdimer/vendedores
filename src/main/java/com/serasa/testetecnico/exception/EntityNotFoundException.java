package com.serasa.testetecnico.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
    }

    public EntityNotFoundException(final String message) {
        super(message);
    }
}
