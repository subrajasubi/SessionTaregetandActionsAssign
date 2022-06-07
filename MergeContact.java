package week1.day1;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(handles.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/following::a)[1]")).click();
		driver.switchTo().window(handles.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::img[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> handles1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(handles1.get(1));
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/following::a)[2]")).click();
		driver.switchTo().window(handles1.get(0));
		driver.findElement(By.linkText("Merge")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
		driver.close();
		
		
		
		
	}
}