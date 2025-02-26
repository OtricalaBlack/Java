package javaapplication3;
import javax.swing.SwingUtilities;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.LinkedList; 
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.*;
import javaapplication3.IntegrationThread;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CountDownLatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainFrame extends javax.swing.JFrame {
    private final Map<String, Integer> parameterCount = new HashMap<>();
    private final Map<Double, RecIntegral> data = new LinkedHashMap<>();

    public MainFrame() {
        initComponents();
        this.setResizable(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14));
        jTable1.getTableHeader().setBackground(new java.awt.Color(255, 255, 255));
        jTable1.getTableHeader().setForeground(new java.awt.Color(0, 0, 0));
        jTable1.getTableHeader().setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jTable1.setShowGrid(true);
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jTable1.setIntercellSpacing(new java.awt.Dimension(1, 1));
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Нижний", "Верхний", "Шаг", "Значение"}
        ) {
            @Override
               public boolean isCellEditable(int row, int column) {
                return column < 3;
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
        saveButton = new javax.swing.JButton();
        loadBinaryButton = new javax.swing.JButton();
        saveBinaryButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        loadJsonButton = new javax.swing.JButton();
        saveJsonButton = new javax.swing.JButton();

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
        clearTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearTableButtonActionPerformed(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(204, 255, 255));
        saveButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        saveButton.setText("Сохранить");
        saveButton.setBorderPainted(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setFocusPainted(false);
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        loadBinaryButton.setBackground(new java.awt.Color(255, 178, 102));
        loadBinaryButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        loadBinaryButton.setForeground(new java.awt.Color(51, 0, 51));
        loadBinaryButton.setText("<html>Загрузить<br>(binary)\n</html>");
        loadBinaryButton.setBorderPainted(false);
        loadBinaryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadBinaryButton.setFocusPainted(false);
        loadBinaryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadBinaryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loadBinaryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadBinaryButtonMouseClicked(evt);
            }
        });

        saveBinaryButton.setBackground(new java.awt.Color(102, 178, 255));
        saveBinaryButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        saveBinaryButton.setText("<html>Сохранить<br>(binary)</html>");
        saveBinaryButton.setBorderPainted(false);
        saveBinaryButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBinaryButton.setFocusPainted(false);
        saveBinaryButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveBinaryButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveBinaryButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBinaryButtonMouseClicked(evt);
            }
        });

        loadButton.setBackground(new java.awt.Color(255, 102, 102));
        loadButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        loadButton.setText("Загрузить");
        loadButton.setBorderPainted(false);
        loadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadButton.setFocusPainted(false);
        loadButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loadButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadButtonMouseClicked(evt);
            }
        });

        loadJsonButton.setBackground(new java.awt.Color(204, 204, 255));
        loadJsonButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        loadJsonButton.setForeground(new java.awt.Color(51, 0, 51));
        loadJsonButton.setText("<html>Загрузить<br>(JSON) </html>");
        loadJsonButton.setBorderPainted(false);
        loadJsonButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loadJsonButton.setFocusPainted(false);
        loadJsonButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loadJsonButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        loadJsonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadJsonButtonMouseClicked(evt);
            }
        });

        saveJsonButton.setBackground(new java.awt.Color(153, 255, 153));
        saveJsonButton.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        saveJsonButton.setText("<html>Сохранить<br>(JSON)</html>");
        saveJsonButton.setBorderPainted(false);
        saveJsonButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveJsonButton.setFocusPainted(false);
        saveJsonButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveJsonButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveJsonButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveJsonButtonMouseClicked(evt);
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(saveBinaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fillTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(loadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(loadBinaryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveJsonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loadJsonButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calcButton))
                        .addContainerGap(34, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addButton)
                                    .addComponent(fillTableButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(clearTableButton)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(saveButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loadButton))
                            .addComponent(calcButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loadJsonButton)
                            .addComponent(saveBinaryButton, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(saveJsonButton)
                            .addComponent(loadBinaryButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

            if (step <= 0 || down >= high) {
                InvalidRecIntegralException.throwException("Некорректные параметры интегрирования!");
            }

            String key = down + "," + high + "," + step;
            parameterCount.put(key, parameterCount.getOrDefault(key, 0) + 1);

            if (parameterCount.get(key) > 3) {
                return;
            }

            RecIntegral rec = new RecIntegral(down, high, step);
            data.put(rec.getLower(), rec);
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{down, high, step, null});
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Введите корректные числа!", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidRecIntegralException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
   int selectedRow = jTable1.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Выберите строку для удаления!", "Ошибка", JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Получаем значение первого столбца (lower), которое является ключом в `data`
    Double keyToRemove = (Double) jTable1.getValueAt(selectedRow, 0);
    
    // Удаляем из `Map`
    if (data.containsKey(keyToRemove)) {
        data.remove(keyToRemove);
    }
    
    // Удаляем строку из таблицы
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.removeRow(selectedRow);
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void calcButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calcButtonMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    AtomicInteger rowIndex = new AtomicInteger(0); 

    ExecutorService executor = Executors.newFixedThreadPool(4); // Максимум 4 потока

    for (RecIntegral rec : data.values()) {
        executor.execute(new IntegrationThread(rec, model, rowIndex));
    }

    executor.shutdown(); 
    }//GEN-LAST:event_calcButtonMouseClicked

    private void fillTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillTableButtonMouseClicked
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Очищаем таблицу перед заполнением
    model.setRowCount(0);
    
    // Заполняем таблицу данными из LinkedList
    for (RecIntegral rec : data.values()){
        model.addRow(new Object[]{rec.getLower(), rec.getUpper(), rec.getStep(), rec.getResult()});
    }
    }//GEN-LAST:event_fillTableButtonMouseClicked

    private void clearTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearTableButtonMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    
    // Очистка всех строк таблицы
     model.setRowCount(0);
    }//GEN-LAST:event_clearTableButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
    JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showSaveDialog(this);
    
    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (FileWriter writer = new FileWriter(file)) {
            for (RecIntegral rec : data.values()) {
                // Проверяем, есть ли ответ в таблице и записываем его
                String result = (rec.getResult() != null) ? String.valueOf(rec.getResult()) : "";
                writer.write(rec.getLower() + " " + rec.getUpper() + " " + rec.getStep() + " " + result + "\n");
            }
            JOptionPane.showMessageDialog(this, "Файл успешно сохранён!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при сохранении файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    }//GEN-LAST:event_saveButtonMouseClicked

    private void loadBinaryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadBinaryButtonMouseClicked
   JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showOpenDialog(this);
    
    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            data.clear(); // Очищаем текущие данные
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            
            int size = in.readInt(); // Считываем количество элементов
            for (int i = 0; i < size; i++) {
                double lower = in.readDouble();
                double upper = in.readDouble();
                double step = in.readDouble();
                
                Double result = null;
                if (in.readBoolean()) { // Если result записан, считываем его
                    result = in.readDouble();
                }
                
                RecIntegral rec = new RecIntegral(lower, upper, step);
                if (result == null) {
                     rec.setResult(0.0); // Или другое значение по умолчанию
                } else {
                    rec.setResult(result);
                }
                data.put(lower, rec);
                
                // Используем пустую строку вместо null в таблице
                String resultDisplay = (result != null) ? String.valueOf(result) : "";

                model.addRow(new Object[]{lower, upper, step, resultDisplay});
            }
            
            JOptionPane.showMessageDialog(this, "Файл успешно загружен!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException | InvalidRecIntegralException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при загрузке бинарного файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_loadBinaryButtonMouseClicked

    private void saveBinaryButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBinaryButtonMouseClicked
  JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showSaveDialog(this);
    
    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();

        if (!file.getName().endsWith(".ser")) {
            file = new File(file.getParent(), file.getName() + ".ser");
        }
        
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            // Записываем каждую запись отдельно
            out.writeInt(data.size()); // Сначала записываем количество элементов
            for (RecIntegral rec : data.values()) {
                out.writeDouble(rec.getLower());
                out.writeDouble(rec.getUpper());
                out.writeDouble(rec.getStep());
                // Если result == null, записываем специальное значение
                out.writeBoolean(rec.getResult() != null);
                if (rec.getResult() != null) {
                    out.writeDouble(rec.getResult());
                }
            }
            JOptionPane.showMessageDialog(this, "Файл успешно сохранён!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при сохранении файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }                         
    }//GEN-LAST:event_saveBinaryButtonMouseClicked

    private void loadButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadButtonMouseClicked
  JFileChooser fileChooser = new JFileChooser();
int option = fileChooser.showOpenDialog(this);

if (option == JFileChooser.APPROVE_OPTION) {
    File file = fileChooser.getSelectedFile();
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
        data.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        String line;
        while ((line = reader.readLine()) != null) {
            // Разбиваем строку по одному или более пробельным символам
            String[] parts = line.trim().split("\\s+");
            System.out.println(" parts.length = " + parts.length + " | parts = " + java.util.Arrays.toString(parts));
            if (parts.length == 3 || parts.length == 4) {
                
                try {
                    double lower = Double.parseDouble(parts[0]);
                    double upper = Double.parseDouble(parts[1]);
                    double step = Double.parseDouble(parts[2]);
                    Double result = null;
                    String resultDisplay = ""; // для таблицы

                    if (parts.length == 4) {
                        if (!parts[3].trim().isEmpty()) {
                            result = Double.parseDouble(parts[3]);
                            resultDisplay = parts[3].trim();
                        }
                    }
                    
                    // Если результат отсутствует, присваиваем значение по умолчанию (например, 0.0)
                    if (result == null) {
                        result = 0.0;
                    }
                    
                    // Вывод отладочной информации перед созданием объекта RecIntegral
                    System.out.println("DEBUG: lower=" + lower + ", upper=" + upper + ", step=" + step + ", result=" + result);
                    
                    RecIntegral rec = new RecIntegral(lower, upper, step);
                    rec.setResult(result);
                    data.put(rec.getLower(), rec);
                    model.addRow(new Object[]{lower, upper, step, resultDisplay});
                } catch (NumberFormatException | InvalidRecIntegralException ex) {
                    JOptionPane.showMessageDialog(this, "Ошибка формата данных в файле!\n" +
                            "Строка: " + line + "\n" +
                            "parts: " + java.util.Arrays.toString(parts),
                            "Ошибка", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } 
            } else {
                System.out.println("  Пропущена строка из-за неверного количества полей: " + line);
            }
        }
        JOptionPane.showMessageDialog(this, "Файл успешно загружен!", "Успех", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Ошибка при загрузке файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}

    }//GEN-LAST:event_loadButtonMouseClicked

    private void clearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearTableButtonActionPerformed

    private void loadJsonButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadJsonButtonMouseClicked
    JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showOpenDialog(this);

    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder jsonText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line.trim());
            }

            // Убираем начальные и конечные квадратные скобки
            String jsonData = jsonText.toString().trim();
            if (jsonData.startsWith("[")) {
                jsonData = jsonData.substring(1);
            }
            if (jsonData.endsWith("]")) {
                jsonData = jsonData.substring(0, jsonData.length() - 1);
            }

            // Разбиваем по "}," чтобы получить отдельные объекты
            String[] objects = jsonData.split("},");
            data.clear();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            for (int i = 0; i < objects.length; i++) {
                String obj = objects[i].trim();
                if (!obj.endsWith("}")) {
                    obj += "}";
                }
                // Убираем фигурные скобки
                if (obj.startsWith("{")) {
                    obj = obj.substring(1);
                }
                if (obj.endsWith("}")) {
                    obj = obj.substring(0, obj.length() - 1);
                }
                String[] keyValuePairs = obj.split(",");

                double lower = 0, upper = 0, step = 0;
                Double result = null;

                for (String pair : keyValuePairs) {
                    String[] keyValue = pair.split(":");
                    if (keyValue.length < 2) {
                        continue; // Пропускаем некорректные пары
                    }
                    String key = keyValue[0].replace("\"", "").trim();
                    String value = keyValue[1].replace("\"", "").trim();

                    switch (key) {
                        case "lower":
                            lower = Double.parseDouble(value);
                            break;
                        case "upper":
                            upper = Double.parseDouble(value);
                            break;
                        case "step":
                            step = Double.parseDouble(value);
                            break;
                        case "result":
                            if (!value.equals("null") && !value.trim().isEmpty()) {
                                result = Double.parseDouble(value);
                            }
                            break;
                    }
                }

                // Если результат отсутствует, присваиваем значение по умолчанию (например, 0.0)
                if (result == null) {
                    result = 0.0;
                }
                
                // Отладочный вывод значений
                System.out.println("Отладка: lower=" + lower + ", upper=" + upper + ", step=" + step + ", result=" + result);

                try {
                    // Создание объекта RecIntegral
                    RecIntegral rec = new RecIntegral(lower, upper, step);
                    rec.setResult(result);
                    data.put(lower, rec);

                    // Добавляем строку в модель таблицы
                    String resultStr = (result == null) ? " " : Double.toString(result);
                    model.addRow(new Object[]{ lower, upper, step, resultStr });
                } catch (InvalidRecIntegralException e) {
                    JOptionPane.showMessageDialog(this, "Ошибка в данных при создании RecIntegral!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }

            JOptionPane.showMessageDialog(this, "Файл успешно загружен!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при загрузке JSON!", "Ошибка", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_loadJsonButtonMouseClicked

    private void saveJsonButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveJsonButtonMouseClicked
     JFileChooser fileChooser = new JFileChooser();
int option = fileChooser.showSaveDialog(this);

if (option == JFileChooser.APPROVE_OPTION) {
    File file = fileChooser.getSelectedFile();
    
    if (!file.getName().endsWith(".json")) {
        file = new File(file.getParent(), file.getName() + ".json");
    }

    try (FileWriter writer = new FileWriter(file)) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n"); // Начало массива JSON

        boolean first = true;
        for (RecIntegral rec : data.values()) {
            if (!first) {
                jsonBuilder.append(",\n");
            }
            first = false;

            jsonBuilder.append("  {\n")
                    .append("\t\"lower\": ").append(rec.getLower()).append(",\n")
                    .append("\t\"upper\": ").append(rec.getUpper()).append(",\n")
                    .append("\t\"step\": ").append(rec.getStep()).append(",\n")
                    .append("\t\"result\": ");
                    
            if (rec.getResult() != null) {
                jsonBuilder.append(rec.getResult()).append("\n");
            } else {
                jsonBuilder.append("null").append("\n");
            }
            
            jsonBuilder.append("  }");
        }

        jsonBuilder.append("\n]"); // Закрываем массив JSON
        writer.write(jsonBuilder.toString());
        writer.flush();

        JOptionPane.showMessageDialog(this, "Файл успешно сохранён!", "Успех", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(this, "Ошибка при сохранении JSON!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}

    }//GEN-LAST:event_saveJsonButtonMouseClicked

    private double integrateTrapezoidal(double a, double b, double h) {
    int n = (int) ((b - a) / h); // Количество полных шагов
    double sum = 0.0;

    for (int i = 0; i < n; i++) {
        double x1 = a + i * h;
        double x2 = x1 + h;
        sum += 0.5 * (Math.tan(x1) + Math.tan(x2)) * h;
    }

    // Проверяем, есть ли остаток после последних полных шагов
    double lastX = a + n * h;
    if (lastX < b) { // Если осталась "неполная" часть
        sum += 0.5 * (Math.tan(lastX) + Math.tan(b)) * (b - lastX);
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
    private javax.swing.JButton loadBinaryButton;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton loadJsonButton;
    private javax.swing.JButton saveBinaryButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton saveJsonButton;
    // End of variables declaration//GEN-END:variables
}
