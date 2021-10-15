package com.ban.aerocivil.stepdefinitions;

import com.ban.aerocivil.abilities.ReadPdf;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;

import static com.ban.aerocivil.task.DescargarDocPDF.descargarDocPDF;
import static com.ban.aerocivil.task.NavegarEstadosFinancieros.navegarEstadosFinancieros;
import static com.ban.aerocivil.util.WebDriverFactory.getWebDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EstadosFinancierosStepDefinitions {

    String actor;
    private WebDriver chrome;
    private EnvironmentVariables environmentVariables;
    String downloadFolder;
    String fileName;

    @Before
    public void setTheStage() throws MalformedURLException{
        chrome = getWebDriver();
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("(.*) ingresa a la web de Aerocivil$")
    public void IngresaALaWebDeAerocivil(String actor) {
        this.actor = actor;
        theActorCalled(actor).can(BrowseTheWeb.with(chrome));

        downloadFolder = environmentVariables.optionalProperty("download.filesFolder")
                .orElseThrow(IllegalArgumentException::new);
        fileName = environmentVariables.optionalProperty("statements.fileName")
                .orElseThrow(IllegalArgumentException::new);
    }

    @When("^navega hasta los estados financieros$")
    public void navegaHastaLosEstadosFinancieros() {
        theActorInTheSpotlight().attemptsTo(
                navegarEstadosFinancieros()
        );
    }

    @When("^selecciona mes a descargar$")
    public void seleccionaMesADescargar() throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(
                descargarDocPDF()
        );
        Thread.sleep(10000);

    }

    @Then("^se realiza la descarga de un documento PDF$")
    public void seRealizaLaDescargaDeUnDocumentoPDF() throws IOException {
        String statementFilePath = String.format("%s/%s", downloadFolder, fileName);
        theActorInTheSpotlight().can(ReadPdf.downloadedInPath(statementFilePath));

        String pdfText = ReadPdf.as(theActorInTheSpotlight()).getText();
        pdfText = pdfText.substring(50, 80);

        System.out.println(pdfText);

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(pdfText).isEqualTo("ESTADO DE SITUACION FINANCIERA")
        );
    }

}
