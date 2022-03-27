package RealTimePRactice;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class JavaScriptScrolling {
	
	@Test
	public void scrollTable() throws InterruptedException {
		
		open("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor)WebDriverRunner.getWebDriver();
		
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		$$(".tableFixHead td:nth-of-type(4)").stream().map(b->b.getText()).forEach(System.out::println);
		
		ElementsCollection listPrice=$$(".tableFixHead td:nth-of-type(4)");
		int sum=0;

		for(int i=0;i<listPrice.size();i++) {
			
			sum=sum+Integer.parseInt(listPrice.get(i).getText());
		}
		
		System.out.println(sum);
		int total=Integer.parseInt($("div.totalAmount").getText().split(":")[1].trim());
		
		Assert.assertEquals(sum, total);
	}

}
