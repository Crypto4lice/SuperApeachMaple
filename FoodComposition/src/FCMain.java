import java.awt.Button;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FCMain {

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		// TODO Auto-generated method stub
		
		GraphicUI gui = new GraphicUI();
		
		gui.createFrame();
		
		
		
		HashMap<String,String[]> foodMap = new HashMap<String,String[]>();
		InsertHash foodHash = new InsertHash();
		
		
		//long midt=0;
		FileInputStream fis = new FileInputStream("food.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex=0;
		int columnindex=0;
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		//long startt = System.currentTimeMillis();
		
		int rows = sheet.getPhysicalNumberOfRows();
		//System.out.println(rows); 5785
		for(rowindex=5;rowindex<5515;rowindex=rowindex+2) {  //5515����.
			XSSFRow row = sheet.getRow(rowindex);
			if(row != null) {
				int cells = row.getPhysicalNumberOfCells();
				String[] lineValue = new String[cells]; //���� �� ���� String�迭
				
				for(columnindex=0;columnindex<=cells;columnindex++) {
					XSSFCell cell = row.getCell(columnindex);
					String value = "";  // �� ��ĭ ���� (���� ���� X)
					if(cell == null) {
						continue;
					} else {
						switch(cell.getCellType()) {
						case XSSFCell.CELL_TYPE_FORMULA:
							value = cell.getCellFormula();
							break;
						case XSSFCell.CELL_TYPE_NUMERIC:
							value = cell.getNumericCellValue()+"";
							break;
						case XSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue()+"";
							break;
						case XSSFCell.CELL_TYPE_BLANK:
							value = cell.getBooleanCellValue()+"";
							break;
						case XSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue()+"";
							break;
						}
					}
					// �� ��ġ���� ������ ��� ��Ʈ�� �迭�� �Ѽ��� �־���
					//if(rowindex == 15) {
					//	System.out.println("cell : "+value);
						//midt = System.currentTimeMillis();
					//}
					lineValue[columnindex] = value;
					
				}
				//�� ��ġ���� �ؽ���(foodMap)�� put����.   (�ؽ� �߰� �Լ� ����ٰ�)
				foodHash.inputHash(foodMap, lineValue);
				
			}
			
		}
		
		
		Scanner s = new Scanner(System.in);
		
		String name;
		double gram;
		
		while(true) {
			
			System.out.print("input name : ");
			name = s.nextLine();
			
			System.out.print("input gram : ");
			gram = s.nextDouble();
			
			
			ArrayList<String[]> searchRes = foodHash.search(foodMap, name);
			
			ArrayList<ArrayList<Double>> numRes = foodHash.convertNum(searchRes, gram);
			for(int j=0;j<numRes.size();j++) {
				for(int i=0;i<numRes.get(j).size();i++) {
					System.out.print(numRes.get(j).get(i) + ", ");
				}
				System.out.println();
			}
		}
			
		//long endt = System.currentTimeMillis();
		//System.out.println("end");
		
		//System.out.println("middle : " + (midt - startt)/1000.0
		//		+ "end : " + (endt - startt)/1000.0);
		
		
		
		
	}
	
	
	

}
