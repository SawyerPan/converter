package com.sawyer.tools.converter.json;

import com.alibaba.fastjson.JSONReader;
import com.sawyer.tools.converter.AbstractConverter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Description.
 *
 * @author sawyer
 * Created at 2018/11/22 22:28
 * @version com.sawyer.tools.converter.json.Json2ExcelConverter v0.1
 */
public class Json2ExcelConverter extends AbstractConverter {
    @SuppressWarnings("unchecked")
    @Override
    protected void doExecute(String inputFileName, String outputFileName) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.LEFT);
        HSSFSheet sheet = wb.createSheet("Output");

        InputStream inputStream = new FileInputStream(inputFileName);
        JSONReader reader = new JSONReader(new InputStreamReader(inputStream));
        reader.startObject();

        int row = 0;
        while (reader.hasNext()) {
            HSSFRow hssfRow = sheet.createRow(row);
            String key = reader.readString();
            Object val = reader.readObject();
            int col = 0;
            HSSFCell cell = hssfRow.createCell(col);
            cell.setCellValue(key);
            cell.setCellStyle(style);

            col++;
            if (val instanceof Map) {
                for (Map.Entry entry : ((Map<String, String>)val).entrySet()) {
                    cell = hssfRow.createCell(col);
                    cell.setCellValue(String.valueOf(entry.getValue()));
                    cell.setCellStyle(style);
                    col++;
                }
            }

            row++;
        }
        reader.endObject();

        FileOutputStream outputStream = new FileOutputStream(outputFileName);
        wb.write(outputStream);
        outputStream.close();
    }
}
