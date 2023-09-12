/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Cong anh
 */
public class KhachHangDTo {
    private String makh;
    private String tenkh;
    private String diachi;
    private String sdt;
    private String email;
    
 

    public KhachHangDTo(KhachHangDTo x)
    {
        makh = x.makh;
        tenkh = x.tenkh;
        diachi = x.diachi;
        sdt = x.sdt;
    }

    public KhachHangDTo(String tenkh, String makh, String diachi, String sdt, String email) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
        
    }

    KhachHangDTo(String maKhachHang) {
            this.makh= maKhachHang;
    }

    

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String toString() {
        return "KhachHang{" + "makh=" + makh + ", tenkh=" + tenkh + ", diachi=" + diachi + ", sdt=" + sdt + ", email=" + email + '}';
    }

   
}
