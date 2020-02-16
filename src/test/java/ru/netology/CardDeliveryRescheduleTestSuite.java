package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.time.format.DateTimeFormatter;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class CardDeliveryRescheduleTestSuite {

    @Test
    @DisplayName("Should rescheduleAppointment")
    void shouldRescheduleAppointment() {

        String lastName = DataGenerator.SubmitFormInfo.generate("ru").getLastName();
        String firstName = DataGenerator.SubmitFormInfo.generate("ru").getFirstName();
        String phone = DataGenerator.SubmitFormInfo.generate("ru").getPhoneNumber();
        String firstDate = DataGenerator.SubmitFormInfo.generate("ru").getFirstDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String secondDate = DataGenerator.SubmitFormInfo.generate("ru").getSecondDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        open("http://localhost:7777");

        $$("#root .form-field").find(Condition.hidden);
        $("[data-test-id=city] input").setValue("Москва");

        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);

        $("[data-test-id=date] input").setValue(firstDate);
        $("[data-test-id=name] input").setValue(lastName + " ".concat(firstName));
        $("[data-test-id=phone] input").setValue("+" + phone);

        $("[data-test-id=agreement]").click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);

//      reschedule

        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(secondDate);

        $$("button").find(Condition.exactText("Запланировать")).click();
        $(withText("Необходимо подтверждение")).waitUntil(Condition.visible, 15000);
        $$("button").find(Condition.exactText("Перепланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    @DisplayName("Should check date")
    void shouldCheckDate() {

        String lastName = DataGenerator.SubmitFormInfo.generate("ru").getLastName();
        String firstName = DataGenerator.SubmitFormInfo.generate("ru").getFirstName();
        String phone = DataGenerator.SubmitFormInfo.generate("ru").getPhoneNumber();
        String firstDate = DataGenerator.SubmitFormInfo.generate("ru").getFirstDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String secondDate = DataGenerator.SubmitFormInfo.generate("ru").getSecondDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        open("http://localhost:7777");

        $$("#root .form-field").find(Condition.hidden);
        $("[data-test-id=city] input").setValue("Москва");

        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);

        $("[data-test-id=date] input").setValue(firstDate);
        $("[data-test-id=name] input").setValue(lastName + " ".concat(firstName));
        $("[data-test-id=phone] input").setValue("+" + phone);

        $("[data-test-id=agreement]").click();
        $$("button").find(Condition.exactText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);

//      reschedule

        $("[data-test-id=date] input").sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
                Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(firstDate);

        $$("button").find(Condition.exactText("Запланировать")).click();
        $(withText("Необходимо подтверждение")).waitUntil(Condition.visible, 15000);
        $$("button").find(Condition.exactText("Перепланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }
}
