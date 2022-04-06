package com.kreitek.refactor.bien;

import com.kreitek.refactor.bien.domain.identifications.CIF;
import com.kreitek.refactor.bien.domain.identifications.DNI;
import com.kreitek.refactor.bien.domain.identifications.NIE;
import com.kreitek.refactor.bien.domain.utils.Console;
import com.kreitek.refactor.bien.domain.validators.ValidatorCif;
import com.kreitek.refactor.bien.domain.validators.ValidatorDni;
import com.kreitek.refactor.bien.domain.validators.ValidatorFactory;
import com.kreitek.refactor.bien.domain.validators.ValidatorNie;
import com.kreitek.refactor.bien.interfaces.Identification;
import com.kreitek.refactor.bien.interfaces.StringPrinter;
import com.kreitek.refactor.bien.interfaces.Validator;

class Main {
    static StringPrinter stringPrinter = Console.getInstance();

    public static void main(String args[]) {

        printMessage();

        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();

        Validator dniValidator = validatorFactory.getValidatorDni();
        Validator cifValidator = validatorFactory.getValidatorCif();
        Validator nieValidator = validatorFactory.getValidatorNie();

        Identification dniCorrecto = new DNI("11111111H", dniValidator);
        stringPrinter.print("DNI " + dniCorrecto.getIdentification() + " es: " + (dniCorrecto.validate() ? "true" : "false"));

        Identification dniIncorrecto01 = new DNI("24324356A", dniValidator);
        stringPrinter.print("DNI " + dniIncorrecto01.getIdentification() + " es: " + (dniIncorrecto01.validate() ? "true" : "false"));

        Identification nieCorrecto = new NIE("X0932707B", nieValidator);
        stringPrinter.print("NIE " + nieCorrecto.getIdentification() + " es: " + (nieCorrecto.validate() ? "true" : "false"));

        Identification nieIncorrecto = new NIE("Z2691139Z", nieValidator);
        stringPrinter.print("NIE " + nieIncorrecto.getIdentification() + " es: " + (nieIncorrecto.validate() ? "true" : "false"));

        Identification cifCorrecto = new CIF("W9696294I", cifValidator);
        stringPrinter.print("CIF " + cifCorrecto.getIdentification() + " es: " + (cifCorrecto.validate() ? "true" : "false"));

        Identification cifIncorrecto = new CIF("W9696294A", cifValidator);
        stringPrinter.print("CIF " + cifIncorrecto.getIdentification() + " es: " + (cifIncorrecto.validate() ? "true" : "false"));
    }

    private static void printMessage() {

        stringPrinter.print("=====================");
        stringPrinter.print("Vamos a refactorizar!");
        stringPrinter.print("=====================");
    }


}