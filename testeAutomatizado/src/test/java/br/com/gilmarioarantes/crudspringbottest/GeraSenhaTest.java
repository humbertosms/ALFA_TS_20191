package br.com.gilmarioarantes.crudspringbottest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GeraSenhaTest {
  private WebDriver driver;
  private String baseUrl;
  private final StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = InstanciaDriver.getDriver();
    baseUrl = "http://www.geradordesenha.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGeraSenha() throws Exception {
    driver.get(baseUrl + "/");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//label[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[2]/div/label[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[2]/div/label[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Gerar Senha']")).click();
    Thread.sleep(2000);
    Assert.assertTrue(driver.findElement(By.name("password")).getText() != null);
  }

  @AfterTest
  public void closeDriver(){
    if(driver != null){
      driver.close();
    }
  }

}
