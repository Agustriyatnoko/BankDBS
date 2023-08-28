import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class VerifyUserAbleToLoginSuccessfully {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();

        driver.get("http://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.className("radius")).click();

        WebElement notifLoginSucces = driver.findElement(By.id("flash"));
        Assert.assertEquals(notifLoginSucces.getText(),"You logged into a secure area!");

        WebElement titleSecureArea = driver.findElement(By.className("icon-lock"));
        Assert.assertEquals(titleSecureArea.getText(),"Secure Area");

        WebElement titleWelcomeArea = driver.findElement(By.className("subheader"));
        Assert.assertEquals(titleWelcomeArea.getText(),"Welcome to the Secure Area. When you are done click logout below.");

    }
}
