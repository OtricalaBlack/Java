package javaapplication3;

import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class IntegrationThread extends Thread {
    private RecIntegral recIntegral;
    private DefaultTableModel model;
    private AtomicInteger rowIndex;

    public IntegrationThread(RecIntegral recIntegral, DefaultTableModel model, AtomicInteger rowIndex) {
        this.recIntegral = recIntegral;
        this.model = model;
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Старт вычислений в потоке: " + threadName);

        double result = integrateTrapezoidal(recIntegral.getLower(), recIntegral.getUpper(), recIntegral.getStep());
        recIntegral.setResult(result);

        System.out.println("Завершение вычислений в потоке: " + threadName + " | Результат: " + result);

        // Обновляем GUI через EDT
        SwingUtilities.invokeLater(() -> {
            model.setValueAt(result, rowIndex.getAndIncrement(), 3);
        });
    }

    private double integrateTrapezoidal(double a, double b, double h) {
        int n = (int) ((b - a) / h);
        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            double x1 = a + i * h;
            double x2 = x1 + h;
            sum += 0.5 * (Math.tan(x1) + Math.tan(x2)) * h;
        }

        double lastX = a + n * h;
        if (lastX < b) {
            sum += 0.5 * (Math.tan(lastX) + Math.tan(b)) * (b - lastX);
        }

        return sum;
    }
}
