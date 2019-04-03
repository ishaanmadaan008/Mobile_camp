import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AndroidHybridAppExample {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        File appDir = new File("src/main/resources/apks");

        File app = new File(appDir, "hybrid-app.apk");

        DesiredCapabilities cap=new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android emulator");

        cap.setCapability("avd", "Nexus_5X_API_25");

        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        AndroidDriver driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        System.out.println(driver.getContext());

        driver.findElement(By.id("com.hybridapptest.forandroid:id/et_url")).clear();
        driver.findElement(By.id("com.hybridapptest.forandroid:id/et_url")).sendKeys("http://google.com");

        driver.findElement(By.id("com.hybridapptest.forandroid:id/btn_move")).click();

        Set<String> s= driver.getContextHandles();

        for(String handle : s)

        {
            System.out.println(handle);

        }
        Thread.sleep(1000);
        System.out.println(driver.getContext());

        driver.context("WEBVIEW_chrome");

        driver.findElement(By.name("q")).sendKeys("Handling hybrid app");

        driver.context("NATIVE_APP");
    }

}


