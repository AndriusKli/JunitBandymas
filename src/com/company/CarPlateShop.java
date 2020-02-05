package com.company;

import java.util.regex.Pattern;

public class CarPlateShop {

    public CarPlateShop() {
    }
    
    public Double calculatePrice(String carNumber) {
        if (illegalArgument(carNumber)) {
            throw new IllegalArgumentException("Incorrect plate number format.");
        }
        carNumber = carNumber.toLowerCase();
        if (superSpecialNameplate(carNumber)) {
            return 10000.0;
        }
        if (specialLetters(carNumber) && lastTheeSymbolsEqual(carNumber)) {
            return 7000.0;
        }
        if (firstThreeSymbolsEqual(carNumber) && lastTheeSymbolsEqual(carNumber)) {
            return 5000.0;
        }
        if (specialLetters(carNumber)) {
            return 2000.0;
        }
        if (firstThreeSymbolsEqual(carNumber) || lastTheeSymbolsEqual(carNumber) || specialNumber(carNumber)) {
            return 1000.0;
        }
        return 500.0;
    }


    public static boolean illegalArgument(String carNumber) {
        return carNumber == null || carNumber.trim().length() < 1 || carNumber.length() > 6;
    }

    public static boolean firstThreeSymbolsEqual(String carNumber) {
        return carNumber.charAt(0) == carNumber.charAt(1) && carNumber.charAt(1) == carNumber.charAt(2);
    }

    public static boolean lastTheeSymbolsEqual(String carNumber) {
        return carNumber.charAt(3) == carNumber.charAt(4) && carNumber.charAt(4) == carNumber.charAt(5);
    }

    public static boolean specialNumber(String carNumber) {
        return carNumber.substring(3, 6).equals("001") || carNumber.substring(3, 6).equals("666");
    }

    public static boolean specialLetters(String carNumber) {
        return carNumber.substring(0, 3).equals("god") || carNumber.substring(0, 3).equals("klr") || carNumber.substring(0, 3).equals("bos");
    }

    public static boolean superSpecialNameplate(String carNumber) {
        return carNumber.length() < 6 || Pattern.compile("[0-9]").matcher(carNumber.substring(0, 3)).find() || Pattern.compile("[a-z]").matcher(carNumber.substring(3, 6)).find();
    }
}

