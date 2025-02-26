package javaapplication3;

public class RecIntegral {
    private double lower;
    private double upper;
    private double step;
    private Double result; // Может быть null до вычисления

    public RecIntegral(double lower, double upper, double step) throws InvalidRecIntegralException {
        // Проверка диапазона для lower
        if (lower < 0.000001 || lower > 1000000) {
            throw new InvalidRecIntegralException("Значение нижнего предела должно быть в пределах от 0.000001 до 1000000");
        }

        // Проверка диапазона для upper
        if (upper < 0.000001 || upper > 1000000) {
            throw new InvalidRecIntegralException("Значение верхнего предела должно быть в пределах от 0.000001 до 1000000");
        }

        // Проверка диапазона для step
        if (step < 0.000001 || step > 1000000) {
            throw new InvalidRecIntegralException("Значение шага должно быть в пределах от 0.000001 до 1000000");
        }

        // Если все проверки прошли, то присваиваем значения
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
