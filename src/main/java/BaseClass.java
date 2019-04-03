import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
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

        AppiumDriverLocalService service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();
        File appDir = new File("src/main/resources/apks");
        File app = new File(appDir, "ApiDemos-debug.apk");
        System.out.println(app.getAbsolutePath());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        capabilities.setCapability("chrome.binary", "/Users/ishaanmadaan/mobile_demo/Mobile_camp/src/main/resources/chromedriver");

        AndroidDriver driver = new AndroidDriver(service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    static IOSDriver<IOSElement> driver;
    public static IOSDriver<IOSElement> iosCapabilities() throws MalformedURLException {

        AppiumDriverLocalService service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort());
        service.start();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 6");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.1");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "3D86B7E7-8D43-4603-805A-2FEED0979011");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        desiredCapabilities.setCapability("connectHardwareKeyboard", false);

        desiredCapabilities.setCapability(MobileCapabilityType.APP,"/Users/ishaanmadaan/Library/Developer/Xcode/DerivedData/UICatalog-bixavueappzakgarnpkcuberzwqc/Build/Products/Debug-iphonesimulator/UICatalog.app");
        driver= new IOSDriver<IOSElement>(service.getUrl(), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


}
