/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import BUS.NhanVien;
import DTO.NhanVienDTO;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

/**
 *
 * @author PC
 */
public class ExportExcel {

    private static CellStyle cellStyleFormatNumber = null;

    public void ExportNhanVien(NhanVien array) {
        System.out.println("Xuat file excel");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("NhanVien");
        int rowNum = 0;
        Row firstRow = sheet.createRow(rowNum++);
        Cell firstCell = firstRow.createCell(0);
        firstCell.setCellValue("Thong tin nhan vien");

        Row row1 = sheet.createRow(rowNum++);
        Cell cella = row1.createCell(0);
        cella.setCellValue("Mã Nhân Viên");

        Cell cellb = row1.createCell(1);
        cellb.setCellValue("Tên Nhân Viên");

        Cell cellc = row1.createCell(2);
        cellc.setCellValue("Loại Nhân Viên");

        Cell celld = row1.createCell(3);
        celld.setCellValue("Chức vụ");

        Cell celle = row1.createCell(4);
        celle.setCellValue("Địa chỉ");

        for (int i = 0; i < array.laySoLuongNhanVien(); i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(0);
            cell1.setCellValue(array.traNV(i).getManv());

            Cell cell2 = row.createCell(1);
            cell2.setCellValue(array.traNV(i).getTennv());

            Cell cell3 = row.createCell(2);
            cell3.setCellValue(array.traNV(i).getLoainv());

            Cell cell4 = row.createCell(3);
            cell4.setCellValue(array.traNV(i).getDiachi());

            Cell cell5 = row.createCell(4);
            cell5.setCellValue(array.traNV(i).getDiachi());

        }

        try {
            FileOutputStream outputStream = new FileOutputStream("nhanvien.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
        Desktop desktop = Desktop.getDesktop();
        File file = new File("NhanVien.xlsx");
        if (file.exists()) {
            try {
                desktop.open(file);
            } catch (IOException ex) {
                Logger.getLogger(ExportExcel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
