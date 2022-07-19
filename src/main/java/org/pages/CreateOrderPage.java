package org.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateOrderPage {
    // При помощи аннотации @FindBy ищем нужные элементы страницы по ID или при помощи локаторов,
    // затем генерируем для них нужные методы
    @FindBy(how = How.ID, using = "name")
    private SelenideElement nameField;

    @FindBy(how = How.ID, using = "phone")
    private SelenideElement phoneField;

    @FindBy(how = How.ID, using = "comment")
    private SelenideElement commentField;


    @FindBy(how = How.XPATH, using = "//*[@data-name = 'createOrder-button']")
    private SelenideElement CreateOrderButton;


    public void inputNameField(String name) {
        nameField.setValue(name);
    }

    public void inputPhoneField(String phone) {
        phoneField.setValue(phone);
    }

    public void inputCommentField(String comment) {
        commentField.setValue(comment);
    }

    public void clickCreateOrderButton() {
        CreateOrderButton.click();
    }


    @FindBy(how = How.XPATH, using = "//*[@data-name = 'orderSuccessfullyCreated-popup-ok-button']")
    private SelenideElement orderSuccessfullyCreatedButton;

    public void clickOrderSuccessfullyCreatedButton() {
        orderSuccessfullyCreatedButton.click();
    }

    @FindBy(how = How.XPATH, using = "//*[@data-name = 'orderSuccessfullyCreated-popup']/span")
    private SelenideElement orderId;

    public String getOrderId() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return orderId.getText().replaceAll("\\D","");
    }


    @FindBy(how = How.XPATH, using = "//*[@data-name = 'openStatusPopup-button']")
    private SelenideElement openStatusPopup;

    public void clickOpenStatusPopup() {
        openStatusPopup.click();
    }


    @FindBy(how = How.XPATH, using = "//*[@data-name = 'searchOrder-input']")
    private SelenideElement searchOrderInput;

    public void inputSearchOrderField(String orderId) {
        searchOrderInput.setValue(orderId);
    }

    @FindBy(how = How.XPATH, using = "//*[@data-name = 'searchOrder-submitButton']")
    private SelenideElement searchOrderSubmitButton;


    public OrderPage searchOrderSubmitButtonClick() {
        searchOrderSubmitButton.click();
        return Selenide.page(OrderPage.class);
    }

}













