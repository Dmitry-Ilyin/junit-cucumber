package org.expamle.tests;


import org.expamle.tests.base.BaseClasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


@DisplayName("Ренессанс кредит")
public class ExampleTest extends BaseClasses {

    @DisplayName("Вклады")
    @ParameterizedTest(name = "параметры {0}, {1}, {2}")
    @CsvFileSource(resources = "/data.csv")
    public void methodParameterizedTest(int sum, String date, int replenishment) {
        app.getHomePage()
                .selectTab("Вклады")
                .checkOpenDepositPage()
                .selectCurrency("Доллары")
                .fillField("Сумма вклада", sum)
                .fillDate(date)
                .fillField("Ежемесячное пополнение", replenishment)
                .selectExtraOptions("Ежемесячная капитализация")
                .checkParameter();
    }
}

