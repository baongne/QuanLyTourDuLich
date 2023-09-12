package BUS;

import DTO.TourDTO;
import DTO.VeTourDTO;
import KetnoiSQL_DAL.config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Tour {
    

   private ArrayList<TourDTO> ds = new ArrayList<>();
   config con = new config();
   
   public Tour(){
       this.ds = con.layDL_Tour();
   }
   
   public TourDTO traTour(int i){
       return ds.get(i);
   }
   
   public TourDTO traTour(String ma){
       for(TourDTO t : ds){
           if(ma.equals(t.getMaTour())){
               return t;
           }
       }
       return null;
   }
   
   public int laySoLuongTour(){
       return this.ds.size();
   }
   public void themTour(TourDTO kh) {
        this.ds.add(kh);
    }
   public void themTour(String tenTour, String maTour, String loaiTour, int Tongsocho, int Sochodu, String DiaDiemTour, String DiaDiemdi, String DiaDiemden, int songaydi, long giaTour){
        TourDTO tour = new TourDTO( tenTour,  maTour,  loaiTour,  Tongsocho,  Sochodu,  DiaDiemTour,  DiaDiemdi,  DiaDiemden,  songaydi,  giaTour);
        con.UpdateSQL_Tour(tour, 1, "null");
        ds.add(tour);
   }
   
   public boolean xoaTour(String ma){
       int i = 0;
       for(TourDTO t : ds){
           if(ma.equalsIgnoreCase(t.getMaTour())){
               ds.remove(i);
               con.UpdateSQL_Tour(t, 2, "null");
               return true;
           }
           i++;
       }
       return false;
   }
   
   public boolean suaTour(String maOld, String tenTour, String maTour, String loaiTour, int Tongsocho, int Sochodu, String DiaDiemTour, String DiaDiemdi, String DiaDiemden, int songaydi, long giaTour){
       int i = 0;
       for(TourDTO t : ds){
           if(maOld.equalsIgnoreCase(t.getMaTour())){
               this.ds.get(i).setTenTour(tenTour);
               this.ds.get(i).setMaTour(maTour);
               this.ds.get(i).setLoaiTour(loaiTour);
               this.ds.get(i).setTongsocho(Tongsocho);
               this.ds.get(i).setSochodu(Sochodu);
               this.ds.get(i).setDiaDiemTour(DiaDiemTour);
               this.ds.get(i).setDiaDiemdi(DiaDiemdi);
               this.ds.get(i).setDiaDiemden(DiaDiemden);
               this.ds.get(i).setSongaydi(songaydi);
               
               this.ds.get(i).setGiaTour(giaTour);
               
               con.UpdateSQL_Tour(this.ds.get(i), 3, maOld);
               return true;
           }
           i++;
       }
       return false;
   }
   
   public ArrayList<TourDTO> timTourUnlimit(String ma){
       int i = 0;
       ArrayList<TourDTO> ds = new ArrayList<>();
       for(TourDTO t : ds){
           if(t.getTenTour().equalsIgnoreCase(ma)){
               ds.add(t);
           }
           if(t.getMaTour().equalsIgnoreCase(ma)){
               ds.add(t);
           }
           if(t.getLoaiTour().equalsIgnoreCase(ma)){
               ds.add(t);
           }
           if(t.getDiaDiemTour().equalsIgnoreCase(ma)){
               ds.add(t);
           }
           if(t.getDiaDiemdi().equalsIgnoreCase(ma)){
               ds.add(t);
           }
           if(t.getDiaDiemden().equalsIgnoreCase(ma)){
               ds.add(t);
           }
           String tongCho = Long.toString(t.getTongsocho());
           if(tongCho.equalsIgnoreCase(ma)){
               ds.add(t);
           }
           String choDu = Long.toString(t.getSochodu());
           if(choDu.equalsIgnoreCase(ma)){
               ds.add(t);
           }
           String soNgay = Integer.toString(t.getSongaydi());
           if(soNgay.equalsIgnoreCase(ma)){
               ds.add(t);
           }
           /*SimpleDateFormat dateFormat = new SimpleDateFormat();
           String ngaydiString = dateFormat.format(ngaydi);
           String ngayveString = dateFormat.format(ngayve);
           if(ngaydiString.equalsIgnoreCase(ma)){
           ds.add(t);
           }
           if(ngayveString.equalsIgnoreCase(ma)){
           ds.add(t);
           }*/
           String giatour = Long.toString(t.getGiaTour());
           if(giatour.equalsIgnoreCase(ma)){
               ds.add(t);
           }
                  i++;
       }
       if(ds != null){
           return ds;
       }
       return null;
   }

   
}