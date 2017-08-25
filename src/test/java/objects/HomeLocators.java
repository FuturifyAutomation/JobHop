package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.BaseClass;

public class HomeLocators extends BaseClass{

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.widget.TextView[contains(@text,'Hoàn thiện')]")
    public WebElement lbl_CompletePercent;

    @FindBy(xpath = ".//android.widget.TextView[contains(@text,'Hoàn thiện')]/ancestor::android.view.View/ancestor::android.view.View/ancestor::android.view.View/preceding-sibling::android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]")
    public WebElement lbl_BananaNumber;

    @FindBy(xpath = ".//android.widget.TextView[contains(@text,'Hoàn thiện')]/ancestor::android.view.View/ancestor::android.view.View/ancestor::android.view.View/preceding-sibling::android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement btn_Menu;

    @FindBy(xpath = ".//android.widget.TextView[@text='Lý lịch bản thân']")
    public WebElement btn_PersonalProfile;

    @FindBy(xpath = ".//android.widget.TextView[@text='Tìm kiếm']")
    public WebElement btn_Search;

    @FindBy(xpath = ".//android.widget.TextView[@text='Video giới thiệu']")
    public WebElement btn_IntroVideo;

    @FindBy(xpath = ".//android.widget.TextView[@text='Tiệm chuối']")
    public WebElement btn_BananaShop;

    @FindBy(xpath = ".//android.widget.Button[@text='ỨNG TUYỂN NGAY!']")
    public WebElement btn_ApplyNow;
}
