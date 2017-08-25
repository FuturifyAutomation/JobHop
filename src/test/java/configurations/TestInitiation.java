package configurations;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestInitiation {

    public AndroidDriver androidDriver;

    @BeforeTest
    @Parameters({"deviceName", "platformVersion", "uRL"})
    public void initiateTest(String deviceName, String platformVersion, String uRL) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

//        Device information
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);

//        JobHop app
        caps.setCapability("app", "D:\\FUTURIFY\\Applications\\JobHop\\16_06_2017.apk");
        caps.setCapability("appPackage","com.futurifyvn.jobhop");
        caps.setCapability("appActivity","md5360dc1ec547c585df09c8fba6cee2abe.MainActivity");

//        Keyboard settings
        caps.setCapability("resetKeyboard", true);
        caps.setCapability("unicodeKeyboard", true);

//        Server inform
        androidDriver = new AndroidDriver(new URL(uRL), caps);
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest
    public void cleanTest(){
        androidDriver.closeApp();
        androidDriver.quit();
    }
}
