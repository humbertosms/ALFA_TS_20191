package br.com.gilmarioarantes.crudspringbottest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by gilmario on 20/03/17.
 */
public class InstanciaDriver {

    public static WebDriver getDriver() {

        WebDriver driver = null;

        final String OS = System.getProperty("os.name").toLowerCase();

        String urlDriver = OS.contains("win") ? "src/test/resources/chromedriver.exe" : "src/test/resources/chromedriver";

        System.setProperty("webdriver.chrome.driver", urlDriver);

        try{
            driver = new ChromeDriver();
        }catch (Exception e){
            System.out.println("Erro ao instanciar o driver");
        }

        return driver;

    }

}
