package modules;

import configurations.TestInitiation;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidKeyCode;
import objects.HomeLocators;
import objects.LoginLocators;
import objects.RegistrationLocators;
import objects.VerifyPinLocators;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoggingInWithPhoneNumber extends TestInitiation {

    private HomeLocators HomeScreen;
    private LoginLocators LoginScreen;
    private VerifyPinLocators VerifyPinScreen;
    private RegistrationLocators RegistrationScreen;

    private SoftAssert softAssert1 = new SoftAssert();
    private SoftAssert softAssert2 = new SoftAssert();
    private SoftAssert softAssert3 = new SoftAssert();

    private String randomText = new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
    private String text = "test";
    private String pin = "123456";

    @BeforeMethod
    private void setUp() {
        HomeScreen = AndroidPageFactory.initElements(androidDriver, HomeLocators.class);
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LoginLocators.class);
        VerifyPinScreen = AndroidPageFactory.initElements(androidDriver, VerifyPinLocators.class);
        RegistrationScreen = AndroidPageFactory.initElements(androidDriver, RegistrationLocators.class);
    }

    @Test
    public void VerifyLoggingInWithAccountNotVerified() throws InterruptedException {

//        Pre-conditions: register new account
        RegistrationScreen.registerAccountWithoutVerifyPin(text + " " + randomText, randomText, randomText, randomText, text + randomText + "@gmail.com");

//        Tap sign in button
        VerifyPinScreen.lbl_SignIn.click();

//        Login with registered account
        LoginScreen.logIn(randomText, randomText);
        softAssert1.assertEquals(LoginScreen.lbl_Message.getText(), "Bạn chưa xác nhận số điện thoại. Vui lòng kiểm tra tin nhắn SMS và nhập mã PIN.");

//        Close message
        LoginScreen.btn_Ok.click();

//        CheckPoint: After logged in with valid Phone number & Password, the PIN code screen appears
//        CheckPoint: The user being taken to PIN screen when he try to logging in with account that hasn't been verified
//        CheckPoint: PIN code screen must contains message: "Please check your SMS to verify PIN code"
        softAssert1.assertTrue(VerifyPinScreen.lbl_Header.isDisplayed());
        softAssert1.assertTrue(VerifyPinScreen.btn_Confirm.isEnabled());
        softAssert1.assertTrue(VerifyPinScreen.btn_Resend.isDisplayed());

//        CheckPoint: PIN code screen should not have any default PIN code, it must be fill in by Jobseeker manually
        softAssert1.assertEquals(VerifyPinScreen.txt_Pin.getText(), "PIN");
        softAssert1.assertAll();
    }

    @Test(priority = 1)
    public void VerifyFieldValidation() {
//        Type pin
        VerifyPinScreen.txt_Pin.sendKeys(pin);

//        Tap confirm button
        VerifyPinScreen.btn_Confirm.click();

//        CheckPoint: A message displays: "Incorrect PIN, please check again" after user has entered an invalid PIN code
//        CheckPoint: PIN code will notice user that number of time logging in left after being submitted invalid PIN code
        softAssert2.assertEquals(VerifyPinScreen.lbl_Message.getText(), "Bạn đã nhập sai mã PIN 1/5 lần. Vui lòng nhập lại hoặc yêu cầu gửi lại một mã PIN mới.");

//        Close message
        VerifyPinScreen.btn_Ok.click();

//        Tap resend button
        VerifyPinScreen.btn_Resend.click();

//        CheckPoint: PIN code is sent to user after pressed on Resend in PIN screen
        softAssert2.assertEquals(VerifyPinScreen.lbl_Message.getText(),"Một mã PIN mới sẽ được gửi tới số điện thoại +84" + randomText.substring(1) + ". Vui lòng kiểm tra và xác nhận.");

//        Close message
        VerifyPinScreen.btn_Ok.click();

//        Tap confirm button again
        VerifyPinScreen.btn_Confirm.click();

//        CheckPoint: PIN code will notice user that number of time logging in left after being submitted invalid PIN code
        softAssert2.assertEquals(VerifyPinScreen.lbl_Message.getText(),"Bạn đã nhập sai mã PIN 2/5 lần. Vui lòng nhập lại hoặc yêu cầu gửi lại một mã PIN mới.");

//        Close message
        VerifyPinScreen.btn_Ok.click();

//        Tap confirm button again
        VerifyPinScreen.btn_Confirm.click();

//        CheckPoint: PIN code will notice user that number of time logging in left after being submitted invalid PIN code
        softAssert2.assertEquals(VerifyPinScreen.lbl_Message.getText(),"Bạn đã nhập sai mã PIN 3/5 lần. Vui lòng nhập lại hoặc yêu cầu gửi lại một mã PIN mới.");

//        Close message
        VerifyPinScreen.btn_Ok.click();

//        Tap confirm button again
        VerifyPinScreen.btn_Confirm.click();

//        CheckPoint: PIN code will notice user that number of time logging in left after being submitted invalid PIN code
        softAssert2.assertEquals(VerifyPinScreen.lbl_Message.getText(),"Bạn đã nhập sai mã PIN 4/5 lần. Vui lòng nhập lại hoặc yêu cầu gửi lại một mã PIN mới.");

//        Close message
        VerifyPinScreen.btn_Ok.click();

//        Tap confirm button again
        VerifyPinScreen.btn_Confirm.click();

//        CheckPoint: PIN code will notice user that number of time logging in left after being submitted invalid PIN code
        softAssert2.assertEquals(VerifyPinScreen.lbl_Message.getText(),"Bạn đã nhập sai mã PIN 5/5 lần. Vui lòng nhập lại hoặc yêu cầu gửi lại một mã PIN mới.");

//        Close message
        VerifyPinScreen.btn_Ok.click();

//        Tap confirm button again
        VerifyPinScreen.btn_Confirm.click();

//        CheckPoint: PIN code shall become invalid after a time specified
        softAssert2.assertEquals(VerifyPinScreen.lbl_Message.getText(),"Số điện thoại đã bị khóa. Vui lòng liên hệ quản trị để đươc hỗ trợ.");

//        Close message
        VerifyPinScreen.btn_Ok.click();

//        Tap sign in button
        VerifyPinScreen.lbl_SignIn.click();

//        Login with blocked account
        LoginScreen.logIn(randomText, randomText);

//        CheckPoint: After submitted 5 times of invalid PIN code, user cannot login anymore
        softAssert2.assertEquals(LoginScreen.lbl_Message.getText(),"Số điện thoại đã bị khóa. Vui lòng liên hệ quản trị để đươc hỗ trợ.");

//        Close message
        VerifyPinScreen.btn_Ok.click();
        softAssert2.assertAll();
    }

        @Test(priority = 2)
        public void VerifyLoggingSession(){

//        Sign in with valid account
        LoginScreen.logIn("01233069234", "qqqqqq");

//        Home screen should appear
        softAssert3.assertTrue(HomeScreen.btn_ApplyNow.isEnabled());

//        Power off then power on device
        androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);
        androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_POWER);

//        Re-open app
        Activity activity = new Activity("com.futurifyvn.jobhop", "md5360dc1ec547c585df09c8fba6cee2abe.MainActivity");
        androidDriver.startActivity(activity);

//        CheckPoint: After resume app from power off, the user account is still logging in
        softAssert3.assertTrue(HomeScreen.btn_ApplyNow.isEnabled());

//        Exit app
        androidDriver.closeApp();

//        Re-open app
        androidDriver.startActivity(activity);

//        CheckPoint: After resume app from exit app, the user account is still logging in
        softAssert3.assertTrue(HomeScreen.btn_ApplyNow.isEnabled());

//        Open multi-tasking
        androidDriver.pressKeyCode(AndroidKeyCode.KEYCODE_APP_SWITCH);
        androidDriver.pressKeyCode(AndroidKeyCode.HOME);

//        Re-open app
        androidDriver.startActivity(activity);

//        CheckPoint: After resume app from close app (Using multitasking), the user account is still logging in
        softAssert3.assertTrue(HomeScreen.btn_ApplyNow.isEnabled());
        softAssert3.assertAll();
    }
}
