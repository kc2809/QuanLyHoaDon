/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlyhoadon;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Bill;
import model.Company;
import model.LinhTinh;

/**
 *
 * @author Administrator
 */
public class PDFProcess {
    private static PDFProcess instance = null;
    private PDFProcess(){}
    
    public static PDFProcess getInstance(){
        if(instance == null){
            instance = new PDFProcess();
        }
        return instance;
    }
    
    public static String fmt(float d)
    {
        if(d == (long) d)
            return String.format("%d",(long)d);
        else
            return String.format("%s",d);
    }
    
    public static String fmd(Long l){
        return String.format("%,d", l);
    }
    public static String fmd(int l){
        return String.format("%,d", l);
    }
    
    public boolean printPDF(String dest,Company company,Bill bill,LinhTinh lt) {
        try{
        BaseFont urName = BaseFont.createFont("font/Time_New_Roman.TTF",BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
        Font nameFont = new Font(urName, 16,Font.BOLD);
        Font addFont = new Font(urName,12);
         Font boldFont = new Font(urName,14,Font.BOLD);
         Font contentFont = new Font(urName,14);
          Font footFont = new Font(urName,16);
            
         Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{2,6,3});
        
        //logo
         Image img = Image.getInstance("logo.jpg");
         img.scaleAbsolute(100, 100);
         PdfPCell cell = new PdfPCell(img);
         cell.setBorder(PdfPCell.NO_BORDER);
         
         //middle content
         String name = company.getName();
         String address = "\n\nĐC: "+ company.getAddress();
         String phone = "\n\nĐT: "+company.getPhone();
         String hed = "\n\n     PHIẾU BÁO GIÁ";
               
        Phrase mid = new Phrase();
        mid.add(new Chunk(name,nameFont));
        mid.add(new Chunk(address+phone,addFont));
        mid.add(new Chunk(hed,nameFont));
        
        PdfPCell midCell = new PdfPCell(mid);
  //      midCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        midCell.setPaddingTop(15);
        midCell.setPaddingLeft(40);
        midCell.setPaddingRight(15);
        midCell.setPaddingBottom(15);
        midCell.setBorder(PdfPCell.NO_BORDER);
        
        // right content
        String soCt = "Số CT: "+ bill.getId();
        String date = "\n\nNgày: "+ bill.getDate()+ "\n\nKho : "+ lt.getKho();
        
        Phrase right = new Phrase();
        right.add(new Chunk(soCt+date,addFont));
        PdfPCell rightCell = new PdfPCell(right);
        rightCell.setPadding(15);
        rightCell.setBorder(PdfPCell.NO_BORDER);
        
        table.addCell(cell);
        table.addCell(midCell);
        table.addCell(rightCell);
        
        document.add(table);
        
       
        Phrase p1 = new Phrase();
        p1.add(new Chunk("Đơn vị: ",addFont));
        p1.add(new Chunk(lt.getDonVi(),boldFont));
        p1.add(new Chunk("\nĐịa Chỉ: \n",addFont));
        
        Paragraph pagra = new Paragraph(p1);
        pagra.setIndentationLeft(15);
        pagra.setSpacingBefore(10);
         pagra.setSpacingAfter(10);
         document.add(pagra);
         
         //table lít
         PdfPTable tablList = new PdfPTable(6);
         
         tablList.setWidthPercentage(100);
         tablList.setWidths(new float[]{1,5,7,2,3,4});
         
         String title[] = {"STT","Mã Hàng","Tên Hàng","SL","Đơn Giá","Thành Tiền"};
         for(int i =0;i<title.length;++i){
             Phrase phr = new Phrase();
             phr.add(new Chunk(title[i],boldFont));
             PdfPCell p = new PdfPCell(phr);
             p.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
             tablList.addCell(p);
         }
         //--- add content
         for(int i=0;i<bill.getCount();++i){
              Phrase[] phrase = new Phrase[6];
             PdfPCell [] pCell = new PdfPCell[6];
             
             for(int k=0;k<6;++k) {
                 phrase[k] = new Phrase();
             }
             phrase[0].add(new Chunk((i+1)+"",contentFont));
             phrase[1].add(new Chunk(bill.getMaHangAt(i),contentFont));
              phrase[2].add(new Chunk(bill.getTenHangAt(i),contentFont));
               phrase[3].add(new Chunk(bill.getSoLuongAt(i)+"",contentFont));
                phrase[4].add(new Chunk(bill.getDonGiaAt(i)+"",contentFont));
                  phrase[5].add(new Chunk(bill.getThanhTienAt(i)+"",contentFont));
             
             for(int j=0;j<6;++j){
                  pCell[j]= new PdfPCell(phrase[j]);
                 pCell[j].setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
               
                 tablList.addCell(pCell[j]);
             }
         }
         
         PdfPCell cell1 = new PdfPCell(new Phrase(new Chunk("Tổng",boldFont)));
         cell1.setColspan(3);
         cell1.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
         tablList.addCell(cell1);
         
         //
          PdfPCell cell2 = new PdfPCell(new Phrase(new Chunk(""+ bill.getTong(),boldFont)));
            cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
         tablList.addCell(cell2);
         
         //
         PdfPCell cell3 = new PdfPCell(new Phrase(new Chunk("",boldFont)));
           cell3.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
         tablList.addCell(cell3);
         
         //
          PdfPCell cell4 = new PdfPCell(new Phrase(new Chunk(String.format("%,d",bill.tongTien()),boldFont)));
            cell4.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
         tablList.addCell(cell4);
         
         
         document.add(tablList);
         //-------------------in phuong thuc thanh toan
          Phrase p2 = new Phrase();
        p2.add(new Chunk("Phương thức thanh toán: ",contentFont));
        p2.add(new Chunk(lt.getThanhToan(),boldFont));
        p2.add(new Chunk("\nLưu ý mua hàng miễn trả lại. Vui lòng giữ phiếu trong 7 ngày: ",contentFont));
        
        Paragraph pagra2 = new Paragraph(p2);
        pagra2.setSpacingBefore(5);
        pagra2.setSpacingAfter(5);
        document.add(pagra2);
         
        //---- footer content
        PdfPTable tblFoot = new PdfPTable(3);
         
         tblFoot.setWidthPercentage(100);
         tblFoot.setWidths(new float[]{1,1,1});

        PdfPCell leftFootCell = new PdfPCell(new Phrase(new Chunk("NGƯỜI LẬP ",footFont)));
        PdfPCell midFootCell = new PdfPCell(new Phrase(new Chunk("KẾ TOÁN ",footFont)));
        PdfPCell rightFootCell = new PdfPCell(new Phrase(new Chunk("THỦ TRƯỞNG ĐƠN VỊ ",footFont)));
        
        
        leftFootCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        leftFootCell.setBorder(PdfPCell.NO_BORDER);
        midFootCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        midFootCell.setBorder(PdfPCell.NO_BORDER);
        rightFootCell.setBorder(PdfPCell.NO_BORDER);
        rightFootCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        
        
        tblFoot.addCell(leftFootCell);
         tblFoot.addCell(midFootCell);
          tblFoot.addCell(rightFootCell);
          
          document.add(tblFoot);
          
         //
        document.close();
        JOptionPane.showMessageDialog(null, "In hoadon.pdf thành công");
        return true;
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "hoadon.pdf đang được mở\nVui lòng đóng lại. Sau đó thử lại");
           e.printStackTrace();
           return false;
       }
    }
}
