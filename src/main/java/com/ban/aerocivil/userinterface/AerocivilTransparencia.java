package com.ban.aerocivil.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AerocivilTransparencia {

    public static final Target BTN_PRESUPUESTO = Target.the("Botón Presupuesto")
            .located(By.xpath("//a[text() = \"5. Presupuesto.\u200B\"]"));
}
