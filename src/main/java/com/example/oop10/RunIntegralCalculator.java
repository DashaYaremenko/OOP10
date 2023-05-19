package com.example.oop10;

import java.util.function.DoubleUnaryOperator;

public class RunIntegralCalculator implements Runnable{
    private CalculatorLogic main;
    private CalcFunction calculator;
    public RunIntegralCalculator(double start, double end, int steps, DoubleUnaryOperator f, CalculatorLogic main) {
        calculator = new CalcFunction(start,end,steps,f);
        this.main = main;
    }
    @Override
    public void run() {
        double v = calculator.calculate();
        main.send(v);
    }
}
