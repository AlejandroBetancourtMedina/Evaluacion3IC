package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	
	@Given("Abrir Chrome")
	public void abrir_navegador() {
	System.out.println("Abrir navegador");
	System.setProperty("webdriver.chrome.driver", "C");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	drive.get("");
	}
	@When ("Ingresa datos del login")
	public void Ingresa_login(String string, String string2) {
		driver.findElement(By.id("usuario")).sendKeys(string);
		driver.findElement(By.id("pass")).sendKeys(string2);
		
	}
	
	@Then("Inicia sesion")
	public void inicia_sesion() {
		System.out.println("inicia sesion con datos ingresados");
		driver.findElement(By.id("btnlogin")).click();
		
	}

	
}
