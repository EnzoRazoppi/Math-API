package com.EnzoR.APIs.controllers;

import com.EnzoR.APIs.exception.UnsupportedMathOperationException;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne,
                      @PathVariable String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne)-convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne)*convertToDouble(numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return convertToDouble(numberOne)/convertToDouble(numberTwo);
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne, @PathVariable String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return (convertToDouble(numberOne)+convertToDouble(numberTwo))/2;
    }

    @RequestMapping("/squareroot/{numberOne}")
    public Double squareRoot(@PathVariable String numberOne){
        if (!isNumeric(numberOne)) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        return Math.sqrt(convertToDouble(numberOne));
    }


    private Double convertToDouble (String strNumber) throws UnsupportedMathOperationException{
        if(strNumber == null || strNumber.isEmpty()) throw new UnsupportedMathOperationException("Please, set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    public boolean isNumeric(String strNumber){
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", ".");
        return (number.matches("[+-]?[0-9]*\\.?[0-9]*"));
    }
}
