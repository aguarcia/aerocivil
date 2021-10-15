package com.ban.aerocivil.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AerocivilInicialPage {

    public static final Target OPC_TRANSPARENCIA = Target.the("Opción Transparencia")
            .located(By.xpath("//span[text() = \"Transparencia\"]"));

}
