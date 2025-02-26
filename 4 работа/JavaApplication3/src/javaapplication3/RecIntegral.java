package javaapplication3;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecIntegral {
    private double lower;
    private double upper;
    private double step;
    private Double result; // Может быть null до вычисления

    // Используем Map для хранения количества одинаковых записей
    private static final Map<String, Integer> countCache = new LinkedHashMap<>();
    private static final Map<Double, RecIntegral> integralCache = new LinkedHashMap<>();

    public RecIntegral(double lower, double upper, double step) throws InvalidRecIntegralException {
        validateRange(lower, "нижнего предела");
        validateRange(upper, "верхнего предела");
        validateRange(step, "шага");

        if (lower > upper) {
            InvalidRecIntegralException.throwException("Нижний предел не может быть больше верхнего предела");
        }

        // Формируем ключ для проверки количества одинаковых значений
        String key = generateKey(lower, upper, step);
        countCache.put(key, countCache.getOrDefault(key, 0) + 1);

        if (countCache.get(key) > 3) {
            throw new InvalidRecIntegralException("Уже существует 3 одинаковых набора значений. Вычисление не выполняется.");
        }

        this.lower = lower;
        this.upper = upper;
        this.step = step;
        this.result = null;
    }

    private void validateRange(double value, String name) throws InvalidRecIntegralException {
        if (value < 0.000001 || value > 1000000) {
            InvalidRecIntegralException.throwException("Значение " + name + " должно быть в пределах от 0.000001 до 1000000");
        }
    }

    private String generateKey(double lower, double upper, double step) {
        return lower + ":" + upper + ":" + step;
    }

    public double getLower() { return lower; }
    public double getUpper() { return upper; }
    public double getStep() { return step; }
    public Double getResult() { return result; }

    public void setResult(double result) {
        this.result = result;
        integralCache.put(result, this); // Добавляем в LinkedHashMap
    }

    public static RecIntegral getByResult(double result) {
        return integralCache.get(result); // Получаем объект по result
    }

    public static Map<Double, RecIntegral> getAllResults() {
        return integralCache; // Получаем всю карту
    }
}
