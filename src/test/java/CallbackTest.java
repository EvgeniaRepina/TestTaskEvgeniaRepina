import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldSwitchToEnglishYA1_1() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button.mail-SettingsButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".svgicon-mail--Settings_setup-other")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".b-selink__arrow")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[data-params='lang=en']")).click();
        Thread.sleep(5000);
        String text = driver.findElement(By.cssSelector(".mail-Settings-Lang")).getText();
        assertEquals("English", text.trim());
    }


    @Test
    void shouldSwitchToRussianYA1_2() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button.mail-SettingsButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".svgicon-mail--Settings_setup-other")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".b-selink__arrow")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[data-params='lang=ru']")).click();
        Thread.sleep(5000);
        String text = driver.findElement(By.cssSelector(".mail-Settings-Lang")).getText();
        assertEquals("Русский", text.trim());
    }


    @Test
    void shouldDeleteNoSelectingYA2() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        String text1 = driver.findElement(By.cssSelector(".mail-NestedList-Item-Info-Extras")).getText();
        boolean toolbarEditable = Boolean.parseBoolean(driver.findElement(By.cssSelector(".ns-view-toolbar-buttons")).getAttribute("isContentEditable"));
        assertEquals(false, toolbarEditable);
        String text2 = driver.findElement(By.cssSelector(".ns-view-toolbar-button-delete")).getAttribute("contentEditable");
        assertEquals("inherit", text2);
        driver.findElement(By.cssSelector(".ns-view-toolbar-button-delete")).click();
        String text3 = driver.findElement(By.cssSelector(".mail-NestedList-Item-Info-Extras")).getText();
        assertEquals(text1, text3);
    }

    @Test
    void shouldDeleteYA3() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        String text1 = driver.findElement(By.cssSelector(".ns-view-messages-item-wrap")).getAttribute("data-id");
        List<WebElement> elements = driver.findElements(By.className("_nb-checkbox-flag"));
        elements.get(0).click();
        Thread.sleep(5000);
        List<WebElement> elements2 = driver.findElements(By.className("_nb-checkbox-input"));
        boolean isSelected = elements2.get(0).isSelected();
        assertEquals(true, isSelected);
        driver.findElement(By.cssSelector(".ns-view-toolbar-button-delete")).click();
        Thread.sleep(5000);
        String text2 = driver.findElement(By.cssSelector(".ns-view-messages-item-wrap")).getAttribute("data-id");
        Thread.sleep(5000);
        assertNotEquals(text1, text2);
    }

    @Test
    void shouldSelectYA4() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        List<WebElement> elements = driver.findElements(By.className("_nb-checkbox-flag"));
        elements.get(0).click();
        elements.get(1).click();
        Thread.sleep(5000);
        List<WebElement> elements2 = driver.findElements(By.className("_nb-checkbox-input"));
        boolean isSelected = elements2.get(0).isSelected();
        assertEquals(true, isSelected);
        boolean isSelected2 = elements2.get(1).isSelected();
        assertEquals(true, isSelected2);
    }

    @Test
    void shouldSendYA5() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("mail-ComposeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("composeYabbles")).sendKeys("k.katik4ti@yandex.ru");
        Thread.sleep(5000);
        String text1 = driver.findElement(By.cssSelector(".ComposeYabblesField")).getText();
        assertEquals("k.katik4ti@yandex.ru", text1);
        driver.findElement(By.className("ComposeSubject-TextField")).sendKeys("hello there!");
        Thread.sleep(5000);
        String text2 = driver.findElement(By.cssSelector("input.ComposeSubject-TextField")).getAttribute("value");
        assertEquals("hello there!", text2);
        driver.findElement(By.cssSelector(".ComposeSendButton Button.Button2_pin_circle-circle")).click();
        Thread.sleep(5000);
        String text3 = driver.findElement(By.cssSelector(".ComposeDoneScreen-Title")).getText();
        assertEquals("Письмо отправлено", text3);

    }

    @Test
    void shouldSendNoAddressAndSubjectYA6_1() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("mail-ComposeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".ComposeSendButton Button.Button2_pin_circle-circle")).click();
        String text1 = driver.findElement(By.cssSelector(".ComposeConfirmPopup-Content")).getText();
        assertEquals("Письмо не отправлено\n" +
                "Пожалуйста, укажите адрес получателя\n" +
                "Вернуться к письму", text1);
        boolean hidden = Boolean.parseBoolean(driver.findElement(By.cssSelector(".popup2_view_classic.ComposePopup")).getAttribute("hidden"));
        assertEquals(false, hidden);
    }

    @Test
    void shouldSendNoAddressYA6_2() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("mail-ComposeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("ComposeSubject-TextField")).sendKeys("hello there!");
        Thread.sleep(6000);
        String text1 = driver.findElement(By.cssSelector("input.ComposeSubject-TextField")).getAttribute("value");
        assertEquals("hello there!", text1);
        driver.findElement(By.cssSelector(".ComposeSendButton Button.Button2_pin_circle-circle")).click();
        String text2 = driver.findElement(By.cssSelector(".ComposeConfirmPopup-Content")).getText();
        assertEquals("Письмо не отправлено\n" +
                "Пожалуйста, укажите адрес получателя\n" +
                "Вернуться к письму", text2);
        boolean hidden = Boolean.parseBoolean(driver.findElement(By.cssSelector(".popup2_view_classic.ComposePopup")).getAttribute("hidden"));
        assertEquals(false, hidden);
    }


    @Test
        //    Фактическое поведение приложения отличается от ожидаемого результата кейса. Если бы оно совпадало, тест
        //    мог бы выглядеть так:
    void shouldSendNoSubjectYA6_3() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("mail-ComposeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("composeYabbles")).sendKeys("234585@gmail.com");
        String text1 = driver.findElement(By.cssSelector(".ComposeYabblesField")).getText();
        assertEquals("234585@gmail.com", text1);
        driver.findElement(By.cssSelector(".ComposeSendButton Button.Button2_pin_circle-circle")).click();
        Thread.sleep(2000);
        String text2 = driver.findElement(By.cssSelector(".ComposeConfirmPopup-Title")).getText();
        assertEquals("Внимание! Ваше письмо пока не отправлено", text2);
        boolean hidden = Boolean.parseBoolean(driver.findElement(By.cssSelector(".popup2_view_classic.ComposePopup")).getAttribute("hidden"));
        assertEquals(false, hidden);

    }

    @Test
        //        Поправка к кейсу: ОР "3. веденный текст отображается в поле "Кому", выделяется красным" не
        //        соответствует работе приложения. Фактический результат - цвет изменяет плашка, и только после клика
        //        на соседнее поле.
    void shouldSendIncorrectAddressNoAtYA6_4_1() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("mail-ComposeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("composeYabbles")).sendKeys("disgustingfroggmail.com");
        String text1 = driver.findElement(By.cssSelector(".ComposeYabblesField")).getText();
        assertEquals("disgustingfroggmail.com", text1);
        Thread.sleep(5000);
        driver.findElement(By.className("ComposeSubject-TextField")).sendKeys("hello there!");
        String text2 = driver.findElement(By.cssSelector(".ComposeYabble_invalid")).getCssValue("background-color");
        assertEquals("rgba(255, 0, 0, 0.2)", text2);
        String text3 = driver.findElement(By.cssSelector("input.ComposeSubject-TextField")).getAttribute("value");
        assertEquals("hello there!", text3);
        driver.findElement(By.cssSelector(".ComposeSendButton Button.Button2_pin_circle-circle")).click();
        Thread.sleep(2000);
        String text4 = driver.findElement(By.cssSelector(".ComposeConfirmPopup-Content")).getText();
        assertEquals("Проверьте получателя\n" +
                "Похоже, что-то не так с адресом: disgustingfroggmail.com.\n" +
                "Вернуться к письму", text4);
        boolean hidden = Boolean.parseBoolean(driver.findElement(By.cssSelector(".popup2_view_classic.ComposePopup")).getAttribute("hidden"));
        assertEquals(false, hidden);
    }

    @Test
        //        Поправка к кейсу: ОР "3. веденный текст отображается в поле "Кому", выделяется красным" не
        //        соответствует
