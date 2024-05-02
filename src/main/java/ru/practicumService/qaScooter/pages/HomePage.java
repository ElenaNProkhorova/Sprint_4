package ru.practicumService.qaScooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private final WebDriver driver;
    //сообщение о закрытии куки
    private By cookieCloseButtonLocator = By.xpath(".//button[text()='да все привыкли']");
    //Верхняя кнопка Заказать
    private By orderButtonUpLocator = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //Нижняя кнопка Заказать
    private By orderButtonDownLocator = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //локатор вопроса
    private String questionLocator = "accordion__heading-%s";
    //локатор ответа
    private String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    //метод закрытия окна о куках
    public void closeCookieMessage() {

        this.driver.findElement(this.cookieCloseButtonLocator).click();
    }

    //метод выбора вопроса
    public void runToAccordion(int index) {
        WebElement questionElement = this.driver.findElement(By.id(String.format(this.questionLocator, index)));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{questionElement});
        (new WebDriverWait(this.driver, 3L)).until(ExpectedConditions.elementToBeClickable(questionElement));
        questionElement.click();
    }

    //метод получения ответа
    public boolean getQuestion(String expectedAnswer) {
        WebElement questionElement = this.driver.findElement(By.xpath(String.format(this.answerLocator, expectedAnswer)));
        return questionElement.isDisplayed();
    }

    //метод нажимает на верхнюю кнопку Заказать
    public void clickOrderUpButton() {
        WebElement orderUpButton = this.driver.findElement(this.orderButtonUpLocator);
        orderUpButton.click();
    }

    //метод нажимает на нижнюю кнопку Заказать
    public void clickOrderDownButton() {
        WebElement orderDownButton = this.driver.findElement(this.orderButtonDownLocator);
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{orderDownButton});
        orderDownButton.click();
    }
}
