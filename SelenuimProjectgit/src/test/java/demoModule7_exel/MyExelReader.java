package demoModule7_exel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyExelReader 
{
	
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static DataFormatter formatter=new DataFormatter();
public static Object[][] readData() throws IOException
{
	FileInputStream fil=new FileInputStream("C:\\\\Users\\\\PDC3A-Training.PDC3A\\\\Desktop\\\\Login.xlsx");
	workbook=new XSSFWorkbook(fil);
	sheet=workbook.getSheet("Sheet1");
	XSSFRow row=sheet.getRow(0);
	int rownum=sheet.getPhysicalNumberOfRows();
    int colnum=row.getLastCellNum();
    System.out.println("Number of row: "+rownum+"\nNumber of column: "+colnum);
	
	Object[][] data=new Object[rownum-1][colnum];
	
	for(int i=0;i<rownum-1;i++)
	{
		XSSFRow Row=sheet.getRow(i+1);
		for(int j=0;j<colnum;j++)
		{
			XSSFCell cell=Row.getCell(j);
			if(cell==null)
			  data[i][j]="";
			else
			{
				String value=formatter.formatCellValue(cell);
				data[i][j]=value;
			}
			
		}
	}
	return data;	
}
}
