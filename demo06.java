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
        
		// ��ȡ.txt���ļ������Ե����������ݵĸ��£�x��ʾ��һ�У�y��ʾ�ڶ���
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

       // �����ʼ����excel�Ĳ��������ҵ�excel��ַ
       String url="C:\\Users\\PC\\Desktop\\Q2Kv2_12b1\\Q2KMasterv2_12b1.xls";
       FileInputStream fs;
       fs = new FileInputStream(url);
       POIFSFileSystem ps=new POIFSFileSystem(fs); //ʹ��POI�ṩ�ķ����õ�excel����Ϣ
       HSSFWorkbook wb=new HSSFWorkbook(ps);
       HSSFSheet sheet=wb.getSheetAt(0); //��ȡ����������Ϊһ��excel�����ж��������
       HSSFRow row=sheet.getRow(0);
       int hang = 0;
       FileOutputStream out=new FileOutputStream(url);//��d://test.xls��д����
       row=sheet.createRow((short)(hang));


       for (int i = 0; i < x.size();i++) {
           //����list.size()������
           row = sheet.createRow(i);
           row.createCell(0).setCellValue((String)x.get(i)); //���õ�һ������0��ʼ����Ԫ�������
           row.createCell(1).setCellValue((String)y.get(i));

       }
       out.flush();
       wb.write(out);
       out.close();
   }
}


