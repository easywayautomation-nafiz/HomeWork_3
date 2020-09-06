package Assignment_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static WebDriver Driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("file:///C:/Users/nafiz/Documents/Home_Work_DynamicTable/DynamicWebTable.html");
		driver.findElements(By.id("dynamicTable"));
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		int skipHeader = 0;
		
		List<Data_Class> list= new ArrayList<Data_Class>();
		for (WebElement row : rows) {

			List<WebElement> cols = row.findElements(By.tagName("td"));
			Data_Class Ref = new Data_Class();
			if (skipHeader != 0) {
				String SSN = cols.get(0).getText();
				String STName = cols.get(1).getText();
				String CourseName = cols.get(2).getText();
				String Amount = cols.get(3).getText();
				String Country = cols.get(4).getText();
				Ref.SSN=SSN;
				Ref.STName=STName;
				Ref.CourseName=CourseName;
				Ref.Amount=Amount;
				Ref.Country=Country;
				
				list.add(Ref);
			}
			for (Data_Class data_Class : list) {
				System.out.println(data_Class.STName);
			}
			
	/*
			 * for (WebElement col : cols) { 
			 * System.out.println(col.getText());
			 */
		}

	}

}
