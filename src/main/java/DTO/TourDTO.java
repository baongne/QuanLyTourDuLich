package DTO;

import KetnoiSQL_DAL.config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class TourDTO {
    public String tenTour;
    public String maTour;
    public String loaiTour;
    public int Tongsocho;
    public int Sochodu;
    public String DiaDiemTour;
    public String  DiaDiemdi;
    public String DiaDiemden;
    public int songaydi;
    public long giaTour;
    

    public TourDTO(TourDTO x) {
        tenTour = x.tenTour;
        maTour = x.maTour;
        loaiTour = x.loaiTour;
        Tongsocho = x.Tongsocho;
        Sochodu = x.Sochodu;
        DiaDiemTour=x.DiaDiemTour;
        DiaDiemdi=x.DiaDiemdi;
        DiaDiemden=x.DiaDiemden;
        songaydi=x.songaydi;
        
        giaTour=x.giaTour;
    }

    public TourDTO(String tenTour, String maTour, String loaiTour, int Tongsocho, int Sochodu, String DiaDiemTour, String DiaDiemdi, String DiaDiemden, int songaydi, long giaTour) {
        this.tenTour = tenTour;
        this.maTour = maTour;
        this.loaiTour = loaiTour;
        this.Tongsocho = Tongsocho;
        this.Sochodu = Sochodu;
        this.DiaDiemTour = DiaDiemTour;
        this.DiaDiemdi = DiaDiemdi;
        this.DiaDiemden = DiaDiemden;
        this.songaydi = songaydi;
        
        this.giaTour = giaTour;
       
    }


    public int compareTo(TourDTO o) {
        return this.maTour.compareTo(o.maTour);
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getLoaiTour() {
        return loaiTour;
    }

    public void setLoaiTour(String loaiTour) {
        this.loaiTour = loaiTour;
    }

    public int getTongsocho() {
        return Tongsocho;
    }

    public void setTongsocho(int Tongsocho) {
        this.Tongsocho = Tongsocho;
    }

    public int getSochodu() {
        return Sochodu;
    }

    public void setSochodu(int Sochodu) {
        this.Sochodu = Sochodu;
    }

    public String getDiaDiemTour() {
        return DiaDiemTour;
    }

    public void setDiaDiemTour(String DiaDiemTour) {
        this.DiaDiemTour = DiaDiemTour;
    }

    public String getDiaDiemdi() {
        return DiaDiemdi;
    }

    public void setDiaDiemdi(String DiaDiemdi) {
        this.DiaDiemdi = DiaDiemdi;
    }

    public String getDiaDiemden() {
        return DiaDiemden;
    }

    public void setDiaDiemden(String DiaDiemden) {
        this.DiaDiemden = DiaDiemden;
    }

    public int getSongaydi() {
        return songaydi;
    }

    public void setSongaydi(int songaydi) {
        this.songaydi = songaydi;
    }

    

    public long getGiaTour() {
        return giaTour;
    }

    public void setGiaTour(long giaTour) {
        this.giaTour = giaTour;
    }

  
}