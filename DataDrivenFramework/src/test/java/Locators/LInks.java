package Locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LInks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver;
driver=new ChromeDriver();
driver.navigate().to("https://tutorialsninja.com/demo/");
List<WebElement> hyperlinks=driver.findElements(By.xpath("//a"));
int count=hyperlinks.size();
int i=0;
System.out.println(count);
for(WebElement e:hyperlinks)
{
	System.out.println(e.getAttribute("href"));
	i++;
}
System.out.println(i);
driver.quit();
	}
	

}
