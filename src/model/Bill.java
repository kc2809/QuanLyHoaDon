/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class Bill {
    Long id;
    String date;
    ArrayList<String> arrMaHang;
    ArrayList<String> arrTenHang;
    ArrayList<Integer>  arrSoLuong;
   ArrayList<Integer> arrDonGia;
   
    
    
   public int getTong(){
       int tong = 0;
       for(int i =0;i<arrSoLuong.size();++i){
           tong+= arrSoLuong.get(i);
       }
       return tong;
   }
   
   public String getThanhTienAt(int i){
       return String.format("%,d",(int)(arrSoLuong.get(i)*arrDonGia.get(i)));
   }
   
   public String getMaHangAt(int pos){
       return arrMaHang.get(pos);
   }
   public String getTenHangAt(int pos){
       return arrTenHang.get(pos);
   }
   public int getSoLuongAt(int pos){
       return arrSoLuong.get(pos);
   }
   public String getDonGiaAt(int pos){
       return String.format("%,d",(arrDonGia.get(pos)));
   }
   
   public int getCount(){
       return arrMaHang.size();
   }
   
   public String getDSMaHang(){
       String s ="";
       for(int i=0;i<arrMaHang.size();++i){
           s+=arrMaHang.get(i)+"/";
       }
       return s;
   }
   public String getDSTenHang(){
       String s ="";
       for(int i=0;i<arrTenHang.size();++i){
           s+=arrTenHang.get(i)+"/";
       }
       return s;
   }
   
   public String getDSSoLuong(){
       String s ="";
       for(int i=0;i<arrSoLuong.size();++i){
           s+=arrSoLuong.get(i)+"/";
       }
       return s;
   }
     public String getDSDonGia(){
       String s ="";
       for(int i=0;i<arrDonGia.size();++i){
           s+=arrDonGia.get(i)+"/";
       }
       return s;
   }
   
   
    public Bill(String date, ArrayList<String> arrMaHang, ArrayList<String> arrTenHang,ArrayList<Integer>  arrSoLuong, ArrayList<Integer>  arrDonGia) {
        this.date = date;
        this.arrMaHang = arrMaHang;
        this.arrTenHang = arrTenHang;
        this.arrSoLuong = arrSoLuong;
        this.arrDonGia = arrDonGia;
    }

    public Bill(Long id, String date, ArrayList<String> arrMaHang, ArrayList<String> arrTenHang, ArrayList<Integer>  arrSoLuong, ArrayList<Integer>  arrDonGia) {
        this.id = id;
        this.date = date;
        this.arrMaHang = arrMaHang;
        this.arrTenHang = arrTenHang;
        this.arrSoLuong = arrSoLuong;
        this.arrDonGia = arrDonGia;
    }
   
    public Bill(String date,String dsMaHang,String dsTenhang,String dsSoLuong,String dsDonGia){
        this.date = date;
        setDSMaHang(dsMaHang);
        setDSTenHang(dsTenhang);
        setDSSoLuong(dsSoLuong);
        setDSDonGia(dsDonGia);
    }
     public Bill(Long id,String date,String dsMaHang,String dsTenhang,String dsSoLuong,String dsDonGia){
       this.id =id; 
        this.date = date;
        setDSMaHang(dsMaHang);
        setDSTenHang(dsTenhang);
        setDSSoLuong(dsSoLuong);
        setDSDonGia(dsDonGia);
    }
    
   public void setDSMaHang(String s){
       arrMaHang = new ArrayList<>();
       String [] arr = s.split("/");
       if(arr.length!=0){
           for(int i=0;i<arr.length;++i){
               arrMaHang.add(arr[i]);
           }
       }
   }
   
    public void setDSTenHang(String s){
         arrTenHang = new ArrayList<>();
       String [] arr = s.split("/");
       if(arr.length!=0){
           for(int i=0;i<arr.length;++i){
               arrTenHang.add(arr[i]);
           }
       }
   }
    
     public void setDSSoLuong(String s){
       String [] arr = s.split("/");
       if(arr.length!=0){
           arrSoLuong = new ArrayList<>();
           for(int i=0;i<arr.length;++i){
               arrSoLuong.add(Integer.parseInt(arr[i]));
           }
       }
   }
    public void setDSDonGia(String s){
       String [] arr = s.split("/");
       if(arr.length!=0){
           arrDonGia = new ArrayList<>();
           for(int i=0;i<arr.length;++i){
               arrDonGia.add(Integer.parseInt(arr[i]));
           }
       }
   }
    
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<String> getArrMaHang() {
        return arrMaHang;
    }

    public void setArrMaHang(ArrayList<String> arrMaHang) {
        this.arrMaHang = arrMaHang;
    }

    public ArrayList<String> getArrTenHang() {
        return arrTenHang;
    }

    public void setArrTenHang(ArrayList<String> arrTenHang) {
        this.arrTenHang = arrTenHang;
    }

    public ArrayList<Integer> getArrSoLuong() {
        return arrSoLuong;
    }

    public void setArrSoLuong(ArrayList<Integer> arrSoLuong) {
        this.arrSoLuong = arrSoLuong;
    }

    public ArrayList<Integer> getArrDonGia() {
        return arrDonGia;
    }

    public void setArrDonGia(ArrayList<Integer> arrDonGia) {
        this.arrDonGia = arrDonGia;
    }
   
    public long tongTien(){
        long result=0;
        
        for(int i=0;i<arrSoLuong.size();++i){
            result +=(long) (arrSoLuong.get(i) * arrDonGia.get(i));
        }
        return result;
    }
    
    public String getDateInSql(){
        String[] arr = date.split("/");
        String result = arr[2]+ "-"+ arr[1]+"-"+ arr[0];
        return result;
    }
}
