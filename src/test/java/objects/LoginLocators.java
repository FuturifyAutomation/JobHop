package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators{

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(className = "android.widget.ImageView")
    public WebElement lbl_Header;

    @FindBy(xpath = ".//android.widget.TextView[@text='SỐ ĐIỆN THOẠI']")
    public WebElement lbl_PhoneNumber;

    @FindBy(xpath = ".//android.widget.TextView[@text='SỐ ĐIỆN THOẠI']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_PhoneNumber;

    @FindBy(xpath = ".//android.widget.TextView[@text='MẬT KHẨU']")
    public WebElement lbl_Password;

    @FindBy(xpath = ".//android.widget.TextView[@text='MẬT KHẨU']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_Password;

    @FindBy(xpath = ".//android.widget.Button[@text='Đăng nhập']")
    public WebElement btn_SignIn;

    @FindBy(xpath = ".//android.widget.Button[@text='Facebook']")
    public WebElement btn_Facebook;

    @FindBy(xpath = ".//android.widget.TextView[@text='Quên mật khẩu']")
    public WebElement lbl_ForgotPassword;

    @FindBy(xpath = ".//android.widget.TextView[@text='Đăng ký']")
    public WebElement lbl_Register;

    @FindBy(id = "android:id/message")
    public WebElement lbl_Message;

    @FindBy(xpath = ".//android.widget.Button[@text='OK']")
    public WebElement btn_Ok;

    public void logIn(String phoneNumber, String passWord){

//        Type phone number
        txt_PhoneNumber.clear();
        txt_PhoneNumber.sendKeys(phoneNumber);

//        Type password
        txt_Password.clear();
        txt_Password.sendKeys(passWord);

//        Tap sign in
        btn_SignIn.click();
    }
}
