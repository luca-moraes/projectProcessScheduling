/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.Controller;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author eu
 */
public class Input extends javax.swing.JFrame {

    /**
     * Creates new form Input
     */
    public Input() {
        initComponents();
        control = new Controller(this);
        
        this.getContentPane().setBackground(new java.awt.Color(102,102,0));

        
        this.jTextPanelSaida.setEditable(false);
        this.rrjTextArea.setEditable(false);
        this.sjfjTextArea.setEditable(false);
        this.fifojTextArea.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabelPath = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPanelSaida = new javax.swing.JTextPane();
        jButtonArchives = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        quantumField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        timeField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        rrjTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fifojTextArea = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sjfjTextArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 0));
        setMaximumSize(new java.awt.Dimension(620, 800));
        setMinimumSize(new java.awt.Dimension(620, 800));
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(102, 0, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setForeground(new java.awt.Color(204, 204, 0));
        jLabel3.setText("Preencha as informações abaixo");

        jLabelPath.setForeground(new java.awt.Color(204, 204, 0));
        jLabelPath.setText("Arquivo Selecionado:");

        jTextPanelSaida.setBackground(new java.awt.Color(0, 0, 0));
        jTextPanelSaida.setForeground(new java.awt.Color(0, 204, 51));
        jTextPanelSaida.setText("Aguardando arquivo...");
        jTextPanelSaida.setMaximumSize(new java.awt.Dimension(10, 8));
        jTextPanelSaida.setMinimumSize(new java.awt.Dimension(10, 8));
        jTextPanelSaida.setPreferredSize(new java.awt.Dimension(10, 8));
        jScrollPane1.setViewportView(jTextPanelSaida);

        jButtonArchives.setBackground(new java.awt.Color(153, 153, 0));
        jButtonArchives.setForeground(new java.awt.Color(153, 102, 0));
        jButtonArchives.setText("Selecione um arquivo de entrada");
        jButtonArchives.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArchivesActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(204, 204, 0));
        jLabel1.setText("Quantum:");

        quantumField.setBackground(new java.awt.Color(0, 0, 0));
        quantumField.setForeground(new java.awt.Color(0, 204, 51));
        quantumField.setText("Digite um valor");
        quantumField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantumFieldMouseClicked(evt);
            }
        });
        quantumField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantumFieldActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 153, 0));
        jButton1.setForeground(new java.awt.Color(153, 102, 0));
        jButton1.setText("Executar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("Intervalo de tempo (segundos):");

        timeField.setBackground(new java.awt.Color(0, 0, 0));
        timeField.setForeground(new java.awt.Color(0, 204, 51));
        timeField.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonArchives, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel3)
                            .addComponent(jLabelPath)
                            .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quantumField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonArchives, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quantumField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setForeground(new java.awt.Color(204, 204, 0));
        jLabel4.setText("Round Robin");

        rrjTextArea.setBackground(new java.awt.Color(0, 0, 0));
        rrjTextArea.setColumns(20);
        rrjTextArea.setForeground(new java.awt.Color(0, 204, 51));
        rrjTextArea.setLineWrap(true);
        rrjTextArea.setRows(5);
        rrjTextArea.setText("Aguardando execução...");
        rrjTextArea.setAutoscrolls(false);
        rrjTextArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane4.setViewportView(rrjTextArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 51, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setForeground(new java.awt.Color(204, 204, 0));
        jLabel2.setText("FIFO");

        fifojTextArea.setBackground(new java.awt.Color(0, 0, 0));
        fifojTextArea.setColumns(20);
        fifojTextArea.setForeground(new java.awt.Color(0, 204, 51));
        fifojTextArea.setRows(5);
        fifojTextArea.setText("Aguardando execução...");
        jScrollPane2.setViewportView(fifojTextArea);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(0, 51, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setForeground(new java.awt.Color(204, 204, 0));
        jLabel5.setText("SJF");

        sjfjTextArea.setBackground(new java.awt.Color(0, 0, 0));
        sjfjTextArea.setColumns(20);
        sjfjTextArea.setForeground(new java.awt.Color(0, 204, 51));
        sjfjTextArea.setRows(5);
        sjfjTextArea.setText("Aguardando execução...");
        jScrollPane3.setViewportView(sjfjTextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 102));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/rr.jpeg"))); // NOI18N
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/sjf.jpeg"))); // NOI18N
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/fifo.jpeg"))); // NOI18N
        jLabel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Z003", 3, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 153, 0));
        jLabel10.setText("GUI made by Lucas Moraes - a.k.a. Conde dos Códigos");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            control.execute(Integer.parseInt(quantumField.getText().toString()), Integer.parseInt(timeField.getText().toString()));
        }catch(Exception e){
             JOptionPane.showMessageDialog(this, "Formato de número inválido, erro: \n  "
                     + e, "Erro de formatação", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonArchivesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArchivesActionPerformed
        // TODO add your handling code here:
        control.mostarFiles();
    }//GEN-LAST:event_jButtonArchivesActionPerformed

    private void quantumFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantumFieldMouseClicked
        // TODO add your handling code here:
        if(!clicked){
            quantumField.setText("");
            clicked = true;
        }
    }//GEN-LAST:event_quantumFieldMouseClicked

    private void quantumFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantumFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantumFieldActionPerformed
    
    public int getQuantumField() {
        return Integer.parseInt(quantumField.getText().toString());
    }

    public void setjTextPanelSaida(String text) {
        this.jTextPanelSaida.setText(text);
        this.jTextPanelSaida.setSize(250, 80);
    }

    public JLabel getjLabelPath() {
        return jLabelPath;
    }

    public void setjLabelPath(String text) {
        this.jLabelPath.setText(text);
    }

    public void setQuantumField(String text) {
        this.quantumField.setText(text);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input().setVisible(true);
            }
        });
    }

    public JTextArea getFifojTextArea() {
        return fifojTextArea;
    }

    public void setFifojTextArea(JTextArea fifojTextArea) {
        this.fifojTextArea = fifojTextArea;
    }

    public JTextArea getRrjTextArea() {
        return rrjTextArea;
    }

    public void setRrjTextArea(JTextArea rrjTextArea) {
        this.rrjTextArea = rrjTextArea;
    }

    public JTextArea getSjfjTextArea() {
        return sjfjTextArea;
    }

    public void setSjfjTextArea(JTextArea sjfjTextArea) {
        this.sjfjTextArea = sjfjTextArea;
    }
    
    public void fifoTextAreaAppend(String text){
        this.fifojTextArea.append(text);
        this.fifojTextArea.setCaretPosition(this.fifojTextArea.getDocument().getLength());
    }
    
    public void sjfTextAreaAppend(String text){
        this.sjfjTextArea.append(text);
        this.sjfjTextArea.setCaretPosition(this.sjfjTextArea.getDocument().getLength());
    }
    
    public void rrTextAreaAppend(String text){
        this.rrjTextArea.append(text);
        this.rrjTextArea.setCaretPosition(this.rrjTextArea.getDocument().getLength());
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void disablejButton1() {
        this.jButton1.setEnabled(false);
    }
    
    public void enablejButton1() {
        this.jButton1.setEnabled(true);
    }

    public JTextPane getjTextPanelSaida() {
        return jTextPanelSaida;
    }

    public void setSizejFrameWindow() {
        this.setSize(620, 800);
    }
    
    public void cleanTextAreas(){
        this.fifojTextArea.setText("");
        this.sjfjTextArea.setText("");
        this.rrjTextArea.setText("");
    }

    private Controller control;
    private boolean clicked = false;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea fifojTextArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonArchives;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPath;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPanelSaida;
    public javax.swing.JTextField quantumField;
    private javax.swing.JTextArea rrjTextArea;
    private javax.swing.JTextArea sjfjTextArea;
    private javax.swing.JTextField timeField;
    // End of variables declaration//GEN-END:variables
}
