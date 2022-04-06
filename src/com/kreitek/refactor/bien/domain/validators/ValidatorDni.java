package com.kreitek.refactor.bien.domain.validators;

import com.kreitek.refactor.bien.interfaces.Validator;

public class ValidatorDni implements Validator {
    @Override
    public int validate(String identification) {
        String dniChars = "TRWAGMYFPDXBNJZSQVHLCKE";
        String intPartDNI = identification.trim().replaceAll(" ", "").substring(0, 8);
        char ltrDNI = identification.charAt(8);
        int valNumDni = Integer.parseInt(intPartDNI) % 23;

        if (identification.length() != 9 || isNumeric(intPartDNI) == false || dniChars.charAt(valNumDni) != ltrDNI) {
            return 0;
        } else {
            return 1;
        }
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
