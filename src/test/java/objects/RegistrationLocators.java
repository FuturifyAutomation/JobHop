package objects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

public class RegistrationLocators {

    private AndroidDriver androidDriver;
    private LoginLocators LoginScreen;

    public RegistrationLocators(AndroidDriver driver){
        this.androidDriver = driver;
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LoginLocators.class);
    }

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.widget.TextView[@text='Đăng ký']")
    public WebElement lbl_Registration;

    @FindBy(xpath = ".//android.widget.TextView[@text='HỌ VÀ TÊN']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_FullName;

    @FindBy(xpath = ".//android.widget.TextView[@text='SỐ ĐIỆN THOẠI']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_PhoneNumber;

    @FindBy(xpath = ".//android.widget.TextView[@text='MẬT KHẨU']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_PassWord;

    @FindBy(xpath = ".//android.widget.TextView[@text='NHẬP LẠI MẬT KHẨU']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_ConfirmPassword;

    @FindBy(xpath = ".//android.widget.TextView[@text='EMAIL']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_Email;

    @FindBy(xpath = ".//android.widget.Button[@text='Đăng ký']")
    public WebElement btn_Register;

    @FindBy(xpath = ".//android.widget.TextView[@text='Đăng nhập']")
    public WebElement lbl_SignIn;

    @FindBy(id = "android:id/message")
    public WebElement lbl_Message;

    @FindBy(xpath = ".//android.widget.Button[@text='OK']")
    public WebElement btn_Ok;

    public void fillRegistrationFields(String fullName, String phoneNumber, String password, String confirmPassword, String emailAddress){

//        Type full name
        txt_FullName.clear();
        txt_FullName.sendKeys(fullName);

//        Type phone number
        txt_PhoneNumber.clear();
        txt_PhoneNumber.sendKeys(phoneNumber);

//        Type password
        txt_PassWord.clear();
        txt_PassWord.sendKeys(password);

//        Type confirm password
        txt_ConfirmPassword.clear();
        txt_ConfirmPassword.sendKeys(confirmPassword);

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Type email
        txt_Email.clear();
        txt_Email.sendKeys(emailAddress);
    }

    public void registerAccountWithoutVerifyPin(String fullName, String phoneNumber, String password, String confirmPassword, String emailAddress) throws InterruptedException {

//        Go to Registration screen from Login screen
        LoginScreen.lbl_Register.click();

//        Fill name, phone, pass, confirm pass and email
        fillRegistrationFields(fullName, phoneNumber, password, confirmPassword, emailAddress);

//        Handle Register button is disabled by hiding Android keyboard setting.
        txt_ConfirmPassword.click();

//        Tap register button
        btn_Register.click();

//        Close message
        btn_Ok.click();
    }
}
