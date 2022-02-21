package RealTimePRactice;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SortPractice {

    @Test
    public void sort(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        //Click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //Capture all webelements into list
        List<WebElement> elementList =driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all webelements into new(original) list
        List<String> originalList=elementList.stream().map(s->s.getText()).collect(Collectors.toList());

        //sort on original list of step 3 -->sorted list
        List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertTrue(originalList.equals(sortedList));
        List<String> price;
        //scan the name column with getText -->Rice-->Print the price of the Rice
        do {
            List<WebElement> rows =driver.findElements(By.xpath("//tr/td[1]"));
            price=rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
            price.forEach(a->System.out.println(a));

            if(price.size()<1){
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        }while(price.size()<1);
    }

    @Test
    private static String getPriceVeggie(WebElement s) {
        String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }
}
