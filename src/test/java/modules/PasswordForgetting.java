package modules;

import configurations.TestInitiation;
import objects.ForgotPasswordLocators;
import objects.LoginLocators;
import objects.RegistrationLocators;
import objects.VerifyPinLocators;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;
import supports.BaseClass;

public class PasswordForgetting extends TestInitiation{

    private LoginLocators LoginScreen;
    private ForgotPasswordLocators ForgotPasswordScreen;

    private SoftAssert softAssert1 = new SoftAssert();
    private SoftAssert softAssert2 = new SoftAssert();
    private SoftAssert softAssert3 = new SoftAssert();

    @BeforeMethod
    private void setUp() {
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LoginLocators.class);
        ForgotPasswordScreen = AndroidPageFactory.initElements(androidDriver, ForgotPasswordLocators.class);
    }

    @Test
    public void VerifyFields(){

//        CheckPoint: Forgot Password Link can be found within Login screen
        softAssert1.assertTrue(LoginScreen.lbl_ForgotPassword.isEnabled());

//        Tap forgot password link
        LoginScreen.lbl_ForgotPassword.click();

//        CheckPoint: After clicking on Link system must navigate to Forgot Password screen
        softAssert1.assertTrue(ForgotPasswordScreen.lbl_Header.isDisplayed());
        softAssert1.assertTrue(ForgotPasswordScreen.lbl_PhoneNumber.isDisplayed());
        softAssert1.assertTrue(ForgotPasswordScreen.btn_Send.isEnabled());

//        CheckPoint: A link return to Login screen must be always available in Forgot password screen
        softAssert1.assertTrue(ForgotPasswordScreen.lbl_Back.isEnabled());
        softAssert1.assertAll();
    }

    @Test(priority = 1)
    public void VerifyFieldsValidation() {

//        Type phone number
        ForgotPasswordScreen.txt_PhoneNumber.sendKeys("111111");

//        Tap Send button
        ForgotPasswordScreen.btn_Send.click();

//        CheckPoint: Jobseeker must input valid phone number to begin process
        softAssert2.assertEquals(ForgotPasswordScreen.lbl_Message.getText(), "Định dạng số điện thoại không đúng.");

//        Close message
        ForgotPasswordScreen.btn_Ok.click();

//        Type phone number again
        ForgotPasswordScreen.txt_PhoneNumber.clear();
        ForgotPasswordScreen.txt_PhoneNumber.sendKeys("1000000000");

//        Tap Send button
        ForgotPasswordScreen.btn_Send.click();

//        CheckPoint: Jobseeker received an error message "Số điện thoại không tồn tại" after submiting request for an unexisted number
        softAssert2.assertEquals(ForgotPasswordScreen.lbl_Message.getText(), "Số điện thoại này chưa được đăng ký.");

//        Close message
        ForgotPasswordScreen.btn_Ok.click();
        softAssert2.assertAll();
    }

    @Test(priority = 2)
    public void VerifyPinValidation() {

//        Type valid phone number
        ForgotPasswordScreen.txt_PhoneNumber.clear();
        ForgotPasswordScreen.txt_PhoneNumber.sendKeys("01233069234");

//        Tap send button
        ForgotPasswordScreen.btn_Send.click();

//        CheckPoint: Jobseeker must have PIN code to use Forgot password feature
        softAssert3.assertTrue(ForgotPasswordScreen.lbl_Pin.isDisplayed());
        softAssert3.assertTrue(ForgotPasswordScreen.btn_Confirm.isEnabled());

//        Tap confirm button
        ForgotPasswordScreen.btn_Confirm.click();

//        CheckPoint: Submitting an empty - null field will be counted as one invalid submit
        softAssert3.assertEquals(ForgotPasswordScreen.lbl_Message.getText(), "Mã PIN không được để trống.");

//        Close message
        ForgotPasswordScreen.btn_Ok.click();

//        Type invalid pin
        ForgotPasswordScreen.txt_Pin.sendKeys("111111");

//        Tap confirm button
        ForgotPasswordScreen.btn_Confirm.click();

//        CheckPoint: A popup with message noticing Jobseeker is input an invalid PIN code
        softAssert3.assertEquals(ForgotPasswordScreen.lbl_Message.getText(), "Mã PIN sai.");

//        Close message
        ForgotPasswordScreen.btn_Ok.click();

//        Tap resend button
        ForgotPasswordScreen.lbl_Resend.click();

//        CheckPoint: Jobseeker received PIN code as a SMS after hit on request new PIN code
        softAssert3.assertEquals(ForgotPasswordScreen.lbl_Message.getText(), "Mã PIN đã được gửi lại.");

//        Close message
        ForgotPasswordScreen.btn_Ok.click();

////        Type valid pin
//        ForgotPasswordScreen.txt_Pin.sendKeys("");
//
////        Tap confirm button
//        ForgotPasswordScreen.btn_Confirm.click();
        softAssert3.assertAll();
    }

    /*@Test
    public void VerifyChangingPasswordValidation() {

//        Change password
        ForgotPasswordScreen.changePassword("qqqqq", "qqqqqq");

//        CheckPoint: An error message shall display after jobseeker input mismatch password for New password and Confirm new password
        ForgotPasswordScreen.verifyMessageContent("Mật khẩu xác nhận không khớp.");

//        Change password again
        ForgotPasswordScreen.changePassword("qqqqqq", "qqqqqq");

//        CheckPoint: Jobseeker received a message with content "Your password has been changed /successful" after password is successfully changed
        ForgotPasswordScreen.verifyMessageContent("Thay đổi mật khẩu thành công.");

//        CheckPoint: Jobseeker can see Login screen displayed after Reset Password process
        LoginScreen.btn_SignIn.isEnabled();
        LoginScreen.btn_Facebook.isEnabled();
    }*/

    /*@Test
    public void VerifyLoggingInAfterChangingPassword(){

//        Login with old password
        LoginScreen.logIn("","");

//        CheckPoint: Jobseeker can not login using old password anymore
        LoginScreen.verifyMessageContent("Số điện thoại hoặc mật khẩu đã nhập không đúng. Vui lòng thử lại.");

//        Login with new password
        LoginScreen.logIn("", "");

//        CheckPoint: New password can be used to login successfully
        HomeScreen.btn_ApplyNow.isEnabled();
    }*/
}
