package javaapplication3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class MainFrame extends javax.swing.JFrame {
private LinkedList<RecIntegral> data = new LinkedList<>();

    public MainFrame() {
        initComponents();
        this.setResizable(false); // Запрещает изменение размера окна
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14));
        jTable1.getTableHeader().setBackground(new java.awt.Color(255,255,255));
        jTable1.getTableHeader().setForeground(new java.awt.Color(0, 0, 0));
        jTable1.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jTable1.setShowGrid(true); // Включаем сетку
        jTable1.setGridColor(new java.awt.Color(0, 0, 0)); // Черные границы у столбцов
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 1)); // Устанавливаем расстояние между ячейками
        
        // Устанавливаем модель для таблицы
    jTable1.setModel(new DefaultTableModel(
        new Object[][] {},
        new String[] { "Нижний", "Верхний", "Шаг", "Значение" }
    ) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column < 3; // Разрешаем редактировать только первые 3 столбца
        }
    });
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        calcButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        fillTableButton = new javax.swing.JButton();
        clearTableButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calc");
        setBackground(new java.awt.Color(0, 0, 0));

        addButton.setBackground(new java.awt.Color(204, 255, 255));
        addButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        addButton.setText("Добавить");
        addButton.setBorderPainted(false);
        addButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addButtonMouseClicked(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 102, 102));
        deleteButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(51, 0, 51));
        deleteButton.setText("Удалить");
        deleteButton.setBorderPainted(false);
        deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteButton.setFocusPainted(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
        });

        calcButton.setBackground(new java.awt.Color(237, 167, 255));
        calcButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        calcButton.setText("Вычислить");
        calcButton.setBorderPainted(false);
        calcButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calcButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        calcButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        calcButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calcButtonMouseClicked(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 239, 90), 5, true));

        jTextField2.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 239, 90), 5, true));

        jTextField3.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 239, 90), 5, true));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel1.setText("Нижний");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel2.setText("Ш");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel3.setText("Верхний");

        jTable1.setBackground(new java.awt.Color(255, 243, 243));
        jTable1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 2, 1, 2, new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Нижний", "Верхний", "Шаг", "Значение"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setShowGrid(false);
        jScrollPane1.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("∫tg(x)");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 1, 3, 1, new java.awt.Color(0, 47, 137)));

        fillTableButton.setBackground(new java.awt.Color(204, 255, 255));
        fillTableButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        fillTableButton.setText("Заполнить");
        fillTableButton.setBorderPainted(false);
        fillTableButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fillTableButton.setFocusPainted(false);
        fillTableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        fillTableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        fillTableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fillTableButtonMouseClicked(evt);
            }
        });

        clearTableButton.setBackground(new java.awt.Color(255, 102, 102));
        clearTableButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        clearTableButton.setForeground(new java.awt.Color(51, 0, 51));
        clearTableButton.setText("Очистить");
        clearTableButton.setBorderPainted(false);
        clearTableButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearTableButton.setFocusPainted(false);
        clearTableButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearTableButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearTableButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearTableButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(calcButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(clearTableButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fillTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addButton)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fillTableButton)
                                .addGap(18, 18, 18)
                                .addComponent(clearTableButton)))
                        .addGap(18, 18, 18)
                        .addComponent(calcButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
    try {
        double down = Double.parseDouble(jTextField1.getText());
        double high = Double.parseDouble(jTextField2.getText());
        double step = Double.parseDouble(jTextField3.getText());

        RecIntegral rec = new RecIntegral(down, high, step);
        data.add(rec);  // Добавляем запись в коллекцию

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{down, high, step, null});

        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        
    } catch (InvalidRecIntegralException e) {
        // Обрабатываем исключение, связанное с некорректным значением диапазона
        JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        // Обработка ошибки неверного формата чисел
        JOptionPane.showMessageDialog(this, "Введите корректные числа!", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_addButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
       int selectedRow = jTable1.getSelectedRow();
    if (selectedRow != -1) {
        data.remove(selectedRow);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(selectedRow);
    } else {
        JOptionPane.showMessageDialog(this, "Выберите строку для удаления");
    }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void calcButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calcButtonMouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();

    for (int i = 0; i < data.size(); i++) {
        RecIntegral rec = data.get(i);
        double result = integrateTrapezoidal(rec.getLower(), rec.getUpper(), rec.getStep());
        rec.setResult(result);
        model.setValueAt(result, i, 3);
    }
    }//GEN-LAST:event_calcButtonMouseClicked

    private void fillTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillTableButtonMouseClicked
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Очищаем таблицу перед заполнением
    model.setRowCount(0);
    
    // Заполняем таблицу данными из LinkedList
    for (RecIntegral rec : data) {
        model.addRow(new Object[]{rec.getLower(), rec.getUpper(), rec.getStep(), rec.getResult()});
    }
    }//GEN-LAST:event_fillTableButtonMouseClicked

    private void clearTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearTableButtonMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Очистка всех строк таблицы
     model.setRowCount(0);
    }//GEN-LAST:event_clearTableButtonMouseClicked

    private double integrateTrapezoidal(double a, double b, double h) {
    int n = (int) Math.ceil((b - a) / h); // Количество шагов
    double sum = 0.0;

    for (int i = 0; i < n; i++) {
        double x1 = a + i * h;
        double x2 = Math.min(b, x1 + h); // Учитываем границу
        sum += 0.5 * (Math.tan(x1) + Math.tan(x2)) * (x2 - x1);
    }

    return sum;
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton calcButton;
    private javax.swing.JButton clearTableButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton fillTableButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
