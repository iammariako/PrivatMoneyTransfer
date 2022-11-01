import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;

import javax.swing.*;

import static com.codeborne.selenide.Selenide.*;

public class Privat {

    @Test
    public void moneyTransfer() {
        WebDriverManager.chromedriver().setup();
        open("https://next.privat24.ua/money-transfer/card");

        $("[data-qa-node='numberdebitSource']").sendKeys("4552331448138217");
        $("[data-qa-node='expiredebitSource']").sendKeys("05/24");
        $("[data-qa-node='cvvdebitSource']").sendKeys("926");
        $("[data-qa-node='firstNamedebitSource']").sendKeys("Taras");
        $("[data-qa-node='lastNamedebitSource']").sendKeys("Shevchenko");
        $("[data-qa-node='numberreceiver']").sendKeys("4004159115449003");
        $("[data-qa-node='amount']").sendKeys("123");
        $("[data-qa-node='currency']").click();
        $("[data-qa-value='USD']").click();
        $("[data-qa-node='firstNamereceiver']").sendKeys("Lesya");
        $("[data-qa-node='lastNamereceiver']").sendKeys("Ukrainka");
        $("[type='submit']").click();
//        $("[data-qa-node='payer-card']").shouldHave(Condition.text("4552 3314 4813 8217"));
        $x("//span[@data-qa-node='payer-card']").shouldHave(Condition.text("4552 3314 4813 8217"));
//        $("[data-qa-node='payer-amount']").shouldHave(Condition.text("123 USD"));
        $x("//div[@data-qa-node='payer-amount']").shouldHave(Condition.text("123 USD"));
//        $("[data-qa-node='payer-currency']").shouldHave(Condition.text("5.41 USD"));
        $x("//div[@data-qa-node='payer-currency']").shouldHave(Condition.text("5.41 USD"));
//        $("[data-qa-node='receiver-name']").shouldHave(Condition.text("LESYA UKRAINKA"));
        $x("//div[@data-qa-node='receiver-name']").shouldHave(Condition.text("LESYA UKRAINKA"));
//        $("[data-qa-node='receiver-card']").shouldHave(Condition.text("4004 1591 1544 9003"));
        $x("//span[@data-qa-node='receiver-card']").shouldHave(Condition.text("4004 1591 1544 9003"));
//        $("[data-qa-node='receiver-amount']").shouldHave(Condition.text("123 USD"));
        $x("//div[@data-qa-node='receiver-amount']").shouldHave(Condition.text("123 USD"));
//        $("[data-qa-node='receiver-currency']").shouldHave(Condition.text("0 USD"));
        $x("//div[@data-qa-node='receiver-currency']").shouldHave(Condition.text("0 USD"));
//        $("[data-qa-node='total']").shouldHave(Condition.text("Разом до списання 128.41 USD"));
        $x("//div[@data-qa-node='total']").shouldHave(Condition.text("Разом до списання 128.41 USD"));
        $("[data-qa-node='submit']").click();
        $("[data-qa-node='card']").shouldHave(Condition.text("4552 **** **** 8217"));
        $("[data-qa-node='cardB']").shouldHave(Condition.text("4004 **** **** 9003"));
        $("[data-qa-node='amount']").shouldHave(Condition.text("123 USD"));
    }
}