package demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.leafground.com/pages/table.html");
		List<WebElement> noOfRows = driver.findElements(By.xpath("//tbody//tr"));
		int rowsize = noOfRows.size();
		System.out.println("ColumnCount:  " +rowsize);
		List<WebElement> noOfColumns = driver.findElements(By.xpath("//tbody//tr//th"));
		int columnSize = noOfColumns.size();
		System.out.println("Number of Columns:  " +columnSize);
		String text = driver.findElement(By.xpath("//tr[@class='even']//td[2]")).getText();
		System.out.println("Progress Value : " +text);
		driver.findElement(By.xpath("(//input[@name='vital'])[5]")).click();
		
		
		
		
		
		
		
	}

}
