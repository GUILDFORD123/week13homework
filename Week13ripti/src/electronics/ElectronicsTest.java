package electronics;

import homepage.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicsTest extends BaseTest {
    String baseurl="https://demo.nopcommerce.com/";

@Before
public void setpu() {
    openBrowser(baseurl);
}
@Test
    public void textverified(){
   // 1.1 Mouse Hover on “Electronics” Tab
    WebElement tab =driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]"));
    tab.click();
   // 1.2 Mouse Hover on “Cell phones” and click
   // 1.3 Verify the text “Cell phones”
}
}