package supports;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;

public class Swiping extends BaseClass {

    public AndroidDriver androidDriver;
    public Dimension size;

    public void swipeForward() throws InterruptedException {
        size = androidDriver.manage().window().getSize();
        System.out.println(size);
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
        androidDriver.swipe(startx, starty, endx, starty, 1000);
        Thread.sleep(2000);
    }

    public  void swipeBack() throws InterruptedException {
        size = androidDriver.manage().window().getSize();
        System.out.println(size);
        int startx = (int) (size.width * 0.70);
        int endx = (int) (size.width * 0.30);
        int starty = size.height / 2;
        System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);
        androidDriver.swipe(endx, starty, startx, starty, 1000);
        Thread.sleep(2000);
    }
}
