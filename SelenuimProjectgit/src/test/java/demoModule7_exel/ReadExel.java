package demoModule7_exel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExel {
  @Test
  public void ReadExelSetOfData() throws IOException 
  {
	  File src=new File("C:\\Users\\PDC3A-Training.PDC3A\\Desktop\\Login.xlsx");
      FileInputStream fil=new FileInputStream(src);
      XSSFWorkbook wb=new XSSFWorkbook(fil);
      XSSFSheet sheet1=wb.getSheetAt(0);
      int rowcount=sheet1.getLastRowNum();
      System.out.println("Total number of rows is: "+rowcount);
      
      for(int i=0;i<=rowcount;i++)
      {
    	  String data=sheet1.getRow(i).getCell(0).getStringCellValue();
    	  System.out.println("test data from excel sheet is: "+data);
    	  
    	  String data1=sheet1.getRow(i).getCell(1).getStringCellValue();
    	  System.out.println("test data from excel sheet is: "+data);
      }
      wb.close();
  }
}
