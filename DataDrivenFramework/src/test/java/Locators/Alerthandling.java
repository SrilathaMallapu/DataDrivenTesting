package Locators;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerthandling {

	public static void main(String args[])
	{
		ChromeOptions chrome=new ChromeOptions();
		chrome.addArguments("--disable-notifications");
		WebDriver driver;
		driver=new ChromeDriver(chrome);
		driver.get("https://www.justdial.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Maybe Later")));
		String name=driver.findElement(By.linkText("Maybe Later")).getText();
		System.out.println(name);
		//Alert alert=driver.switchTo().alert();
		/*alert.getText();
		alert.accept();
		alert.dismiss();*/
		//Authentication popup message
		
		
		driver.quit();
	}
}
