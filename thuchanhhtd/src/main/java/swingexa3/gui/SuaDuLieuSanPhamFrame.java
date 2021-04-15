/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingexa3.gui;

import swingexa.gui.*;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MyPC
 */
public class SuaDuLieuSanPhamFrame extends javax.swing.JInternalFrame {
    
    public int idproduct;

    /**
     * Creates new form SuaDuLieuSanPhamFrame
     */
    public SuaDuLieuSanPhamFrame() {
        initComponents();
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }
    
    public void load_product_data() throws SQLException{
        Product sp = new Product();
        Product kq = sp.get_product_by_id(this.idproduct);
        jtxtPname.setText(kq.getPname());
        jtxtPcategory.setText(kq.getPcategory());
        jtxtPprice.setText(String.valueOf(kq.getPprice()));
    }
    
    public void load_product_image_data(){
        Product sp = new Product();
        Product kq = sp.get_product_image_by_id(this.idproduct);
        jtxtPname.setText(kq.getPname());
        jtxtPcategory.setText(kq.getPcategory());
        jtxtPprice.setText(String.valueOf(kq.getPprice()));
        ImageIcon icon = new ImageIcon(kq.getImageOut());
        jlblImage.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtPname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtPcategory = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxtPprice = new javax.swing.JTextField();
        jbtnUpdate = new javax.swing.JButton();
        jbtnQuit = new javax.swing.JButton();
        jlblImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtxtImage = new javax.swing.JTextField();
        jbtnBrowse = new javax.swing.JButton();

        jLabel1.setText("Tên Sản Phẩm");

        jLabel2.setText("Tên Doanh Mục");

        jLabel3.setText("Giá");

        jbtnUpdate.setText("Cập nhập");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnQuit.setText("Thoát");
        jbtnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnQuitActionPerformed(evt);
            }
        });

        jLabel4.setText("Ảnh Sản Phẩm");

        jbtnBrowse.setText("Duyệt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnBrowse)
                            .addComponent(jbtnUpdate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnQuit)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jlblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtxtPname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtPcategory, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtPprice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtPcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jtxtPprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtxtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnBrowse))
                        .addGap(0, 38, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jlblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnUpdate)
                    .addComponent(jbtnQuit))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnQuitActionPerformed
        try {
            // TODO add your handling code here:
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SuaDuLieuSanPhamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnQuitActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        try {
            // TODO add your handling code here:
            Product sp = new Product(idproduct, jtxtPname.getText(),
                    jtxtPcategory.getText(),
                Integer.parseInt(jtxtPprice.getText()));
            sp.update_current_product();
            JOptionPane.showMessageDialog(null, "Đã cập nhật dữ liệu");
            this.setClosed(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(SuaDuLieuSanPhamFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnQuit;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JLabel jlblImage;
    private javax.swing.JTextField jtxtImage;
    private javax.swing.JTextField jtxtPcategory;
    private javax.swing.JTextField jtxtPname;
    private javax.swing.JTextField jtxtPprice;
    // End of variables declaration//GEN-END:variables
}
