package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TopMenutest extends BaseTest{
    String baseUrl ="https://demo.nopcommerce.com/";
    public void selectMenu(String menu) {
        WebElement menuLink = driver.findElement(By.xpath(menu));
        menuLink.click();}
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void  verifyPageNavigation(){
        WebElement menu = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[1]/a"));
        menu.click();
        WebElement desktop = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div"));
        desktop.click();
        WebElement seleect = driver.findElement(By.id("products-orderby"));
        seleect.click();
        Select select = new Select(seleect);
        select.selectByIndex(2);
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        WebElement menu = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[1]/a"));
        menu.click();
        WebElement desktop = driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div"));
        desktop.click();
        WebElement seleect = driver.findElement(By.id("products-orderby"));
        seleect.click();
        Select select = new Select(seleect);
        select.selectByIndex(1);
        Thread.sleep(3000);
      WebElement cart= driver.findElement(By.xpath("//div[@class='item-grid']/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
      cart.click();
        Thread.sleep(1000);
       String Actualresult = driver.findElement(By.xpath("//div[@class='product-name']/h1")).getText();
      // String expectedresult = "Build your own computer";
      // Assert.assertEquals(Actualresult,expectedresult);
       WebElement pre = driver.findElement(By.id("product_attribute_1"));  //2.6
       pre.click();
       Select select1 =new Select(pre);
       select1.selectByIndex(1);
       WebElement gb = driver.findElement(By.id("product_attribute_2"));//2.7
       gb.click();
       Select select2 = new Select(gb);
       select2.selectByIndex(3);
        driver.findElement(By.xpath("//input[@id='product_attribute_3_7']")).click(); //2.8
       WebElement os = driver.findElement(By.id("product_attribute_4_9"));//2.9
      os.click();
       //Select select4 = new Select(radio);
      // select4.selectByIndex(1);//2.10
       WebElement microsoft =driver.findElement(By.xpath("//input[@id='product_attribute_5_10']"));
       microsoft.isEnabled();
        WebElement commander =driver.findElement(By.xpath("//dd[@id='product_attribute_input_5']/ul/li[3]"));
        commander.click();
       WebElement price = driver.findElement(By.id("price-value-1"));
       price.click();
        WebElement add = driver.findElement(By.id("add-to-cart-button-1"));
       add.click();
       Thread.sleep(7000);
        String acrualtext = driver.findElement(By.id("add-to-cart-button-1")).getText();
        System.out.println(acrualtext);
      String expected  = "The product has been added to your shopping cart";
        //Assert.assertEquals(acrualtext,expected);
        //After that close the bar clicking on the cross button.
        WebElement cross = driver.findElement(By.xpath("//div[@class='add-to-cart']/div"));
        cross.click();
        Thread.sleep(1000);
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shopping =driver.findElement(By.xpath("//div[@class='bar-notification success']/p/a"));
        shopping.click();
        String actual= driver.findElement(By.xpath("//h1[text()='Shopping cart']")).getText();
        System.out.println(acrualtext);
        String exp = "Shopping cart";
        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        WebElement qty = driver.findElement(By.id("updatecart"));
        qty.click();
        //Verify the Total"$2,950.00"
        String actu = driver.findElement(By.xpath("//span[@class='value-summary']/strong")).getText();
        System.out.println(actu);
        String expts ="$2,940.00";
//2.18 click on checkbox “I agree with the terms of service”
        WebElement tick = driver.findElement(By.id("termsofservice"));
        tick.click();
        //2.19 Click on “CHECKOUT”
        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
        //2.20 Verify the Text “Welcome, Please Sign In!”
        String actual1 = driver.findElement(By.xpath("//div[@class='page-title']/h1")).getText();
        String expected1="Welcome, Please Sign In!";
        System.out.println(actual1);
      //2.21Click on “CHECKOUT AS GUEST” Tab
        WebElement guest = driver.findElement(By.xpath("//div[@class='new-wrapper checkout-as-guest-or-register-block']/div[3]/button"));
        guest.click();
        //2.22 Fill the all mandatory field
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("rip"); //FIRST
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("pat"); //last
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("rippat@yahoo.com"); //email
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United State"); //country
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Canton"); //city
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("16 cantburt road"); //add1
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("098765"); //zip
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("0123456789"); //tel
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id=\"checkout-step-billing\"]/div/button[4]")).click();





    }
@After

    public void endtest(){
      //  closeBrowser();
}
}
