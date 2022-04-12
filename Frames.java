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

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		//browser setup
		ChromeDriver driver = new ChromeDriver();
		
		//get url
		driver.get("http://leafground.com/");
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//click frame
		driver.findElement(By.xpath("//h5[text()='Frame']")).click();
		
		
		
	    driver.switchTo().frame(0);				;
		String text = driver.getTitle();
		System.out.println(text);
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		System.out.println(driver.findElement(By.xpath("//button[@id=\"Click\"]")).getText());
	 
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//button[@id='Click1']")).click();
		driver.switchTo().defaultContent();
		List<WebElement> noOfFrames = driver.findElements(By.tagName("iframe"));
		int size = noOfFrames.size();
		System.out.println(size);


		
		

		
	}

}
