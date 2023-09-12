/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import BUS.NhanVien;
import DTO.NhanVienDTO;
import KetnoiSQL_DAL.config;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExcel {

    public void ImportNhanVien() throws InvalidFormatException {
        try {
            /*FileInputStream excelFile = new FileInputStream(new File("Demo-ApachePOI-Excel.xlsx"));*/
            config con = new config();
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            //check result
            File file = chooser.getSelectedFile();
            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            DataFormatter fmt = new DataFormatter();
            Iterator<Row> iterator = datatypeSheet.iterator();
            Row firstRow = iterator.next();
            Cell firstCell = firstRow.getCell(0);
            System.out.println(firstCell.getStringCellValue());
            List<NhanVienDTO> listOfCustomer = new ArrayList<NhanVienDTO>();
            int i = 0;
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                NhanVien customer = new NhanVien();
                customer.traNV(i).setManv(currentRow.getCell(0).getStringCellValue());
                customer.traNV(i).setTennv(currentRow.getCell(1).getStringCellValue());
                customer.traNV(i).setLoainv(currentRow.getCell(2).getStringCellValue());
                customer.traNV(i).setChucvu(currentRow.getCell(3).getStringCellValue());
                customer.traNV(i).setDiachi(currentRow.getCell(4).getStringCellValue());
                listOfCustomer.add(customer.traNV(i));
                i++;
            }
            i = 0;
            for (NhanVienDTO customer : listOfCustomer) {
                System.out.println(customer);
                con.UpdateSQL_NhanVien(customer, 1, "null");
                i++;
            }
            workbook.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
}
