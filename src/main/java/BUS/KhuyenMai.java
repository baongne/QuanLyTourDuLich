package BUS;
import DTO.KhuyenMaiDTO;
import KetnoiSQL_DAL.config;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
public class KhuyenMai {
    
    private ArrayList<KhuyenMaiDTO>danhSach = new ArrayList<KhuyenMaiDTO>();
    config con = new config();
    public KhuyenMai() 
    {
        this.danhSach = con.layDL_KhuyenMai(); //cach khai bao 1 arrayList
    }
    public KhuyenMaiDTO traKH(int i){
        return danhSach.get(i);
    }
    public KhuyenMaiDTO traKH(String maKH){
        for (KhuyenMaiDTO khachHang : danhSach) {
            if (maKH.equalsIgnoreCase(khachHang.getMakm())) {
                return khachHang;
            }
        }
        return null;
    }
    
  
    
    public void themKhuyenMai(String tenkm,String makm, Date ngaykm, Date hansudung, long tiengiam)
    {
        KhuyenMaiDTO kh = new KhuyenMaiDTO( tenkm, makm,  ngaykm,  hansudung,  tiengiam);
        this.danhSach.add(kh);    
        con.UpdateSQL_KhuyenMai(kh, 1, "null");
    }
    
    
    
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongKhuyenMai()
    {
        return this.danhSach.size();
    }

    public boolean xoaKhuyenMai(String ma)
    {        
        int i = 0;
        for (KhuyenMaiDTO khachHang : danhSach) {
            if (ma.equalsIgnoreCase(khachHang.getMakm())) {
                this.danhSach.remove(i); 
                con.UpdateSQL_KhuyenMai(khachHang, 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
        
    public boolean suaKhuyenMai(String maOld, String tenkm,String makm, Date ngaykm, Date hansudung, long tiengiam)
    {        
        int i = 0;
        for (KhuyenMaiDTO khachHang : danhSach) {
            if (maOld.equalsIgnoreCase(khachHang.getMakm())) {
                this.danhSach.get(i).setTenkm(tenkm); 
                this.danhSach.get(i).setMakm(makm);
                this.danhSach.get(i).setNgaykm(ngaykm); 
                this.danhSach.get(i).setHansudung(hansudung);
                this.danhSach.get(i).setTiengiam(tiengiam);
                
                con.UpdateSQL_KhuyenMai(this.danhSach.get(i), 3, maOld);
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    
    public ArrayList<KhuyenMaiDTO> timKhuyenMaiUnlimit(String ma)
    {   
        int i =0;
        ArrayList<KhuyenMaiDTO> dskh = new ArrayList<>();
        for (KhuyenMaiDTO khachHang : danhSach) 
        {
            if(khachHang.getTenkm().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(khachHang.getMakm().equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat();
            String ngayKMString = dateFormat.format(khachHang.getNgaykm());
            String hanSDString = dateFormat.format(khachHang.getHansudung());
            String tienGiam = Long.toString(khachHang.getTiengiam());
            if(ngayKMString.equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(hanSDString.equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            if(tienGiam.equalsIgnoreCase(ma))
            {   
                dskh.add(khachHang);
            }
            i++;
        }
        if (dskh != null) {
            return dskh;
        }
        return null;
    }
}
    
    
   

