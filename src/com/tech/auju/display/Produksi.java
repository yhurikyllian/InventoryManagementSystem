/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tech.auju.display;

import com.tech.auju.implementation.ProduksiImpl;
import com.tech.auju.objects.Bahan;
import javax.swing.JOptionPane;

/**
 *
 * @author sora
 */
public class Produksi extends javax.swing.JFrame {
    
    private ProduksiImpl pi;
    private Bahan bahan;

    /**
     * Creates new form Produksi
     */
    public Produksi() {
        initComponents();
        txtSearch.setText("");
        txtAmount.setText("");
        initTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBaru = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetail = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        txtAmount = new javax.swing.JTextField();
        btnTransaction = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnLogOut = new javax.swing.JMenuItem();
        mnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnAbout = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pembelian v.2.0");

        tblBaru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama Bahan", "Jumlah", "Harga", "Supplier"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBaru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBaruMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBaru);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail"));

        txtDetail.setEditable(false);
        txtDetail.setColumns(20);
        txtDetail.setRows(5);
        jScrollPane2.setViewportView(txtDetail);

        jLabel2.setText("Jumlah bahan yang diminta :");

        txtAmount.setText("jTextField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnTransaction.setText("Make Transaction");
        btnTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransactionActionPerformed(evt);
            }
        });

        txtSearch.setText("jTextField2");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        mnLogOut.setText("Log out");
        mnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(mnLogOut);

        mnExit.setText("Exit");
        mnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        mnAbout.setText("About");
        mnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAboutActionPerformed(evt);
            }
        });
        jMenu2.add(mnAbout);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnTransaction))
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransaction)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblBaruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBaruMouseClicked
        // TODO add your handling code here:
        showInfo();
    }//GEN-LAST:event_tblBaruMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransactionActionPerformed
        // TODO add your handling code here:
        int x = 0;
        if(!txtAmount.getText().equals(""))
            x = Integer.parseInt(txtAmount.getText());
        
        if((tblBaru.getSelectedColumn() != -1) && (x > 1)){
            if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Are you sure to make a transaction?", "Attention", JOptionPane.YES_NO_OPTION)) {
                int amount = Integer.parseInt(txtAmount.getText());                 
                pi.submitData(tblBaru.getSelectedRow(), amount);
                txtSearch.setText("");
                initTable();
            }  
        }              
    }//GEN-LAST:event_btnTransactionActionPerformed

    private void mnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLogOutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Login(this, true).setVisible(true);
    }//GEN-LAST:event_mnLogOutActionPerformed

    private void mnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mnExitActionPerformed

    private void mnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAboutActionPerformed
        // TODO add your handling code here:
        new About(this, true, "Produksi").setVisible(true);
    }//GEN-LAST:event_mnAboutActionPerformed

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
            java.util.logging.Logger.getLogger(Produksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTransaction;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem mnAbout;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenuItem mnLogOut;
    private javax.swing.JTable tblBaru;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextArea txtDetail;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    /**
     * Fill table with bahan's information from bahan table.
     */
    private void initTable() {
        pi = new ProduksiImpl();
        tblBaru.setModel(pi.getTableModel());
        pi.fillTable(tblBaru);
    }
    
    /**
     * Search bahan by text from txtSearch.
     */
    private void search() {
        pi.searchBahan(txtSearch.getText());
        tblBaru.setModel(pi.getTableModel());
        pi.updateTable(tblBaru);
    }
    
    /**
     * Fill txtDetail with information of Bahan.
     */
    private void showInfo() {
        bahan = pi.getSelectedBahan(tblBaru.getSelectedRow());
        String text = "Nama bahan : " + bahan.getNama_bahan() + "\nJumlah : " +
                bahan.getJumlah_bahan() + "\nHarga satuan : " +
                bahan.getHarga_satuan() + "\nMerk : " +
                bahan.getMerk().getNama_merk() + "\nWarna : " +
                bahan.getWarna().getNama_warna() + "\nJenis : " +
                bahan.getJenis().getNama_jenis();
        
        txtDetail.setText(text);
    }
}