//        работе приложения. Фактический результат - цвет изменяет плашка, и только после клика на соседнее поле.
    void shouldSendIncorrectAddress2AtYA6_4_2() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("mail-ComposeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("composeYabbles")).sendKeys("disgustingfrog@@gmail.com");
        Thread.sleep(5000);
        String text1 = driver.findElement(By.cssSelector(".ComposeYabblesField")).getText();
        assertEquals("disgustingfrog@@gmail.com", text1);
        driver.findElement(By.className("ComposeSubject-TextField")).sendKeys("hello there!");
        Thread.sleep(5000);
        String text2 = driver.findElement(By.cssSelector(".ComposeYabble_invalid")).getCssValue("background-color");
        assertEquals("rgba(255, 0, 0, 0.2)", text2);
        String text3 = driver.findElement(By.cssSelector("input.ComposeSubject-TextField")).getAttribute("value");
        assertEquals("hello there!", text3);
        driver.findElement(By.cssSelector(".ComposeSendButton Button.Button2_pin_circle-circle")).click();
        Thread.sleep(2000);
        String text4 = driver.findElement(By.cssSelector(".ComposeConfirmPopup-Content")).getText();
        assertEquals("Проверьте получателя\n" +
                "Похоже, что-то не так с адресом: disgustingfrog@@gmail.….\n" +
                "Вернуться к письму", text4);
        boolean hidden = Boolean.parseBoolean(driver.findElement(By.cssSelector(".popup2_view_classic.ComposePopup")).getAttribute("hidden"));
        assertEquals(false, hidden);
    }

    @Test
        //        Поправка к кейсу: ОР "3. веденный текст отображается в поле "Кому", выделяется красным" не
        //        соответствует
