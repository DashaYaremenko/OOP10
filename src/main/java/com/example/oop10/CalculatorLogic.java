package com.example.oop10;

public class CalculatorLogic implements CalculatorInter {
    private double totalResult;
    private int finished;

    public Result calcIntegral(int interval, int threads){
        double a=0;
        double b=Math.PI/2;
        double delta = (b - a) / threads;
        totalResult = 0;
        finished = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            RunIntegralCalculator calculator = new RunIntegralCalculator(a + i * delta, a + i * delta + delta,
                    interval/threads,t->Math.sin(2*t)*Math.cos(3*t), this);
            new Thread(calculator).start();
        }
        try {
            synchronized (this) {
                while (finished < threads) {
                    wait();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupted");
        }
        long finish = System.currentTimeMillis();
        return new Result(totalResult, finish - start);
    }
    public synchronized void send(double v) {
        totalResult += v;
        finished++;
        notify();
    }


}
