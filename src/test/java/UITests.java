import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.pages.CreateOrderPage;
import org.pages.LoginPage;
import org.pages.OrderPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UITests {

private String SignInUrl = "*****";


    // тест, написанный напрямую через selenide, без использования page object
    // Авторизация и переход к странице создания заказа
    @Test
    public void loginAndCheckOrderForm ()
    {
        Configuration.browser = "firefox";
        open(SignInUrl);
        $(By.id("username")).setValue("user2"); // аннотация $ в селениде означает команду "найти какой-то элемент".
        // Команда здесь означает "найди id "username" подставь туда значение "user2"
        $(By.id("password")).setValue("hellouser2");
        $(By.xpath("//*[@data-name = 'signIn-button']")).click();
        $(By.xpath("//*[@data-name = 'openStatusPopup-button']")).shouldBe(Condition.enabled);
        $(By.xpath("//*[@data-name = 'createOrder-button']")).shouldBe(Condition.enabled);
    }


    // авторизация пользователя
    @Test
    public void UserSignInTest() {
        LoginPage loginPage = open(SignInUrl, LoginPage.class);
        loginPage.inputLogin("user1");
        loginPage.inputPassword("hellouser1");
        loginPage.clickSignInButton();
    }


    // авторизация пользователя и создания нового заказа
    @Test
    public void UserSignInAndCreateOrderTest() {
        Configuration.timeout = 10000;
        LoginPage loginPage = open(SignInUrl, LoginPage.class);
        loginPage.inputLogin("user2");
        loginPage.inputPassword("hellouser2");
        CreateOrderPage createOrderPage = loginPage.clickSignInButton(); // переход на новую страницу после авторизации
        createOrderPage.inputNameField("Konstantin");
        createOrderPage.inputPhoneField("654321");
        createOrderPage.inputCommentField("создать новый заказ");
        createOrderPage.clickCreateOrderButton();
    }


    // негативный тест (передаются неверные логин и пароль, нажимается кнопка авторизации,
    // затем происходит проверка отображения нотификации "ошибка авторизации" ('authorizationError-popup-close-button')
    @Test
    public void userAuthError () {
        Configuration.browser = "firefox";
        open(SignInUrl);
        $(By.id("username")).setValue("hello");
        $(By.id("password")).setValue("12345678");
        $(By.xpath("//*[@data-name = 'signIn-button']")).click();
        $(By.xpath("//*[@data-name = 'authorizationError-popup-close-button']")).shouldBe(Condition.visible);
    }


    // E2E тест: авторизация, создание нового заказа,
    // проверка корректности переданных в теле заказа данных клиента (поля Name,Phone,Comment)
    @Test
    public void E2ETest() {
        Configuration.browser = "firefox";
        LoginPage loginPage = open(SignInUrl, LoginPage.class);
        loginPage.inputLogin("user2");
        loginPage.inputPassword("hellouser2");
        CreateOrderPage createOrderPage = loginPage.clickSignInButton();
        createOrderPage.inputNameField("Konstantin");
        createOrderPage.inputPhoneField("654321");
        createOrderPage.inputCommentField("новый заказ");
        createOrderPage.clickCreateOrderButton();
        String orderId = createOrderPage.getOrderId();
        createOrderPage.clickOrderSuccessfullyCreatedButton();
        createOrderPage.clickOpenStatusPopup();
        createOrderPage.inputSearchOrderField(orderId);
        OrderPage orderPage = createOrderPage.searchOrderSubmitButtonClick();

        Assertions.assertEquals(orderPage.getName(), "Konstantin", "Name is not equal");
        Assertions.assertEquals(orderPage.getPhone(), "654321", "Phone is not equal");
        Assertions.assertEquals(orderPage.getComment(), "новый заказ", "Comment is not equal");

    }
}
