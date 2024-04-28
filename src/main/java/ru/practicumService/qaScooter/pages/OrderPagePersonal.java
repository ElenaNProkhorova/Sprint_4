package ru.practicumService.qaScooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPagePersonal {
    private final WebDriver driver;
    //локатор имени
    private final By nameFieldLocator = By.xpath(".//input[@placeholder='* Имя']");
    //локатор фамилии
    private final By surNameLocator = By.xpath(".//input[@placeholder='* Фамилия']");
    //локатор адреса
    private final By adressLocator = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор станции метро
    private final By metroLocator = By.xpath(".//input[@placeholder='* Станция метро']");
    //локатор выбора станции
    private final String metroStationLocator = "//button[@value='%s'][div[text()='%s']]";
    //локатор телефона
    private final By telLocator = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки Далее
    private final By nextButtonLocator = By.xpath(".//button[text()='Далее']");

    public OrderPagePersonal(WebDriver driver) {

        this.driver = driver;
    }

    //ввод имени
    public void inputName(String nameUser) {
        WebElement nameField = this.driver.findElement(this.nameFieldLocator);
        nameField.sendKeys(new CharSequence[]{nameUser});
    }

    //ввод фамилии
    public void inputSurName(String surnameUser) {
        WebElement surnameField = this.driver.findElement(this.surNameLocator);
        surnameField.sendKeys(new CharSequence[]{surnameUser});
    }

    //ввод адреса
    public void inputAdress(String adressUser) {
        WebElement adressField = this.driver.findElement(this.adressLocator);
        adressField.sendKeys(new CharSequence[]{adressUser});
    }

    //ввод метро
    public void inputMetroStation(int numStation, String stationUser) {
        WebElement metroField = this.driver.findElement(this.metroLocator);
        metroField.click();
        WebElement metroStation = this.driver.findElement(By.xpath(String.format("//button[@value='%s'][div[text()='%s']]", numStation, stationUser)));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{metroStation});
        metroStation.click();
    }

    //ввод телефона
    public void inputTel(String telUser) {
        WebElement telField = this.driver.findElement(this.telLocator);
        telField.sendKeys(new CharSequence[]{telUser});
    }

    //нажать на кнопку Далее
    public void clickNextButton() {
        WebElement nextButton = this.driver.findElement(this.nextButtonLocator);
        nextButton.click();
    }
}
