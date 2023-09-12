package BUS;

import DTO.TourDTO;
import DTO.VeTourDTO;
import KetnoiSQL_DAL.config;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thanh Tran
 */
public class VeTour  {

   
    private ArrayList<VeTourDTO> danhSach = new ArrayList<VeTourDTO>();
    config con = new config();

    public VeTour() {
        this.danhSach = con.layDL_VeTour(); //cach khai bao 1 arrayList
    }

    public VeTourDTO traKH(int i) {
        return danhSach.get(i);
    }

    public VeTourDTO traKH(String maKH) {
        for (VeTourDTO vetour : danhSach) {
            if (maKH.equalsIgnoreCase(vetour.getMavetour())) {
                return vetour;
            }
        }
        return null;
    }

    public Long tinhTongTien(int Sl, String Ma) {
        Tour tour = new Tour();
        for (VeTourDTO veTour : danhSach) {
            System.out.println(veTour.getMatour());

            return Sl * tour.traTour(veTour.getMatour()).getGiaTour();

        }
        return null;
    }

    /*public KhachHang(ArrayList<KhachHang> danhSach) {
    this.danhSach = danhSach;
    }*/
    public void themVeTour(VeTourDTO kh) {
        this.danhSach.add(kh);
    }

    public void themVeTour(String mavetour, String matour, long tiengiam, Date ngaydatve, Date hansudung) {
        VeTourDTO vt = new VeTourDTO(mavetour, matour, tiengiam, ngaydatve, hansudung);
        this.danhSach.add(vt);
        con.UpdateSQL_VeTour(vt, 1, "null");
    }

    //4. Lay ra so luong khach hang trong danh sach
    public int laySoLuongVeTour() {
        return this.danhSach.size();
    }

    //7. Xoa mot khach hang ra khoi danh sach khach hang dua tren ma khach hang
    public boolean xoaVeTour(VeTourDTO kh) {
        return this.danhSach.remove(kh);
    }

    public boolean xoaVeTour(String ma) {
        int i = 0;
        for (VeTourDTO khachHang : danhSach) {
            if (ma.equalsIgnoreCase(khachHang.getMavetour())) {
                this.danhSach.remove(i);
                con.UpdateSQL_VeTour(khachHang, 2, "null");
                return true;
            }
            i++;
        }

        return false;

    }

    public boolean suaVeTour(String maOld, String mavetour, String matour, long tiengiam, Date ngaydatve, Date hansudung) {
        int i = 0;
        for (VeTourDTO khachHang : danhSach) {
            if (maOld.equalsIgnoreCase(khachHang.getMavetour())) {
                this.danhSach.get(i).setMatour(matour);
                this.danhSach.get(i).setTiengiam(tiengiam);
                this.danhSach.get(i).setNgaydatve(ngaydatve);
                this.danhSach.get(i).setHansudung(hansudung);

                con.UpdateSQL_VeTour(this.danhSach.get(i), 3, maOld);

                return true;
            }
            i++;
        }

        return false;

    }

    //8. Tim kiem tat ca khach hang dua tren Ma khach hang duoc nhap tu ban phim
    public void timVeTour(String ma) {
        for (VeTourDTO khachHang : danhSach) {
            if (khachHang.getMavetour().contains(ma));
            System.out.println(khachHang);
        }
    }

    public ArrayList<VeTourDTO> timKhachHangUnlimit(String ma) {
        int i = 0;
        ArrayList<VeTourDTO> dskh = new ArrayList<>();
        for (VeTourDTO khachHang : danhSach) {
            if (khachHang.getMavetour().equalsIgnoreCase(ma)) {
                dskh.add(khachHang);
            }
            if (khachHang.getMatour().equalsIgnoreCase(ma)) {
                dskh.add(khachHang);
            }
            String TienGiam = Long.toString(khachHang.getTiengiam());
            if (TienGiam.equalsIgnoreCase(ma)) {
                dskh.add(khachHang);
            }
            Date ngayDatVe = khachHang.getNgaydatve();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String ngayDatVeString = sdf.format(ngayDatVe);
            if (ngayDatVeString.equalsIgnoreCase(ma)) {
                dskh.add(khachHang);
            }
            Date hansudung = khachHang.getHansudung();
            SimpleDateFormat ccc = new SimpleDateFormat("dd/MM/yyyy");
            String hanSuDung = ccc.format(hansudung);
            if (hanSuDung.equalsIgnoreCase(ma)) {
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
