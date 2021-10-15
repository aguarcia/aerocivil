package com.ban.aerocivil.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

import java.util.Set;

import static com.ban.aerocivil.userinterface.AerocivilEstadoFinanciero.BTN_BALANCE;
import static com.ban.aerocivil.userinterface.AerocivilEstadoFinanciero.OPC_DESC_PDF;
import static com.ban.aerocivil.userinterface.AerocivilInicialPage.OPC_TRANSPARENCIA;
import static com.ban.aerocivil.userinterface.AerocivilPresupuesto.MENU_ESTADO_FINANCIERO;
import static com.ban.aerocivil.userinterface.AerocivilTransparencia.BTN_PRESUPUESTO;
import static com.ban.aerocivil.util.WebDriverFactory.getWebDriver;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarEstadosFinancieros implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPC_TRANSPARENCIA),
                Click.on(BTN_PRESUPUESTO),
                // (Performable) getWebDriver().switchTo().window(String.valueOf(getWebDriver().getWindowHandles())),
                Click.on(MENU_ESTADO_FINANCIERO),
                Click.on(BTN_BALANCE)

        );
    }

    public static NavegarEstadosFinancieros navegarEstadosFinancieros(){
        return instrumented(NavegarEstadosFinancieros.class);
    }
}
