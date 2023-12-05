package Homepage;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TopMenuTest extends BaseTest {

       //Write the following Test:
    String basUrl = "http://tutorialsninja.com/demo/index.php";
    public void selectMenu(String menu){driver.findElement(By.xpath("//a[text()='"+menu+"']")).click();
    }@Before
    public void setup() {
        openBrowser(basUrl);
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Desktops']")).click();
        selectMenu("Show AllDesktops");
        String Actual = driver.findElement(By.xpath("//h2[text()='Desktops']")).getText();
        String Expected = "Desktops";
        Assert.assertEquals(Actual,Expected);
    }

@Test
public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){

        driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")).click();
        selectMenu("Show AllLaptops & Notebooks");
        String actual1 = driver.findElement(By.xpath("//h2[text()='Laptops & Notebooks']")).getText();
        String Expected1 = "Laptops & Notebooks";
        Assert.assertEquals(actual1,Expected1);


}
@Test
public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        driver.findElement(By.xpath("//a[text()='Components']")).click();
        selectMenu("Show AllComponents");
        String actualResult = driver.findElement(By.xpath("//h2[text()='Components']")).getText();
        String expectedResult = "Components";
        Assert.assertEquals(actualResult,expectedResult);
}

    @After
    public void endtest() {
      //  closeBrowser();
    }

}


