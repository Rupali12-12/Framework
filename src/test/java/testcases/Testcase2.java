package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testcase2 {
	Properties properties = new Properties();
	WebDriver driver;
	@Test(priority=1)
	public void openbrow() throws IOException {
		FileInputStream path = new FileInputStream("D:\\Java_Program\\Testng_frame\\src\\main\\java\\resources\\data.properties");
		properties.load(path);
		String url = properties.getProperty("url");
		
		String browser = properties.getProperty("browser");
		System.out.println(browser);

		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\AUtomation_software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			
		}
		else if(browser.equals("edge")) {
			System.setProperty("webdriver.chrome.driver", "D:\\AUtomation_software\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
	}
	@Test(priority=2)
	public void navigateurl() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("indi");
	    Thread.sleep(2000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
		System.out.println(list);
		for (WebElement webElement : list) {
			
			if (webElement.getText().equals("India")) 
			{
				//Thread.sleep(3000);
				webElement.click();
			}
		}
	}
	
}
