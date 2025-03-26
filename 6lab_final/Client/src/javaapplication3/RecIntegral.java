package javaapplication3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.LinkedList;
import java.util.List;

public class RecIntegral implements Externalizable {
    private double lower;
    private double upper;
    private double step;
    private Double result; // Может быть null до вычисления

    public static final List<RecIntegral> integralList = new LinkedList<>();

    // Конструктор по умолчанию (обязательно для Externalizable)
    public RecIntegral() {}

    public RecIntegral(double lower, double upper, double step) throws InvalidRecIntegralException {
        validateRange(lower, "нижнего предела");
        validateRange(upper, "верхнего предела");
        validateRange(step, "шага");

        if (lower > upper) {
            throw new InvalidRecIntegralException("Нижний предел не может быть больше верхнего предела");
        }

        this.lower = lower;
        this.upper = upper;
        this.step = step;
        this.result = 0.0;

        integralList.add(this);
    }

    public synchronized void addPartialResult(double partialResult) {
        this.result += partialResult;
    }

    public synchronized void setResult(double result) {
        this.result = result;
    }

    private void validateRange(double value, String name) throws InvalidRecIntegralException {
        if (value < 0.000001 || value > 1000000) {
            throw new InvalidRecIntegralException("Значение " + name + " должно быть в пределах от 0.000001 до 1000000");
        }
    }

    public double getLower() { return lower; }
    public double getUpper() { return upper; }
    public double getStep() { return step; }
    public Double getResult() { return result; }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

        out.writeDouble(upper);
        out.writeDouble(step);
        out.writeBoolean(result != null);
        if (result != null) {
            out.writeDouble(result);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException {
  
        upper = in.readDouble();
        step = in.readDouble();
        if (in.readBoolean()) {
            result = in.readDouble();
        } else {
            result = null;
        }
    }
}
