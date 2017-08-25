package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.BaseClass;

public class ForgotPasswordLocators{

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.widget.TextView[@text='Quên mật khẩu']")
    public WebElement lbl_Header;

    @FindBy(xpath = ".//android.widget.TextView[@text='SỐ ĐIỆN THOẠI']")
    public WebElement lbl_PhoneNumber;

    @FindBy(className = "android.widget.EditText")
    public WebElement txt_PhoneNumber;

    @FindBy(className = "android.widget.EditText")
    public WebElement txt_Pin;

    @FindBy(xpath = ".//android.view.View[2]/android.widget.EditText[1]")
    public WebElement txt_NewPassword;

    @FindBy(xpath = ".//android.view.View[4]/android.widget.EditText[1]")
    public WebElement txt_ConfirmNewPassword;

    @FindBy(xpath = ".//android.widget.Button[@text='Gửi']")
    public WebElement btn_Send;

    @FindBy(xpath = ".//android.widget.Button[@text='Xác nhận']")
    public WebElement btn_Confirm;

    @FindBy(xpath = ".//android.widget.TextView[@text='PIN']")
    public WebElement lbl_Pin;

    @FindBy(xpath = ".//android.widget.TextView[@text='Gửi lại']")
    public WebElement lbl_Resend;

    @FindBy(xpath = ".//android.widget.TextView[@text='Quay lại']")
    public WebElement lbl_Back;

    @FindBy(id = "android:id/message")
    public WebElement lbl_Message;

    @FindBy(xpath = ".//android.widget.Button[@text='OK']")
    public WebElement btn_Ok;

    public void changePassword(String newPassword, String confirmNewPassword){
        txt_NewPassword.sendKeys(newPassword);
        txt_ConfirmNewPassword.sendKeys(confirmNewPassword);
        btn_Confirm.click();
    }
}
