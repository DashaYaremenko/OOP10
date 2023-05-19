package com.example.oop10;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.IntStream;

public class CalcFunction {
    private double start;
    private double finish;
    private double step;
    private int nStep;
    private DoubleUnaryOperator f;
    public CalcFunction(double start,double finish, int nStep, DoubleUnaryOperator f){
        this.start=start;
        this.finish=finish;
        this.nStep=nStep;
        this.f=f;
        step=(finish-start)/nStep;
    }
    public double calculate() {
        return IntStream.range(0, nStep).mapToDouble(i -> start + i * step  +step/2).map(f).map(y -> y * step).sum();

    }
}
