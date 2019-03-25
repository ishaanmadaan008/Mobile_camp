import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static AndroidDriver getDriverWithNativeCaps()
    {

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
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver driver = new AndroidDriver(service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriver getDriverWithBrowserCaps() throws MalformedURLException {

        File appDir = new File("src/main/resources/apks");
        File app = new File(appDir, "ApiDemos-debug.apk");
        System.out.println(app.getAbsolutePath());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("chrome.binary", "/Users/ishaanmadaan/mobile_demo/Mobile_camp/src/main/resources/chromedriver");

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }



}
