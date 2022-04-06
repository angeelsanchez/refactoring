package com.kreitek.refactor.bien;

import com.kreitek.refactor.bien.domain.DNI;
import com.kreitek.refactor.bien.domain.TIPODNI;

class  Main
{
    public static void main(String args[])
    {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");

        // creamos un DNI correcto
        DNI dniCorrecto = new DNI(TIPODNI.DNI, "11111111H", null);
        Boolean esValido = (dniCorrecto.validarDNI() == 1);
        System.out.println( "DNI " + dniCorrecto.numDNI + " es: " + esValido.toString());

        // creamos un DNI incorrecto
        DNI dniIncorrecto01 = new DNI(TIPODNI.DNI, "24324356A", null);
        Boolean esValido01 = (dniIncorrecto01.validarDNI() == 1);
        System.out.println( "DNI " + dniIncorrecto01.numDNI + " es: " + esValido01.toString());

        // creamos un NIE correcto
        DNI nieCorrecto = new DNI(TIPODNI.NIE, "X0932707B", null);
        Boolean esValidoNie = (nieCorrecto.validarDNI() == 1);
        System.out.println( "NIE " + nieCorrecto.numDNI + " es: " + esValidoNie.toString());

        // creamos un NIE incorrecto
        DNI nieIncorrecto = new DNI(TIPODNI.NIE, "Z2691139Z", null);
        Boolean esValidoNieIncorrecto = (nieIncorrecto.validarDNI() == 1);
        System.out.println( "NIE " + nieIncorrecto.numDNI + " es: " + esValidoNieIncorrecto.toString());

        // creamos un CIF correcto
        DNI cifCorrecto = new DNI(TIPODNI.CIF, "W9696294I", null);
        Boolean esValidoCIF = (cifCorrecto.validarDNI() == 1);
        System.out.println( "CIF " + cifCorrecto.numDNI + " es: " + esValidoCIF.toString());

        // creamos un CIF incorrecto
        DNI cifIncorrecto = new DNI(TIPODNI.CIF, "W9696294A", null);
        Boolean esValidoCifIncorrecto = (cifIncorrecto.validarDNI() == 1);
        System.out.println( "NIE " + cifIncorrecto.numDNI + " es: " + esValidoCifIncorrecto.toString());
    }
}