package com.kreitek.refactor.bien.domain.validators;

import com.kreitek.refactor.bien.interfaces.Validator;

public class ValidatorFactory {

    private static volatile ValidatorFactory instance = null;

    private ValidatorFactory() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance method to create");
        }
    }

    public static ValidatorFactory getInstance() {
        if (instance == null) {
            synchronized (ValidatorFactory.class) {
                if (instance == null) {
                    instance = new ValidatorFactory();
                }
            }
        }

        return instance;
    }

    public Validator getValidatorDni() {
        return new ValidatorDni();
    }

    public Validator getValidatorNie() {
        return new ValidatorNie();
    }

    public Validator getValidatorCif() {
        return new ValidatorCif();
    }

}
