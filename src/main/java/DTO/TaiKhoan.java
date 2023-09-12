package DTO;

import KetnoiSQL_DAL.config;
import java.util.ArrayList;

public class TaiKhoan {
    private String matk;
    private String matkhau;
    private String email;
    private String quyentruycap;
 

    public TaiKhoan(String matk, String matkhau, String email, String quyentruycap) {
  
        this.matk = matk;
        this.matkhau = matkhau;
        this.email = email;
        this.quyentruycap = quyentruycap;
     
    }

    public TaiKhoan(String matk, String matkhau) {
        this.matk = matk;
        this.matkhau = matkhau;
    }
  

    public String getMatk() {
        return matk;

      
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getQuyentruycap() {
        return quyentruycap;
    }

    public void setQuyentruycap(String quyentruycap) {
        this.quyentruycap = quyentruycap;
    }
    
    
}