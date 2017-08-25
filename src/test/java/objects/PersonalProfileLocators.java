package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalProfileLocators{

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement btn_Back;

    @FindBy(xpath = ".//android.widget.TextView[@text='Lý lịch bản thân']")
    public WebElement lbl_PersonalProfile;

    @FindBy(xpath = ".//android.view.View[1]/android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement btn_EditInformation;

    @FindBy(xpath = ".//android.widget.TextView[@text='HỌ VÀ TÊN']")
    public WebElement lbl_FullName;

    @FindBy(xpath = ".//android.widget.TextView[@text='CHIỀU CAO (CM)']")
    public WebElement lbl_Height;

    @FindBy(xpath = ".//android.widget.TextView[@text='TRƯỜNG HỌC']")
    public WebElement lbl_School;

    @FindBy(xpath = ".//android.widget.TextView[@text='CÂN NẶNG (KG)']")
    public WebElement lbl_Weight;

    @FindBy(xpath = ".//android.widget.TextView[@text='CMND']")
    public WebElement lbl_CMND;

    @FindBy(xpath = ".//android.widget.TextView[@text='NGÀY CẤP CMND']")
    public WebElement lbl_DeliveryDate;

    @FindBy(xpath = ".//android.widget.TextView[@text='NƠI CẤP CMND']")
    public WebElement lbl_DeliveryArea;

    @FindBy(xpath = ".//android.widget.TextView[@text='NGÀY SINH']")
    public WebElement lbl_BirthDay;

    @FindBy(xpath = ".//android.widget.TextView[@text='GIỚI TÍNH']")
    public WebElement lbl_Gender;

    @FindBy(xpath = ".//android.widget.TextView[@text='SỐ ĐIỆN THOẠI']")
    public WebElement lbl_PhoneNumber;

    @FindBy(xpath = ".//android.widget.TextView[@text='EMAIL']")
    public WebElement lbl_Email;

    @FindBy(xpath = ".//android.widget.TextView[@text='ĐỊA CHỈ']")
    public WebElement lbl_Address;

    @FindBy(xpath = ".//android.widget.TextView[@text='KINH NGHIỆM']")
    public WebElement lbl_Experience;

    @FindBy(xpath = ".//android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.widget.ImageView[1]")
    public WebElement btn_EditExperience;

    @FindBy(xpath = ".//android.widget.TextView[@text='HỌ VÀ TÊN']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.TextView[1]")
    public WebElement lbl_FullNameValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='NGÀY SINH']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.TextView[1]")
    public WebElement lbl_BirthDayValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='GIỚI TÍNH']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.TextView[1]")
    public WebElement lbl_GenderValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='CHIỀU CAO (CM)']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.TextView[1]")
    public WebElement lbl_HeightValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='CÂN NẶNG (KG)']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.TextView")
    public WebElement lbl_WeightValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='EMAIL']/ancestor::android.view.View/preceding-sibling::android.view.View/android.widget.EditText[1]")
    public WebElement lbl_PhoneNumberValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='EMAIL']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.TextView[1]")
    public WebElement lbl_EmailValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='ĐỊA CHỈ']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.TextView")
    public WebElement lbl_AddressValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='TRƯỜNG HỌC']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.TextView")
    public WebElement lbl_SchoolValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='CMND']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.TextView")
    public WebElement lbl_CMNDValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='NGÀY CẤP CMND']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.TextView")
    public WebElement lbl_DeliveryDateValue;

    @FindBy(xpath = ".//android.widget.TextView[@text='NƠI CẤP CMND']/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.TextView")
    public WebElement lbl_DeliveryAreaValue;
}