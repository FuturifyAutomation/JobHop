package supports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

public class Waiting extends BaseClass{

    WebDriver webDriver;

    // This is a constructor, as every page need a base driver to find web elements
//    public Waiting(WebDriver driver){
//        this.webDriver = driver;
//    }

    public void waitForTextViewSize(int amount, int seconds) throws InterruptedException {

//        Get size of text view list
        List<WebElement> lTextView = webDriver.findElements(By.className("android.widget.TextView"));
        int iTextViewCount = lTextView.size();
        int i = 0;
        while (iTextViewCount != amount & i <= seconds) {
            Thread.sleep(1000);
            lTextView = webDriver.findElements(By.className("android.widget.TextView"));
            iTextViewCount = lTextView.size();
            i++;
        }
    }

    public void waitForEditTextSize(int amount, int seconds) throws InterruptedException {

//        Get size of edit text list
        List<WebElement> lEditText = webDriver.findElements(By.className("android.widget.EditText"));
        int iTextViewCount = lEditText.size();
        int i = 0;
        while (iTextViewCount != amount & i <= seconds) {
            Thread.sleep(1000);
            lEditText = webDriver.findElements(By.className("android.widget.EditText"));
            iTextViewCount = lEditText.size();
            i++;
        }
    }
}
