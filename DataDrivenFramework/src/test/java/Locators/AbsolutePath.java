package Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;

@Ignore
public class AbsolutePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver;
driver=new ChromeDriver();
driver.get("https://tutorialsninja.com/demo/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Qafox.com")));
driver.findElement(By.linkText("Software")).click();
String error=driver.findElement(By.xpath("/html/body/div/div/div/p")).getText();
System.out.println(error);
if(error.contains("There are no products to list in this category."))
{
	System.out.println("Ture ");
}
else
{
	System.out.println("it is not possible");
}
driver.quit();
	}

}
