package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supports.BaseClass;

public class BananaShopLocators extends BaseClass{

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.view.View[1]/android.view.View[3]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement btn_Back;

    @FindBy(xpath = ".//android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.widget.TextView[1]")
    public WebElement lbl_BananaNumber;

    @FindBy(xpath = ".//android.widget.TextView[@text='Nhận chuối miễn phí']")
    public WebElement lbl_FreeBanana;

    @FindBy(xpath = ".//android.widget.TextView[@text='Chia sẻ']")
    public WebElement btn_Share;
}
