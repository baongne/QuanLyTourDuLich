package BUS;

import DTO.TaiKhoan;
import KetnoiSQL_DAL.config;
import java.util.ArrayList;

public class TaiKhoanBUS {
    
    
    private ArrayList<TaiKhoan>danhSach = new ArrayList<TaiKhoan>();
    config con = new config();
    public TaiKhoanBUS() 
    {
        this.danhSach = con.layDL_TK(); //cach khai bao 1 arrayList
    }
    public TaiKhoan traKH(int i){
        return danhSach.get(i);
    }
    public TaiKhoan traKH(String maKH){
        for (int i = 0; i < danhSach.size(); i ++) {
            if (maKH.equalsIgnoreCase(danhSach.get(i).getMatk())) {
                return danhSach.get(i);
            }
        }
        return null;
    }
    
    /*public KhachHang(ArrayList<KhachHang> danhSach) {
    this.danhSach = danhSach;
    }*/
    
    public void themKhachHang(TaiKhoan kh)
    {
        this.danhSach.add(kh);    
    }
    
    
    
    public void themKhachHang(String matk, String matkhau, String email, String quyentruycap)
    {
        TaiKhoan kh = new TaiKhoan( matk,  matkhau,  email,  quyentruycap);
        this.danhSach.add(kh);    
        con.UpdateSQL_TaiKhoan(kh, 1, "null");
    }
    
    
    
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongKhachHang()
    {
        return this.danhSach.size();
    }
    
    
    
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
   
    public boolean xoaKhachHang(String ma)
    {        
   
        for (int i = 0; i < danhSach.size(); i ++) {
            if (ma.equalsIgnoreCase(danhSach.get(i).getMatk())) {
                this.danhSach.remove(i); 
                con.UpdateSQL_TaiKhoan(danhSach.get(i), 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    public boolean suaKhachHang(String maOld, String matk, String matkhau, String email, String quyentruycap)
    {        

        for (int i = 0; i < danhSach.size(); i ++) {
            if (maOld.equalsIgnoreCase(danhSach.get(i).getMatk())) {
                this.danhSach.get(i).setMatk(matk); 
                this.danhSach.get(i).setMatkhau(matkhau);
                this.danhSach.get(i).setEmail(email); 
                this.danhSach.get(i).setQuyentruycap(quyentruycap);
                
                con.UpdateSQL_TaiKhoan(this.danhSach.get(i), 3, maOld);
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    
    public ArrayList<TaiKhoan> timKhachHangUnlimit(String ma)
    {   
        int i =0;
        ArrayList<TaiKhoan> dskh = new ArrayList<>();
        for (TaiKhoan khachHang : danhSach) 
        {
            if(khachHang.getMatk().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getMatkhau().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getEmail().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getQuyentruycap().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
          
            i++;
        }
        if (dskh != null) {
            return dskh;
        }
        return null;
    }
}