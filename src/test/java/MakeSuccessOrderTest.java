import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.practicumService.qaScooter.pages.HomePage;
import ru.practicumService.qaScooter.pages.OrderPageAboutRent;
import ru.practicumService.qaScooter.pages.OrderPagePersonal;

public class MakeSuccessOrderTest {
    private WebDriver driver;

    public MakeSuccessOrderTest() {
    }

    @Before
    public void setup() {
        WebDriverFactory WebDriverFactory = new WebDriverFactory();
        this.driver = WebDriverFactory.getWebdriver(System.getProperty("browser", "firefox"));
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void successOrderTestUpButton() {
        HomePage createOrder = new HomePage(this.driver);
        createOrder.closeCookieMessage();
        createOrder.clickOrderUpButton();
        OrderPagePersonal orderPagePersonal = new OrderPagePersonal(this.driver);
        orderPagePersonal.inputName("Имя");
        orderPagePersonal.inputSurName("Фамилия");
        orderPagePersonal.inputAdress("Москва");
        orderPagePersonal.inputMetroStation(78, "Арбатская");
        orderPagePersonal.inputTel("89123456789");
        orderPagePersonal.clickNextButton();
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(this.driver);
        orderPageAboutRent.inputDate("01.05.2024");
        orderPageAboutRent.inputPeriod("двое суток");
        orderPageAboutRent.pressFinishOrderButton();
        orderPageAboutRent.pressYesOrderButton();
        orderPageAboutRent.completeOrder();
    }

    @Test
    public void successOrderTestDownButton() {
        HomePage createOrder = new HomePage(this.driver);
        createOrder.closeCookieMessage();
        createOrder.clickOrderDownButton();
        OrderPagePersonal orderPagePersonal = new OrderPagePersonal(this.driver);
        orderPagePersonal.inputName("Елена");
        orderPagePersonal.inputSurName("Прохорова");
        orderPagePersonal.inputAdress("Питер");
        orderPagePersonal.inputMetroStation(57, "Арбатская");
        orderPagePersonal.inputTel("11111111111");
        orderPagePersonal.clickNextButton();
        OrderPageAboutRent orderPageAboutRent = new OrderPageAboutRent(this.driver);
        orderPageAboutRent.inputDate("01.06.2024");
        orderPageAboutRent.inputPeriod("трое суток");
        orderPageAboutRent.pressFinishOrderButton();
        orderPageAboutRent.pressYesOrderButton();
        orderPageAboutRent.completeOrder();
    }

    @After
    public void tearDown() {
        this.driver.quit();
    }
}
