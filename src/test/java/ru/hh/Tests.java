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
                .putValueInSearchFieldAndSubmit(x5Group)
                .unsetCurrentCityFromFilter(currentCityRus)
                .clickOnCompanyCardInSearchResults(x5Group)
                .goToCompanyPageFromVacancyCard(x5GroupImport)
                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("QA-инженер (web)");
    }


    @DisplayName("Найти вакансию 'Backend QA engineer' в 'X5 Digital'")
    @Test
    void findVacancyBackendQaEngineerInX5Digital() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(x5Digital)
                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard(x5Digital)
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
                .putValueInSearchFieldAndSubmit(x5Digital)
                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard(x5Digital)
                .clickIWantToWorkHereButton()
                .checkTitleOfFirstAccountLoginForm();
    }


    @DisplayName("Проверить наличие кнопки перехода на сайт X5 Group")
    @Test
    void checkPresenseOfButtonToGoToX5GroupSite() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(x5Group)
                .unsetCurrentCityFromFilter(currentCityRus)
                .clickOnCompanyCardInSearchResults(x5Group)
                .goToCompanyPageFromVacancyCard(x5GroupImport)
                .goToX5TechPage()
                .CheckIWantToWorkHereButtonIsVisible();
    }

}
