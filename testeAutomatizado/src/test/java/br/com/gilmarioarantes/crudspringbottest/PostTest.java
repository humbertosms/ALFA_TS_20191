package br.com.gilmarioarantes.crudspringbottest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;


import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PostTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = InstanciaDriver.getDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  @Test(priority = 1)
  public void testaIclusaoPost() {
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Adicionar")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("autor")).clear();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("autor")).sendKeys("Gilmar Ferreira Arantes");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("titulo")).clear();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("titulo")).sendKeys("Post Teste Funcional");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("data")).clear();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("data")).sendKeys("2019-05-03");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("texto")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("texto")).clear();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("texto")).sendKeys("Este posto objetva mostrar o teste funcional automatizado utilizando o selenium.");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Texto'])[1]/following::button[1]")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[2]/div/table/tbody/tr/td[1]")).getText() != null);
  }

  @Test(priority = 2)
  public void testaAlteracaoPost() throws Exception {
    //driver.get("http://localhost:8080/save");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Editar")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("titulo")).clear();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.id("titulo")).sendKeys("Post Teste Funcional Alterado");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/button")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[3]")).getText().equals("Post Teste Funcional Alterado"));
  }

  @Test(priority = 3)
  public void testaExclusaoPost() throws Exception {
    //driver.get("http://localhost:8080/save");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.linkText("Excluir")).click();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    WebElement webElement = null;
    try{
      webElement = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/table/tbody/tr[1]/td[3]"));

    }catch (Exception e){
      Assert.assertTrue(webElement == null);
    }

  }

  @AfterTest
  public void closeDriver(){
    if(driver != null){
      driver.close();
    }
  }

}
