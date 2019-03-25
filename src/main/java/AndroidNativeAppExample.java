import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AndroidNativeAppExample {

    public static void main(String[] args) throws Exception {

            AppiumDriverLocalService service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
            service.start();

            File appDir = new File("src/main/resources/apks");
            File app = new File(appDir, "ApiDemos-debug.apk");
            System.out.println(app.getAbsolutePath());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability("avd", "Nexus_5X_API_25");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_25");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            AndroidDriver driver = new AndroidDriver(service.getUrl(), capabilities);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
            driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
            driver.findElementById("android:id/checkbox").click();
            driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();

            driver.findElementById("android:id/edit").sendKeys("hello");
            List<WebElement> w1=driver.findElementsByClassName("android.widget.Button");
            w1.get(1).click();
            System.out.println("Test passed");
            service.stop();
            driver.close();

//
//        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
//        //Tap
//        TouchAction t = new TouchAction(driver);
//        WebElement expandList=	driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
//        t.tap(tapOptions().withElement(element(expandList))).perform();
//        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
//        WebElement pn=	driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
//
//        t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
//        //Thread.sleep(2000);
//        System.out.println(driver.findElementById("android:id/title").isDisplayed());


    }

}
