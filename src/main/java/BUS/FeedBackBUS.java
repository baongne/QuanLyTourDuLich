/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.FeedBack;
import KetnoiSQL_DAL.config;
import java.util.ArrayList;

/**
 *
 * @author Thanh Tran
 */
public class FeedBackBUS {
    

    private ArrayList<FeedBack>danhSach = new ArrayList<FeedBack>();
    config con = new config();
    public FeedBackBUS() 
    {
        this.danhSach = con.LayDL_Feedback(); //cach khai bao 1 arrayList
    }
    
    public FeedBack traFB(int i){
        return danhSach.get(i);
    }
    public FeedBack traFB(String ten){
        for (int i = 0; i < danhSach.size(); i ++) {
            if (ten.equalsIgnoreCase(danhSach.get(i).getHoten())) {
                return danhSach.get(i);
            }
        }
        return null;
    }
    
    /*public KhachHang(ArrayList<KhachHang> danhSach) {
    this.danhSach = danhSach;
    }*/
    
    public void themFeedBack(FeedBack kh)
    {
        this.danhSach.add(kh);    
    }
    
    
    
    public void themFeedBack(String hoten, String email, String sdt, String diachi, String noidung)
    {
        FeedBack kh = new FeedBack( hoten,  email,  sdt,  diachi,  noidung);
        this.danhSach.add(kh);   
        con.UpdateSQL_FeedBack(kh, 1, "null");
    }
    
    
    //2. Them In danh sach khach hang ra man hinh
    
    
   
    
    public int laySoLuongFeedBack()
    {
        return this.danhSach.size();
    }
  
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean  xoaFeedBack(FeedBackBUS kh)
    {
        return this.danhSach.remove(kh);
    }
    
    public boolean xoaFeedBack(String ma)
    {        

        for (int i = 0; i < danhSach.size(); i ++) {
            if (ma.equalsIgnoreCase(danhSach.get(i).getHoten())) {
                this.danhSach.remove(i); 
                con.UpdateSQL_FeedBack(danhSach.get(i), 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    public boolean suaFeedBack(String maOld, String hoten, String email, String sdt, String diachi, String noidung)
    {        

        for (int i = 0; i < danhSach.size(); i ++) {
            if (maOld.equalsIgnoreCase(danhSach.get(i).getHoten())) {
                this.danhSach.get(i).setHoten(hoten); 
                this.danhSach.get(i).setEmail(email);
                this.danhSach.get(i).setSdt(sdt); 
                this.danhSach.get(i).setDiachi(diachi);
                this.danhSach.get(i).getNoidung();
                
                con.UpdateSQL_FeedBack(this.danhSach.get(i), 3, maOld);
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    
    public ArrayList<FeedBack> timFeedBackUnlimit(String ma)
    {   

        ArrayList<FeedBack> dskh = new ArrayList<>();
        for (int i = 0; i < danhSach.size(); i ++) 
        {
            if(danhSach.get(i).getHoten().equalsIgnoreCase(ma))
            {   
                dskh.add(danhSach.get(i));
            }
            if(danhSach.get(i).getEmail().equalsIgnoreCase(ma))
            {   
                dskh.add(danhSach.get(i));
            }
            if(danhSach.get(i).getSdt().equalsIgnoreCase(ma))
            {   
                dskh.add(danhSach.get(i));
            }
            if(danhSach.get(i).getDiachi().equalsIgnoreCase(ma))
            {   
                dskh.add(danhSach.get(i));
            }
            if(danhSach.get(i).getNoidung().equalsIgnoreCase(ma))
            {   
                dskh.add(danhSach.get(i));
            }
            i++;
        }
        if (dskh != null) {
            return dskh;
        }
        return null;
    }
}
