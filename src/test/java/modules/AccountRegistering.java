package modules;

import configurations.TestInitiation;
import objects.LoginLocators;
import objects.RegistrationLocators;
import objects.VerifyPinLocators;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AccountRegistering extends TestInitiation {

    private LoginLocators LoginScreen;
    private RegistrationLocators RegistrationScreen;
    private VerifyPinLocators VerifyPinScreen;

    private SoftAssert softAssert1 = new SoftAssert();
    private SoftAssert softAssert2 = new SoftAssert();
    private SoftAssert softAssert3 = new SoftAssert();
    private SoftAssert softAssert4 = new SoftAssert();

    private String randomText = new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
    private String text = "test";
    private String email = text + randomText + "@gmail.com";

    @BeforeMethod
    private void setUp() {
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LoginLocators.class);
        RegistrationScreen = AndroidPageFactory.initElements(androidDriver, RegistrationLocators.class);
        VerifyPinScreen = AndroidPageFactory.initElements(androidDriver, VerifyPinLocators.class);
    }

    @Test
    public void VerifyFieldsInRegistrationScreen() throws InterruptedException {

//        CheckPoint: Link to register screen can be found in Login screen
        softAssert1.assertTrue(LoginScreen.lbl_Register.isDisplayed());

//        Tap Register link
        LoginScreen.lbl_Register.click();

//        CheckPoint: Register screen must be displayed after user tapped on Register Link
        softAssert1.assertTrue(RegistrationScreen.lbl_Registration.isDisplayed());

//        CheckPoint: Register Fields should contains Full Name - Phone number - Password - Confirm Password - Email
        softAssert1.assertTrue(RegistrationScreen.txt_FullName.isEnabled());
        softAssert1.assertTrue(RegistrationScreen.txt_Email.isEnabled());
        softAssert1.assertTrue(RegistrationScreen.txt_PhoneNumber.isEnabled());
        softAssert1.assertTrue(RegistrationScreen.txt_PassWord.isEnabled());
        softAssert1.assertTrue(RegistrationScreen.txt_ConfirmPassword.isEnabled());

//        CheckPoint: A link return to Login screen must be always available in Register screen
        softAssert1.assertTrue(RegistrationScreen.lbl_SignIn.isEnabled());

//        Swipe down
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");
        Thread.sleep(1000);

//        CheckPoint: User can swipe up - down to input or view fields in Register screen without any issue
        softAssert1.assertTrue(RegistrationScreen.btn_Register.isDisplayed());

//        Swipe up
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ VÀ TÊN\");");
        Thread.sleep(1000);

//        CheckPoint: User can swipe up - down to input or view fields in Register screen without any issue
        softAssert1.assertTrue(RegistrationScreen.txt_FullName.isDisplayed());
        softAssert1.assertAll();
    }

    @Test(priority = 1)
    public void VerifyRegistrationFieldsValidation() {

//        Type account information
        RegistrationScreen.fillRegistrationFields(randomText, randomText + "12", "12345", randomText, text + randomText);
        RegistrationScreen.txt_PassWord.click();

//        CheckPoint: Đăng ký button shall be activated right after user has filled all the field
        softAssert2.assertTrue(RegistrationScreen.btn_Register.isEnabled());

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: User cannot register account with Full name contains only one word, an error message displayed to user: Họ và tên phải có ít nhất 02 từ
        softAssert2.assertEquals(RegistrationScreen.lbl_Message.getText(), "Họ và tên phải chứa ít nhất 2 từ.");

//        Close message
        RegistrationScreen.btn_Ok.click();

//        Scroll to Name field
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ VÀ TÊN\");");

//        Type name again
        RegistrationScreen.txt_FullName.clear();
        RegistrationScreen.txt_FullName.sendKeys(text);
        RegistrationScreen.txt_PassWord.click();

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: User cannot register account with Full name contains below 6 characters, an error message displayed to user: Họ và tên bắt buộc phải chứa ít nhất 6 kí tự.
        softAssert2.assertEquals(RegistrationScreen.lbl_Message.getText(), "Họ và tên phải chứa ít nhất 6 kí tự.");

//        Close message
        RegistrationScreen.btn_Ok.click();

//        Scroll to Name field
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ VÀ TÊN\");");

