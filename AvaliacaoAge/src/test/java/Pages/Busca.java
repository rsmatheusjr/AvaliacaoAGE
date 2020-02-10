package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Teste.TesteCucumber;
import Utils.Utils;

public class Busca {
	// Inicialização
	public WebDriver driver;

	public Busca() {
	}

	// Valida o resultado da busca efetuada
	public String validarResultadoBusca() {
		this.driver = TesteCucumber.getDriver();
		WebElement campoResultado = driver.findElement(By.tagName("h2"));
		String[] resultado = campoResultado.getText().split(": ");
		Utils.log(Status.PASS, campoResultado, "Validar resultado = " + resultado[1]);			
		return resultado[1];
	}
}