package br.com.alfa.humberto.paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaginaResultadoConsulta {
	
	@FindBy(xpath="/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[1]")
	WebElement gridResultadoConsulta;

	WebDriver drive;

	public PaginaResultadoConsulta(WebDriver driver) {
		super();
		this.drive = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(drive, 30);
	}

	public WebElement getGridResultadoConsulta() {
		return gridResultadoConsulta;
	}

	public void setGridResultadoConsulta(WebElement gridResultadoConsulta) {
		this.gridResultadoConsulta = gridResultadoConsulta;
	}
	
	
	
	
}
