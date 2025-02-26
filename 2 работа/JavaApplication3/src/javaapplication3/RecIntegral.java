/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication3;

public class RecIntegral {
    private double lower;
    private double upper;
    private double step;
    private Double result; // Может быть null до вычисления

    public RecIntegral(double lower, double upper, double step) {
        this.lower = lower;
        this.upper = upper;
        this.step = step;
        this.result = null;
    }

    public double getLower() { return lower; }
    public double getUpper() { return upper; }
    public double getStep() { return step; }
    public Double getResult() { return result; }

    public void setResult(double result) { this.result = result; }
}
