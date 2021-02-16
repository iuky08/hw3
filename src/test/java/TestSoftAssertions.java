//1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
// Если может - приведите пример, когда.

//$("h1 div") - найдет элемент h1, в котором будет содержаться тэги и h1 и div
//$("h1").$("div") тэг h1 будет родительским, тэг div - дочерним

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Point;

import java.awt.*;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSoftAssertions {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void dataAppearsInOutputBlockTest() {
        Configuration.timeout = 3000;
       // Откройте страниц Selenide в Github
        Selenide.open("https://github.com/selenide/selenide");
       // Перейдите в раздел Wiki проекта
        $(byText("Wiki")).click();
       // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(byAttribute("data-filterable-for","wiki-pages-filter")).shouldBe(visible);
        $$(".Box-row").findBy(text("SoftAssertions")).click();
       // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".page").shouldHave(text("Using JUnit5 extend test class"));
    }
}
