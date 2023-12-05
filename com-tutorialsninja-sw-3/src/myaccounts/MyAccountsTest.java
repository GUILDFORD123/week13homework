package myaccounts;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class MyAccountsTest extends BaseTest {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";
    public void selectMyAccountOptions(String Option) {
     WebElement menu= driver.findElement(By.linkText(Option));
     menu.click();
    }
    @Before
    public void setBaseUrl() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]")).click();
        selectMyAccountOptions("Register");

    //driver.findElement(By.xpath("//li[@class='dropdown open']/ul/li[1]")).click();
    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));
    String Actual =driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
    System.out.println(Actual);
    String Expected ="Register Account";
    Assert.assertEquals(Actual,Expected);

    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]")).click();
         selectMyAccountOptions("Login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(400));
        String Actual =driver.findElement(By.xpath("//h2[text()='Returning Customer']")).getText();
        System.out.println(Actual);
        String Expected ="Returning Customer";
        Assert.assertEquals(Actual,Expected);

    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        driver.findElement(By.xpath("//ul[@class='list-inline']/li[2]")).click();
         selectMyAccountOptions("Register");
        //driver.findElement(By.xpath("//li[@class='dropdown open']/ul/li[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(By.id("input-firstname")).sendKeys("Rip");
        driver.findElement(By.id("input-lastname")).sendKeys("Pate");
        driver.findElement(By.id("input-email")).sendKeys("ripti15@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("1234567891");//tel
        driver.findElement(By.id("input-password")).sendKeys("rip123");
        driver.findElement(By.id("input-confirm")).sendKeys("rip123");
        driver.findElement(By.xpath("//div[@class='form-group']/div/label[1]")).click();//privacy
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();//tick
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.findElement(By.xpath("//input[@type='submit']")).click();//cuntinu
        String Actual =driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        System.out.println(Actual);
        String Expected ="Your Account Has Been Created!";
       Assert.assertEquals(Actual,Expected);

    }
    }
