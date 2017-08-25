package modules;

import configurations.TestInitiation;
import objects.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import supports.AndroidPageFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MainMenu extends TestInitiation{

    private HomeLocators HomeScreen;
    private LoginLocators LoginScreen;
    private BananaShopLocators BananaShopScreen;
    private EditProfileLocators EditProfileScreen;
    private PersonalProfileLocators PersonalProfileScreen;
    private MenuNavigationLocators MenuNavigationScreen;

    private SoftAssert softAssert1 = new SoftAssert();
    private SoftAssert softAssert2 = new SoftAssert();
    private SoftAssert softAssert3 = new SoftAssert();
    private SoftAssert softAssert4 = new SoftAssert();

    public String randomText = new SimpleDateFormat("MMddHHmmss").format(Calendar.getInstance().getTime());
    public String text = "test";
    public String email = "quangdo@futurify.vn";
    public String height = "180";

    @BeforeMethod
    public void setUp(){
        HomeScreen = AndroidPageFactory.initElements(androidDriver, HomeLocators.class);
        LoginScreen = AndroidPageFactory.initElements(androidDriver, LoginLocators.class);
        BananaShopScreen = AndroidPageFactory.initElements(androidDriver, BananaShopLocators.class);
        EditProfileScreen = AndroidPageFactory.initElements(androidDriver, EditProfileLocators.class);
        MenuNavigationScreen = AndroidPageFactory.initElements(androidDriver, MenuNavigationLocators.class);
        PersonalProfileScreen = AndroidPageFactory.initElements(androidDriver, PersonalProfileLocators.class);
    }

    @Test
    public void VerifyMainScreen() throws InterruptedException {

//        Pre-conditions: Register new account
        LoginScreen.logIn("01233069234", "qqqqqq");

//        CheckPoint: User can see these components in Main menu: Profile Picture, Personal Profile, Intro Video, Settings, Bananas Shop and APPLY NOW button
        HomeScreen.btn_PersonalProfile.isEnabled();
        HomeScreen.btn_Search.isEnabled();
        HomeScreen.btn_IntroVideo.isEnabled();
        HomeScreen.btn_BananaShop.isEnabled();
        HomeScreen.btn_Menu.isEnabled();
        HomeScreen.btn_ApplyNow.isEnabled();

//        CheckPoint: Status of Profile Completion shall not display as 100% of completion after Jobseekers are just registered and logged in
        softAssert1.assertEquals(HomeScreen.lbl_CompletePercent.getText(), "Hoàn thiện 40% hồ sơ");

//        Tap on Profile completion
        HomeScreen.lbl_CompletePercent.click();
        Thread.sleep(2000);

//        CheckPoint: Profile Completion will take user to Personal Profile after pressing on it
        softAssert1.assertTrue(PersonalProfileScreen.lbl_PersonalProfile.isDisplayed());

//        Tap back button
        PersonalProfileScreen.btn_Back.click();
        softAssert1.assertAll();
    }

    @Test(priority = 1)
    public void VerifySlideMenuNavigation() throws InterruptedException {

//        Show slide menu
        Thread.sleep(2000);
        HomeScreen.btn_Menu.click();

//        CheckPoint: User can see list of items in Side menu
        MenuNavigationScreen.lbl_Home.isEnabled();
        MenuNavigationScreen.lbl_InterviewSchedule.isEnabled();
        MenuNavigationScreen.lbl_Message.isEnabled();
        MenuNavigationScreen.lbl_Job.isEnabled();
        MenuNavigationScreen.lbl_Exit.isEnabled();

//        CheckPoint: Profile Picture displayed in Side menu
        MenuNavigationScreen.btn_ProfilePicture.isEnabled();

//        Tap on profile picture
        MenuNavigationScreen.btn_ProfilePicture.click();

//        CheckPoint: Job seeker can go to Profile after tapping on Username and Avatar in Sidemenu
        softAssert2.assertTrue(PersonalProfileScreen.lbl_PersonalProfile.isDisplayed());
        Thread.sleep(2000);

//        Tap Back button
        PersonalProfileScreen.btn_Back.click();
        Thread.sleep(2000);

//        Tap on outside of menu navigation
        MenuNavigationScreen.btn_ApplyNow.click();
        Thread.sleep(2000);

//        CheckPoint: User can touch outside of the Side menu to close Side menu
//        CheckPoint: Jobseeker can see his amount of Banana in main menu and linked to Tiệm Chuối after tapping on it
        softAssert2.assertEquals(HomeScreen.lbl_BananaNumber.getText(), "150");

//        Tap on banana number
        HomeScreen.lbl_BananaNumber.click();

//        Tiệm chuối should appear
        BananaShopScreen.lbl_FreeBanana.isDisplayed();
        BananaShopScreen.btn_Share.isEnabled();
        Thread.sleep(2000);

//        Tap back button
        BananaShopScreen.btn_Back.click();
        softAssert2.assertAll();
    }

    @Test(priority = 2)
    public void VerifyFieldsExisting() throws InterruptedException {

//        Tap Personal Profile
        Thread.sleep(2000);
        HomeScreen.btn_PersonalProfile.click();

//        CheckPoint: User can start viewing his self Profile after tapping on Personal Profile component
        softAssert3.assertTrue(PersonalProfileScreen.lbl_PersonalProfile.isDisplayed());

//        CheckPoint: Personal Profile contains these fields: Name, Email, Date of Birth, Current Location, Gender
        softAssert3.assertTrue(PersonalProfileScreen.lbl_FullName.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_BirthDay.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_Gender.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_Height.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_Weight.isDisplayed());

//        Scroll to next fields
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".text(\"NƠI CẤP CMND\"));");
        softAssert3.assertTrue(PersonalProfileScreen.lbl_PhoneNumber.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_Email.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_Address.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_School.isDisplayed());

//        CheckPoint: The personal profile fields including real personal ID card: ID Number, Date delivered, Location ID delivered
        softAssert3.assertTrue(PersonalProfileScreen.lbl_CMND.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_DeliveryDate.isDisplayed());
        softAssert3.assertTrue(PersonalProfileScreen.lbl_DeliveryArea.isDisplayed());

//        CheckPoint: The email that used to registered to be displaying in Profile
        softAssert3.assertEquals(PersonalProfileScreen.lbl_EmailValue.getText(), email);
        softAssert3.assertAll();
    }

    @Test(priority = 3)
    public void VerifyFieldsEditing() throws InterruptedException {

//        Scroll to top screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ VÀ TÊN\");");

//        Tap edit information button
        PersonalProfileScreen.btn_EditInformation.click();

//        CheckPoint: The pencil (edit) button shall lead jobseeker to Edit profile screen
        EditProfileScreen.lbl_EditProfile.isDisplayed();

//        Clear name
        EditProfileScreen.txt_LastName.clear();
        EditProfileScreen.txt_FirstName.clear();

//        Scroll to bottom screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".className(\"android.widget.Button\"));");

//        Tap Save button
        EditProfileScreen.btn_Save.click();

//        CheckPoint: Jobseeker cannot leave edit profile screen until these fields are valid: Tên, Họ, Ngày sinh, Giới tính
        softAssert4.assertEquals(EditProfileScreen.lbl_Message.getText(), "Tên và họ bắt buộc phải nhập");

//        Close message
        EditProfileScreen.btn_Ok.click();
        Thread.sleep(1000);

//        Scroll to top screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ\");");

//        Type last name
        EditProfileScreen.txt_LastName.sendKeys(randomText);

//        Scroll to bottom screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".className(\"android.widget.Button\"));");

//        Tap Save button
        EditProfileScreen.btn_Save.click();

//        CheckPoint: Jobseeker cannot leave edit profile screen until these fields are valid: Tên, Họ, Ngày sinh, Giới tính
        softAssert4.assertEquals(EditProfileScreen.lbl_Message.getText(), "Họ bắt buộc phải nhập");

//        Close message
        EditProfileScreen.btn_Ok.click();
        Thread.sleep(1000);

//        Scroll to top screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ\");");

//        Type first name
        EditProfileScreen.txt_FirstName.sendKeys(text);

//        Scroll to bottom screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".className(\"android.widget.Button\"));");

//        Tap Save button
        EditProfileScreen.btn_Save.click();

//        CheckPoint: Jobseeker cannot leave edit profile screen until these fields are valid: Tên, Họ, Ngày sinh, Giới tính
        softAssert4.assertEquals(EditProfileScreen.lbl_Message.getText(), "Ngày sinh bắt buộc phải chọn");

//        Close message
        EditProfileScreen.btn_Ok.click();
        Thread.sleep(1000);

//        Scroll to top screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ\");");

//        Select birthday
        EditProfileScreen.inputBirthday();

//        Scroll to bottom screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".className(\"android.widget.Button\"));");

//        Tap Save button
        EditProfileScreen.btn_Save.click();

//        CheckPoint: Jobseeker cannot leave edit profile screen until these fields are valid: Tên, Họ, Ngày sinh, Giới tính
        softAssert4.assertEquals(EditProfileScreen.lbl_Message.getText(), "Giới tính bắt buộc phải chọn");

//        Close message
        EditProfileScreen.btn_Ok.click();
        Thread.sleep(1000);

//        Scroll to top screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ\");");

//        Select gender
        EditProfileScreen.selectGender();

//        Scroll to bottom screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".className(\"android.widget.Button\"));");

//        Tap Save button
        EditProfileScreen.btn_Save.click();

//        CheckPoint: Jobseeker cannot leave edit profile screen until these fields are valid: Tên, Họ, Ngày sinh, Giới tính
        softAssert4.assertEquals(EditProfileScreen.lbl_Message.getText(), "Chiều cao bắt buộc phải nhập");

//        Close message
        EditProfileScreen.btn_Ok.click();
        Thread.sleep(1000);

//        Scroll to top screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
                + ".getChildByText(new UiSelector().className(\"android.widget.TextView\"), \"HỌ\");");

