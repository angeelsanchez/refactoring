package com.kreitek.refactor.bien.domain.validators;

import com.kreitek.refactor.bien.domain.TipoUltCaracter;
import com.kreitek.refactor.bien.interfaces.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorCif implements Validator {
    private TipoUltCaracter tipUltCar;
    private String cifUP;
    private char primerCar;
    private char ultimoCar;
    private char carControl;
    private int pos;

    @Override
    public int validate(String identification) {
        try {
            if (identification != null) {
                cifUP = identification.toUpperCase();
                primerCar = cifUP.charAt(0);
                ultimoCar = cifUP.charAt(cifUP.length() - 1);

                if (!structure(identification)) return 0;
                if (!finalCharacter(ultimoCar)) return 0;

                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 99;
        }
    }

    private boolean structure(String identification) {

        if ("ABCDEFGHJKLMNPQRSUVW".indexOf(cifUP.charAt(0)) == -1) {
            return false;
        }

        final Pattern mask = Pattern
                .compile("[ABCDEFGHJKLMNPQRSUVW][0-9]{7}[A-Z[0-9]]{1}");
        final Matcher matcher = mask.matcher(cifUP);
        if (!matcher.matches()) {
            return false;
        }

        if (primerCar == 'P' || primerCar == 'Q' || primerCar == 'S' || primerCar == 'K' || primerCar == 'W') {
            tipUltCar = TipoUltCaracter.LETRA;
            if (!(ultimoCar >= 'A' && ultimoCar <= 'Z')) {
                return false;
            }
        } else if (primerCar == 'A' || primerCar == 'B' || primerCar == 'E'
                || primerCar == 'H') {
            tipUltCar = TipoUltCaracter.NUMERO;
            if (!(ultimoCar >= '0' && ultimoCar <= '9')) {
                return false;
            }
        } else {
            tipUltCar = TipoUltCaracter.AMBOS;
        }
        return true;
    }

    private boolean finalCharacter(char letter) {
        calCharControl();
        if (tipUltCar == TipoUltCaracter.NUMERO) {

            final Integer ultCar = Integer.parseInt(Character
                    .toString(letter));
            if (pos != ultCar.intValue()) {

                return false;
            }

        } else if (tipUltCar == TipoUltCaracter.LETRA) {
            if (carControl != letter) {
                return false;
            }

        } else {
            Integer ultCar = -1;

            ultCar = "JABCDEFGHI".indexOf(letter);

            if (ultCar < 0) {
                ultCar = Integer.parseInt(Character.toString(letter));
                if (pos != ultCar.intValue()) {
                    return false;
                }
            }
            if ((pos != ultCar.intValue()) && (carControl != letter)) {
                return false;
            }
        }
        return true;
    }

    private void calCharControl() {
        final String digitos = cifUP.substring(1, cifUP.length() - 1);

        Integer sumaPares = 0;
        for (int i = 1; i <= digitos.length() - 1; i = i + 2) {
            sumaPares += Integer.parseInt(digitos.substring(i, i + 1));
        }

        Integer sumaImpares = 0;
        for (int i = 0; i <= digitos.length() - 1; i = i + 2) {
            Integer cal = Integer.parseInt(digitos.substring(i, i + 1)) * 2;
            if (cal.toString().length() > 1) {
                cal = Integer.parseInt(cal.toString().substring(0, 1))
                        + Integer.parseInt(cal.toString().substring(1, 2));
            }
            sumaImpares += cal;
        }

        final Integer total = sumaPares + sumaImpares;

        Integer numControl = 10 - (total % 10);

        pos = numControl == 10 ? 0 : numControl;
        carControl = "JABCDEFGHI".charAt(pos);
    }
}
