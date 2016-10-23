/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.Company;
import model.LinhTinh;
import my.database.MyDatabase;
import quanlyhoadon.PDFProcess;
import sun.util.calendar.LocalGregorianCalendar;

/**
 *
 * @author Administrator
 */
public class RecordFrame extends javax.swing.JInternalFrame {

    MyDatabase database = MyDatabase.getInstance();
    PDFProcess pdf = PDFProcess.getInstance();
    
    ArrayList<String> arrMaHang;
    ArrayList<String> arrTenHang;
    ArrayList<Integer> arrSoLuong;
    ArrayList<Integer> arrDonGia;
    
    public RecordFrame() {
        initComponents();
        init();
        getCurrentData();
    }
    
    private void init(){
        arrMaHang = new ArrayList<>();
        arrTenHang = new ArrayList<>();
        arrSoLuong = new ArrayList<>();
        arrDonGia = new ArrayList<>();
        
        database.getDatabase();
    }
    
    public int getTongSL(){
       int tong = 0;
       for(int i=0;i<arrSoLuong.size();++i){
           tong+= arrSoLuong.get(i);
       }
       return tong;
              
    }
    
    public long getTonngTien(){
        long tong = 0;
        for(int i=0;i<arrSoLuong.size();++i){
            tong+= (long)(arrSoLuong.get(i) * arrDonGia.get(i));
        }
        return tong;
    }
    
    public void updateTong(){
        tfSl.setText(String.format("%,d", getTongSL()));
        tfTong.setText(String.format("%,d",getTonngTien()));
    }
    
    public boolean checkValidate(){
        String mess="";
        try{
            mess= "Số lượng không đúng định dạng số nguyên.";
            Integer.parseInt(tfSoLuong.getText());
            
            mess = " Dơn giá không đúng định dạng số nguyên";
            Integer.parseInt(tfDonGia.getText());
            
            return true;
        }
         catch(NumberFormatException e){
             
             JOptionPane.showMessageDialog(null, mess+"\n Thử lại...");
             return false;
         }
    }
    
    private void addDataToArray(){
        arrMaHang.add(tfMaHang.getText());
        arrTenHang.add(tfTenHang.getText());
        arrSoLuong.add(Integer.parseInt(tfSoLuong.getText()));
        arrDonGia.add(Integer.parseInt(tfDonGia.getText()));
        
        updateTong();
    }
    
    private void getCurrentData() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        tfNgay.setText(sdf.format(d));
        
        tfIdChungTu.setText((database.getRowCountBillTbl() +1)+"");
        tfKho.setText("CTY");
        tfDonVi.setText("Bán Lẻ");
        tfThanhToan.setText("Tiền Mặt");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfMaHang = new javax.swing.JTextField();
        tfTenHang = new javax.swing.JTextField();
        tfSoLuong = new javax.swing.JTextField();
        tfDonGia = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_hoadon = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNgay = new javax.swing.JTextField();
        tfKho = new javax.swing.JTextField();
        tfDonVi = new javax.swing.JTextField();
        tfThanhToan = new javax.swing.JTextField();
        btnInHoaDon = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tfIdChungTu = new javax.swing.JLabel();
        btnXoaTrang = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tfSl = new javax.swing.JLabel();
        tfTong = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Hóa Đơn");

        jLabel1.setText("Mã Hàng:");

        jLabel2.setText("Tên Hàng:");

        jLabel3.setText("Số Lượng:");

        jLabel4.setText("Đơn Giá:");

        btnDelete.setText("Xóa Hàng");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        table_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Hàng", "Tên Hàng", "Số Lượng", "Đơn Giá", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_hoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_hoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_hoadon);

        jLabel5.setText("Ngày:");

        jLabel6.setText(" Kho:");

        jLabel7.setText("Đơn Vị:");

        jLabel8.setText("Phương thức thanh toán:");

        btnInHoaDon.setText("In Hóa Đơn");
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        jLabel9.setText(" Số Chứng Từ:");

        btnXoaTrang.setText("Xóa Trắng");
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("                                                  Tổng:");