//        Type name again
        RegistrationScreen.txt_FullName.clear();
        RegistrationScreen.txt_FullName.sendKeys(text + " " + randomText);
        RegistrationScreen.txt_PassWord.click();

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: After registered with a fake/unformatted phone numbers, system must display error message: "Please use your actual phone numbers" and focus to the field
        softAssert2.assertEquals(RegistrationScreen.lbl_Message.getText(), "Định dạng số điện thoại không đúng.");

//        Close message
        RegistrationScreen.btn_Ok.click();

//        Scroll to Name field
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ VÀ TÊN\");");

//        Type phone number again
        RegistrationScreen.txt_PhoneNumber.clear();
        RegistrationScreen.txt_PhoneNumber.sendKeys(randomText);
        RegistrationScreen.txt_PassWord.click();

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: When typing less than 6 characters into Password field, error "Password must contain at least 6 characters" should appear
        softAssert2.assertEquals(RegistrationScreen.lbl_Message.getText(), "Mật khẩu phải chứa ít nhất 6 kí tự.");

//        Close message
        RegistrationScreen.btn_Ok.click();

//        Scroll to Name field
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ VÀ TÊN\");");

//        Type password again
        RegistrationScreen.txt_PassWord.clear();
        RegistrationScreen.txt_PassWord.sendKeys(randomText + "123");
        RegistrationScreen.txt_ConfirmPassword.click();

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: An noticeable message must be displayed after User using an invalid email "Vui lòng nhập email hợp lệ"
        softAssert2.assertEquals(RegistrationScreen.lbl_Message.getText(), "Vui lòng nhập email hợp lệ");

//        Close message
        RegistrationScreen.btn_Ok.click();

//        Re-type email
        RegistrationScreen.txt_Email.clear();
        RegistrationScreen.txt_Email.sendKeys(email);
        RegistrationScreen.txt_ConfirmPassword.click();

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: System must display an error message after password and confirm password fields are not consistent
        softAssert2.assertEquals(RegistrationScreen.lbl_Message.getText(), "Mật khẩu và mật khẩu xác nhận không khớp.");

//        Close message
        RegistrationScreen.btn_Ok.click();
        softAssert2.assertAll();
    }

    @Test(priority = 2)
    public void VerifyRegisteringAccountSuccessfully() {

//        Scroll to Name field
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ VÀ TÊN\");");

//        Re-type password
        RegistrationScreen.txt_PassWord.clear();
        RegistrationScreen.txt_PassWord.sendKeys(randomText);
        RegistrationScreen.txt_ConfirmPassword.click();

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: User don't have to enter International code (+xx) as prefix to register new account, register form can be submitted without (+84)
//        CheckPoint: After registered with valid information, a message should be displayed to User: "Thank you for registering, Please check PIN code to verify in the next step"
        softAssert3.assertEquals(RegistrationScreen.lbl_Message.getText(), "Tài khoản đã được tạo. Vui lòng kiểm tra tin nhắn SMS và nhập mã xác nhận.");

//        Close message
        RegistrationScreen.btn_Ok.click();

//        CheckPoint: Phone numbers field displays country code (+84) as a prefix
        softAssert3.assertTrue(VerifyPinScreen.lbl_PhoneNumber.getText().contains("+84"));
        softAssert3.assertTrue(VerifyPinScreen.lbl_PhoneNumber.getText().contains(randomText.substring(1)));
        softAssert3.assertAll();


//        The PIN code should be sent to user after user registered successfully

//        PIN code that sent to user should have came with a message: "Verification code at JobHop: xxxx"
    }

    @Test(priority = 3)
    public void VerifyRegisteringExistedAccount() {

//        Go to Registration screen
        VerifyPinScreen.lbl_SignIn.click();
        LoginScreen.lbl_Register.click();

//        Register existing account
        RegistrationScreen.fillRegistrationFields(text + " " + randomText, "01233069234", randomText, randomText, email);
        RegistrationScreen.txt_ConfirmPassword.click();

//        Scroll to register button
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().className(\"android.widget.Button\"));");

//        Tap register button
        RegistrationScreen.btn_Register.click();

//        CheckPoint: After registered with an existed phone numbers, system must send error message to user: "The phone numbers are in used, please use a different phone numbers"
        softAssert4.assertEquals(RegistrationScreen.lbl_Message.getText(), "Số điện thoại đã được sử dụng.");

//        Close message
        RegistrationScreen.btn_Ok.click();
        softAssert4.assertAll();
    }
}
