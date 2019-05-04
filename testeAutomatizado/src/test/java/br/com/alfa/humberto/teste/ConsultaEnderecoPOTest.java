package br.com.alfa.humberto.teste;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.alfa.humberto.InstanciaDriver;
import br.com.alfa.humberto.paginas.PaginaConsultaCEP;
import br.com.alfa.humberto.paginas.PaginaResultadoConsulta;

public class ConsultaEnderecoPOTest {

	WebDriver driver;
	PaginaConsultaCEP consulta;
	PaginaResultadoConsulta resultadoConsulta;

	@Test
	public void setup() {
		this.driver = InstanciaDriver.getDriver();
		consulta = new PaginaConsultaCEP(driver);
		resultadoConsulta = new PaginaResultadoConsulta(driver);		
	}
	@Test
	public void consultaPorCep() {
		consulta.informarCep("74393580");
		consulta.consultar();
		Assert.assertTrue(resultadoConsulta.getGridResultadoConsulta().getText().contains("Rua SR 17"));
		driver.close();
	}

}
