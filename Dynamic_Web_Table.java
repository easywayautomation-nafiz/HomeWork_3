package Assignment_02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Web_Table {
	// WebDriver driver= null;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.get("file:///C:/Users/nafiz/Documents/Dynamic_table.html");
		List<WebElement> rows = driver.findElements(By.tagName("tr"));

		List<Data_Class_2> List = new ArrayList<Data_Class_2>();
		int skipHeader = 0;
		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));
			if (skipHeader != 0) {
				Data_Class_2 ref = new Data_Class_2();
				String BatchName = cols.get(0).getText();
				String StudentName = cols.get(1).getText();
				String CourseName = cols.get(2).getText();
				ref.BatchName = BatchName;
				ref.StudentName = StudentName;
				ref.CourseName = CourseName;

				List.add(ref);

			}
			skipHeader++;
		}
		
		for (Data_Class_2 data : List) {

			System.out.println(data.StudentName);

			
		}

	}

}
