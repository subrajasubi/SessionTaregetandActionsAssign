package week1.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesChercher {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.switchTo().frame("frame1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//b[@id='topic']/following::input")).sendKeys("Animals");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following::input")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement ele = driver.findElement(By.id("animals"));
		Select sec = new Select(ele);
		sec.selectByVisibleText("Big Baby Cat");
		
		
		
		
		
	}
}