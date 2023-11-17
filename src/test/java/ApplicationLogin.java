import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*1. Open a browser
 2. Open URL (https://opensource-demo.orangehrmlive.com/)
 3. Enter User Name
 4. Enter password
 5. Click on login button
 6. Check the page title*/
public class ApplicationLogin {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com");
//      Thread.sleep(1000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        driver.findElement(By.name("username")).isDisplayed();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Admin");

        WebDriverWait wait2 = new WebDriverWait( driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));


        driver.findElement(By.name("password")).isDisplayed();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        WebDriverWait wait3 = new WebDriverWait( driver, Duration.ofSeconds(5));
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));

//        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.cssSelector("button.oxd-button--medium")).click();

        if ("OrangeHRM" == driver.getTitle()) {
            System.out.println(":Logged In Successfully and it's home page");
        }
        driver.quit();
    }

}
