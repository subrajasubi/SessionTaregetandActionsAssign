package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);
		WebElement mens = driver.findElement(By.xpath("//span[@class='catText']"));
		builder.moveToElement(mens).perform();
	    driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String shoesCount = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(shoesCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.xpath("//div[@class='sort-selected']")).click();
		driver.findElement(By.xpath("//ul[@class='sort-value']//li[2]")).click();
		Thread.sleep(2000);
		List<WebElement> sortedList = driver.findElements(By.xpath("//div[@class='product-desc-rating ']//div[@class='product-price-row clearfix']"));
		for (WebElement each : sortedList) {
			System.out.println(each.getText());
		}
		WebElement price = driver.findElement(By.className("input-filter"));
		price.clear();
		price.sendKeys("900",Keys.ENTER);
		WebElement toPrice = driver.findElement(By.name("toVal"));
		toPrice.clear();
		toPrice.sendKeys("1200",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		Thread.sleep(6000);
//		driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
//		String text = driver.findElement(By.xpath("(//div[@class='filters'])[1]")).getText();
//		System.out.println(text);
		WebElement result = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		builder.moveToElement(result).perform();
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		String text2 = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
		System.out.println(text2);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./Snapshot.png");
		FileUtils.copyFile(screenshotAs, destination);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}}