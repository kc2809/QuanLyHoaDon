/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import my.database.MyDatabase;

/**
 *
 * @author Administrator
 */
public class StatictisFrame extends javax.swing.JInternalFrame {
    ArrayList<Bill> arrBill;
    MyDatabase database = MyDatabase.getInstance();
    
    detailFrame detail = null;
    
    public StatictisFrame() {
        initComponents();
        init();
    }
    
    private void init(){
        arrBill = new ArrayList<>();
        database.getDatabase();
        
       tbThongKe.addMouseListener(new MouseAdapter() {
             public void mousePressed(MouseEvent me) {
               JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                 if (me.getClickCount() == 2) {
                     showDetailRecord(row);
                     System.out.println("BAN DA CHOI 2 NHAY" +row );
            }
    }
});
    }
    
    private void showDetailRecord(int row){
        if(detail == null){
            detail = new detailFrame();
        }
        detail.setData(arrBill.get(row));
        detail.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbThongKe = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbChoiceSearch = new javax.swing.JComboBox<>();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfDoanhThu = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Thống Kê");
        setToolTipText("");

        tbThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Số Chứng Từ", "Ngày", "Mặt Hàng", "Tổng Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbThongKe);

        jLabel1.setText("Tìm Kiếm Bởi:");

        cbChoiceSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Số Chứng Từ", "Ngày/Tháng/Năm", "Tháng/Năm", "Năm" }));

        btnSearch.setText("Tìm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Doanh Thu:");

        tfDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tfDoanhThu.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbChoiceSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbChoiceSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
     private void resetTable(){
        DefaultTableModel model = (DefaultTableModel)tbThongKe.getModel();
       if (model.getRowCount() > 0) {
        for (int i = model.getRowCount() - 1; i > -1; i--) {
            model.removeRow(i);
        }
        arrBill.clear();
        }
    }
    
    private void addDataToTable(){
        if(arrBill.size()>0){
            long dt = 0;
            DefaultTableModel model =(DefaultTableModel)tbThongKe.getModel();
            
            for(int i=0;i<arrBill.size();++i){
               model.addRow(new Object[]{tbThongKe.getRowCount()+1,arrBill.get(i).getId(),arrBill.get(i).getDate(),
               arrBill.get(i).getDSTenHang(),String.format("%,d", arrBill.get(i).tongTien())});
               dt += arrBill.get(i).tongTien();
            }
           tfDoanhThu.setText(String.format("%,d", dt));
        }
        
    }
     
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
           System.out.println(cbChoiceSearch.getSelectedIndex());
        switch(cbChoiceSearch.getSelectedIndex()){
            //so chung tu
            case 0:
                searchByChungTu();
                break;
             //ngay thang nam
            case 1:
                searchByDMY();
                break;
             //thang nam
            case 2:
                searchByMY();
                break;
            //nam
            case 3:
                searchByY();
                break;
  
        }
        
    }//GEN-LAST:event_btnSearchActionPerformed
   
    
    
    
    private void searchByChungTu(){
       resetTable();
       try{
             int id = Integer.parseInt(tfSearch.getText());
             arrBill = database.getDataFromBillTblById(id);
             if(arrBill.size()>0){
             addDataToTable();
       }
       else{
           JOptionPane.showMessageDialog(null,"Không tìm thấy dữ liệu ");
       }
       }
       catch(NumberFormatException e){
           JOptionPane.showMessageDialog(null,"Không đúng định dạng số nguyên. \n Ví dụ: 23 ");
       }
               
     
   } 
   private void searchByDMY(){
       resetTable();
       String s = tfSearch.getText();
       
       Date d = null;
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       try{
           d = sdf.parse(s);    
       }
       catch(ParseException e){
           d= null;
           JOptionPane.showMessageDialog(null,"Ngày không đúng định dạng dd/MM/yyyy. \nVí dụ: 2/12/2016");
       }
       
       if(d!=null){
            String [] arr = s.split("/");
            int day = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int year= Integer.parseInt(arr[2]);
            arrBill = database.getDataFromBillTblBy(day, month, year);
             if(arrBill.size()>0){
                addDataToTable();
            }
            else{
                JOptionPane.showMessageDialog(null,"Không tìm thấy dữ liệu.");
            }
       }
      
       
   } 
   private void searchByMY(){
       resetTable();
       String s = "01/"+tfSearch.getText();
       
       Date d = null;
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       try{
           d = sdf.parse(s);    
       }
       catch(ParseException e){
           d= null;
           JOptionPane.showMessageDialog(null,"Ngày không đúng định dạng MM/yyyy. \nVí dụ: 12/2016");
       }
       
       if(d!=null){
            String [] arr = s.split("/");
            int day = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int year= Integer.parseInt(arr[2]);
            arrBill = database.getDataFromBillTblBy(0, month, year);
             if(arrBill.size()>0){
                addDataToTable();
            }
            else{
                JOptionPane.showMessageDialog(null,"Không tìm thấy dữ liệu ");
            }
       }
   } 
   private void searchByY(){
        resetTable();
       String s = "01/05/"+tfSearch.getText();
       
       Date d = null;
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
       try{
           d = sdf.parse(s);    
       }
       catch(ParseException e){
           d= null;
           JOptionPane.showMessageDialog(null,"Ngày không đúng định dạng yyyy. \nVí dụ: 2016");
       }
       
       if(d!=null){
            String [] arr = s.split("/");
            int day = Integer.parseInt(arr[0]);
            int month = Integer.parseInt(arr[1]);
            int year= Integer.parseInt(arr[2]);
            arrBill = database.getDataFromBillTblBy(0, 0, year);
             if(arrBill.size()>0){
                addDataToTable();
            }
            else{
                JOptionPane.showMessageDialog(null,"Không tìm thấy dữ liệu ");
            }
       }
   } 
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cbChoiceSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbThongKe;
    private javax.swing.JLabel tfDoanhThu;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
}
