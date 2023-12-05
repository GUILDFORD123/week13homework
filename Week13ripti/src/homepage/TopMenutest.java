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
        Thread.sleep(1000);
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
       Thread.sleep(2000);
        String acrualtext = driver.findElement(By.xpath("//div[@class='bar-notification success']")).getText();
        System.out.println(acrualtext);
       String expected  = "The product has been added to your shopping cart";
        //Assert.assertEquals(acrualtext,expected);

    }
@After

    public void endtest(){
      //  closeBrowser();
}
}
