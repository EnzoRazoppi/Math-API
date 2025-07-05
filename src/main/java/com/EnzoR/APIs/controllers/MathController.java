package com.EnzoR.APIs.controllers;

import com.EnzoR.APIs.exception.UnsupportedMathOperationException;
import com.EnzoR.APIs.model.MathOperations;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo){
        return MathOperations.sum(numberOne, numberOne);
    }

    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo){
        return MathOperations.subtraction(numberOne, numberTwo);
    }

    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo){
        return MathOperations.multiplication(numberOne, numberTwo);
    }

    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo){
        return MathOperations.division(numberOne, numberTwo);
    }

    @RequestMapping("/average/{numberOne}/{numberTwo}")
    public Double average(@PathVariable String numberOne, @PathVariable String numberTwo){
        return MathOperations.average(numberOne, numberTwo);
    }

    @RequestMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable String number){
        return MathOperations.squareRoot(numberOne, numberTwo);
    }

}
