package rest.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reportUtil {

	private static ExtentReports extent;

	public static ExtentReports loadReport() {

		
		extent = new ExtentReports();

		extent.setSystemInfo("rakshitha", Configuration.getProperty("rakshitha"));
		
		String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
		
		String reportPath = System.getProperty("user.dir") 
			    + "/reports/report_" + time + ".html";
		
		//String file = System.getProperty("user.dir") + "/src/test/resources/reports/" + uniqname + "report.html";

		ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

		extent.attachReporter(spark);

		return extent;

	}
	
	
	

}
