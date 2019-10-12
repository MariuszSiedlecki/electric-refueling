package com.commons.extras;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.commons.Naming.LOCAL_PATH;

public class CreatorXls<T> {

    private Class clazz;

    public CreatorXls(Class clazz) {
        this.clazz = clazz;
    }

    public File createFile(String filename, List<T> series) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(filename);

        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor((short) 10);
        headerFont.setFontHeightInPoints((short) 10);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);

        List<String> columns = new ArrayList<>();
        for (Field f : clazz.getDeclaredFields()) {
            columns.add(f.getName());
        }
        //       columnsTitle.remove(0);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns.get(i));
            cell.setCellStyle(headerStyle);
        }
        for (int i = 0; i < series.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            for (int j = 0; j < columns.size(); j++) {
                HSSFCell cell = row.createCell(j);
                Method method = series
                        .get(i)
                        .getClass()
                        .getMethod("get" + columns
                                .get(j)
                                .substring(0, 1)
                                .toUpperCase() + columns
                                .get(j)
                                .substring(1));
                Object result = method.invoke(series.get(i));
                cell.setCellValue(String.valueOf(result));
            }
        }

        String file = LOCAL_PATH + filename + " " + DateParser.millsToDate(System.currentTimeMillis()) + ".xls";
        workbook.write(new File(file));
        workbook.createSheet();
        return new File(file);
    }
}
