import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class AndroidSpecialActions extends BaseClass {


    public static void main(String[] args) throws InterruptedException {

       keyEvents();

    }

    public static void touchEvents()
    {

        AndroidDriver driver = getDriverWithNativeCaps();

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //Tap
        TouchAction t =new TouchAction(driver);
        WebElement expandList=	driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]");
        t.tap(tapOptions().withElement(element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text=\"1. Custom Adapter\"]").click();
        WebElement pn=driver.findElementByXPath("//android.widget.TextView[@text='People Names']");

        t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
        System.out.println(driver.findElementById("android:id/title").isDisplayed());

    }


    public static void keyEvents()
    {
        AndroidDriver driver = getDriverWithNativeCaps();
        System.out.println("*******"+driver.currentActivity());
        System.out.println("*******"+driver.getContext());
        //views - Native , Hybrid, Webview
        System.out.println("*******"+driver.getOrientation());
        System.out.println("*******"+driver.isDeviceLocked());
        //  driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.navigate().back();

    }

    public static void scrollActions()
    {
        AndroidDriver driver = getDriverWithNativeCaps();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
    }


    public static void swipeActions()
    {
        AndroidDriver driver = getDriverWithNativeCaps();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();
        TouchAction t=new TouchAction(driver);
        //long press //on element// 2 sec// move to another element and you release
        WebElement first=driver.findElementByXPath("//*[@content-desc='15']");
        WebElement second=driver.findElementByXPath("//*[@content-desc='45']");

        t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();

    }


    public  static void dragAndDropActions()
    {
        AndroidDriver driver = getDriverWithNativeCaps();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
        WebElement source= (WebElement) driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination= (WebElement) driver.findElementsByClassName("android.view.View").get(1);


        TouchAction t = new TouchAction(driver);
        t.longPress(element(source)).moveTo(element(destination)).release().perform();
    }


}
