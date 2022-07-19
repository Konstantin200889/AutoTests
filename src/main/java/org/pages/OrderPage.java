package org.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderPage {

// находим нужное поле и при помощи *getName.getText* вытаскиваем из него нужное значение (Name)
    @FindBy(how = How.XPATH, using = "//*[@data-name = 'order-item-0']/span")
    private SelenideElement getName;

    public String getName() {
        try {
            Thread.sleep(3000); // задаем допустимый лимит таймаута для отклика (чтобы значение успело подтянуться в поле)
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return getName.getText();

    }


    @FindBy(how = How.XPATH, using = "//*[@data-name = 'order-item-1']/span")
    private SelenideElement getPhone;

    public String getPhone() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return getPhone.getText().replaceAll("\\D", ""); // вытаскиваем значение Phone
    }

    // \\D - регулярное выражение, при помощи которого находим все НЕ числа в поле
    // \\d - регулярное выражение, при помощи которого находим все числа в поле (затем меняем их на ""(пустой символ))

        @FindBy(how = How.XPATH, using = "//*[@data-name = 'order-item-2']/span")
        private SelenideElement getComment;

        public String getComment() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return getComment.getText().replaceAll("\\d", ""); // вытаскиваем значение Comment
        }

}
