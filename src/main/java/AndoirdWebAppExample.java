import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.JavascriptExecutor;

import java.net.MalformedURLException;

public class AndoirdWebAppExample  extends BaseClass {

    public static void main(String[] args) throws MalformedURLException {

// TODO Auto-generated method stub
            AndroidDriver<AndroidElement> driver=getDriverWithBrowserCaps();
            /* driver.get("http://facebook.com");
            driver.findElementByXPath("//*[@id='u_0_1']/div[1]/div/input").sendKeys("qwerty");
            driver.findElementByName("pass").sendKeys("12345");
            driver.findElementByXPath("//button[@value='Log In']").click();*/
            //rahulonlinetutor@gmail.com

            driver.get("http://cricbuzz.com");
            driver.findElementByXPath("//a[@href='#menu']").click();
            driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
            System.out.println(driver.getCurrentUrl());
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,480)", "");

            //Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
    }
}
