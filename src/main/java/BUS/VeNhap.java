package BUS;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class VeNhap implements Comparable<VeNhap>{
    public String mave;
    public Date ngaytaove;
    public Date hansudung;
    public long giavegiamgia;
    public int gio;

    public VeNhap(VeNhap x) {
        mave = x.mave;
        ngaytaove = x.ngaytaove;
        hansudung = x.hansudung;
        giavegiamgia = x.giavegiamgia;
        gio = x.gio;
    }

    public VeNhap(String mave, Date ngaytaove, Date hansudung, long giavegiamgia, int gio) {
        this.mave = mave;
        this.ngaytaove = ngaytaove;
        this.hansudung = hansudung;
        this.giavegiamgia = giavegiamgia;
        this.gio = gio;
    }
    
    @Override
    public int compareTo(VeNhap o) {
        return this.mave.compareTo(o.mave);
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public Date getNgaytaove() {
        return ngaytaove;
    }

    public void setNgaytaove(Date ngaytaove) {
        this.ngaytaove = ngaytaove;
    }

    public Date getHansudung() {
        return hansudung;
    }

    public void setHansudung(Date hansudung) {
        this.hansudung = hansudung;
    }

    public long getGiavegiamgia() {
        return giavegiamgia;
    }

    public void setGiavegiamgia(long giavegiamgia) {
        this.giavegiamgia = giavegiamgia;
    }

    public int getGio() {
        return gio;
    }

    public void setGio(int gio) {
        this.gio = gio;
    }

    @Override
    public String toString() {
        return "Ve{" + "mave=" + mave + ", ngaytaove=" + ngaytaove + ", hansudung=" + hansudung + ", giavegiamgia=" + giavegiamgia + ", gio=" + gio + '}';
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma ve: ");
        mave = sc.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Nhap ngay tao ve(dd/MM/yyyy): ");
        String date1Str = sc.nextLine();
        try {
            ngaytaove = format.parse(date1Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Nhap han su dung(dd/MM/yyyy): ");
        String date2Str = sc.nextLine();
        try {
            hansudung = format.parse(date2Str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Nhap gia ve giam gia: ");
        giavegiamgia = sc.nextLong();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.mave);
        hash = 79 * hash + Objects.hashCode(this.ngaytaove);
        hash = 79 * hash + Objects.hashCode(this.hansudung);
        hash = 79 * hash + (int) (this.giavegiamgia ^ (this.giavegiamgia >>> 32));
        hash = 79 * hash + this.gio;
        hash = 79 * hash + Objects.hashCode(this.danhSach);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VeNhap other = (VeNhap) obj;
        if (this.giavegiamgia != other.giavegiamgia) {
            return false;
        }
        if (this.gio != other.gio) {
            return false;
        }
        if (!Objects.equals(this.mave, other.mave)) {
            return false;
        }
        if (!Objects.equals(this.ngaytaove, other.ngaytaove)) {
            return false;
        }
        if (!Objects.equals(this.hansudung, other.hansudung)) {
            return false;
        }
        return Objects.equals(this.danhSach, other.danhSach);
    }
    
    
    
    public void xuat()
    {
        System.out.println("Ma ve la: "+this.mave);
        System.out.println("Ngay tao ve la: "+this.ngaytaove);
        System.out.println("Han su dung: "+this.hansudung);
        System.out.println("Gia ve giam gia la: "+this.giavegiamgia);
   
    }
    
    private ArrayList<VeNhap>danhSach;

    public VeNhap()
    {
        this.danhSach = new ArrayList<VeNhap>(); //cach khai bao 1 arrayList
    }
    
    public VeNhap(ArrayList<VeNhap> danhSach) {
        this.danhSach = danhSach;
    }
    
    //1. Them khach hang vao danh sach 
    public void themVeNhap(VeNhap ve)
    {
        this.danhSach.add(ve);    
    }
    
    //2. Them In danh sach khach hang ra man hinh
    public void inDanhSachVe()
    {
        for (VeNhap veNhap : danhSach) 
        {
            System.out.println(veNhap);
        }
    }
    
    //3. Kiem tra danh sach khach hang co rong hay khong
    public boolean kiemTraDanhSachRong()
    {
        return this.danhSach.isEmpty();
    }
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongVe()
    {
        return this.danhSach.size();
    }
    //5. lam rong danh sach khach hang
    public void lamRongDanhSach()
    {
        this.danhSach.removeAll(danhSach);
    }
    
    //6. Kiem tra khach hang co ton tai trong danh sach hay khong, dua tren ma khach hang
    public boolean kiemTraTonTai(VeNhap ve)
    {
        return this.danhSach.contains(ve);
    }
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean  xoaVe(VeNhap ve)
    {
        return this.danhSach.remove(ve);
    }
    
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    public void timVe(String ma)
    {
        for (VeNhap ve : danhSach) 
        {
            if(ve.getMave().contains(ma));
            System.out.println(ve);
        }
    }
}
