package javaapplication3;

import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class IntegrationThread extends Thread {
    private RecIntegral recIntegral;
    private DefaultTableModel model;
    private int rowIndex;
    private double start;
    private double end;

    public IntegrationThread(RecIntegral recIntegral, DefaultTableModel model, int rowIndex, double start, double end) {
        this.recIntegral = recIntegral;
        this.model = model;
        this.rowIndex = rowIndex;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();


        double result = integrateTrapezoidal(start, end, recIntegral.getStep());

        recIntegral.addPartialResult(result);

        System.out.println("Завершение вычислений в потоке: " + threadName + " | Результат: " + result);

        // Обновляем GUI через EDT
        SwingUtilities.invokeLater(() -> {
            model.setValueAt(recIntegral.getResult(), rowIndex, 3);
        });
    }

    private double integrateTrapezoidal(double a, double b, double h) {
        double sum = 0.0;
        for (double x = a; x < b; x += h) {
            sum += 0.5 * (Math.tan(x) + Math.tan(x + h)) * h;
        }
        return sum;
    }
}
