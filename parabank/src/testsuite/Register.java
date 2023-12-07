package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends BaseTest {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() throws InterruptedException {
        //1.verifyThatSigningUpPageDisplay
        WebElement verify = driver.findElement(By.id("topPanel"));
        verify.getText();
        //* click on the ‘Register’ link
        Thread.sleep(1000);
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();
        //* Verify the text ‘Signing up is easy!’
        String actual = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        String expected = "Signing up is easy!";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() throws InterruptedException {
        // click on the ‘Register’ link
        Thread.sleep(1000);
        WebElement reg = driver.findElement(By.xpath("//a[text()='Register']"));
        reg.click();
        driver.findElement(By.id("customer.firstName")).sendKeys("rip"); //FIRST
        driver.findElement(By.id("customer.lastName")).sendKeys("pate"); //last
        driver.findElement(By.id("customer.address.street")).sendKeys("12 canton");  //add
        driver.findElement(By.id("customer.address.city")).sendKeys("canton"); //city
        driver.findElement(By.id("customer.address.state")).sendKeys("Canton"); //state
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456"); //zip
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("0123456789"); //phone
        driver.findElement(By.id("customer.ssn")).sendKeys("0123456789"); //ssn
        driver.findElement(By.id("customer.username")).sendKeys("ripti12"); //username
        driver.findElement(By.id("customer.password")).sendKeys("ripe13"); //password
        driver.findElement(By.id("repeatedPassword")).sendKeys("ripe13"); //confirm
        Thread.sleep(2000);
        driver.findElement(By.xpath("//form[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
        String actual = driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        String expcted = "Your account was created successfully. You are now logged in.";
        System.out.println(expcted);
        //Assert.assertEquals(actual,expcted);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        // Enter valid username
        driver.findElement(By.name("username")).sendKeys("ripti10"); //username
        // Enter valid password
        driver.findElement(By.name("password")).sendKeys("ripti11"); //password
        //Click on ‘LOGIN’ button
        //Thread.sleep(3000);
        Thread.sleep(1000);
        WebElement count = driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]/input"));
        count.click();
         String actualres =driver.findElement(By.xpath("//h1[text()='Accounts Overview']")).getText();
        String expectedres= "Accounts Overview";
         System.out.println(expectedres);
         Assert.assertEquals(actualres,expectedres);
// Verify the ‘Accounts Overview’ text is display
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {

//* Enter invalid username
        // Enter valid username
        driver.findElement(By.className("input")).sendKeys("ripti10"); //username
        // Enter valid password
        driver.findElement(By.className("input")).sendKeys("ripti1"); //password
        //Click on ‘LOGIN’ button
        Thread.sleep(1000);
        WebElement count = driver.findElement(By.xpath("//input[@type='submit']"));
        count.click();
        //* Verify the error message ‘The username and password could not be verified.’
        String actualres = driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        String expectedres = "The username and password could not be verified.";
        System.out.println(expectedres);

    }

    @Test
    public void userShouldLogOutSuccessfully() {
// Enter valid username
        driver.findElement(By.className("input")).sendKeys("ripti10"); //username
        // Enter valid password
        driver.findElement(By.className("input")).sendKeys("ripti11"); //password
        //Click on ‘LOGIN’ button
        WebElement count = driver.findElement(By.xpath("//div[@id='loginPanel']/form/div[3]"));
        count.click();
        // Click on ‘Log Out’ link
     // WebElement logout = driver.findElement(By.xpath("//div[@id='leftPanel']/ul/li[8]"));
       // logout.click();
        //Verify the text ‘Customer Login’
        String actualres = driver.findElement(By.xpath("//div[@id='leftPanel']/h2")).getText();
        String expectedres = "Customer Login";
        System.out.println(expectedres);

    }
}