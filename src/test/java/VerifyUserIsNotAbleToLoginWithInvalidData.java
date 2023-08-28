import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class VerifyUserIsNotAbleToLoginWithInvalidData {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("august");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("123456");

        driver.findElement(By.className("radius")).click();

        WebElement notifLoginNotSucces = driver.findElement(By.id("flash"));
        Assert.assertEquals(notifLoginNotSucces.getText(),"Your username is invalid!");



    }
}
