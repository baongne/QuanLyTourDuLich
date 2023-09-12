package DTO;

import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class PhuongTienDTO {
    private String mapt;
    private String loaipt;
    private String bienso;
    private long tongsocho;
    private long sochocondu;
    
    public PhuongTienDTO(PhuongTienDTO x){
        mapt = x.mapt;
        loaipt = x.loaipt;
        bienso = x.bienso;
        tongsocho = x.tongsocho;
        sochocondu = x.sochocondu;
    }

    public PhuongTienDTO(String mapt, String loaipt, String bienso, long tongsocho, long sochocondu) {
        this.mapt = mapt;
        this.loaipt = loaipt;
        this.bienso = bienso;
        this.tongsocho = tongsocho;
        this.sochocondu = sochocondu;
    }

    public PhuongTienDTO(String mapt) {
        this.mapt = mapt;
    }
    
    public String getMapt() {
        return mapt;
    }

    public void setMapt(String mapt) {
        this.mapt = mapt;
    }

    public String getLoaipt() {
        return loaipt;
    }

    public void setLoaipt(String loaipt) {
        this.loaipt = loaipt;
    }

    public String getBienso() {
        return bienso;
    }

    public void setBienso(String bienso) {
        this.bienso = bienso;
    }

    public long getTongsocho() {
        return tongsocho;
    }

    public void setTongsocho(long tongsocho) {
        this.tongsocho = tongsocho;
    }

    public long getSochocondu() {
        return sochocondu;
    }

    public void setSochocondu(long sochocondu) {
        this.sochocondu = sochocondu;
    }

    @Override
    public String toString() {
        return "PhuongTien{" + "mapt=" + mapt + ", loaipt=" + loaipt + ", bienso=" + bienso + ", tongsocho=" + tongsocho + ", sochocondu=" + sochocondu + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.mapt);
        hash = 29 * hash + Objects.hashCode(this.loaipt);
        hash = 29 * hash + Objects.hashCode(this.bienso);
        hash = 29 * hash + (int) (this.tongsocho ^ (this.tongsocho >>> 32));
        hash = 29 * hash + (int) (this.sochocondu ^ (this.sochocondu >>> 32));
        return hash;
    }
    
   
}    
    

