package BUS;

import DTO.DiaDiemDTO;
import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DiaDiem {
   
    private ArrayList<DiaDiemDTO>danhSach = new ArrayList<DiaDiemDTO>();
    config con = new config();
    public DiaDiem() 
    {
        this.danhSach = con.LayDL_DiaDiem(); //cach khai bao 1 arrayList
    }



    public DiaDiemDTO traDiaDiem(int i) {
        return danhSach.get(i);
    }

    public DiaDiemDTO traDiaDiem(String maDD) {
        for (DiaDiemDTO diaDiem : danhSach) {
            if (maDD.equalsIgnoreCase(diaDiem.getMadd())) {
                return diaDiem;
            }
        }
        return null;
    }

    public void themDiaDiem(DiaDiemDTO diaDiem) {
        this.danhSach.add(diaDiem);
    }

    public void themDiaDiem(String maDD, String tenDD, String tenTinh, String khuVuc) {
        DiaDiemDTO diaDiem = new DiaDiemDTO(maDD, tenDD, tenTinh, khuVuc);
        this.danhSach.add(diaDiem);
        con.UpdateSQL_DiaDiem(diaDiem, 1, "null");
    }

    public int laySoLuongDiaDiem() {
        return this.danhSach.size();
    }

    public boolean xoaDiaDiem(DiaDiemDTO diaDiem) {
        return this.danhSach.remove(diaDiem);
    }

    public boolean xoaDiaDiem(String maDD) {
        int i = 0;
        for (DiaDiemDTO diaDiem : danhSach) {
            if (maDD.equalsIgnoreCase(diaDiem.getMadd())) {
                this.danhSach.remove(i);
                con.UpdateSQL_DiaDiem(diaDiem, 2, "null");
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean suaDiaDiem(String maOld, String madd, String tendd, String thuoctinh, String khuvuc) {
        int i = 0;
        for (DiaDiemDTO diaDiem : danhSach) {
            if (maOld.equalsIgnoreCase(diaDiem.getMadd())) {
                this.danhSach.get(i).setMadd(madd);
                this.danhSach.get(i).setTendd(tendd);
                this.danhSach.get(i).setThuoctinh(thuoctinh);
                this.danhSach.get(i).setKhuvuc(khuvuc);
                con.UpdateSQL_DiaDiem(this.danhSach.get(i), 3, maOld);
                return true;
            }
            i++;
        }
        return false;
    }

    public void timDiaDiem(String maDD) {
        for (DiaDiemDTO diaDiem : danhSach) {
            if (diaDiem.getMadd().contains(maDD)) {
                System.out.println(diaDiem);
            }
        }
    }

    public ArrayList<DiaDiemDTO> timDiaDiemUnlimit(String madd) {
        ArrayList<DiaDiemDTO> dsDiaDiem = new ArrayList<>();
        for (DiaDiemDTO diaDiem : danhSach) {
            if (diaDiem.getMadd().equalsIgnoreCase(madd)) {
                dsDiaDiem.add(diaDiem);
            }
            if (diaDiem.getTendd().equalsIgnoreCase(madd)) {
                dsDiaDiem.add(diaDiem);
            }
            if (diaDiem.getThuoctinh().equalsIgnoreCase(madd)) {
                dsDiaDiem.add(diaDiem);
            }
            if (diaDiem.getKhuvuc().equalsIgnoreCase(madd)) {
                dsDiaDiem.add(diaDiem);
            }
        }
        return dsDiaDiem;
    }
}

