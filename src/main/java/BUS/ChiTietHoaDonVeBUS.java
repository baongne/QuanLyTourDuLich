package BUS;

import KetnoiSQL_DAL.config;
import java.util.ArrayList;
import java.util.Scanner;

public class ChiTietHoaDonVeBUS {
    private String mave;
    private String maHD;
    private String MaCTHD;
    private int soluongve;
    private long tienve;

    public ChiTietHoaDonVeBUS(String mave, String maHD, String MaCTHD, int soluongve, long tienve) {
        this.mave = mave;
        this.maHD = maHD;
        this.MaCTHD = MaCTHD;
        this.soluongve = soluongve;
        this.tienve = tienve;
    }

   

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaCTHD() {
        return MaCTHD;
    }

    public void setMaCTHD(String MaCTHD) {
        this.MaCTHD = MaCTHD;
    }

    public int getSoluongve() {
        return soluongve;
    }

    public void setSoluongve(int soluongve) {
        this.soluongve = soluongve;
    }

    public long getTienve() {
        return tienve;
    }

    public void setTienve(long tienve) {
        this.tienve = tienve;
    }

    public config getCon() {
        return con;
    }

    public void setCon(config con) {
        this.con = con;
    }



    

    

    
    @Override
    public String toString() {
        return "ChiTietHoaDonVe{" +
                "soluongve=" + soluongve +
                ", tienve=" + tienve +
                '}';
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong ve: ");
        soluongve = sc.nextInt();
        System.out.println("Nhap tien ve: ");
        tienve = sc.nextLong();
    }

    public void xuat() {
        System.out.println("So luong ve: " + soluongve);
        System.out.println("Tien ve: " + tienve);
    }
    
    private ArrayList<ChiTietHoaDonVeBUS>danhSach = new ArrayList<ChiTietHoaDonVeBUS>();
    config con = new config();
    public ChiTietHoaDonVeBUS() 
    {
        this.danhSach = con.LayDL_CTHD(); //cach khai bao 1 arrayList
    }
    public ChiTietHoaDonVeBUS traKH(int i){
        return danhSach.get(i);
    }
    public ChiTietHoaDonVeBUS traKH(String maKH){
        for (ChiTietHoaDonVeBUS khachHang : danhSach) {
            if (maKH.equalsIgnoreCase(khachHang.getMaHD())) {
                return khachHang;
            }
        }
        return null;
    }
    
    /*public KhachHang(ArrayList<KhachHang> danhSach) {
    this.danhSach = danhSach;
    }*/
    
    public void themKhachHang(ChiTietHoaDonVeBUS kh)
    {
        this.danhSach.add(kh);    
    }
    
    public String maCTHD(String MaHD)
    {
        int i= 0;
        for (ChiTietHoaDonVeBUS chiTietHoaDonVe : danhSach) {
            if (chiTietHoaDonVe.getMaHD().equals(MaHD)) {
                i++;
            }
        }
        
        return MaHD +"_00"+Integer.toString(i);
    }
    
    
    public void themKhachHang(String mave,String MaCTHD, String maHD, int soluongve, long tienve)
    {
        ChiTietHoaDonVeBUS kh = new ChiTietHoaDonVeBUS(mave,MaCTHD, maHD, soluongve, tienve);
        this.danhSach.add(kh);    
        con.UpdateSQL_CTHD(kh, 1, "null");
    }
    
    
    
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuong()
    {
        return this.danhSach.size();
    }
    
    
    
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean  xoaCTHD(ChiTietHoaDonVeBUS kh)
    {
        return this.danhSach.remove(kh);
    }
    public boolean xoaKhachHang(String ma)
    {        
        int i = 0;
        for (ChiTietHoaDonVeBUS khachHang : danhSach) {
            if (ma.equalsIgnoreCase(khachHang.getMaHD())) {
                this.danhSach.remove(i); 
                con.UpdateSQL_CTHD(khachHang, 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    public boolean suaKhachHang(String maOld, String mave, String maHD, String MaCTHD, int soluongve, long tienve)
    {        
        int i = 0;
        for (ChiTietHoaDonVeBUS khachHang : danhSach) {
            if (maOld.equalsIgnoreCase(khachHang.getMaHD())) {
                this.danhSach.get(i).setMaHD(maHD); 
                this.danhSach.get(i).setMave(mave);
                this.danhSach.get(i).setMaCTHD(MaCTHD); 
                this.danhSach.get(i).setSoluongve(soluongve);
                this.danhSach.get(i).setTienve(tienve);
                
                con.UpdateSQL_CTHD(this.danhSach.get(i), 3, maOld);
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    public void timKhachHang(String ma)
    {
        for (ChiTietHoaDonVeBUS khachHang : danhSach) 
        {
            if(khachHang.getMaCTHD().contains(ma));
            System.out.println(khachHang);
        }
    }
    public String maCTHD()
    {
        String s = "CTHD00" + Integer.toString(laySoLuong()+ 1 );
        return s;
    }
    public ArrayList<ChiTietHoaDonVeBUS> timCTHDVeUnlimit(String ma)
    {   
        int i =0;
        ArrayList<ChiTietHoaDonVeBUS> dskh = new ArrayList<>();
        for (ChiTietHoaDonVeBUS khachHang : danhSach) 
        {
            if(khachHang.getMaHD().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getMaCTHD().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getMave().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getSoluongve() == Integer.parseInt(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getTienve() == Long.parseLong(ma))
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