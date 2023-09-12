/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.ChiTietTourDuLichDTo;
import KetnoiSQL_DAL.config;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thanh Tran
 */
public class ChiTietTourDuLichBUS {
   
    private ArrayList<ChiTietTourDuLichDTo> danhsach = new ArrayList<>();
    config con = new config();
    public ChiTietTourDuLichBUS(){
        this.danhsach = con.LayDL_CTTour();
    }
    
    public ChiTietTourDuLichDTo traCTTour(int i){
        return danhsach.get(i);
    }
    
    public ChiTietTourDuLichDTo traCTTour(String ma1, String ma2){
        for(ChiTietTourDuLichDTo ctt : danhsach){
            if(ma1.equalsIgnoreCase(ctt.getMatour()) && ma2.equalsIgnoreCase(ctt.getMaks())){
                return ctt;
            }
        }
        return null;
    }
    
    public void themCTTour(ChiTietTourDuLichDTo ctt){
        this.danhsach.add(ctt);
    }
    
    public void themCTTour(String ddtour, String matour, String khoihanh, String noiden, int thutungay, String maks, long tienan, long tienphong, long phidichvu){
        ChiTietTourDuLichDTo ctt = new ChiTietTourDuLichDTo( ddtour,  matour,  khoihanh,  noiden,  thutungay,  maks,  tienan,  tienphong,  phidichvu);
        this.danhsach.add(ctt);
        con.UpdateSQL_CTTour(ctt, 1, "null");
    }
    
    public int laySoLuongCTTour(){
        return this.danhsach.size();
    }
    
    public boolean xoaCTTour(ChiTietTourDuLichBUS ctt){
        return this.danhsach.remove(ctt);
    }
    
    public boolean xoaCTTour(String ma){
        int i = 0;
        for(ChiTietTourDuLichDTo ctt : danhsach){
            if(ma.equalsIgnoreCase(ctt.getMatour())){
                con.UpdateSQL_CTTour(ctt, 2, "null");
                return true;
            }
            i++;
        }
        return false;
    }
    
    public boolean suaCTTour(String maOld, String ddtour, String matour, String khoihanh, String noiden, int thutungay, String maks, long tienan, long tienphong, long phidichvu){
        int i = 0;
        for(ChiTietTourDuLichDTo ctt : danhsach){
            if(maOld.equalsIgnoreCase(ctt.getMatour())){
                this.danhsach.get(i).setDdtour(ddtour);
                this.danhsach.get(i).setMatour(matour);
                this.danhsach.get(i).setKhoihanh(khoihanh);
                this.danhsach.get(i).setNoiden(noiden);
                this.danhsach.get(i).setThutungay(thutungay);
                this.danhsach.get(i).setMaks(maks);
                this.danhsach.get(i).setTienan(tienan);
                this.danhsach.get(i).setTienphong(tienphong);
                this.danhsach.get(i).setPhidichvu(phidichvu);
                
                con.UpdateSQL_CTTour(this.danhsach.get(i), 3, maOld);
                return true;
            }
            i++;
        }
        return false;
    }
    
    public ArrayList<ChiTietTourDuLichDTo> timCTTourUnlimit (String ma){
        int i = 0;
        ArrayList<ChiTietTourDuLichDTo> dstour = new ArrayList<>();
        for(ChiTietTourDuLichDTo ctt : danhsach){
            if(ctt.getDdtour().equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            if(ctt.getMatour().equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            if(ctt.getKhoihanh().equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            if(ctt.getNoiden().equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            if(ctt.getMaks().equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            String tienAn = Long.toString(ctt.getTienan());
            if(tienAn.equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            String tienPhong = Long.toString(ctt.getTienphong());
            if(tienPhong.equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            String phiDV = Long.toString(ctt.getPhidichvu());
            if(phiDV.equalsIgnoreCase(ma)){
                dstour.add(ctt);
            }
            i++;
        }
        if(dstour != null){
            return dstour;
        }
        return null;
    }
}
