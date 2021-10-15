package com.ban.aerocivil.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AerocivilPresupuesto {

    public static final Target MENU_ESTADO_FINANCIERO = Target.the("Menú Estado Financiero")
            .located(By.xpath("//li//a[text() = \"Estados financieros\"]"));

}
