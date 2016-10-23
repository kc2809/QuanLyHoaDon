/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import model.Bill;
import model.Company;
import my.database.MyDatabase;

/**
 *
 * @author Administrator
 */
public class MainFrame extends javax.swing.JFrame {

    CompanyFrame companyFrame = null;
    RecordFrame recordFrame = null;
    StatictisFrame statisFrame =null;
    
    public MainFrame() {
        initComponents();
        MyDatabase database = MyDatabase.getInstance();
        database.getDatabase();
        database.getDataFromCompanyTable();
        
     //   Bill b  = new Bill("2006-12-5","23/23","Kem Xoi/Bun Cha ca","2/5","5.0/6");
     //   database.insertBillTable(b);
     System.out.println("COunt = " + database.getRowCountBillTbl());
        showInfoCompany();
    }
    
    private void showInfoCompany(){
        if(companyFrame == null){
            companyFrame = new CompanyFrame();
            desktop.add(companyFrame);
        }
        show(0);
     }
    private void showRecordFrame(){
        if(recordFrame ==null){
            recordFrame = new RecordFrame();
            desktop.add(recordFrame);
        }
        show(1);
    }
    
    private void showStatictisFrame(){
        if(statisFrame == null){
            statisFrame = new StatictisFrame();
            desktop.add(statisFrame);
        }
        show(2);
    }
    
    private void show(int pos){
        //---- 0 : company frame 
        //-----1 : record frame
        //-----2 : statics frame
        
        if(companyFrame !=null){
               companyFrame.setVisible(false);
        }
         if(recordFrame !=null){
            recordFrame.setVisible(false);
        }
        if(statisFrame !=null){
            statisFrame.setVisible(false);
        }
        
        switch(pos){
            case 0:
                 if(companyFrame !=null){
                     companyFrame.setVisible(true);
                 }
                 break;
            case 1:
                 if(recordFrame !=null){
                       recordFrame.setVisible(true);
                   }
                 break;
            case 2:
                   if(statisFrame !=null){
                        statisFrame.setVisible(true);
                      }
                   break;
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

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuCongTy = new javax.swing.JMenuItem();
        menuInHoaDon = new javax.swing.JMenuItem();
        menuThongKe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menu");

        menuCongTy.setText("Công Ty");
        menuCongTy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCongTyActionPerformed(evt);
            }
        });
        jMenu2.add(menuCongTy);

        menuInHoaDon.setText("In Hóa Đơn");
        menuInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInHoaDonActionPerformed(evt);
            }
        });
        jMenu2.add(menuInHoaDon);

        menuThongKe.setText("Thống Kê");
        menuThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThongKeActionPerformed(evt);
            }
        });
        jMenu2.add(menuThongKe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuCongTyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCongTyActionPerformed
        // TODO add your handling code here:
           showInfoCompany();
    }//GEN-LAST:event_menuCongTyActionPerformed

    private void menuInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInHoaDonActionPerformed
        // TODO add your handling code here:
        showRecordFrame();
    }//GEN-LAST:event_menuInHoaDonActionPerformed

    private void menuThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThongKeActionPerformed
        // TODO add your handling code here:
        showStatictisFrame();
    }//GEN-LAST:event_menuThongKeActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuCongTy;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuInHoaDon;
    private javax.swing.JMenuItem menuThongKe;
    // End of variables declaration//GEN-END:variables

   
}