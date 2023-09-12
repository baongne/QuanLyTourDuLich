
package BUS;


import DTO.DiaDiemVuiChoiDTo;
import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Huu Quoc Bao
 */
public class DiaDiemVuiChoi{
    
    
    private ArrayList<DiaDiemVuiChoiDTo> danhSach = new ArrayList<>();
    private config con = new config();

    public DiaDiemVuiChoi(){
        this.danhSach = con.LayDL_DiaDiemVuiChoi();
    }
    
    public DiaDiemVuiChoiDTo traDiaDiem(int i) {
        return danhSach.get(i);
    }

    public DiaDiemVuiChoiDTo traDiaDiem(String maDD) {
        for (DiaDiemVuiChoiDTo diaDiem : danhSach) {
            if (maDD.equalsIgnoreCase(diaDiem.getMaDiaDiem())) {
                return diaDiem;
            }
        }
        return null;
    }

    public void themDiaDiem(DiaDiemVuiChoiDTo diaDiem) {
        this.danhSach.add(diaDiem);
    }

    public void themDiaDiem(String diaDiemTour, String tenDiaDiem, String maDiaDiem) {
        DiaDiemVuiChoiDTo diaDiem = new DiaDiemVuiChoiDTo(diaDiemTour, tenDiaDiem, maDiaDiem);
        this.danhSach.add(diaDiem);
        con.UpdateSQL_DDVC(diaDiem, 1, "null");
    }

    public int laySoLuongDiaDiem() {
        return this.danhSach.size();
    }

    public boolean xoaDiaDiem(DiaDiemVuiChoi diaDiem) {
        return this.danhSach.remove(diaDiem);
    }

    public boolean xoaDiaDiem(String maDD) {
        int i = 0;
        for (DiaDiemVuiChoiDTo diaDiem : danhSach) {
            if (maDD.equalsIgnoreCase(diaDiem.getMaDiaDiem())) {
                this.danhSach.remove(i);
                con.UpdateSQL_DDVC(diaDiem, 2, "null");
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean suaDiaDiem(String maOld, String diaDiemTour, String tenDiaDiem, String maDiaDiem) {
        int i = 0;
        for (DiaDiemVuiChoiDTo diaDiem : danhSach) {
            if (maOld.equalsIgnoreCase(diaDiem.getMaDiaDiem())) {
                this.danhSach.get(i).setDiaDiemTour(diaDiemTour);
                this.danhSach.get(i).setTenDiaDiem(tenDiaDiem);
                this.danhSach.get(i).setMaDiaDiem(maDiaDiem);
                con.UpdateSQL_DDVC(this.danhSach.get(i), 3, maOld);
                return true;
            }
            i++;
        }
        return false;
    }

    public void timDiaDiem(String maDD) {
        for (DiaDiemVuiChoiDTo diaDiem : danhSach) {
            if (diaDiem.getMaDiaDiem().contains(maDD)) {
                System.out.println(diaDiem);
            }
        }
    }

    public ArrayList<DiaDiemVuiChoiDTo> timDiaDiemUnlimit(String maDD) {
        ArrayList<DiaDiemVuiChoiDTo> dsDiaDiem = new ArrayList<>();
        for (DiaDiemVuiChoiDTo diaDiem : danhSach) {
            if (diaDiem.getMaDiaDiem().equalsIgnoreCase(maDD)) {
                dsDiaDiem.add(diaDiem);
            }
            if (diaDiem.getTenDiaDiem().equalsIgnoreCase(maDD)) {
                dsDiaDiem.add(diaDiem);
            }
            if (diaDiem.getDiaDiemTour().equalsIgnoreCase(maDD)) {
                dsDiaDiem.add(diaDiem);
            }
        }
        return dsDiaDiem;
    }
}
