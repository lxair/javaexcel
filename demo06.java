package hhh;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.*;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;


public class demo06 {

	
	public static void main(String[] args) throws IOException {
        
		// 读取.txt的文件，测试的是两列数据的更新，x表示第一列，y表示第二列
		List x = new ArrayList();
        List y = new ArrayList();
       String fileName = "C:\\Users\\PC\\Desktop\\Q2Kv2_12b1\\demo.txt";
;
       File file = new File(fileName);
       FileReader fr = new FileReader(file);
       BufferedReader br = new BufferedReader(fr);
       String line;
       System.out.println("Read text file using BufferedReader");
       while ((line = br.readLine()) != null) {
           String[] s =line.split(" ");
           x.add(s[0]);
           y.add(s[1]);
       }
       System.out.println(x);
       System.out.println(y);

       // 这个开始就是excel的操作，先找到excel地址
       String url="C:\\Users\\PC\\Desktop\\Q2Kv2_12b1\\Q2KMasterv2_12b1.xls";
       FileInputStream fs;
       fs = new FileInputStream(url);
       POIFSFileSystem ps=new POIFSFileSystem(fs); //使用POI提供的方法得到excel的信息
       HSSFWorkbook wb=new HSSFWorkbook(ps);
       HSSFSheet sheet=wb.getSheetAt(0); //获取到工作表，因为一个excel可能有多个工作表
       HSSFRow row=sheet.getRow(0);
       int hang = 0;
       FileOutputStream out=new FileOutputStream(url);//向d://test.xls中写数据
       row=sheet.createRow((short)(hang));


       for (int i = 0; i < x.size();i++) {
           //创建list.size()行数据
           row = sheet.createRow(i);
           row.createCell(0).setCellValue((String)x.get(i)); //设置第一个（从0开始）单元格的数据
           row.createCell(1).setCellValue((String)y.get(i));

       }
       out.flush();
       wb.write(out);
       out.close();
   }
}


