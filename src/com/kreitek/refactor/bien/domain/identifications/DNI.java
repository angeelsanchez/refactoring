package com.kreitek.refactor.bien.domain.identifications;

import com.kreitek.refactor.bien.interfaces.Identification;

public class DNI implements Identification {
    @Override
    public String getIdentification() {
        return null;
    }

    @Override
    public void setIdentification(String identification) {

    }

    @Override
    public boolean validate() {
        return false;
    }
}
