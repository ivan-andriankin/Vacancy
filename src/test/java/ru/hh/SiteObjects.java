package ru.hh;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SiteObjects {

    private SelenideElement
            searchInput = $("#a11y-search-input"),
            phraseOne = $("h1[data-qa=bloko-header-2]"),
            iWantToWorkHereButton = $("[data-qa=resumeservice-button__targetemployer]"),
            x5TechElement = $(".th_illustration__link.th_illustration__link--tech.th_dpt"),
            vacancyTitle = $("data-qa=vacancy-title"),
            vacancyResponseLink = $("data-qa=vacancy-response-link-top")
    ;

    private ElementsCollection
            locationForVacancy = $$("[data-qa=serp__novafilter-title]"),
            allDivElements = $$("div"),
            companyNameInVacancyCard = $$("[data-qa=vacancy-serp__vacancy-employer]"),
            allSpanElements = $$("span"),
            particularVacancy = $$(".bloko-link"),
            languageButton = $$(".lang--N5GSKUyI3fBf0bLLxFVh"),
            buttonsInTopMenu = $$(".supernova-navi-item.supernova-navi-item_lvl-1"),
            phraseTwo = $$("a[data-qa=index__work-in-profession-header]"),
            accountLoginTitle = $$(".account-login-tile")


    ;


    public SiteObjects openPage() {
        open("/");
        return this;
    }

    public SiteObjects putValueInSearchFieldAndSubmit(String value) {
        searchInput.setValue(value);
        $("[data-qa=search-button]").click();
        return this;
    }

    public SiteObjects unsetCurrentCityFromFilter(String value) {
        locationForVacancy.findBy(text(value)).click();
        return this;
    }

    public SiteObjects clickOnCompanyCardInSearchResults(String value) {
        allDivElements.findBy(text(value)).click();
        return this;
    }

    public SiteObjects goToCompanyPageFromVacancyCard(String value) {
        companyNameInVacancyCard.findBy(text(value)).click();
        return this;
    }

    public SiteObjects expandVacanciesDropDownCategories(String value) {
        allSpanElements.findBy(text(value)).click();
        return this;
    }

    public SiteObjects clickOnTheVacancy(String value) {
        particularVacancy.findBy(text(value)).click();
        return this;
    }

    public SiteObjects changeLanguage() {
        languageButton.last().click();
        return this;
    }

    public SiteObjects checkButtonsInTopMenu(List<String> value) {
        buttonsInTopMenu.shouldHave(texts(value));
        return this;
    }

    public SiteObjects checkCurrentCityInPhraseOne(String value) {
        phraseOne.shouldHave(text("Вакансии дня в " + value));
        return this;
    }

    public SiteObjects checkCurrentCityInPhraseTwo(String value) {
        phraseTwo.last().shouldHave(text("Работа по профессиям в " + value));
        return this;
    }

    public SiteObjects clickIWantToWorkHereButton() {
        iWantToWorkHereButton.click();
        return this;
    }

    public SiteObjects CheckIWantToWorkHereButtonIsVisible() {
        iWantToWorkHereButton.shouldBe(visible);
        return this;
    }

    public SiteObjects checkTitleOfFirstAccountLoginForm() {
        accountLoginTitle.first().shouldHave(text("Войдите на сайт"));
        return this;
    }

    public SiteObjects goToX5TechPage() {
        x5TechElement.click();
        return this;
    }

    public SiteObjects checkVacancyTitle(String value) {
        vacancyTitle.shouldHave(text(value));
        return this;
    }

    public SiteObjects clickVacancyResponseButton() {
        vacancyResponseLink.click();
        return this;
    }

}
