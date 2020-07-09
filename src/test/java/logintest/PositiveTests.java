package logintest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PositiveTests {


    @Test
    public void loginTest(){
        SimpleDateFormat starting=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //trying to record start point
        SimpleDateFormat ending=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //trying to record end point
        Date date=new Date();
        System.out.println("START login test "+ starting.format(date));
        //comments defining intention

        //Create driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver=new ChromeDriver();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //open test page
        String url="http://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");




        //maximise browser window
        driver.manage().window().maximize();

        //enter username
        WebElement username=driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //enter password
        WebElement password=driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //click log in button
        WebElement logInButton=driver.findElement(By.tagName("button"));
        logInButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //verification:
        //new url

        //logout button is visible
        WebElement logOutButton=driver.findElement(By.xpath("//a[@class='button secondary radius']"));


        //successful login method
        WebElement successMessage=driver.findElement(By.cssSelector("#flash"));
        //Close browser

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        System.out.println("END of login test "+ ending.format(date));

    }
}
