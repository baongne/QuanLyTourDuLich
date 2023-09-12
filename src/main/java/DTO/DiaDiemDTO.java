package DTO;

import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DiaDiemDTO {
    private String madd;
    private String tendd;
    private String thuoctinh;
    private String khuvuc;

    public DiaDiemDTO(String madd, String tendd, String thuoctinh, String khuvuc) {
        this.madd = madd;
        this.tendd = tendd;
        this.thuoctinh = thuoctinh;
        this.khuvuc = khuvuc;
    }

    public String getMadd() {
        return madd;
    }

    public void setMadd(String madd) {
        this.madd = madd;
    }

    public String getTendd() {
        return tendd;
    }

    public void setTendd(String tendd) {
        this.tendd = tendd;
    }

    public String getThuoctinh() {
        return thuoctinh;
    }

    public void setThuoctinh(String thuoctinh) {
        this.thuoctinh = thuoctinh;
    }

    public String getKhuvuc() {
        return khuvuc;
    }

    public void setKhuvuc(String khuvuc) {
        this.khuvuc = khuvuc;
    }
    
    

    @Override
    public String toString() {
        return "DiaDiem{" + "madd=" + madd + ", tendd=" + tendd + ", thuoctinh=" + thuoctinh + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.madd);
        hash = 89 * hash + Objects.hashCode(this.tendd);
        hash = 89 * hash + Objects.hashCode(this.thuoctinh);
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
        final DiaDiemDTO other = (DiaDiemDTO) obj;
        if (!Objects.equals(this.madd, other.madd)) {
            return false;
        }
        if (!Objects.equals(this.tendd, other.tendd)) {
            return false;
        }
        return Objects.equals(this.thuoctinh, other.thuoctinh);
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma dia diem: ");
        madd = sc.nextLine();
        System.out.println("Nhap ten dia diem: ");
        tendd = sc.nextLine();
        System.out.println("Nhap thong tin dia diem: ");
        thuoctinh = sc.nextLine();
    }
    
    public void xuat() {
    System.out.println("Ma dia diem: " + madd);
    System.out.println("Ten dia diem: " + tendd);
    System.out.println("Thuoc tinh: " + thuoctinh);
    }
    
    
}

