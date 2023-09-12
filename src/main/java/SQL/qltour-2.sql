-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 20, 2023 lúc 06:36 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qltour`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiettour`
--

CREATE TABLE `chitiettour` (
  `DiaDiemTour` text NOT NULL,
  `MaTour` text NOT NULL,
  `MaKS` text NOT NULL,
  `DiaDiemDen` text NOT NULL,
  `DiaDiemKhoiHanh` text NOT NULL,
  `ThuTuNgay` int(11) NOT NULL,
  `TienAn` int(11) NOT NULL,
  `TienPhong` int(11) NOT NULL,
  `TienDichVu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `chitiettour`
--

INSERT INTO `chitiettour` (`DiaDiemTour`, `MaTour`, `MaKS`, `DiaDiemDen`, `DiaDiemKhoiHanh`, `ThuTuNgay`, `TienAn`, `TienPhong`, `TienDichVu`) VALUES
('Miền Trung - Đà Nẵng', 'CTT0004', 'KS0004', 'Đà Nẵng', 'Thành phố Hồ Chí Minh', 6, 3000000, 2000000, 5000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthd`
--

CREATE TABLE `cthd` (
  `MaHD` text NOT NULL,
  `MaVe` text NOT NULL,
  `SoLuongVe` int(11) NOT NULL,
  `TienVe` int(11) NOT NULL,
  `maCTHD` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `cthd`
--

INSERT INTO `cthd` (`MaHD`, `MaVe`, `SoLuongVe`, `TienVe`, `maCTHD`) VALUES
('10011', 'manh123', 1, 0, ''),
('CTHD002', 'VT0004', 1, 905321652, 'HD001'),
('CTHD003', 'VT0004', 2, 905444634, 'HD001'),
('CTHD004', 'VT0004', 2, 905612215, 'HD001'),
('CTHD005', 'VT0004', 123, 905820840, 'HD001'),
('CTHD006', 'VT0004', 1, 905966324, 'HD001'),
('CTHD007', 'VT0004', 1, 906490751, 'HD001'),
('CTHD008', 'VT0004', 2, 906812748, 'HD001'),
('CTHD008', 'VT0004', 1, 906909673, 'HD002'),
('CTHD0010', 'VT0004', 1, 908371029, 'HD002'),
('CTHD0011', 'VT0004', 1, 100000, 'HD002'),
('CTHD0012', 'VT0004', 1, 100000, 'HD002'),
('CTHD0013', 'VT0004', 1, 100000, 'HD002'),
('CTHD0014', 'VT0004', 1, 100000, 'HD002'),
('CTHD0015', 'VT0004', 1, 100000, 'HD002'),
('CTHD0016', 'VT0004', 1, 100000, 'HD002'),
('CTHD0017', 'VT0004', 2, 100000, 'HD002'),
('CTHD0018', 'VT0004', 12, 100000, 'HD002'),
('CTHD0019', 'VT0004', 1, 100000, 'HD003'),
('CTHD0020', 'VT0004', 1, 100000, 'HD004'),
('CTHD0021', 'VT0004', 1, 100000, 'HD004'),
('CTHD0022', 'VT0004', 2, 100000, 'HD006'),
('CTHD0023', 'VT0004', 123123, 100000, 'HD007'),
('CTHD0024', 'VT0004', 1, 100000, 'HD007'),
('CTHD0025', 'VT0004', 3, 100000, 'HD008'),
('CTHD0026', 'VT0004', 123123, 100000, 'HD009'),
('CTHD0027', 'VT0004', 2, 100000, 'HD009');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diadiem`
--

CREATE TABLE `diadiem` (
  `MaDD` int(11) NOT NULL,
  `TenDD` text NOT NULL,
  `ThuocTinh` text NOT NULL,
  `KhuVuc` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `diadiem`
--

INSERT INTO `diadiem` (`MaDD`, `TenDD`, `ThuocTinh`, `KhuVuc`) VALUES
(0, '[Bà Rịa- Vũng Tàu]', '[TP Hồ Chí Minh]', '[Miền Nam]');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `diadiemvuichoi`
--

CREATE TABLE `diadiemvuichoi` (
  `MaDDVC` int(11) NOT NULL,
  `TenDDVC` text NOT NULL,
  `ThuocDiaDiemTour` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `feedback`
--

CREATE TABLE `feedback` (
  `hoten` text DEFAULT NULL,
  `sdt` text DEFAULT NULL,
  `email` text DEFAULT NULL,
  `diachi` text DEFAULT NULL,
  `noidung` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `feedback`
--

INSERT INTO `feedback` (`hoten`, `sdt`, `email`, `diachi`, `noidung`) VALUES
(NULL, NULL, NULL, NULL, NULL),
('Lê Ngọc Chấn', '0917339754', 'chan@gmail.com', 'Phú Nhuận', 'Chưa bao giờ đi một cái công ty nào tuyệt vời như vậy '),
(NULL, NULL, NULL, NULL, NULL),
('Lê Thị Khánh Trâm', '0917338654', 'tram@gmail.com', 'Quận 10', 'Dịch vụ còn quá kém'),
(NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` text NOT NULL,
  `MaKh` text NOT NULL,
  `TongTien` int(11) NOT NULL,
  `NgayXuatHoaDon` date NOT NULL,
  `MaNV` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaKh`, `TongTien`, `NgayXuatHoaDon`, `MaNV`) VALUES
('HD001', '0001230', 15000, '2023-05-20', '00012'),
('HD002', 'KH0031', 1200000, '2023-05-20', '1121'),
('HD003', 'KH0032', 100000, '2023-05-20', '1121'),
('HD004', 'KH0033', 100000, '2023-05-20', '1121'),
('HD004', 'KH0034', 100000, '2023-05-20', '1121'),
('HD006', 'KH0035', 200000, '2023-05-20', '1121'),
('HD007', 'KH0037', 100000, '2023-05-20', '1121'),
('HD008', 'KH0038', 300000, '2023-05-20', '1121');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `huongdanvien`
--

CREATE TABLE `huongdanvien` (
  `MaNV` text NOT NULL,
  `MaTour` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachhang`
--

CREATE TABLE `khachhang` (
  `MaKh` text NOT NULL,
  `TenKh` text NOT NULL,
  `DiaChi` text NOT NULL,
  `SDT` int(11) NOT NULL,
  `email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khachsan`
--

CREATE TABLE `khachsan` (
  `MaKS` text NOT NULL,
  `TenKS` text NOT NULL,
  `TienKS` int(11) NOT NULL,
  `SDT` int(11) NOT NULL,
  `TienPhong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `khachsan`
--

INSERT INTO `khachsan` (`MaKS`, `TenKS`, `TienKS`, `SDT`, `TienPhong`) VALUES
('KS0001', 'Paloma Hotel', 1000000, 917339863, 200000),
('KS0004', 'Eden Garden Hotel', 3000000, 917339654, 400000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKhuyenMai` text NOT NULL,
  `TenKM` text NOT NULL,
  `NgayKM` date NOT NULL,
  `HanSuDung` date NOT NULL,
  `TienGiam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` text NOT NULL,
  `LoaiNV` text NOT NULL,
  `TenNV` text NOT NULL,
  `DiaChi` text NOT NULL,
  `ChucVu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `LoaiNV`, `TenNV`, `DiaChi`, `ChucVu`) VALUES
('NV0001', 'Nhân Viên Bán Hàng', 'Võ Công Anh', 'Quận 10', 'Nhân Viên'),
('NV0002', 'Quản Lý Kho', 'Trần Đức Thanh', 'Quận 4', 'Quản Lý'),
('NV0003', 'Nhân Viên Bán Hàng', 'Nguyễn Hữu Quốc Bảo', 'Bình Tân', 'Nhân Viên'),
('NV0004', 'Nhân Viên Bán Hàng', 'Nguyễn Văn Mạnh', 'Quận 7', 'Quản Lý');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phuongtien`
--

CREATE TABLE `phuongtien` (
  `MaPT` text NOT NULL,
  `LoaiPT` text NOT NULL,
  `TenPT` text NOT NULL,
  `SoChoTrong` int(11) NOT NULL,
  `SoChoConDu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `phuongtien`
--

INSERT INTO `phuongtien` (`MaPT`, `LoaiPT`, `TenPT`, `SoChoTrong`, `SoChoConDu`) VALUES
('PT0001', 'Xe Bus', 'A01', 31, 2),
('PT0002', 'Máy Bay', 'A02', 30, 3),
('PT0003', 'Xe Lửa', 'A03', 40, 3),
('PT0004', 'Thuyền', 'A04', 32, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quyentruycap`
--

CREATE TABLE `quyentruycap` (
  `MaNV` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `quyentruycap`
--

INSERT INTO `quyentruycap` (`MaNV`) VALUES
('1121');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `tentaikhoan` text NOT NULL,
  `matkhau` text NOT NULL,
  `manv` text NOT NULL,
  `loaitk` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`tentaikhoan`, `matkhau`, `manv`, `loaitk`) VALUES
('admin', '123456', '1121', 'admin'),
('thanhtran', 'Thanh12345', '123', 'Nhân Viên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tour`
--

CREATE TABLE `tour` (
  `MaTour` text CHARACTER SET utf8 COLLATE utf8_vietnamese_ci NOT NULL,
  `TongSoCho` int(11) NOT NULL,
  `SoChoConTrong` int(11) NOT NULL,
  `TenTour` text NOT NULL,
  `Diadiemtour` text NOT NULL,
  `DiaDiemDi` text NOT NULL,
  `DiaDiemDen` text NOT NULL,
  `LoaiTour` text NOT NULL,
  `SoNgay` int(11) NOT NULL,
  `GiaTour` int(11) NOT NULL,
  `GhiChu` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `tour`
--

INSERT INTO `tour` (`MaTour`, `TongSoCho`, `SoChoConTrong`, `TenTour`, `Diadiemtour`, `DiaDiemDi`, `DiaDiemDen`, `LoaiTour`, `SoNgay`, `GiaTour`, `GhiChu`) VALUES
('Tour0001', 32, 2, 'Hồ Chí Minh - Đà Nẵng', 'Miền Trung -  Đà Nẵng', 'Hồ Chí Minh', 'Đà Nẵng', 'Tour Tham Quan', 10, 1000000, 'null'),
('Tour0002', 40, 3, 'Hồ Chí Minh', 'Miền Trung - Huế', 'Hồ Chí Minh', 'Huế', 'Tour Ẩm Thực', 15, 5000000, 'null');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ve`
--

CREATE TABLE `ve` (
  `MaVe` text NOT NULL,
  `NgayTaoVe` date NOT NULL,
  `HanSuDung` date NOT NULL,
  `MaTour` text NOT NULL,
  `tiengiam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ve`
--

INSERT INTO `ve` (`MaVe`, `NgayTaoVe`, `HanSuDung`, `MaTour`, `tiengiam`) VALUES
('VT0001', '2023-02-02', '2023-03-04', 'Tour0001', 200000),
('VT0002', '2023-04-03', '2023-04-06', 'Tour0002', 300000),
('VT0003', '2023-05-05', '2023-06-06', 'Tour0003', 50000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cthd`
--
ALTER TABLE `cthd`
  ADD KEY `FK_MaHD` (`MaHD`(768));

--
-- Chỉ mục cho bảng `diadiem`
--
ALTER TABLE `diadiem`
  ADD PRIMARY KEY (`MaDD`);

--
-- Chỉ mục cho bảng `diadiemvuichoi`
--
ALTER TABLE `diadiemvuichoi`
  ADD PRIMARY KEY (`MaDDVC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
