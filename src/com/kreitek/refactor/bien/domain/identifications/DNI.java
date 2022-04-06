package com.kreitek.refactor.bien.domain.identifications;

import com.kreitek.refactor.bien.interfaces.Identification;
import com.kreitek.refactor.bien.interfaces.Validator;

public class DNI implements Identification {
    private String identification;
    private final Validator validator;

    public DNI(String dni, Validator validator) {
        this.identification = dni;
        this.validator = validator;
    }

    @Override
    public String getIdentification() {
        return this.identification;
    }

    @Override
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Override
    public boolean validate() {
        return validator.validate(this.identification) == 1;
    }
}
