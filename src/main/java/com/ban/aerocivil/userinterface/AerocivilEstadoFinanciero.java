package com.ban.aerocivil.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AerocivilEstadoFinanciero {

    public static final Target BTN_BALANCE = Target.the("Botón Balance")
            .located(By.xpath("//div[text() = \"Balances\"]"));

    public static final Target OPC_DESC_PDF = Target.the("Opción de descarga de PDF")
            .located(By.xpath("//h2[text() = \"Estado de Situación Financiera a 30 de abril de 2021\"]/../../..//a[@class = \"tool-doc view\"]//img"));
}
