package demoModule7_exel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File("DemoExel.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("DemoExel.xlsx got created");
	}
}
