package BUS;

import DTO.TaiKhoan;
import GiaodienUI.BieuMauHoaDon;
import GiaodienUI.DatVeTour;
import GiaodienUI.Main;

import GiaodienUI.login;
import KetnoiSQL_DAL.config;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.PopupMenu;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.management.MBeanAttributeInfo;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModuleXuLy {

    config setup = new config();
    

   
    public boolean login(String matk, String matkhau) throws SQLException {
        
        ArrayList<TaiKhoan> danhSachTaiKhoan = setup.layDL_TK();
        TaiKhoan input = new TaiKhoan(matk, matkhau);

        for (int i = 0; i < danhSachTaiKhoan.size(); i++) {
            if (danhSachTaiKhoan.get(i).getMatk().equals(input.getMatk()) == true) {
                if (danhSachTaiKhoan.get(i).getMatkhau().equals(input.getMatkhau()) == true) {
                    danhSachTaiKhoan.get(i).getEmail();
                    setup.UpdateSQL_QTC(1, danhSachTaiKhoan.get(i).getEmail());
                    
                    return true;
                             
                }

            }
        }
        return false;
    }

    public void chuyenFrame(JFrame mot) {
        Main main = new Main();
        main.setVisible(true);
        mot.setVisible(false);

    }

    public void dangXuat(JFrame mot) {
        String a = setup.layDL_QTC();
        setup.UpdateSQL_QTC(2, a);
        login main = new login();
        main.setVisible(true);
        mot.setVisible(false);

    }

    public void chuyenFrameMuaVe(String MaHD, String MaVeTour, String MaKH, String MaTour,int Sl, int flat) {
        JFrame frame = new JFrame();
        JFrame frame1 = new JFrame();
        
        String manv= setup.layDL_QTC();
        HoaDon hd = new HoaDon();
        ChiTietHoaDonVeBUS cthd = new ChiTietHoaDonVeBUS();
        VeTour vt = new VeTour();
        Tour tour = new Tour();
        KhachHang kh = new KhachHang();
        
        System.out.println(manv);
        if (flat == 0) {
            DatVeTour dvt = new DatVeTour(MaHD, MaVeTour);
            System.out.println(MaHD);
            frame.add(dvt);
            frame.setLocation(100, 100); // đặt vị trí
            frame.setSize(930, 580); // đặt kích thước
            frame.setVisible(true);

        } else if (flat == 1) {
            frame.setVisible(false);
            
            long millis = System.currentTimeMillis();

            // creating a new object of the class Date  
            Date date1 = new Date(millis);  
            
            hd.themHoaDon(MaHD,manv , MaKH, (tour.traTour(vt.traKH(MaVeTour).getMatour()).getGiaTour())*Sl, date1);
            
            
            Date date = hd.traHD(MaHD).getNgayxuathoadon();
            System.out.println(date);
            Calendar calendar = Calendar.getInstance();
            calendar.set(date.getYear(), date.getMonth(), date.getDate());
            Date ngayDiDate = calendar.getTime();

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String ngayDiString = dateFormat.format(ngayDiDate);
            
            long tong = Sl*tour.traTour(MaTour).getGiaTour();
            BieuMauHoaDon bmhd = new BieuMauHoaDon(MaHD, manv, MaKH,ngayDiString, MaVeTour,MaTour,Sl, vt.traKH(MaVeTour).getTiengiam(),tong );
            frame1.add(bmhd);
            frame1.setLocation(100, 100); // đặt vị trí
            frame1.setSize(930, 580); // đặt kích thước
            frame1.setVisible(true);

        }
        else if (flat == 2) {
            
            frame1.setVisible(false);

        }
    }

}
