package DTO;
import KetnoiSQL_DAL.config;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
public class KhuyenMaiDTO {
    private String makm;
    private String tenkm;
    private Date ngaykm;
    private Date hansudung;
    private long tiengiam;
    

    public KhuyenMaiDTO( String tenkm,String makm, Date ngaykm, Date hansudung, long tiengiam) {
        this.makm = makm;
        this.tenkm = tenkm;
        this.ngaykm = ngaykm;
        this.hansudung = hansudung;
        this.tiengiam = tiengiam;
    }
    
    public KhuyenMaiDTO(KhuyenMaiDTO x)
    {   
        makm = x.makm;
        tenkm = x.tenkm;
        ngaykm = x.ngaykm;
        hansudung = x.hansudung;
        tiengiam = x.tiengiam;
    }
    
    
    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public Date getNgaykm() {
        return ngaykm;
    }

    public void setNgaykm(Date ngaykm) {
        this.ngaykm = ngaykm;
    }

    public Date getHansudung() {
        return hansudung;
    }

    public void setHansudung(Date hansudung) {
        this.hansudung = hansudung;
    }

    public long getTiengiam() {
        return tiengiam;
    }

    public void setTiengiam(long tiengiam) {
        this.tiengiam = tiengiam;
    }

    @Override
    public String toString() {
        return "KhuyenMai{" + "makm=" + makm + ", tenkm=" + tenkm + ", ngaykm=" + ngaykm + ", hansudung=" + hansudung + ", tiengiam=" + tiengiam + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.makm);
        hash = 59 * hash + Objects.hashCode(this.tenkm);
        hash = 59 * hash + Objects.hashCode(this.ngaykm);
        hash = 59 * hash + Objects.hashCode(this.hansudung);
        hash = 59 * hash + (int) (this.tiengiam ^ (this.tiengiam >>> 32));
        return hash;
    }

    
}
    
    
   

