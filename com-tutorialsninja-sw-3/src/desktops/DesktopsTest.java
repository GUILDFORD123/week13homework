package desktops;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class DesktopsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php";
    public void selectMenu(String menu){driver.findElement(By.xpath("//a[text()='"+menu+"']")).click();}
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {
        selectMenu("Desktops");
        selectMenu("Show AllDesktops");
        driver.findElement(By.id("input-sort")).click();
        driver.findElement(By.xpath("//select[contains(@id,'input-sort')]/option[3]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));
        String Actual =driver.findElement(By.xpath("//a[text()='Sony VAIO']")).getText();
        System.out.println(Actual);
        String Expected ="Sony VAIO";
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        selectMenu("Desktops");
        selectMenu("Show AllDesktops");
        driver.findElement(By.id("input-sort")).click();
        driver.findElement(By.xpath("//select[contains(@id,'input-sort')]//option[2]")).click();
        selectMenu("HP LP3065");
        Thread.sleep(2000);
        driver.findElement(By.className("fa-calendar")).click();
        driver.findElement(By.xpath("//th[@colspan='5']")).click();
        driver.findElement(By.xpath("//div[@class='input-group date']")).click();
        driver.findElement(By.xpath("//input[@id='input-quantity']")).click();
        driver.findElement(By.id("button-cart")).click();
        Thread.sleep(2000);
        String actualresult = driver.findElement(By.xpath(" //div[@class=\"alert alert-success alert-dismissible\"]")).getText();
        System.out.println(actualresult);
        Thread.sleep(1000);
        String expectedResult = "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×";
        Assert.assertEquals(expectedResult, actualresult);//2.9
        driver.findElement(By.linkText("shopping cart")).click();//2.10
        Thread.sleep(1000);
        String actual = driver.findElement(By.xpath("//div[@id='checkout-cart']/div[1]/div[1]/h1")).getText();
        System.out.println(actual);
        String expected = "Shopping Cart  (1.00kg)";
        Assert.assertEquals(actual, expected);//2.11
        Thread.sleep(1000);
        String actualProductname = driver.findElement(By.xpath("//div[@id='content']/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a")).getAccessibleName();
        System.out.println(actualProductname);
        String expectedProductName="HP LP3065";
        Thread.sleep(1000);
        Assert.assertEquals(actualProductname,expectedProductName);
        String actualDelieverydate=driver.findElement(By.xpath("//div[@id='content']/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/small[1]")).getText();//2.13
        Thread.sleep(1000);
        System.out.println(actualDelieverydate);
        String expectedDelieveryDate="Delivery Date:2011-04-22";
        Thread.sleep(2000);
       Assert.assertEquals(actualDelieverydate,expectedDelieveryDate);
        String actualTotal=driver.findElement(By.xpath("//div[@id='content']/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")).getText();//2.15
        String expectedTotal="$122.00";
        Thread.sleep(1000);
        Assert.assertEquals(actualTotal,expectedTotal);
    }
@After
    public void endtest(){
        //closeBrowser();
}
    }
