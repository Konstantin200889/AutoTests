package org.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    // При помощи аннотации @FindBy ищем нужные элементы страницы по ID или при помощи локаторов,
    // затем генерируем для них нужные методы

    @FindBy(how = How.ID, using = "username")
    private SelenideElement loginField; // новый элемент, в который будут сохраняться
    // введенные в тесте данные

    @FindBy(how = How.ID, using = "password") // поиск по ID
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@data-name = 'signIn-button']") // поиск по локатору
    private SelenideElement signInButton;

    public void inputLogin(String username) {
        loginField.setValue(username);
    } // метод, который запишет
    //в loginField введенные в тесте данные

    public void inputPassword(String password) {
        passwordField.setValue(password);
    }



    public CreateOrderPage clickSignInButton() {
        signInButton.click();
        return Selenide.page(CreateOrderPage.class); // метод, для нажатия кнопки авторизации и перехода на след. страницу
    }
}

