import  config.env_target;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login extends env_target{

    @Test
    public  void main(){
        System.setProperty("webdriver.chrome.driver","D:\\testing_web\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(120);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[3]/button"))
        );

        driver.findElement(By.name("email")).sendKeys("admin@example.com");
        driver.findElement(By.id("password")).sendKeys("password");

        driver.findElement(By.xpath("/html/body/section/div/div/div/div/div[2]/form/div[3]/button")).click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"navbar\"]/div/ol/li"))
        );


    }
}
