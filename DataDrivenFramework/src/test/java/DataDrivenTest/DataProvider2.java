package DataDrivenTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {

	ChromeDriver driver=new ChromeDriver();
	@Test(dataProvider="getdata",dataProviderClass=GetData.class)
	public void LoginwithValidCredentials(String[] str)
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(str[0]);
		driver.findElement(By.id("input-password")).sendKeys(str[1]);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
        driver.quit();		
	}

	/*@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}*/
}
