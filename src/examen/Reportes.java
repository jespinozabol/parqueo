/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author jeez
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    private ArrayList<Double> list;
    
    public Reportes(Usuario usr, int fila, int columna) {
        initComponents();
//       this.jrtDia.setSelected(true);
        

    }
    
    private void FillData()
    {
        int sum = list.stream().mapToInt(Double::intValue).sum();
        this.jTxtHora.setText(Double.toString(list.size()));
        this.jTxtDiarioTotal.setText(Double.toString(sum));
    }
    private void LoadDataFromFiles() {
        Scanner s;
        list = new ArrayList<Double>();
        File folder = new File(Paths.get(".").toAbsolutePath().normalize().toString());
        File[] listOfFiles = folder.listFiles();
        boolean isHour = this.jrthora.isSelected();
        String value = jTxtfiltro.getText();
        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            String[] output = file.getName().split("-");
            if (isHour && output[0].equals(value) && file.isFile() && file.getName().endsWith(".txt")) {
                try {                    
                    s = new Scanner(new File(file.getName()));                  
                    
                    while (s.hasNext()) {
                        list.add(Double.parseDouble(s.next()));
                    }
                    s.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                /* do somthing with content */
            }
            if (!isHour && output[1].equals(value) && file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    
                    s = new Scanner(new File(file.getName()));                  
                    
                    while (s.hasNext()) {
                        list.add(Double.parseDouble(s.next()));
                    }
                    s.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
                }
                /* do somthing with content */
            }
            FillData();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jrtDia = new javax.swing.JRadioButton();
        jrthora = new javax.swing.JRadioButton();
        jTxtfiltro = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtHora = new javax.swing.JTextField();
        jTxtDiarioTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("REPORTES");

        buttonGroup1.add(jrtDia);
        jrtDia.setText("Dia");
        jrtDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrtDiaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrthora);
        jrthora.setText("Hora");

        jTxtfiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtfiltroActionPerformed(evt);
            }
        });

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Total de Vehiculos");

        jLabel3.setText("Total");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtDiarioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(7, 7, 7)
                                .addComponent(jTxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jrtDia)
                                .addGap(18, 18, 18)
                                .addComponent(jrthora)
                                .addGap(18, 18, 18)
                                .addComponent(jTxtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)
                        .addComponent(jButton1)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrtDia)
                    .addComponent(jrthora)
                    .addComponent(jTxtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtDiarioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(135, Short.MAX_VALUE))
        );

        jrtDia.getAccessibleContext().setAccessibleName("Dia");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrtDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrtDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrtDiaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoadDataFromFiles();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTxtfiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtfiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtfiltroActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTxtDiarioTotal;
    private javax.swing.JTextField jTxtHora;
    private javax.swing.JTextField jTxtfiltro;
    private javax.swing.JRadioButton jrtDia;
    private javax.swing.JRadioButton jrthora;
    // End of variables declaration//GEN-END:variables
}
