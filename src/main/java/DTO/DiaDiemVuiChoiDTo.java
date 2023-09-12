
package DTO;


import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Huu Quoc Bao
 */
public class DiaDiemVuiChoiDTo implements Comparable<DiaDiemVuiChoiDTo>{
    public String diaDiemTour;
    public String tenDiaDiem;
    public String maDiaDiem;

    @Override
    public int compareTo(DiaDiemVuiChoiDTo o) {
        return this.maDiaDiem.compareTo(o.maDiaDiem);
    }

    
    public DiaDiemVuiChoiDTo(String diaDiemTour, String tenDiaDiem, String maDiaDiem) {
        this.diaDiemTour = diaDiemTour;
        this.tenDiaDiem = tenDiaDiem;
        this.maDiaDiem = maDiaDiem;
    }
    
    public DiaDiemVuiChoiDTo(DiaDiemVuiChoiDTo x){
        diaDiemTour = x.diaDiemTour;
        tenDiaDiem = x.tenDiaDiem;
        maDiaDiem = x.maDiaDiem;
    }

    public String getDiaDiemTour() {
        return diaDiemTour;
    }

    public void setDiaDiemTour(String diaDiemTour) {
        this.diaDiemTour = diaDiemTour;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(String maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }
    
   
}
