/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import KetnoiSQL_DAL.config;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thanh Tran
 */
public class ChiTietTourDuLichDTo {
    private String ddtour;
    private String matour;
    private String khoihanh;
    private String noiden;
    private String maks;
    private long tienan;
    private long tienphong;
    private long phidichvu;
    private int thutungay;


    public ChiTietTourDuLichDTo(String ddtour, String matour, String khoihanh, String noiden, int thutungay, String maks, long tienan, long tienphong, long phidichvu) {
        this.ddtour = ddtour;
        this.matour = matour;
        this.khoihanh = khoihanh;
        this.noiden = noiden;
        this.maks = maks;
        this.tienan = tienan;
        this.tienphong = tienphong;
        this.phidichvu = phidichvu;
        this.thutungay= thutungay;
    }

    public String getDdtour() {
        return ddtour;
    }

    public void setDdtour(String ddtour) {
        this.ddtour = ddtour;
    }

    public String getMatour() {
        return matour;
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public String getKhoihanh() {
        return khoihanh;
    }

    public void setKhoihanh(String khoihanh) {
        this.khoihanh = khoihanh;
    }

    public String getNoiden() {
        return noiden;
    }

    public void setNoiden(String noiden) {
        this.noiden = noiden;
    }

    public String getMaks() {
        return maks;
    }

    public void setMaks(String maks) {
        this.maks = maks;
    }

    public long getTienan() {
        return tienan;
    }

    public void setTienan(long tienan) {
        this.tienan = tienan;
    }

    public long getTienphong() {
        return tienphong;
    }

    public void setTienphong(long tienphong) {
        this.tienphong = tienphong;
    }

    public long getPhidichvu() {
        return phidichvu;
    }

    public void setPhidichvu(long phidichvu) {
        this.phidichvu = phidichvu;
    }

    public int getThutungay() {
        return thutungay;
    }

    public void setThutungay(int thutungay) {
        this.thutungay = thutungay;
    }
    
   
}