        tfSl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        tfTong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel5))
                                    .addGap(35, 35, 35))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(125, 125, 125)
                                    .addComponent(jLabel9)
                                    .addGap(31, 31, 31)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnXoaTrang)
                                .addGap(35, 35, 35)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfNgay)
                            .addComponent(tfKho)
                            .addComponent(tfDonVi)
                            .addComponent(tfThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(tfIdChungTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnInHoaDon)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tfSl, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(tfTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfMaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(tfIdChungTu, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNgay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnAdd)
                    .addComponent(btnXoaTrang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
       DefaultTableModel model = (DefaultTableModel)table_hoadon.getModel();
       if(table_hoadon.getSelectedRow() == -1){
             if(table_hoadon.getRowCount()==0){
              //   Message.setText("Table is empty");
             }
             else{
              //   Message.setText("You must selected a product");
             }
        }
       else{
           model.removeRow(table_hoadon.getSelectedRow());
           resetTextFiled();
       }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(checkValidate() == true){
             DefaultTableModel model =(DefaultTableModel)table_hoadon.getModel();
             int dongia = Integer.parseInt(tfDonGia.getText());
             long t =(long) Integer.parseInt(tfSoLuong.getText()) * dongia;
             
            if(tfMaHang.getText().trim().length()>0){
                addDataToArray();
               model.addRow(new Object[]{table_hoadon.getRowCount()+1,tfMaHang.getText(),tfTenHang.getText(),
               tfSoLuong.getText(),pdf.fmd(dongia),pdf.fmd(t)});
               resetTextFiled();
            }
        }
        
    }//GEN-LAST:event_btnAddActionPerformed
    private void resetTextFiled(){
        tfMaHang.setText("");
        tfTenHang.setText("");
        tfSoLuong.setText("");
        tfDonGia.setText("");
    }
    
    private void resetTable(){
        DefaultTableModel model = (DefaultTableModel)table_hoadon.getModel();
       if (model.getRowCount() > 0) {
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        }
       
       arrMaHang.clear();
       arrTenHang.clear();
       arrSoLuong.clear();
       arrDonGia.clear();
    }
    
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
     //   Message.setText("");
        DefaultTableModel model = (DefaultTableModel)table_hoadon.getModel();
         if(table_hoadon.getSelectedRow() == -1){
             if(table_hoadon.getRowCount()==0){
               //  Message.setText("Table is empty");
             }
             else{
              //   Message.setText("You must selected a product");
             }
         }
         else{
               int selected = table_hoadon.getSelectedRow();
               if(checkValidate()){
                int sl = Integer.parseInt(tfSoLuong.getText());
                int dongia = Integer.parseInt(tfDonGia.getText());
                long t =(long) Integer.parseInt(tfSoLuong.getText()) * dongia;
                
                model.setValueAt(tfMaHang.getText(),selected,1);
                model.setValueAt(tfTenHang.getText(),selected,2);
                model.setValueAt(pdf.fmd(sl),selected,3);
                model.setValueAt(pdf.fmd(dongia),selected,4);
                model.setValueAt(pdf.fmd(t),selected,5);
                
                
                arrMaHang.set(selected, tfMaHang.getText());
                arrTenHang.set(selected, tfTenHang.getText());
                arrSoLuong.set(selected,sl);
                arrDonGia.set(selected, Integer.parseInt(tfDonGia.getText()));
            }
              
         }
    
        
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void table_hoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_hoadonMouseClicked
        DefaultTableModel model = (DefaultTableModel)table_hoadon.getModel();
        
        String slString = model.getValueAt(table_hoadon.getSelectedRow(),3).toString().replace(",", "");
        String dgString = model.getValueAt(table_hoadon.getSelectedRow(),4).toString().replace(",", "");
        
        tfMaHang.setText(model.getValueAt(table_hoadon.getSelectedRow(),1).toString());
        tfTenHang.setText(model.getValueAt(table_hoadon.getSelectedRow(),2).toString());
        tfSoLuong.setText(slString);
         tfDonGia.setText(dgString);
    }//GEN-LAST:event_table_hoadonMouseClicked

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        // TODO add your handling code here:
    Bill b = new Bill( Long.parseLong(tfIdChungTu.getText()),tfNgay.getText(),arrMaHang,arrTenHang,arrSoLuong,arrDonGia);
    LinhTinh lt = new LinhTinh(tfKho.getText(),tfDonVi.getText(),tfThanhToan.getText());
     Company comp = database.getDataFromCompanyTable();
    //print pdf file
     if(PDFProcess.getInstance().printPDF("hoadon.pdf", comp, b, lt)){
         //save to database
         database.insertBillTable(b);
         //reset textfile
         resetTextFiled();
         resetTable();
         //update So chung tu
         tfIdChungTu.setText((database.getRowCountBillTbl() +1)+"");
     }
    
    }//GEN-LAST:event_btnInHoaDonActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangActionPerformed
        resetTextFiled();
    }//GEN-LAST:event_btnXoaTrangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoaTrang;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_hoadon;
    private javax.swing.JTextField tfDonGia;
    private javax.swing.JTextField tfDonVi;
    private javax.swing.JLabel tfIdChungTu;
    private javax.swing.JTextField tfKho;
    private javax.swing.JTextField tfMaHang;
    private javax.swing.JTextField tfNgay;
    private javax.swing.JLabel tfSl;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenHang;
    private javax.swing.JTextField tfThanhToan;
    private javax.swing.JLabel tfTong;
    // End of variables declaration//GEN-END:variables
}
