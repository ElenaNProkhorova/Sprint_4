package ru.practicumService.qaScooter.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageAboutRent {
    private final WebDriver driver;
    //Локатор ввода даты
    private final By dataFieldLocator = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //Локатор ввода периода
    private final By periodFieldLocator = By.xpath(".//div[text()='* Срок аренды']");
    //локатор выбора дней аренды
    private final String periodDaysLocator = ".//div[text()='%s']";
    //локатор кнопки Заказать
    private final By finishOrderButtonLocator = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Локатор кнопки Да
    private final By confirmButtonLocator = By.xpath(".//button[text()='Да']");
    //Локатор сообщения Заказ оформлен
    private final By completeMessage = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPageAboutRent(WebDriver driver) {

        this.driver = driver;
    }

    //ввод даты
    public void inputDate(String dateUser) {
        WebElement dateField = this.driver.findElement(this.dataFieldLocator);
        dateField.sendKeys(new CharSequence[]{dateUser, Keys.ENTER});
    }

    //ввод периода
    public void inputPeriod(String periodUser) {
        WebElement periodField = this.driver.findElement(this.periodFieldLocator);
        periodField.click();
        WebElement periodDays = this.driver.findElement(By.xpath(String.format(".//div[text()='%s']", periodUser)));
        periodDays.click();
    }

    //нажать на кнопку Заказать
    public void pressFinishOrderButton() {
        WebElement finishOrderButton = this.driver.findElement(this.finishOrderButtonLocator);
        finishOrderButton.click();
    }

    //Нажать на кнопку ДА
    public void pressYesOrderButton() {
        WebElement confirmButton = this.driver.findElement(this.confirmButtonLocator);
        confirmButton.click();
    }

    //Сообщение об успешном создании заказа
    public void completeOrder() {
        WebElement confirmMessage = this.driver.findElement(this.completeMessage);
        Assert.assertTrue("Сообщение об успешном создании заказа отсутствует", confirmMessage.isEnabled());
    }
}
