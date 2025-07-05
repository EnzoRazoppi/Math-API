package com.EnzoR.APIs.model;

import com.EnzoR.APIs.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class MathOperations {

    public static Double sum(String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public static Double subtraction(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne)-convertToDouble(numberTwo);
    }

    public static Double multiplication(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne)*convertToDouble(numberTwo);
    }

    public static Double division(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne)/convertToDouble(numberTwo);
    }

    public static Double average(String numberOne, String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return (convertToDouble(numberOne)+convertToDouble(numberTwo))/2;
    }

    public static Double squareRoot(String number){
        if (!isNumeric(number)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return Math.sqrt(convertToDouble(number));
    }


    private static Double convertToDouble (String strNumber) throws UnsupportedMathOperationException {
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private static boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[+-]?[0-9]*\\.?[0-9]*"));
    }
}
