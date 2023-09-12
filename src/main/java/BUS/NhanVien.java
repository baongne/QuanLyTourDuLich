package BUS;


import DTO.NhanVienDTO;
import KetnoiSQL_DAL.config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class NhanVien  {
    
   
    private ArrayList<NhanVienDTO>danhSach = new ArrayList<NhanVienDTO>();
    config con = new config();
    public NhanVien()
    {
        this.danhSach = con.layDL_NhanVien(); //cach khai bao 1 arrayList
    }
    public NhanVienDTO traNV(int i){
        return danhSach.get(i);
    }
    public NhanVienDTO traNV(String maNV){
        for (NhanVienDTO nhanVien : danhSach) {
            if (maNV.equalsIgnoreCase(nhanVien.getManv())) {
                return nhanVien;
            }
        }
        return null;
    }
    public void themNhanVien(NhanVienDTO nv)
    {
        this.danhSach.add(nv);    
    }
    
    
    
    public void themNhanVien(String tennv,String manv,  String diachi,String loainv, String chucvu)
    {
        NhanVienDTO nv = new NhanVienDTO(tennv, manv,  diachi, loainv,  chucvu);
        this.danhSach.add(nv);    
        con.UpdateSQL_NhanVien(nv, 1, "null");
    }
    
    
    
    
    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongNhanVien()
    {
        return this.danhSach.size();
    }
    
    
    
    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean  xoaNhanVien(NhanVien nv)
    {
        return this.danhSach.remove(nv);
    }
    public boolean xoaNhanVien(String ma)
    {        
        int i = 0;
        for (NhanVienDTO nhanVien : danhSach) {
            if (ma.equalsIgnoreCase(nhanVien.getManv())) {
                this.danhSach.remove(i); 
                con.UpdateSQL_NhanVien(nhanVien, 2, "null");
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    
    public boolean suaNhanVien(String maOld, String tennv,String manv,  String diachi,String loainv, String chucvu)
    {        
        int i = 0;
        for (NhanVienDTO nhanVien : danhSach) {
            if (maOld.equalsIgnoreCase(nhanVien.getManv())) {
                this.danhSach.get(i).setTennv(tennv); 
                this.danhSach.get(i).setManv(manv);
                this.danhSach.get(i).setDiachi(diachi); 
                this.danhSach.get(i).setLoainv(loainv);
                this.danhSach.get(i).setChucvu(chucvu);
                
                con.Update(maOld,this.danhSach.get(i));
                
                return true;
            }
            i++;
        }
        
        return false;
        
    }
    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    public void timNhanVien(String ma)
    {
        for (NhanVienDTO nhanVien : danhSach) 
        {
            if(nhanVien.getManv().contains(ma));
            System.out.println(nhanVien);
        }
    }
    public ArrayList<NhanVienDTO> timNhanVienUnlimit(String ma)
    {   
        int i =0;
        ArrayList<NhanVienDTO> dsnv = new ArrayList<>();
        for (NhanVienDTO nhanVien : danhSach) 
        {
            if(nhanVien.getManv().equalsIgnoreCase(ma))
            {   
                dsnv.add(nhanVien);
            }
            if(nhanVien.getTennv().equalsIgnoreCase(ma))
            {   //String tennv,String manv,  String diachi,String loainv, String chucvu
                dsnv.add(nhanVien);
            }
            if(nhanVien.getLoainv().equalsIgnoreCase(ma))
            {   
                dsnv.add(nhanVien);
            }
            if(nhanVien.getDiachi().equalsIgnoreCase(ma))
            {   
                dsnv.add(nhanVien);
            }
            if(nhanVien.getChucvu().equalsIgnoreCase(ma))
            {   
                dsnv.add(nhanVien);
            }
            i++;
        }
        if (dsnv != null) {
            return dsnv;
        }
        return null;
    }

    
}
// 