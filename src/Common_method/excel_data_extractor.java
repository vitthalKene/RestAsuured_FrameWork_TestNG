package Common_method;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_data_extractor {
	
	public static int getdata(String FileName, String sheet_name, String tcname) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Vitthal\\OneDrive\\Documents\\"+FileName+".xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);    //to show excel file format
		
		int count=workbook.getNumberOfSheets();
		//System.out.println(count);
		//return count;
		
		for (int i=0; i<count; i++)
		{
			String sheetname=workbook.getSheetName(i);
			System.out.println("SheetName is : " +sheetname);
			
			if (sheetname.equalsIgnoreCase(sheet_name))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				 Iterator<Row> row=sheet.iterator();
			       Row first_row=row.next();
			       Iterator<Cell> cells=first_row.cellIterator();
			
					int j=0;
					int tc_column=0;
					
					while(cells.hasNext())
					{
						Cell cell_value=cells.next();
						System.out.println("Cell Value is : " +cell_value);
						
						if(cell_value.getStringCellValue().equalsIgnoreCase("tc_name"))
								
					{
							tc_column=j;
							System.out.println(tc_column);
					}
						j++;
					}
					while(row.hasNext())
					{
						Row R=row.next();
						   if(R.getCell(tc_column).getStringCellValue().equalsIgnoreCase(tcname))
	                    {
							   Iterator<Cell> cellvalues=R.cellIterator();
	                        while (cellvalues.hasNext())
	                     {
	                    	 String Excel_data=cellvalues.next().getStringCellValue();
	                    	 System.out.println(Excel_data);
	                    	 
	                     }
		                     
					}
			}
			}
		}
	
	return count;
	}

	}
