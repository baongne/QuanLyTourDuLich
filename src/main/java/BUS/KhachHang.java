package BUS;


import DTO.KhachHangDTo;
import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHang {
    
    
    private ArrayList<KhachHangDTo>danhSach = new ArrayList<KhachHangDTo>();
    config con = new config();
    public KhachHang() 
    {
        this.danhSach = con.layDL_KhachHang(); //cach khai bao 1 arrayList
    }
    public KhachHangDTo traKH(int i){
        return danhSach.get(i);
    }
    public KhachHangDTo traKH(String maKH){
        for (KhachHangDTo khachHang : danhSach) {
            if (maKH.equalsIgnoreCase(khachHang.getMakh())) {
                return khachHang;
            }
        }
        return null;
    }
    
    /*public KhachHang(ArrayList<KhachHang> danhSach) {
    this.danhSach = danhSach;
    }*/
    
    public void themKhachHang(KhachHangDTo kh)
    {
        this.danhSach.add(kh);    
    }
    
    
    
    public void themKhachHang(String tenkh, String makh, String diachi, String sdt, String email)
    {
        KhachHangDTo kh = new KhachHangDTo(tenkh, makh, diachi, sdt, email);
        this.danhSach.add(kh);    
        con.UpdateSQL_KhachHang(kh, 1, "null");
    }
    
    
    
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongKhachHang()
    {
        return this.danhSach.size();
    }
    public String maKH()
    {
        String s = "KH00" + Integer.toString(laySoLuongKhachHang() + 1 );
        return s;
    }
    
    
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean  xoaKhachHang(KhachHang kh)
    {
        return this.danhSach.remove(kh);
    }
    public boolean xoaKhachHang(String ma)
    {        
        int i = 0;
        for (KhachHangDTo khachHang : danhSach) {
            if (ma.equalsIgnoreCase(khachHang.getMakh())) {
                this.danhSach.remove(i); 
                con.UpdateSQL_KhachHang(khachHang, 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    public boolean suaKhachHang(String maOld, String tenkh, String makh, String diachi, String sdt, String email)
    {        
        int i = 0;
        for (KhachHangDTo khachHang : danhSach) {
            if (maOld.equalsIgnoreCase(khachHang.getMakh())) {
                this.danhSach.get(i).setTenkh(tenkh); 
                this.danhSach.get(i).setMakh(makh);
                this.danhSach.get(i).setDiachi(diachi); 
                this.danhSach.get(i).setSdt(sdt);
                this.danhSach.get(i).setEmail(email);
                
                con.UpdateSQL_KhachHang(this.danhSach.get(i), 3, maOld);
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    public void timKhachHang(String ma)
    {
        for (KhachHangDTo khachHang : danhSach) 
        {
            if(khachHang.getMakh().contains(ma));
            System.out.println(khachHang);
        }
    }
    public ArrayList<KhachHangDTo> timKhachHangUnlimit(String ma)
    {   
        int i =0;
        ArrayList<KhachHangDTo> dskh = new ArrayList<>();
        for (KhachHangDTo khachHang : danhSach) 
        {
            if(khachHang.getMakh().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getTenkh().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getSdt().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getDiachi().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getEmail().equalsIgnoreCase(ma))
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
