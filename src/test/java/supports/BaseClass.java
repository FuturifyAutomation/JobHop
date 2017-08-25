package supports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import objects.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public AndroidDriver androidDriver;

    public HomeLocators HomeScreen;
    public LoginLocators LoginScreen;
    public SearchLocators SearchScreen;
    public VerifyPinLocators VerifyPinScreen;
    public RegistrationLocators RegistrationScreen;
    public ForgotPasswordLocators ForgotPasswordScreen;
    public EditProfileLocators EditProfileScreen;
    public SearchResultsLocators SearchResultsScreen;
    public PersonalProfileLocators PersonalProfileScreen;
    public MenuNavigationLocators MenuNavigationScreen;
    public BananaShopLocators BananaShopScreen;

    public SoftAssert SoftAssert = new SoftAssert();

    @BeforeSuite
    @Parameters({"deviceName", "platformVersion", "uRL"})
    public void setUp(String deviceName, String platformVersion, String uRL) throws MalformedURLException {

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
        androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        HomeScreen = PageFactory.initElements(androidDriver, HomeLocators.class);
        LoginScreen = PageFactory.initElements(androidDriver, LoginLocators.class);
        SearchScreen = PageFactory.initElements(androidDriver, SearchLocators.class);
        VerifyPinScreen = PageFactory.initElements(androidDriver, VerifyPinLocators.class);
        RegistrationScreen = AndroidPageFactory.initElements(androidDriver, RegistrationLocators.class);
        ForgotPasswordScreen = PageFactory.initElements(androidDriver, ForgotPasswordLocators.class);
        MenuNavigationScreen = PageFactory.initElements(androidDriver, MenuNavigationLocators.class);
        EditProfileScreen = PageFactory.initElements(androidDriver, EditProfileLocators.class);
        SearchResultsScreen = PageFactory.initElements(androidDriver, SearchResultsLocators.class);
        PersonalProfileScreen = PageFactory.initElements(androidDriver, PersonalProfileLocators.class);
        BananaShopScreen = PageFactory.initElements(androidDriver, BananaShopLocators.class);
    }

    @AfterSuite
    public void tearDown(){
        androidDriver.closeApp();
        androidDriver.quit();
    }
}