//        Type height
        EditProfileScreen.txt_Height.sendKeys(height);

//        Scroll to center screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".text(\"EMAIL\"));");

//        CheckPoint: Jobseeker cannot edit his phone number
        softAssert4.assertFalse(EditProfileScreen.txt_PhoneNumber.isEnabled());

//        CheckPoint: The email that used to registered to be displaying in Profile
        softAssert4.assertEquals(EditProfileScreen.txt_Email.getText(), email);

//        Scroll to bottom of screen
        androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector()"
                + ".className(\"android.widget.Button\"));");

//        Type CMND
        EditProfileScreen.txt_CMND.sendKeys(text + randomText + "33");

//        CheckPoint: ID number field can only input number digit, keyboard will only display numpad after Jobseeker tapping on it
        softAssert4.assertEquals(EditProfileScreen.txt_CMND.getText(), randomText + "33");

//        Type school
        EditProfileScreen.txt_School.sendKeys("tin");
        Thread.sleep(2000);

//        CheckPoint: School info field can be suggested by many options after Jobseeker input matched character
        softAssert4.assertTrue(androidDriver.findElement(By.xpath(".//android.widget.TextView[@text='Trường ĐH Ngoại ngữ - Tin học TP.HCM']")).isDisplayed());
        softAssert4.assertTrue(androidDriver.findElement(By.xpath(".//android.widget.TextView[@text='Trường Đại học Công nghệ thông tin Gia Định  ']")).isDisplayed());
        softAssert4.assertTrue(androidDriver.findElement(By.xpath(".//android.widget.TextView[@text='Trường Đại học Công nghệ Thông tin - ĐH Quốc gia TP.HCM']")).isDisplayed());

//        Type school again
        EditProfileScreen.txt_School.clear();
        EditProfileScreen.txt_School.sendKeys("tin tuyen dung");
        Thread.sleep(2000);

//        CheckPoint: School info field can be input with value different from suggestion
        softAssert4.assertEquals(EditProfileScreen.txt_School.getText(), "tin tuyen dung");
        List<WebElement> elementList = androidDriver.findElements(By.className("android.widget.TextView"));
        softAssert4.assertEquals(elementList.size(),6);

//        Tap save button
        EditProfileScreen.btn_Save.click();

//        CheckPoint: User can see his profile to be updated after fields are valid and saved in Personal Profile
        softAssert4.assertEquals(PersonalProfileScreen.lbl_FullNameValue.getText(),text + " " + randomText);
        softAssert4.assertTrue(PersonalProfileScreen.lbl_BirthDayValue.getText().contains("2016"));
        softAssert4.assertEquals(PersonalProfileScreen.lbl_GenderValue.getText(), "Nam");
        softAssert4.assertEquals(PersonalProfileScreen.lbl_HeightValue.getText(), height);
        softAssert4.assertAll();
    }
}
