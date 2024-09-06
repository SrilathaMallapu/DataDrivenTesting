package DataDrivenTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.MyListeners;

public class LoginTest {

	WebDriver driver;
	
	@BeforeMethod
	public void LaunchBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.navigate().to("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		WebElement MyAccount=driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a/span[1]"));
		MyAccount.click();
		WebElement Register=driver.findElement(By.linkText("Register"));
		Register.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Register")));
	}
	
	@Test(dataProvider="supplydata")
	public void LoginTest2(String first,String last,String email,String phone,String pass,String confir)
	{
		driver.findElement(By.id("input-firstname")).sendKeys(first);
		driver.findElement(By.id("input-lastname")).sendKeys(last);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(phone);
		driver.findElement(By.id("input-password")).sendKeys(pass);
		driver.findElement(By.id("input-confirm")).sendKeys(confir);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		Assert.assertTrue(false);
	}
	@Ignore
	@Test(dependsOnMethods="LoginTest2",alwaysRun=true)
	public void success()
	{
		System.out.println("success message");
	}
	@DataProvider(indices= {0})
	public Object supplydata()
	{
		Object[][] data= {{"Marina","Garita","Maria@gemiw.com","23458679","Maria@345","Maria@345"},{"Marina","Garita","Maria@gemir.com","234586790","Maria@345","Maria@345"}};
		return data;
			
		}
	
	@AfterMethod
	public void CloseBrowser()
	{
	driver.quit();
}
}