//        работе приложения. Фактический результат - цвет изменяет плашка, и только после клика на соседнее поле.
    void shouldSendIncorrectAddressNoDomainYA6_4_3() throws InterruptedException {
        driver.get("https://mail.yandex.ru/?uid=1571005443#tabs/relevant");
        driver.findElement(By.className("HeadBanner-Button-Enter")).click();
        driver.findElement(By.cssSelector("#passp-field-login")).sendKeys("k.katik4ti@yandex.ru");
        driver.findElement(By.id("passp:sign-in")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("Textinput-Control")).sendKeys("6RacnhVjTarqrJ51");
        driver.findElement(By.className("Button2_view_action")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("mail-ComposeButton")).click();
        Thread.sleep(5000);
        driver.findElement(By.className("composeYabbles")).sendKeys("disgustingfrog@");
        String text1 = driver.findElement(By.cssSelector(".ComposeYabblesField")).getText();
        assertEquals("disgustingfrog@", text1);
        driver.findElement(By.className("ComposeSubject-TextField")).sendKeys("hello there!");
        String text2 = driver.findElement(By.cssSelector(".ComposeYabble_invalid")).getCssValue("background-color");
        assertEquals("rgba(255, 0, 0, 0.2)", text2);
        String text3 = driver.findElement(By.cssSelector("input.ComposeSubject-TextField")).getAttribute("value");
        assertEquals("hello there!", text3);
        driver.findElement(By.cssSelector(".ComposeSendButton Button.Button2_pin_circle-circle")).click();
        Thread.sleep(2000);
        String text4 = driver.findElement(By.cssSelector(".ComposeConfirmPopup-Content")).getText();
        assertEquals("Проверьте получателя\n" +
                "Похоже, что-то не так с адресом: disgustingfrog@.\n" +
                "Вернуться к письму", text4);
        boolean hidden = Boolean.parseBoolean(driver.findElement(By.cssSelector(".popup2_view_classic.ComposePopup")).getAttribute("hidden"));
        assertEquals(false, hidden);
    }
}