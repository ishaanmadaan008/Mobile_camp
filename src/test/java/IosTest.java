import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.junit.Test;

import java.net.MalformedURLException;

public class IosTest extends BaseClass{

    @Test
    public void test() throws MalformedURLException {


        IOSDriver<IOSElement> driver=iosCapabilities();
        driver.findElementByAccessibilityId("Alert Views").click();
        driver.findElementByXPath("//*[@value='Text Entry']").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("hello");
        driver.findElementByName("OK").click();
        driver.navigate().back();



    }
}
