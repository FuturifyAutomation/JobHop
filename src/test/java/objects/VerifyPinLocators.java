package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.BaseClass;

public class VerifyPinLocators {

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.widget.TextView[@text='Xác nhận PIN']")
    public WebElement lbl_Header;

    @FindBy(xpath = ".//android.widget.Button[@text='Xác nhận']/ancestor::android.view.View/preceding-sibling::android.view.View/preceding-sibling::android.view.View/descendant::android.widget.TextView")
    public WebElement lbl_PhoneNumber;

    @FindBy(xpath = ".//android.widget.Button[@text='Xác nhận']/ancestor::android.view.View/preceding-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_Pin;

    @FindBy(xpath = ".//android.widget.Button[@text='Xác nhận']")
    public WebElement btn_Confirm;

    @FindBy(xpath = ".//android.widget.TextView[@text='Gửi lại']")
    public WebElement btn_Resend;

    @FindBy(xpath = ".//android.widget.TextView[@text='Đăng nhập']")
    public WebElement lbl_SignIn;

    @FindBy(id = "android:id/message")
    public WebElement lbl_Message;

    @FindBy(xpath = ".//android.widget.Button[@text='OK']")
    public WebElement btn_Ok;
}
