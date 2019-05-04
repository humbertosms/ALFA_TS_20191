package br.com.alfa.humberto.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaConsultaCEP {
	@FindBy(name="relaxation")
	private WebElement caixaDeTexto;
	
	@FindBy(name="(.//*[normalize-space(text()) and normalize-space(.)='Sim'])[1]/following::input[1]")
	private WebElement btnConsulta;
	
	WebDriver drive;

	public PaginaConsultaCEP(WebDriver drive) {
		super();
		this.drive = drive;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(drive, 30);
		PageFactory.initElements(factory, this);
	}

	public void informarCep(String cep){
		caixaDeTexto.clear();
		caixaDeTexto.sendKeys(cep);
	}
	
	public void consultar() {
		btnConsulta.click();
	}
}
