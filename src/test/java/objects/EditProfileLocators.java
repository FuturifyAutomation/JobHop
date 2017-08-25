package objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfileLocators{

    /**
     * txt --> text box
     * rad --> radio button
     * btn --> button
     * lbl --> label
     * lnk --> link
     * lst --> list
     * chk --> checkbox
     */

    @FindBy(xpath = ".//android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]android.widget.ImageView[1]")
    public WebElement btn_Back;

    @FindBy(xpath = ".//android.widget.TextView[contains(@text,'Chỉnh sửa thông tin')]")
    public WebElement lbl_EditProfile;

    @FindBy(xpath = ".//android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]")
    public WebElement txt_FirstName;

    @FindBy(xpath = ".//android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[4]/android.widget.EditText[1]")
    public WebElement txt_LastName;

    @FindBy(xpath = ".//android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[6]/android.widget.EditText[1]")
    public WebElement txt_BirthDay;

    @FindBy(xpath = ".//android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[8]/android.widget.EditText[1]")
    public WebElement txt_Gender;

    @FindBy(xpath = ".//android.widget.TextView[@text='EMAIL']/ancestor::android.view.View/preceding-sibling::android.view.View/android.widget.EditText[1]")
    public WebElement txt_PhoneNumber;

    @FindBy(xpath = ".//android.widget.TextView[@text='EMAIL']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.EditText[1]")
    public WebElement txt_Email;

    @FindBy(xpath = ".//android.view.View[2]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[1]/android.view.View[11]/android.widget.EditText[1]")
    public WebElement txt_Address;

    @FindBy(xpath = ".//android.widget.TextView[@text='CHIỀU CAO (CM)']/ancestor::android.view.View/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_Height;

    @FindBy(xpath = ".//android.widget.TextView[@text='CÂN NẶNG (KG)']/ancestor::android.view.View/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_Weight;

    @FindBy(xpath = ".//android.widget.TextView[@text='TRƯỜNG HỌC']/ancestor::android.view.View/following-sibling::android.view.View/android.view.View[1]/android.view.View[1]/android.widget.EditText[1]")
    public WebElement txt_School;

    @FindBy(xpath = ".//android.widget.TextView[@text='CMND']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.EditText[1]")
    public WebElement txt_CMND;

    @FindBy(xpath = ".//android.widget.TextView[@text='NGÀY CẤP CMND']/ancestor::android.view.View/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_DeliveryDate;

    @FindBy(xpath = ".//android.widget.TextView[@text='NƠI CẤP CMND']/ancestor::android.view.View/ancestor::android.view.View/following-sibling::android.view.View/descendant::android.widget.EditText")
    public WebElement txt_DeliveryArea;

    @FindBy(xpath = ".//android.widget.Button[@text='Lưu']")
    public WebElement btn_Save;

    @FindBy(id = "android:id/message")
    public WebElement lbl_Message;

    @FindBy(xpath = ".//android.widget.Button[@text='OK']")
    public WebElement btn_Ok;

    @FindBy(xpath = ".//android.widget.Button[@text='2016']")
    public WebElement btn_Year;

    @FindBy(xpath = ".//android.widget.Button[@text='Xong']")
    public WebElement btn_Done;

    public void inputBirthday(){

//        Open birthday dropdown
        txt_BirthDay.click();

//        Select year
        btn_Year.click();

//        Tap ok button
        btn_Done.click();
    }

    public void selectGender(){

//        Open gender dropdown
        txt_Gender.click();

//        Select gender
//        Tap ok button
        btn_Ok.click();
    }

    public void fillEditProfileFields(String firstName, String lastName, String birthDay, String gender, String email, String address){

//        Type first name
        if (firstName != ""){
            txt_FirstName.sendKeys(firstName);
        }

//        Type last name
        if (lastName != ""){
            txt_LastName.sendKeys(lastName);
        }

//        Select birthday
        if(birthDay != ""){
            txt_BirthDay.sendKeys(birthDay);
        }

//        Select gender
        if (gender != ""){
            txt_Gender.click();
//            androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + gender + "\");");
            btn_Ok.click();
        }

//        Type email
        if (email != ""){
            txt_Email.sendKeys(email);
        }

//        Type address
        if (address != ""){
//            androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Lưu\");");
            txt_Address.sendKeys(address);
        }
    }

    public void editPersonalProfile(String firstName, String lastName, String birthDay, String gender, String email, String address){
        fillEditProfileFields(firstName, lastName, birthDay, gender, email, address);
        btn_Save.click();
    }
}
