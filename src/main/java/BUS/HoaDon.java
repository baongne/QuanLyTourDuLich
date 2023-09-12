package BUS;

import DTO.HoaDonDTO;
import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HoaDon {
    
    private ArrayList<HoaDonDTO>danhSach = new ArrayList<>();
    config con = new config();
    
    public HoaDon()
    {
        this.danhSach = con.layDL_HoaDon(); //cach khai bao 1 arrayList
    }
    public HoaDonDTO traHD(int i){
        return danhSach.get(i);
    }
    public HoaDonDTO traHD(String maHD){
        for (HoaDonDTO hoaDon : danhSach) {
            if (maHD.equalsIgnoreCase(hoaDon.getMahd())) {
                return hoaDon;
            }
        }
        return null;
    }
    
    /*public KhachHang(ArrayList<KhachHang> danhSach) {
    this.danhSach = danhSach;
    }*/
    
    public void themHoaDon(HoaDonDTO kh)
    {
        this.danhSach.add(kh);    
    }
    
    
    
    public void themHoaDon(String mahd, String manv, String makhachdatve, long tongtien, Date ngayxuathoadon)
    {
        HoaDonDTO kh = new HoaDonDTO( mahd,  manv,  makhachdatve,  tongtien,  ngayxuathoadon);
        this.danhSach.add(kh);    
        con.UpdateSQL_HoaDon(kh, 1, "null");
    }
    
    
    
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongHoaDon()
    {
        return this.danhSach.size();
    }
    
    public String maHD()
    {
        String s = "HD00" + Integer.toString(laySoLuongHoaDon()+ 1 );
        return s;
    }
    
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean  xoaHoaDon(HoaDon kh)
    {
        return this.danhSach.remove(kh);
    }
    
    public boolean xoaHoaDon(String ma)
    {        
        int i = 0;
        for (HoaDonDTO hoaDon : danhSach) {
            if (ma.equalsIgnoreCase(hoaDon.getMahd())) {
                this.danhSach.remove(i); 
                con.UpdateSQL_HoaDon(hoaDon, 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    public boolean suaHoaDon(String maOld, String mahd, String manv, String makhachdatve, long tongtien, Date ngayxuathoadon)
    {        
        int i = 0;
        for (HoaDonDTO hd : danhSach) {
            if (maOld.equalsIgnoreCase(hd.getMahd())) {
                this.danhSach.get(i).setMahd(mahd); 
                this.danhSach.get(i).setManv(manv);
                this.danhSach.get(i).setMakhachdatve(makhachdatve); 
                this.danhSach.get(i).setTongtien(tongtien);
                this.danhSach.get(i).setNgayxuathoadon(ngayxuathoadon);
                
                con.UpdateSQL_HoaDon(this.danhSach.get(i), 3, maOld);
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    public void timHoaDon(String ma)
    {
        for (HoaDonDTO hd : danhSach) 
        {
            if(hd.getMahd().contains(ma));
            System.out.println(hd);
        }
    }
    
    public ArrayList<HoaDonDTO> timHoaDonUnlimit(String ma)
    {   
        int i =0;
        ArrayList<HoaDonDTO> dskh = new ArrayList<>();
        for (HoaDonDTO khachHang : danhSach) 
        {
            if(khachHang.getMahd().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getManv().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getMakhachdatve().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            String ttien = Long.toString(khachHang.getTongtien());
            if(ttien.equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            String ngayXuat = dateFormat.format(khachHang.getNgayxuathoadon());
            if(ngayXuat.equalsIgnoreCase(ma))
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