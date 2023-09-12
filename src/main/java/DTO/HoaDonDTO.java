package DTO;

import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class HoaDonDTO {
    private String mahd;
    private String manv;
    private String makhachdatve;
    private long tongtien;
    private Date ngayxuathoadon;

    public HoaDonDTO(String mahd, String manv, String makhachdatve, long tongtien, Date ngayxuathoadon) {
        this.mahd = mahd;
        this.manv = manv;
        this.makhachdatve = makhachdatve;
        this.tongtien = tongtien;
        this.ngayxuathoadon = ngayxuathoadon;
    }
    
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }
    
    
    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMakhachdatve() {
        return makhachdatve;
    }

    public void setMakhachdatve(String makhachdatve) {
        this.makhachdatve = makhachdatve;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public Date getNgayxuathoadon() {
        return ngayxuathoadon;
    }

    public void setNgayxuathoadon(Date ngayxuathoadon) {
        this.ngayxuathoadon = ngayxuathoadon;
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma hoa don: ");
        this.mahd = sc.nextLine();

        System.out.println("Nhap ma khach dat ve: ");
        this.makhachdatve = sc.nextLine();

        System.out.println("Nhap tong tien: ");
        this.tongtien = sc.nextLong();
        sc.nextLine();

        Date ngayxuat = null;
        while (ngayxuat == null) {
        System.out.println("Nhap ngay xuat hoa don(dd/MM/yyyy): ");
        String ngayxuatString = sc.nextLine();
        try {
            ngayxuat = new SimpleDateFormat("dd/MM/yyyy").parse(ngayxuatString);
        } catch (ParseException e) {
            System.out.println("Nhap ngay xuat hoa don sai dinh dang, hay nhap lai!");
        }
    }
        this.ngayxuathoadon = ngayxuat;
    }

    public void xuat() {
        System.out.println("Ma hoa don: " + this.mahd);
        System.out.println("Ma khach dat ve: " + this.makhachdatve);
        System.out.println("Tong tien: " + this.tongtien);
        System.out.println("Ngay xuat hoa don: " + this.ngayxuathoadon);
    }
    
   
}