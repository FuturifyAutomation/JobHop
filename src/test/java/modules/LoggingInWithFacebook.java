package modules;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import supports.BaseClass;

public class LoggingInWithFacebook extends BaseClass{

    @Test
    public void asd(){

//        CheckPoint: User can see Facebook login option in Login screen
        LoginScreen.btn_Facebook.isEnabled();

//        Tap facebook button
        LoginScreen.btn_Facebook.click();














    }

    @AfterMethod
    public void finalAssertion(){
        SoftAssert.assertAll();
    }
}
