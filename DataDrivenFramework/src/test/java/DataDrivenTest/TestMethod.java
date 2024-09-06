package DataDrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;


public class TestMethod {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String values;
		double phone;boolean bool;
		
String Filepath=System.getProperty("user.dir")+"\\Test-Data\\TutorialsNinja.xlsx";
File FileInput=new File(Filepath);
FileInputStream fis=new FileInputStream(FileInput);
XSSFWorkbook xsf=new XSSFWorkbook(fis);
XSSFSheet sheet = xsf.getSheet("TestCases");
//int i=0,j=0;
//Iterator<Row> rows=sheet.iterator();
int rowscount=sheet.getLastRowNum();
int colscount=sheet.getRow(1).getLastCellNum();
Object[][] data=new Object[rowscount][colscount];
int rownumber=data.length;
int colnumber=data[0].length;

System.out.println("Row number is"+rownumber+'\n'+"Column number is"+colnumber);
System.out.println("Row number is"+rowscount+'\n'+"Column number is"+colscount);
for(int i=0;i<rowscount;i++) {
	XSSFRow rows=sheet.getRow(i);
	for (int j=0;j<colscount;j++)
	{
		XSSFCell Celldata=rows.getCell(j);
	CellType data2 = Celldata.getCellType();
		switch(data2) {
		
		case STRING:
			 values=Celldata.getStringCellValue();
			System.out.print(Celldata.getStringCellValue()+ " ");
			data[i][j]=values;
		break;
		case NUMERIC: 
			 phone=Celldata.getNumericCellValue();
			System.out.print(Celldata.getNumericCellValue()+ " ");
			data[i][j]=phone;
		break;
		case BOOLEAN: 
			 bool=Celldata.getBooleanCellValue();
			System.out.print(Celldata.getBooleanCellValue()+ " ");
			 data[i][j]=bool;
		break;
		
		}
		
	}
	System.out.println();System.out.println();
}
System.out.println("Values present in the Object values");
for(int i=0;i<rownumber;i++)
{
	for(int j=0;j<colnumber;j++) {
		System.out.print(data[i][j]+" ");
	}
	System.out.println();
}
}

	
}
