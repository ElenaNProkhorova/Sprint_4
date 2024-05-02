import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {
    public WebDriverFactory() {
    }

    public static WebDriver getWebdriver(String browserType) {
        if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver();
            return new OperaDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
}
