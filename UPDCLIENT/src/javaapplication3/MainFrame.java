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
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import javax.swing.Timer;

import java.io.IOException;



public class MainFrame extends javax.swing.JFrame {
    private final List<RecIntegral> data = new LinkedList<>(); 
private UDPClient client;

    public MainFrame() {
        initComponents();
         client = new UDPClient();
        client.startListening();
           client.sendPing(); // Клиент сразу начинает пинговать
     
        jMenuBar1.setBackground(new Color(238, 238, 238));
        jMenuBar1.setBorder(null);
        this.setResizable(true);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        clearTableButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        fillTableButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        calcButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        ServerCalc = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadMenu = new javax.swing.JMenu();
        loadFromTxt = new javax.swing.JMenuItem();
        loadFromBinary = new javax.swing.JMenuItem();
        loadFromJSON = new javax.swing.JMenuItem();
        SaveMenu = new javax.swing.JMenu();
        saveFromTxt = new javax.swing.JMenuItem();
        saveFromBinary = new javax.swing.JMenuItem();
        saveFromJSON = new javax.swing.JMenuItem();
        MultiThreadingCheckBox = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calc");
        setBackground(new java.awt.Color(248, 229, 233));

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

        jPanel3.setForeground(new java.awt.Color(153, 153, 153));

        jTextField1.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 239, 90), 5, true));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel3.setText("Верхний");

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel1.setText("Нижний");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        jLabel2.setText("Ш");

        jTextField3.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 239, 90), 5, true));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 239, 90), 5, true));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

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

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("∫tg(x)");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 1, 3, 1, new java.awt.Color(0, 47, 137)));

        timeLabel.setText("Время вычислений: 0 мс");

        ServerCalc.setBackground(new java.awt.Color(153, 255, 153));
        ServerCalc.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        ServerCalc.setText("ServerCalc");
        ServerCalc.setBorderPainted(false);
        ServerCalc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ServerCalc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ServerCalc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ServerCalc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ServerCalcMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(clearTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(fillTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(calcButton)
                        .addGap(18, 18, 18)
                        .addComponent(ServerCalc)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timeLabel)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(timeLabel)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(calcButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fillTableButton)
                            .addComponent(addButton))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clearTableButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(ServerCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setToolTipText("");
        jMenuBar1.setRequestFocusEnabled(false);

        jMenu1.setText("Файл");

        LoadMenu.setText("Загрузить");

        loadFromTxt.setText("Загрузить из текстового файла");
        loadFromTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFromTxtActionPerformed(evt);
            }
        });
        LoadMenu.add(loadFromTxt);

        loadFromBinary.setText("Загрузить из binary файла");
        loadFromBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFromBinaryActionPerformed(evt);
            }
        });
        LoadMenu.add(loadFromBinary);

        loadFromJSON.setText("Загрузить из JSON");
        loadFromJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFromJSONActionPerformed(evt);
            }
        });
        LoadMenu.add(loadFromJSON);

        jMenu1.add(LoadMenu);

        SaveMenu.setText("Сохранить");

        saveFromTxt.setText("Сохранить в текстовый файл");
        saveFromTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFromTxtActionPerformed(evt);
            }
        });
        SaveMenu.add(saveFromTxt);

        saveFromBinary.setText("Сохранить в binary файл");
        saveFromBinary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFromBinaryActionPerformed(evt);
            }
        });
        SaveMenu.add(saveFromBinary);

        saveFromJSON.setText("Сохранить в JSON");
        saveFromJSON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFromJSONActionPerformed(evt);
            }
        });
        SaveMenu.add(saveFromJSON);

        jMenu1.add(SaveMenu);

        MultiThreadingCheckBox.setSelected(true);
        MultiThreadingCheckBox.setText("Многопоточность");
        jMenu1.add(MultiThreadingCheckBox);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadFromTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFromTxtActionPerformed
          JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showOpenDialog(this);

    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            data.clear(); // Очистка текущих данных
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Очищаем таблицу

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
                        
                        // Добавляем в LinkedList
                        data.add(rec); // Используем add() для добавления элемента в LinkedList
                        
                        // Добавляем строку в таблицу
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

    }//GEN-LAST:event_loadFromTxtActionPerformed

    private void loadFromBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFromBinaryActionPerformed
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
                data.add(rec); // Используем add для LinkedList
                
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
    }//GEN-LAST:event_loadFromBinaryActionPerformed

    private void loadFromJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFromJSONActionPerformed
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
            data.clear(); // Очищаем данные перед загрузкой
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0); // Очищаем таблицу

            for (int i = 0; i < objects.length; i++) {
                String obj = objects[i].trim();
                if (!obj.endsWith("}")) {
                    obj += "}"; // Завершаем объект, если нет закрывающей фигурной скобки
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

                    // Используем LinkedList, чтобы добавить запись
                    data.add(rec);

                    // Добавляем строку в модель таблицы
                    String resultStr = (result == null) ? " " : Double.toString(result);
                    model.addRow(new Object[]{lower, upper, step, resultStr});
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
    }//GEN-LAST:event_loadFromJSONActionPerformed

    private void saveFromTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFromTxtActionPerformed
              JFileChooser fileChooser = new JFileChooser();
    int option = fileChooser.showSaveDialog(this);
    
    if (option == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try (FileWriter writer = new FileWriter(file)) {
            // Перебираем все элементы в LinkedList
            for (RecIntegral rec : data) {
                // Проверяем, есть ли ответ в таблице и записываем его
                String result = (rec.getResult() != null) ? String.valueOf(rec.getResult()) : "";
                writer.write(rec.getLower() + " " + rec.getUpper() + " " + rec.getStep() + " " + result + "\n");
            }
            JOptionPane.showMessageDialog(this, "Файл успешно сохранён!", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при сохранении файла!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_saveFromTxtActionPerformed

    private void saveFromBinaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFromBinaryActionPerformed
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
            for (RecIntegral rec : data) {  // Исправлено на data (LinkedList)
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
    }//GEN-LAST:event_saveFromBinaryActionPerformed

    private void saveFromJSONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFromJSONActionPerformed
          
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
            for (RecIntegral rec : data) {  // Используем data как LinkedList
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
    }//GEN-LAST:event_saveFromJSONActionPerformed

    private void calcButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calcButtonMouseClicked
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

    // Очищаем результаты перед новым вычислением
    for (RecIntegral rec : data) {
        rec.setResult(0.0);
    }

    boolean useMultiThreading = MultiThreadingCheckBox.isSelected(); 
    long startTime = System.currentTimeMillis(); 

    if (useMultiThreading) {
        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<?>> futures = new ArrayList<>();

        int i = 0;
        for (RecIntegral rec : data) {
            int actualParts = (int) ((rec.getUpper() - rec.getLower()) / rec.getStep());
            numThreads = Math.min(4, actualParts);
            double range = (rec.getUpper() - rec.getLower()) / numThreads;

            for (int j = 0; j < numThreads; j++) {
                double start = rec.getLower() + j * range;
                double end = rec.getLower() + (j + 1) * range;
                futures.add(executor.submit(new IntegrationThread(rec, model, i, start, end)));
            }
            i++;
        }

        // Дожидаемся завершения всех потоков
        executor.shutdown();
        try {
            for (Future<?> future : futures) {
                future.get(); // Блокирует, пока поток не завершится
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    } else {
        int i = 0;
        for (RecIntegral rec : data) {
            double result = integrateTrapezoidal(rec.getLower(), rec.getUpper(), rec.getStep());
            rec.setResult(result);
            final int rowIndex = i;
            SwingUtilities.invokeLater(() -> model.setValueAt(rec.getResult(), rowIndex, 3));
            i++;
        }
    }

    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime;
    timeLabel.setText("Время вычислений: " + elapsedTime + " мс");
    }//GEN-LAST:event_calcButtonMouseClicked

    private void addButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addButtonMouseClicked
        try {
            double down = Double.parseDouble(jTextField1.getText());
            double high = Double.parseDouble(jTextField2.getText());
            double step = Double.parseDouble(jTextField3.getText());

            if (step <= 0 || down >= high) {
                InvalidRecIntegralException.throwException("Некорректные параметры интегрирования!");
            }

            // Составляем ключ для параметров
            String key = down + "," + high + "," + step;

            // Здесь нужно решить, как отслеживать повторы. Если вам нужно просто отслеживать, добавьте элемент в список:
            // Например, используем список для параметров (считаем, что параметр должен быть уникальным):
            boolean exists = false;
            for (RecIntegral rec : data) {
                if (rec.getLower() == down && rec.getUpper() == high && rec.getStep() == step) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                // Прекращаем выполнение, если такой параметр уже есть
                return;
            }

            RecIntegral rec = new RecIntegral(down, high, step);

            // Добавляем новый объект RecIntegral в список data
            data.add(rec);

            // Обновляем таблицу
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.addRow(new Object[]{down, high, step, null});

            // Очищаем текстовые поля
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Введите корректные числа!", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
        } catch (InvalidRecIntegralException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonMouseClicked

    private void fillTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fillTableButtonMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        // Очищаем таблицу перед заполнением
        model.setRowCount(0);

        // Заполняем таблицу данными из LinkedList
        for (RecIntegral rec : data) {
            model.addRow(new Object[]{rec.getLower(), rec.getUpper(), rec.getStep(), rec.getResult()});
        }
    }//GEN-LAST:event_fillTableButtonMouseClicked

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Выберите строку для удаления!", "Ошибка", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Получаем значение первого столбца (lower), которое является ключом в `data`
        Double keyToRemove = (Double) jTable1.getValueAt(selectedRow, 0);

        // Удаляем объект из `LinkedList` по найденному значению
        RecIntegral recToRemove = null;
        for (RecIntegral rec : data) {
            if (rec.getLower() == keyToRemove) {
                recToRemove = rec;
                break;
            }
        }

        if (recToRemove != null) {
            data.remove(recToRemove);
        }

        // Удаляем строку из таблицы
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.removeRow(selectedRow);
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void clearTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearTableButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearTableButtonActionPerformed

    private void clearTableButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearTableButtonMouseClicked
     
    }//GEN-LAST:event_clearTableButtonMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void ServerCalcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ServerCalcMouseClicked
  try {
    int selectedRow = jTable1.getSelectedRow();
    if (selectedRow == -1) {
        System.out.println("No row selected.");
        return;
    }

    String upperLimit = jTable1.getValueAt(selectedRow, 0).toString();
    String lowerLimit = jTable1.getValueAt(selectedRow, 1).toString();
    String step = jTable1.getValueAt(selectedRow, 2).toString();
    String message = "IntegralData:" + upperLimit + "," + lowerLimit + "," + step;

    client.sendMessage(message); // Отправляем данные, пинги продолжаются
    System.out.println("Sent data: " + message);

    // Запускаем Swing Timer с задержкой 1000 мс (1 секунда) для обновления 4-й ячейки выбранной строки
    new javax.swing.Timer(1000, e -> {
        jTable1.setValueAt(client.finalResult, selectedRow, 3);
        // Останавливаем таймер после первого срабатывания
        ((javax.swing.Timer) e.getSource()).stop();
    }).start();
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}

    }//GEN-LAST:event_ServerCalcMouseClicked

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
    private javax.swing.JMenu LoadMenu;
    private javax.swing.JCheckBoxMenuItem MultiThreadingCheckBox;
    private javax.swing.JMenu SaveMenu;
    private javax.swing.JButton ServerCalc;
    private javax.swing.JButton addButton;
    private javax.swing.JButton calcButton;
    private javax.swing.JButton clearTableButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton fillTableButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JMenuItem loadFromBinary;
    private javax.swing.JMenuItem loadFromJSON;
    private javax.swing.JMenuItem loadFromTxt;
    private javax.swing.JMenuItem saveFromBinary;
    private javax.swing.JMenuItem saveFromJSON;
    private javax.swing.JMenuItem saveFromTxt;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
