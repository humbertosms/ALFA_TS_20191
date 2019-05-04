package alfa.br.com.teste;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:reports/test-report" }
, glue = { "alfa.br.com.teste" }
, features = {"src/main/teste/resources/avaliacao.feature" })	
public class CucumberRunner {

}
