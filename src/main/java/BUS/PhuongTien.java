package BUS;

import DTO.PhuongTienDTO;
import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class PhuongTien{
    
    private ArrayList<PhuongTienDTO>danhSachPT = new ArrayList<PhuongTienDTO>();
    config con = new config();
    public PhuongTien() 
    {
        this.danhSachPT = con.layDL_PhuongTien(); //cach khai bao 1 arrayList
    }
    
    public PhuongTienDTO traPT(int i){
        return danhSachPT.get(i);
    }
    
    public PhuongTienDTO traPT(String maPT){
        for (PhuongTienDTO phuongTien : danhSachPT) {
            if (maPT.equalsIgnoreCase(phuongTien.getMapt())) {
                return phuongTien;
            }
        }
        return null;
    }
    
    /*public KhachHang(ArrayList<KhachHang> danhSach) {
    this.danhSach = danhSach;
    }*/
    
    public void themPhuongTien(PhuongTienDTO pt)
    {
        this.danhSachPT.add(pt);    
    }
    
    
    
    public void themPhuongTien(String mapt, String loaipt, String bienso, long tongsocho, long sochocondu)
    {
        PhuongTienDTO pt = new PhuongTienDTO(mapt, loaipt, bienso, tongsocho, sochocondu);
        this.danhSachPT.add(pt);    
        con.UpdateSQL_PhuongTien(pt, 1, "null");
    }
    
    
    
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongPhuongTien()
    {
        return this.danhSachPT.size();
    }
    
    
    
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean  xoaPhuongTien(PhuongTien pt)
    {
        return this.danhSachPT.remove(pt);
    }
    public boolean xoaPhuongTien(String ma)
    {        
        int i = 0;
        for (PhuongTienDTO phuongTien : danhSachPT) {
            if (ma.equalsIgnoreCase(phuongTien.getMapt())) {
                this.danhSachPT.remove(i); 
                con.UpdateSQL_PhuongTien(phuongTien, 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    public boolean suaPhuongTien(String maOld, String mapt, String loaipt, String bienso, long tongsocho, long sochocondu)
    {        
        int i = 0;
        for (PhuongTienDTO phuongTien : danhSachPT) {
            if (maOld.equalsIgnoreCase(phuongTien.getMapt())) {
                this.danhSachPT.get(i).setLoaipt(loaipt); 
                this.danhSachPT.get(i).setMapt(mapt);
                this.danhSachPT.get(i).setBienso(bienso); 
                this.danhSachPT.get(i).setTongsocho(tongsocho);
                this.danhSachPT.get(i).setSochocondu(sochocondu);
                
                con.UpdateSQL_PhuongTien(this.danhSachPT.get(i), 3, maOld);
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    public void timPhuongTien(String ma)
    {
        for (PhuongTienDTO phuongTien : danhSachPT) 
        {
            if(phuongTien.getMapt().contains(ma));
            System.out.println(phuongTien);
        }
    }
    public ArrayList<PhuongTienDTO> timPhuongTienUnlimit(String ma)
    {   
        int i =0;
        ArrayList<PhuongTienDTO> dspt = new ArrayList<>();
        for (PhuongTienDTO phuongTien : danhSachPT) 
        {
            if(phuongTien.getMapt().equalsIgnoreCase(ma))
            {   
                dspt.add(phuongTien);
            }
            if(phuongTien.getLoaipt().equalsIgnoreCase(ma))
            {   
                dspt.add(phuongTien);
            }
            if(phuongTien.getBienso().equalsIgnoreCase(ma))
            {   
                dspt.add(phuongTien);
            }
            
            String tongCho = Long.toString(phuongTien.getTongsocho());
            if(tongCho.equalsIgnoreCase(ma)){
                dspt.add(phuongTien);
            }
            
            String sochodu = Long.toString(phuongTien.getSochocondu());
            if(sochodu.equalsIgnoreCase(ma)){
                dspt.add(phuongTien);
            }
            i++;
        }
        if (dspt != null) {
            return dspt;
        }
        return null;
    }
}    
    

