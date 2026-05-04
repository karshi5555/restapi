package rest.pojo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static Map<String, Map<String, String>> testData = new HashMap<>();

	public  static void readExcel() throws EncryptedDocumentException, IOException {
		
		String env = System.getProperty("env");

		String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/"+env+"app.xlsx";

		File file = new File(filePath);

		Workbook wb = WorkbookFactory.create(file);

		Sheet sname = wb.getSheet("admin");

		Row row = sname.getRow(0);

		int noOFROWS = sname.getPhysicalNumberOfRows();

		for (int i = 1; i < noOFROWS; i++) {

			Map<String, String> data = new HashMap<>();

			Row r = sname.getRow(i);

			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {

				String key = getData(row.getCell(j));
				String value = getData(r.getCell(j));

				data.put(key, value);

			}

			testData.put(getData(r.getCell(0)), data);

		}

	}

	public static String getData(Cell cell) {

		DataFormatter df = new DataFormatter();

		return df.formatCellValue(cell);
	}

	public static Map<String, String> getTestData(String methoName) throws EncryptedDocumentException, IOException {

		return testData.get(methoName);
	}
	
	

}
