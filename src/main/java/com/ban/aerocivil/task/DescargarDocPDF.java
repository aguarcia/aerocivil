package com.ban.aerocivil.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static com.ban.aerocivil.userinterface.AerocivilEstadoFinanciero.OPC_DESC_PDF;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DescargarDocPDF implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OPC_DESC_PDF)
        );
    }

    public static DescargarDocPDF descargarDocPDF(){
        return instrumented(DescargarDocPDF.class);
    }
}
