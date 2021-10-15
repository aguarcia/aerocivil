package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/estadosFinancieros/estadosFinancieros.feature"},
        glue = {"com.ban.aerocivil.stepdefinitions"},
        snippets = SnippetType.CAMELCASE
)

public class RunnersEstadosFinancieros {
}
