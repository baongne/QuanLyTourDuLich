
package BUS;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Thanh Tran
 */
public class BookVeBUS implements Comparable<BookVeBUS>{
    public String hoTen;
    public String diaChi;
    public String soDT;
    public String email;
    public String maVeTour;
    public String noiDi;
    public String noiDen;
    public String loaiTour;
    public long giaTour;
    
    public BookVeBUS(BookVeBUS x) {
        hoTen = x.hoTen;
        diaChi = x.diaChi;
        soDT = x.soDT;
        email = x.email;
        maVeTour = x.maVeTour;
        noiDi = x.noiDi;
        noiDen = x.noiDen;
        loaiTour = x.loaiTour;
        giaTour = x.giaTour;
    }

    public BookVeBUS(String hoTen, String diaChi, String soDT, String email, String maVeTour, String noiDi, String noiDen, String loaiTour, long giaTour) {
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.email = email;
        this.maVeTour = maVeTour;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.loaiTour = loaiTour;
        this.giaTour = giaTour;
       
    }

    @Override
    public int compareTo(BookVeBUS o) {
        return this.maVeTour.compareTo(o.maVeTour);
    }
    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaVeTour() {
        return maVeTour;
    }

    public void setMaVeToủ(String maVeTour) {
        this.maVeTour = maVeTour;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public String getLoaiTour() {
        return loaiTour;
    }

    public void setLoaiTour(String loaiTour) {
        this.loaiTour = loaiTour;
    }

    public long getGiaTour() {
        return giaTour;
    }

    public void setGiaTour(long giaTour) {
        this.giaTour = giaTour;
    }
    
    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
    
}
