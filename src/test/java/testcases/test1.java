package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class test1 {
	WebDriver driver;
	@Test
  public void met() throws InterruptedException {
	  System.out.println("Hello");
	  System.setProperty("webdriver.chrome.driver", "D:\\AUtomation_software\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='radio-btn-example']/fieldset/label[3]/input")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='radio-btn-example']/fieldset/label[1]/input")).click();
		boolean status = driver.findElement(By.xpath("//div[@id='radio-btn-example']/fieldset/label[1]/input")).isSelected();
		System.out.println(status);
		Thread.sleep(10000);
		
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
		
		Thread.sleep(2000);
		
		Select s = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
		Thread.sleep(3000);
		s.selectByIndex(1);
		Thread.sleep(3000);
		s.selectByValue("option2");
		Thread.sleep(3000);
		s.selectByVisibleText("Option3");
		
		

		
	
}
}
