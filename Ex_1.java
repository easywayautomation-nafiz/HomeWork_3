package Assignment_02;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ex_1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("file:///C:/Users/nafiz/Documents/Dynamic_table.html");
		
		List<WebElement> rows = driver.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			List<WebElement> cols = driver.findElements(By.tagName("td"));
		
			for (WebElement col : cols) {
				System.out.println(col.getText());
			} 
	
			
		}
		
	
	}

}
