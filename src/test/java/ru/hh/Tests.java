package ru.hh;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

@Tag("vacancy_tests")
public class Tests extends TestBase {

    @Severity(SeverityLevel.NORMAL)
    @MethodSource("menuItems")
    @ParameterizedTest(name="AT - Проверить набор кнопок {0} верхней панели на английском и на русском")
    void checkSetOfButtonsInTopMenuInEnglishAndRussian(List<String> buttons) {
        siteObjects.openPage()
                .changeLanguage()
                .checkButtonsInTopMenu(buttons);
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Найти вакансию 'QA-инженер (web)' в 'X5 Group'")
    @Test
    void findVacancyQaEngineerInX5Group() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(x5Group)
//                .unsetCurrentCityFromFilter(currentCityRus)
                .clickOnCompanyCardInSearchResults(x5Group)
                .goToCompanyPageFromVacancyCard(x5GroupImport)
//                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("QA-инженер (web)")
                .checkVacancyTitle("QA-инженер (web)")
                .clickVacancyResponseButton();
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Найти вакансию 'Backend QA engineer' в 'X5 Digital'")
    @Test
    void findVacancyBackendQaEngineerInX5Digital() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(x5Digital)
//                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard(x5Digital)
//                .expandVacanciesDropDownCategories("Вакансии в других регионах")
                .expandVacanciesDropDownCategories("Тестировщик")
                .clickOnTheVacancy("Backend QA engineer");
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Проверить наличие кнопки перехода на сайт X5 Digital")
    @Test
    void checkPresenseOfButtonToGoToX5DigitalSite() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(x5Digital)
//                .unsetCurrentCityFromFilter(currentCityRus)
                .goToCompanyPageFromVacancyCard(x5Digital)
                .clickIWantToWorkHereButton()
                .checkTitleOfFirstAccountLoginForm();
    }


    @Severity(SeverityLevel.NORMAL)
    @DisplayName("AT - Проверить наличие кнопки перехода на сайт X5 Group")
    @Test
    void checkPresenseOfButtonToGoToX5GroupSite() {
        siteObjects.openPage()
                .putValueInSearchFieldAndSubmit(x5Group)
//                .unsetCurrentCityFromFilter(currentCityRus)
                .clickOnCompanyCardInSearchResults(x5Group)
                .goToCompanyPageFromVacancyCard(x5GroupImport)
                .goToX5TechPage()
                .CheckIWantToWorkHereButtonIsVisible();
    }

}
