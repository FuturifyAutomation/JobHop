package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.BaseClass;

public class MenuNavigationLocators extends BaseClass{

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement btn_ProfilePicture;

    @FindBy(xpath = ".//android.widget.Button[@text='ỨNG TUYỂN NGAY!']")
    public WebElement btn_ApplyNow;

    @FindBy(xpath = ".//android.widget.TextView[@text='Trang chủ']")
    public WebElement lbl_Home;

    @FindBy(xpath = ".//android.widget.TextView[@text='Lịch phỏng vấn']")
    public WebElement lbl_InterviewSchedule;

    @FindBy(xpath = ".//android.widget.TextView[@text='Lịch phỏng vấn']")
    public WebElement lbl_Message;

    @FindBy(xpath = ".//android.widget.TextView[@text='Lịch phỏng vấn']")
    public WebElement lbl_Job;

    @FindBy(xpath = ".//android.widget.TextView[@text='Lịch phỏng vấn']")
    public WebElement lbl_Exit;
}
