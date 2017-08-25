package supports;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Scrolling{

    public AndroidDriver driver;

    public Scrolling(AndroidDriver driver){
        this.driver = driver;
    }

    public void scrollToText(String text){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + text +"\"));");
    }

    public void scrollToClass(String className){
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"" + className + "\"));");
    }
}
