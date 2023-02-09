package ru.hh;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.hh.utils.Locale;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Tests extends TestBase {

    @Test
    void test1() {
        open("/");
        $("#a11y-search-input").setValue("X5 Group");
        $("[data-qa=search-button]").click();
        $$("[data-qa=serp__novafilter-title]").findBy(text(currentCityRus)).click();
        $$("div").findBy(text("X5 Group")).click();
        $$("[data-qa=vacancy-serp__vacancy-employer]").findBy(text("X5 GROUP, Import")).click();
        $$("span").findBy(text("Вакансии в других регионах")).click();
        $$("span").findBy(text("Тестировщик")).click();
        $$(".bloko-link").findBy(text("QA-инженер (web)")).click();
    }

    @Test
    void test2() {
        open("/");
        $("#a11y-search-input").setValue("X5 digital");
        $("[data-qa=search-button]").click();
        $$("[data-qa=serp__novafilter-title]").findBy(text(currentCityRus)).click();
        $$("[data-qa=vacancy-serp__vacancy-employer]").findBy(text("X5 Digital")).click();
        $$("span").findBy(text("Вакансии в других регионах")).click();
        $$("span").findBy(text("Тестировщик")).click();
        $$(".bloko-link").findBy(text("Backend QA engineer")).click();
    }

    @MethodSource("menuItems")
    @ParameterizedTest(name="qqq")
    void test3(List<String> buttons) {
        open("/");
        $$(".lang--N5GSKUyI3fBf0bLLxFVh").last().click();
        $$(".supernova-navi-item.supernova-navi-item_lvl-1").shouldHave(texts(buttons));
    }

    @Test
    void test4() {
            open("/");
            $("h1[data-qa=bloko-header-2]").shouldHave(text("Вакансии дня в " + currentCityRus));
    }

    @Test
    void test5() {
        open("/");
        $$("a[data-qa=index__work-in-profession-header]").last()
                .shouldHave(text("Работа по профессиям в " + currentCityRus));
    }

    @Test
    void test6() {
        open("/");
        $("#a11y-search-input").setValue("X5 digital");
        $("[data-qa=search-button]").click();
        $$("[data-qa=serp__novafilter-title]").findBy(text(currentCityRus)).click();
        $$("[data-qa=vacancy-serp__vacancy-employer]").findBy(text("X5 Digital")).click();
        $("[data-qa=resumeservice-button__targetemployer]").click();
        $$(".account-login-tile").first().shouldHave(text("Войдите на сайт"));

    }

    @Test
    void test7() {
        open("/");
        $("#a11y-search-input").setValue("X5 Group");
        $("[data-qa=search-button]").click();
        $$("[data-qa=serp__novafilter-title]").findBy(text(currentCityRus)).click();
        $$("div").findBy(text("X5 Group")).click();
        $$("[data-qa=vacancy-serp__vacancy-employer]").findBy(text("X5 GROUP, Import")).click();
        $(".th_illustration__link.th_illustration__link--tech.th_dpt").click();
        $("[data-qa=resumeservice-button__targetemployer]").shouldBe(visible);
    }

}
