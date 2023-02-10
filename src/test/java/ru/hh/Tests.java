package ru.hh;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class Tests extends TestBase {

    SiteObjects siteObjects = new SiteObjects();

    @DisplayName("Найти вакансию 'QA-инженер (web)' в 'X5 Group'")
    @Test
    void findVacancyQaEngineerInX5Group() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit("X5 Group")
                .unsetCurrentCityFromFilter(currentCityRus)
                .clickOnCompanyCardInSearchResults("X5 Group")
                .goToCompanyPageFromVacancyCard("X5 GROUP, Import")
                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("QA-инженер (web)");
    }


    @DisplayName("Найти вакансию 'Backend QA engineer' в 'X5 Digital'")
    @Test
    void findVacancyBackendQaEngineerInX5Digital() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit("X5 digital")
                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard("X5 Digital")
                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("QA-инженер (web)");
    }


    @MethodSource("menuItems")
    @ParameterizedTest(name="Проверить набор кнопок {0} верхней панели на английском и на русском")
    void checkSetOfButtonsInTopMenuInEnglishAndRussian(List<String> buttons) {
        siteObjects.openPage()
                .changeLanguage()
                .checkButtonsInTopMenu(buttons);
    }


    @DisplayName("Проверить, что указан правильный город во фразе 1")
    @Test
    void checkCorrectCityInFirstPhrase() {
        siteObjects.openPage()
                .checkCurrentCityInPhraseOne(currentCityRus);
    }


    @DisplayName("Проверить, что указан правильный город во фразе 2")
    @Test
    void checkCorrectCityInSecondFrase() {
        siteObjects.openPage()
                .checkCurrentCityInPhraseTwo(currentCityRus);
    }


    @DisplayName("Проверить наличие кнопки перехода на сайт X5 Digital")
    @Test
    void checkPresenseOfButtonToGoToX5DigitalSite() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit("X5 digital")
                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard("X5 Digital")
                .clickIWantToWorkHereButton()
                .checkTitleOfFirstAccountLoginForm();
    }


    @DisplayName("Проверить наличие кнопки перехода на сайт X5 Group")
    @Test
    void checkPresenseOfButtonToGoToX5GroupSite() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit("X5 Group")
                .unsetCurrentCityFromFilter(currentCityRus)
                .clickOnCompanyCardInSearchResults("X5 Group")
                .goToCompanyPageFromVacancyCard("X5 GROUP, Import")
                .goToX5TechPage()
                .CheckIWantToWorkHereButtonIsVisible();
    }

}
