package br.com.alfa.humberto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstanciaDriver {

	public static WebDriver getDriver() {

		WebDriver driver = null;

		final String OS = System.getProperty("os.name").toLowerCase();

		String urlDriver = OS.contains("win") ? "src/test/resources/chromedriver.exe --whitelist-ip %*"
				: "src/test/resources/chromedriver";

		System.setProperty("webdriver.chrome.driver", urlDriver);

		try {
			driver = new ChromeDriver();
		} catch (Exception e) {
			System.out.println("Erro ao instanciar o driver");
		}

		return driver;

	}

}