package com.vinicios.sistema_chamados.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ValidationConfig {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public static Validator getValidator() {
        return factory.getValidator();
    }
}
