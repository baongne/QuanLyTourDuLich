/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KetnoiSQL_DAL;

import DTO.KhuyenMaiDTO;

import BUS.ChiTietHoaDonVeBUS;

import DTO.KhachHangDTo;

import DTO.TourDTO;

import DTO.ChiTietTourDuLichDTo;
import DTO.DiaDiemDTO;
import DTO.DiaDiemVuiChoiDTo;
import DTO.FeedBack;
import DTO.HoaDonDTO;
import DTO.KhachSanDTO;
import DTO.NhanVienDTO;
import DTO.PhuongTienDTO;
import DTO.TaiKhoan;
import DTO.VeTourDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.ArrayList;

public class config {

    private final String url = "jdbc:mysql://localhost:3306/qltour?useUnicode=yes&characterEncoding=UTF-8&useSSL=false&allowPublicKeyRetrieval=true&zeroDateTimeBehavior=convertToNull";
    private final String user = "root";
    private final String password = "";

    public void Update(String Ma, NhanVienDTO nv) { // theo mã
        String sqlUpdate = "UPDATE nhanvien SET LoaiNV = ?, TenNV = ? , DiaChi = ?,  ChucVu = ? WHERE MaNV = ?;";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = con.prepareStatement(sqlUpdate);
            
            stmt.setString(1, nv.getLoainv());
            stmt.setString(2, nv.getTennv());
            stmt.setString(3, nv.getDiachi());
            stmt.setString(4, nv.getChucvu());
            stmt.setString(5, Ma);
            
            stmt.execute();         
            
        } catch (SQLException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

    public void CheckConnect() {
        try ( Connection con = DriverManager.getConnection(url, user, password)) {
            System.out.println("Thành công");
            System.out.println(con.getCatalog());
        } catch (SQLException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<TaiKhoan> layDL_TK() {
        ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
        // Khởi tạo kết nối đến cơ sở dữ liệu
        try ( Connection con = DriverManager.getConnection(url, user, password)) {

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM taikhoan");

            while (rs.next()) {
                String user = rs.getString("tentaikhoan");
                String password = rs.getString("matkhau");
                String maNV = rs.getString("manv");
                String qtruycap = rs.getString("loaitk");
                TaiKhoan tk = new TaiKhoan(user, password, maNV, qtruycap);
                danhSachTaiKhoan.add(tk);
            }
        } catch (SQLException e) {

        }
        return danhSachTaiKhoan;
    }

    public String layDL_QTC() {
        String s = null;
        try {
            // Khởi tạo kết nối đến cơ sở dữ liệu
            Connection con = DriverManager.getConnection(url, user, password);

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM quyentruycap");

            while (rs.next()) {
                s = rs.getString("MaNV");
            }
        } catch (SQLException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public void UpdateSQL_QTC(int i, String maNV) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO quyentruycap VALUES(?)";
            String selectAll = "SELECT * FROM quyentruycap";
            try {

                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, maNV);

                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (i == 2) { // xóa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM quyentruycap WHERE MaNV = '" + maNV + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void UpdateSQL_HoaDon(HoaDonDTO HoaDon, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO hoadon VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM hoadon";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, HoaDon.getMahd());
                stmt.setString(2, HoaDon.getMakhachdatve());
                stmt.setLong(3, HoaDon.getTongtien());
                java.sql.Date ngaySD = new java.sql.Date(HoaDon.getNgayxuathoadon().getTime());
                stmt.setDate(4, ngaySD);
                stmt.setString(5, HoaDon.getManv());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM hoadon WHERE mahoadon = '" + HoaDon.getMahd() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM hoadon WHERE mahoadon = '" + HoaDon.getMahd() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO hoadon VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM hoadon";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, HoaDon.getMahd());
                stmt.setString(2, HoaDon.getMakhachdatve());
                stmt.setLong(3, HoaDon.getTongtien());
                java.sql.Date ngaySD = new java.sql.Date(HoaDon.getNgayxuathoadon().getTime());
                stmt.setDate(4, ngaySD);
                stmt.setString(5, HoaDon.getManv());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_NhanVien(NhanVienDTO nhanvien, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO nhanvien VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM nhanvien";
            try {

                con = DriverManager.getConnection(url, user, password);

                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getManv());
                stmt.setString(2, nhanvien.getLoainv());
                stmt.setString(3, nhanvien.getTennv());
                stmt.setString(4, nhanvien.getDiachi());
                stmt.setString(5, nhanvien.getChucvu());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);

                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM nhanvien WHERE MaNV = '" + nhanvien.getManv() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

            // crate statement to insert student
        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM nhanvien WHERE MaNV = '" + MaNV_OLD + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO nhanvien VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM nhanvien";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getManv());
                stmt.setString(2, nhanvien.getLoainv());
                stmt.setString(3, nhanvien.getTennv());
                stmt.setString(4, nhanvien.getDiachi());
                stmt.setString(5, nhanvien.getChucvu());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }

        }
    }

    public void UpdateSQL_KhachHang(KhachHangDTo nhanvien, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO khachhang VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM khachhang";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getMakh());
                stmt.setString(2, nhanvien.getTenkh());
                stmt.setString(3, nhanvien.getDiachi());
                stmt.setString(4, nhanvien.getSdt());
                stmt.setString(5, nhanvien.getEmail());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM khachhang WHERE maKh = '" + nhanvien.getMakh() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

            // crate statement to insert student
        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM khachhang WHERE maKh = '" + nhanvien.getMakh() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sqlInsert = "INSERT INTO khachhang VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM khachhang";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getMakh());
                stmt.setString(2, nhanvien.getTenkh());
                stmt.setString(3, nhanvien.getDiachi());
                stmt.setString(4, nhanvien.getSdt());
                stmt.setString(5, nhanvien.getEmail());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_KhachSan(KhachSanDTO nhanvien, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO khachsan VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM khachsan";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getMaKhachSan());
                stmt.setString(2, nhanvien.getTenKhachSan());
                stmt.setString(4, nhanvien.getSdt());
                stmt.setInt(3, (int) nhanvien.getTienKhachSan());
                stmt.setInt(5, (int) nhanvien.getTienPhong());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM khachsan WHERE maks = '" + nhanvien.getMaKhachSan() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

            // crate statement to insert student
        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM khachsan WHERE maks = '" + nhanvien.getMaKhachSan() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

            String sqlInsert = "INSERT INTO khachsan VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM khachsan";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getMaKhachSan());
                stmt.setString(2, nhanvien.getTenKhachSan());
                stmt.setString(4, nhanvien.getSdt());
                stmt.setInt(3, (int) nhanvien.getTienKhachSan());
                stmt.setInt(5, (int) nhanvien.getTienPhong());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_VeTour(VeTourDTO nhanvien, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO ve VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM ve";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getMavetour());
                java.sql.Date ngayDV = new java.sql.Date(nhanvien.getNgaydatve().getTime());
                stmt.setDate(2, ngayDV);
                java.sql.Date ngaySD = new java.sql.Date(nhanvien.getHansudung().getTime());
                stmt.setDate(3, ngaySD);
                stmt.setString(4, nhanvien.getMatour());
                stmt.setLong(5, nhanvien.getTiengiam());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM ve WHERE mave = '" + nhanvien.getMavetour() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM ve WHERE mave = '" + nhanvien.getMavetour() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO ve VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM ve";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, nhanvien.getMavetour());
                java.sql.Date ngayDV = new java.sql.Date(nhanvien.getNgaydatve().getTime());
                stmt.setDate(2, ngayDV);
                java.sql.Date ngaySD = new java.sql.Date(nhanvien.getHansudung().getTime());
                stmt.setDate(3, ngaySD);
                stmt.setString(4, nhanvien.getMatour());

                stmt.setLong(5, nhanvien.getTiengiam());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_PhuongTien(PhuongTienDTO PhuongTien, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO phuongtien VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM phuongtien";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, PhuongTien.getMapt());
                stmt.setString(2, PhuongTien.getLoaipt());
                stmt.setString(3, PhuongTien.getBienso());
                stmt.setLong(4, PhuongTien.getSochocondu());
                stmt.setLong(5, PhuongTien.getTongsocho());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM phuongtien WHERE MaPT = '" + PhuongTien.getMapt() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM phuongtien WHERE MaPT = '" + PhuongTien.getMapt() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO phuongtien VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM phuongtien";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, PhuongTien.getMapt());
                stmt.setString(2, PhuongTien.getLoaipt());
                stmt.setString(3, PhuongTien.getBienso());
                stmt.setLong(4, PhuongTien.getSochocondu());
                stmt.setLong(5, PhuongTien.getTongsocho());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_Tour(TourDTO Tour, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO tour VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String selectAll = "SELECT * FROM tour";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, Tour.getMaTour());
                stmt.setInt(2, Tour.getTongsocho());
                stmt.setInt(3, Tour.getSochodu());
                stmt.setString(4, Tour.getTenTour());
                stmt.setString(5, Tour.getDiaDiemTour());
                stmt.setString(6, Tour.getDiaDiemdi());
                stmt.setString(7, Tour.getDiaDiemden());
                stmt.setString(8, Tour.getLoaiTour());
                stmt.setInt(9, Tour.getSongaydi());

                stmt.setLong(10, Tour.getGiaTour());

                stmt.setString(11, "null");
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM tour WHERE MaTour = '" + Tour.getMaTour() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

            // crate statement to insert student
        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM tour WHERE MaTour = '" + Tour.getMaTour() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Khởi tạo kết nối đến cơ sở dữ liệu
            //1 là thêm
            String sqlInsert = "INSERT INTO tour VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            String selectAll = "SELECT * FROM tour";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, Tour.getMaTour());
                stmt.setInt(2, Tour.getTongsocho());
                stmt.setInt(3, Tour.getSochodu());
                stmt.setString(4, Tour.getTenTour());
                stmt.setString(5, Tour.getDiaDiemTour());
                stmt.setString(6, Tour.getDiaDiemdi());
                stmt.setString(7, Tour.getDiaDiemden());
                stmt.setString(8, Tour.getLoaiTour());
                stmt.setInt(9, Tour.getSongaydi());

                stmt.setLong(10, Tour.getGiaTour());

                stmt.setString(11, "null");
                stmt.execute();
                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public ArrayList<HoaDonDTO> layDL_HoaDon() {
        ArrayList<HoaDonDTO> danhSachHoaDon = new ArrayList<>();
        try {
            // Khởi tạo kết nối đến cơ sở dữ liệu
            Connection con = DriverManager.getConnection(url, user, password);

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hoadon");

            while (rs.next()) {

                String mahd = rs.getString("MaHD");
                String makh = rs.getString("makh");
                long tongtien = Long.parseLong(rs.getString("tongtien"));
                java.sql.Date ngayxuat = rs.getDate("ngayxuathoadon");
                String manv = rs.getString("manv");
                HoaDonDTO HoaDon = new HoaDonDTO(mahd, manv, makh, tongtien, ngayxuat);
                danhSachHoaDon.add(HoaDon);
            }
            return danhSachHoaDon;
        } catch (SQLException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachHoaDon;
    }

    //-----------------------------------------------
    public void UpdateSQL_DDVC(DiaDiemVuiChoiDTo DDVC, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO diadiemvuichoi VALUES(?, ?, ?)";
            String selectAll = "SELECT * FROM diadiemvuichoi";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(3, DDVC.getDiaDiemTour());
                stmt.setString(2, DDVC.getTenDiaDiem());
                stmt.setString(1, DDVC.getMaDiaDiem());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM diadiemvuichoi WHERE MaDDVC = '" + DDVC.getDiaDiemTour() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM diadiemvuichoi WHERE MaDDVC = '" + DDVC.getDiaDiemTour() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO diadiemvuichoi VALUES(?, ?, ?)";
            String selectAll = "SELECT * FROM diadiemvuichoi";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(3, DDVC.getDiaDiemTour());
                stmt.setString(2, DDVC.getTenDiaDiem());
                stmt.setString(1, DDVC.getMaDiaDiem());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_KhuyenMai(KhuyenMaiDTO KhuyenMai, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO khuyenmai VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM khuyenmai";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, KhuyenMai.getMakm());
                stmt.setString(2, KhuyenMai.getTenkm());
                java.sql.Date ngayDi = new java.sql.Date(KhuyenMai.getNgaykm().getTime());
                stmt.setDate(3, ngayDi);
                java.sql.Date ngayVe = new java.sql.Date(KhuyenMai.getHansudung().getTime());
                stmt.setDate(4, ngayVe);
                stmt.setLong(5, KhuyenMai.getTiengiam());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM khuyenmai WHERE MaKhuyenMai = '" + KhuyenMai.getMakm() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM khuyenmai WHERE MaKhuyenMai = '" + KhuyenMai.getMakm() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO khuyenmai VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM khuyenmai";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, KhuyenMai.getMakm());
                stmt.setString(2, KhuyenMai.getTenkm());
                stmt.setDate(3, (Date) KhuyenMai.getNgaykm());
                stmt.setDate(4, (Date) KhuyenMai.getHansudung());
                stmt.setLong(5, KhuyenMai.getTiengiam());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_CTHD(ChiTietHoaDonVeBUS KhuyenMai, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO cthd VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM cthd";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, KhuyenMai.getMaHD());
                stmt.setString(2, KhuyenMai.getMave());
                stmt.setInt(3, KhuyenMai.getSoluongve());
                stmt.setInt(4, (int) KhuyenMai.getTienve());
                stmt.setString(5, KhuyenMai.getMaCTHD());

                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM cthd WHERE MaHD = '" + KhuyenMai.getMaCTHD() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM cthd WHERE MaHD = '" + KhuyenMai.getMaCTHD() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO cthd VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM cthd";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, KhuyenMai.getMaHD());
                stmt.setString(2, KhuyenMai.getMave());
                stmt.setLong(3, KhuyenMai.getSoluongve());
                stmt.setLong(4, KhuyenMai.getTienve());
                stmt.setString(5, KhuyenMai.getMaCTHD());

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_DiaDiem(DiaDiemDTO KhuyenMai, int i, String MaNV_OLD) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO diadiem VALUES(?, ?, ?,?)";
            String selectAll = "SELECT * FROM diadiem";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, KhuyenMai.getMadd());
                stmt.setString(2, KhuyenMai.getTendd());
                stmt.setString(3, KhuyenMai.getThuoctinh());
                stmt.setString(4, KhuyenMai.getKhuvuc());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM diadiem WHERE MaDD = '" + KhuyenMai.getMadd() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM diadiem WHERE MaDD = '" + KhuyenMai.getMadd() + "'";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        String sqlInsert = "INSERT INTO diadiem VALUES(?, ?, ?,?)";
        String selectAll = "SELECT * FROM diadiem";
        try {
            // connect to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            // crate statement to insert student
            PreparedStatement stmt = con.prepareStatement(sqlInsert);
            stmt.setString(1, KhuyenMai.getMadd());
            stmt.setString(2, KhuyenMai.getTendd());
            stmt.setString(3, KhuyenMai.getThuoctinh());
            stmt.setString(4, KhuyenMai.getKhuvuc());
            stmt.execute();

            // select all student
            stmt = con.prepareStatement(selectAll);
            // get data from table 'student'
            ResultSet rs = stmt.executeQuery();
            // show data
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3) + "  " + rs.getString(4));
            }
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            //ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
    }

    public void UpdateSQL_FeedBack(FeedBack fb, int i, String hoten_old) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO feedback VALUES(?, ?, ?,?,?)";
            String selectAll = "SELECT * FROM feedback";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, fb.getHoten());
                stmt.setString(2, fb.getSdt());
                stmt.setString(3, fb.getEmail());
                stmt.setString(4, fb.getDiachi());
                stmt.setString(5, fb.getNoidung());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM feedback WHERE hoten = '" + fb.getHoten() + "';";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM feedback WHERE hoten = '" + fb.getHoten() + "';";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO feedback VALUES(?, ?,?,?,?)";
            String selectAll = "SELECT * FROM feedback";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, fb.getHoten());
                stmt.setString(2, fb.getSdt());
                stmt.setString(3, fb.getEmail());
                stmt.setString(4, fb.getDiachi());
                stmt.setString(5, fb.getNoidung());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                //ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_CTTour(ChiTietTourDuLichDTo fb, int i, String matour_old) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO chitiettour VALUES(?, ?, ?,?,?,?,?,?,?)";
            String selectAll = "SELECT * FROM chitiettour";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, fb.getDdtour());
                stmt.setString(2, fb.getMatour());
                stmt.setString(3, fb.getMaks());
                stmt.setString(4, fb.getNoiden());
                stmt.setString(5, fb.getKhoihanh());
                stmt.setInt(6, fb.getThutungay());
                stmt.setLong(7, fb.getTienan());
                stmt.setLong(8, fb.getTienphong());
                stmt.setLong(9, fb.getPhidichvu());

                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + rs.getString(6) + "  " + rs.getString(7) + "  " + rs.getString(8) + "  " + rs.getString(9));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM chitiettour WHERE MaTour = '" + fb.getMatour() + "';";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM chitiettour WHERE MaTour = '" + fb.getMatour() + "';";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO chitiettour VALUES(?, ?, ?,?,?,?,?,?,?)";
            String selectAll = "SELECT * FROM chitiettour";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, fb.getDdtour());
                stmt.setString(2, fb.getMatour());
                stmt.setString(3, fb.getMaks());
                stmt.setString(4, fb.getNoiden());
                stmt.setString(5, fb.getKhoihanh());
                stmt.setInt(6, fb.getThutungay());
                stmt.setLong(7, fb.getTienan());
                stmt.setLong(8, fb.getTienphong());
                stmt.setLong(9, fb.getPhidichvu());

                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + rs.getString(6) + "  " + rs.getString(7) + "  " + rs.getString(8) + "  " + rs.getString(9));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void UpdateSQL_TaiKhoan(TaiKhoan tk, int i, String matkhau_old) {
        // Khởi tạo kết nối đến cơ sở dữ liệu
        Connection con;
        //1 là thêm
        if (i == 1) {
            String sqlInsert = "INSERT INTO taikhoan(tentaikhoan, matkhau, manv, loaitk) VALUES(?, ?, ?,?)";
            String selectAll = "SELECT * FROM taikhoan";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, tk.getMatk());
                stmt.setString(2, tk.getMatkhau());
                stmt.setString(3, tk.getEmail());
                stmt.setString(4, tk.getQuyentruycap());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (i == 2) { // xóa                      
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM taikhoan WHERE matkhau = '" + tk.getMatkhau() + "';";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (i == 3) {//sửa
            try {

                con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                String delete = "DELETE FROM taikhoan WHERE matkhau = '" + tk.getMatkhau() + "';";
                stmt.executeUpdate(delete);
            } catch (SQLException ex) {
                Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
            }
            String sqlInsert = "INSERT INTO taikhoan VALUES(?, ?, ?,?)";
            String selectAll = "SELECT * FROM taikhoan";
            try {
                // connect to database
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);

                // crate statement to insert student
                PreparedStatement stmt = con.prepareStatement(sqlInsert);
                stmt.setString(1, tk.getMatk());
                stmt.setString(2, tk.getMatkhau());
                stmt.setString(3, tk.getEmail());
                stmt.setString(4, tk.getQuyentruycap());
                stmt.execute();

                // select all student
                stmt = con.prepareStatement(selectAll);
                // get data from table 'student'
                ResultSet rs = stmt.executeQuery();
                // show data
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2)
                            + "  " + rs.getString(3) + "  " + rs.getString(4));
                }
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //--------------------------------------------------------
    public ArrayList<KhuyenMaiDTO> layDL_KhuyenMai() {
        ArrayList<KhuyenMaiDTO> danhSachTaiKhoan = new ArrayList<>();

        // Khởi tạo kết nối đến cơ sở dữ liệu
        try ( Connection con = DriverManager.getConnection(url, user, password)) {

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM khuyenmai");
            while (rs.next()) {
                String MAKM = rs.getString("MaKhuyenMai");
                String TENKM = rs.getString("TenKM");
                Date NGAYKM = rs.getDate("NgayKM");
                Date HANSD = rs.getDate("HanSuDung");
                long TIENGIAM = rs.getLong("TienGiam");

                KhuyenMaiDTO km = new KhuyenMaiDTO(MAKM, TENKM, NGAYKM, HANSD, TIENGIAM);
                danhSachTaiKhoan.add(km);
            }
        } catch (SQLException e) {

        }
        return danhSachTaiKhoan;
    }

    public ArrayList<VeTourDTO> layDL_VeTour() {
        ArrayList<VeTourDTO> danhSachVeTour = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ve");

            while (rs.next()) {

                String mavt = rs.getString("MaVe");
                String maTour = rs.getString("MaTour");
                Date hansudung = rs.getDate("HanSuDung");
                Date ngayTaove = rs.getDate("NgayTaoVe");
                long tiengiam = rs.getLong("tiengiam");
                VeTourDTO vt = new VeTourDTO(mavt, maTour, tiengiam, ngayTaove, hansudung);
                danhSachVeTour.add(vt);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachVeTour;
    }

    //--------------------------------------------------------------------
    public ArrayList<NhanVienDTO> layDL_NhanVien() {
        ArrayList<NhanVienDTO> danhSachNhanVien = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nhanvien");

            while (rs.next()) {

                String manv = rs.getString("MaNV");
                String tennv = rs.getString("TenNV");
                String loainv = rs.getString("LoaiNV");
                String diachi = rs.getString("DiaChi");
                String chucvu = rs.getString("ChucVu");

                NhanVienDTO pt = new NhanVienDTO(tennv, manv, diachi,loainv, chucvu); // tao ra dữ liệu con 
                danhSachNhanVien.add(pt); // add dữ liệu con vào arraylist
            }

        } catch (SQLException ex) {
            Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachNhanVien;
    }

    public ArrayList<TourDTO> layDL_Tour() {
        ArrayList<TourDTO> danhSachTour = new ArrayList<>();

        // Khởi tạo kết nối đến cơ sở dữ liệu
        try ( Connection con = DriverManager.getConnection(url, user, password)) {

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tour");

            while (rs.next()) {
                String MaTour = rs.getString("MaTour");
                int tongSocho = rs.getInt("TongSoCho");
                int soChodu = rs.getInt("SoChoConTrong");
                String TenTour = rs.getString("TenTour");
                String diadiemTour = rs.getString("DiaDiemTour");
                String diaDiemDi = rs.getString("DiaDiemDi");
                String ddDen = rs.getString("DiaDiemDen");
                String LoaiTour = rs.getString("LoaiTour");
                int Songaydi = rs.getInt("SoNgay");

                long GiaTour = rs.getLong("GiaTour");

                TourDTO tour = new TourDTO(TenTour, MaTour, LoaiTour, tongSocho, soChodu, diadiemTour, diaDiemDi, ddDen, Songaydi, GiaTour);
                danhSachTour.add(tour);
            }
        } catch (SQLException e) {

        }
        return danhSachTour;
    }

    public ArrayList<PhuongTienDTO> layDL_PhuongTien() {
        // Khởi tạo kết nối đến cơ sở dữ liệu

        ArrayList<PhuongTienDTO> danhSachTour = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM phuongtien");

            while (rs.next()) {

                String Mapt = rs.getString("MaPT");
                String Loaipt = rs.getString("LoaiPT");
                String Tenpt = rs.getString("TenPT");
                long Tongsocho = rs.getLong("SoChoTrong");
                long Sochodu = rs.getLong("SoChoConDu");

                PhuongTienDTO pt = new PhuongTienDTO(Mapt, Loaipt, Tenpt, Tongsocho, Sochodu);
                danhSachTour.add(pt);
            }
        } catch (SQLException e) {

        }
        return danhSachTour;
    }

    public ArrayList<KhachHangDTo> layDL_KhachHang() {
        ArrayList<KhachHangDTo> danhSachTour = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {

            // Thực hiện truy vấn và lấy kết quả
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM khachhang");

            while (rs.next()) {

                String makh = rs.getString("MaKh");
                String ten = rs.getString("TenKh");
                String diachi = rs.getString("DiaChi");
                String sdt = Integer.toString(rs.getInt("SDT"));
                String email = rs.getString("email");

                KhachHangDTo pt = new KhachHangDTo(ten, makh, diachi, sdt, email); // tao ra dữ liệu con 
                danhSachTour.add(pt); // add dữ liệu con vào arraylist
            }

        } catch (SQLException ex) {
            //Logger.getLogger(config.class.getName()).log(Level.SEVERE, null, ex);
        }
        return danhSachTour;
    }

    public ArrayList<FeedBack> LayDL_Feedback() {
        ArrayList<FeedBack> danhSachFB = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM feedback");
            while (rs.next()) {

                String hten = rs.getString("hoten");
                String sodt = rs.getString("sdt");
                String email = rs.getString("email");
                String dchi = rs.getString("diachi");
                String ndung = rs.getString("noidung");

                FeedBack fb = new FeedBack(hten, email, sodt, dchi, ndung);
                danhSachFB.add(fb);
            }
        } catch (SQLException ex) {

        }
        return danhSachFB;
    }

    public ArrayList<KhachSanDTO> LayDL_KhachSan() {
        ArrayList<KhachSanDTO> danhSachKH = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM khachsan");
            while (rs.next()) {
                String maKS = rs.getString("MaKS");
                String tenKS = rs.getString("TenKS");
                long tienKS = rs.getLong("TienKS");
                String soDT = rs.getString("SDT");
                long tienPhong = rs.getLong("TienPhong");

                KhachSanDTO ks = new KhachSanDTO(tenKS, soDT, tienKS, tienPhong, maKS);
                danhSachKH.add(ks);
            }
        } catch (SQLException ex) {

        }
        return danhSachKH;
    }

    public ArrayList<DiaDiemVuiChoiDTo> LayDL_DiaDiemVuiChoi() {
        ArrayList<DiaDiemVuiChoiDTo> DiaDiemVuiChoi = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM diadiemvuichoi");
            while (rs.next()) {

                String maddvc = rs.getString("MaDDVC");
                String tenddvc = rs.getString("TenDDVC");
                String diadiemTour = rs.getString("ThuocDiaDiemTour");
                DiaDiemVuiChoiDTo fb = new DiaDiemVuiChoiDTo(diadiemTour, tenddvc, maddvc);
                DiaDiemVuiChoi.add(fb);
            }
        } catch (SQLException ex) {

        }
        return DiaDiemVuiChoi;
    }

    public ArrayList<DiaDiemDTO> LayDL_DiaDiem() {
        ArrayList<DiaDiemDTO> dd = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM diadiem");
            while (rs.next()) {
                String maDD = rs.getString("MaDD");
                String tenDD = rs.getString("TenDD");
                String thuocTinh = rs.getString("ThuocTinh");
                String khuVuc = rs.getString("KhuVuc");

                DiaDiemDTO fb = new DiaDiemDTO(maDD, tenDD, thuocTinh, khuVuc);
                dd.add(fb);
            }
        } catch (SQLException ex) {

        }
        return dd;
    }

    public ArrayList<ChiTietHoaDonVeBUS> LayDL_CTHD() {
        ArrayList<ChiTietHoaDonVeBUS> dd = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cthd");
            while (rs.next()) {

                String Mahoadon = rs.getString("MaHD");
                String maVe = rs.getString("MaVe");
                int sluong = rs.getInt("SoLuongVe");
                long tVe = rs.getLong("TienVe");
                String Machitiethoadon = rs.getString("maCTHD");

                ChiTietHoaDonVeBUS fb = new ChiTietHoaDonVeBUS(maVe, Mahoadon, Machitiethoadon, sluong, tVe);
                dd.add(fb);
            }
        } catch (SQLException ex) {

        }
        return dd;
    }

    public ArrayList<ChiTietTourDuLichDTo> LayDL_CTTour() {
        ArrayList<ChiTietTourDuLichDTo> dsTour = new ArrayList<>();
        try ( Connection con = DriverManager.getConnection(url, user, password)) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM chitiettour");
            while (rs.next()) {

                String ddTour = rs.getString("DiaDiemTour");
                String MaTour = rs.getString("MaTour");
                String khoiHanh = rs.getString("DiaDiemKhoiHanh");
                String noiDen = rs.getString("DiaDiemDen");
                int thuTuNgay = rs.getInt("ThuTuNgay");
                String maKS = rs.getString("MaKS");
                long tienAn = rs.getLong("TienAn");
                long tienPhong = rs.getLong("TienPhong");
                long phiDV = rs.getLong("TienDichVu");

                ChiTietTourDuLichDTo ctt = new ChiTietTourDuLichDTo(ddTour, MaTour, khoiHanh, noiDen, thuTuNgay, maKS, tienAn, tienPhong, phiDV);

                dsTour.add(ctt);
            }
        } catch (SQLException ex) {

        }
        return dsTour;
    }

}
