/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class LinhTinh {
    String kho;
    String donVi;
    String thanhToan;

    public LinhTinh(String kho, String donVi, String thanhToan) {
        this.kho = kho;
        this.donVi = donVi;
        this.thanhToan = thanhToan;
    }
    
    
    
    public String getKho() {
        return kho;
    }

    public void setKho(String kho) {
        this.kho = kho;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public String getThanhToan() {
        return thanhToan;
    }

    public void setThanhToan(String thanhToan) {
        this.thanhToan = thanhToan;
    }
    
    
}
