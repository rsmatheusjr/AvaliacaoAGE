package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import Teste.TesteCucumber;
import Utils.Utils;

public class Fap {
	// Inicializa��o
	public WebDriver driver;
	public static String empresa;

	public static String getEmpresa() {
		return empresa;
	}

	public static int rat;

	public static int getRat() {
		return rat;
	}

	public static int fap;

	public static int getFap() {
		return fap;
	}

	public static String salario;

	public static Float getSalario() {
		return Float.parseFloat(salario);
	}

	public Fap() {
	}

	// Valida que esta na pagina do FAP
	public String validarTelaFap() {
		this.driver = TesteCucumber.getDriver();
		WebElement validar = driver.findElement(By.tagName("h1"));
		if(validar.getText().trim().contentEquals(("Gest�o FAP: estrat�giapara diminuir custos").toUpperCase().trim())) {
			Utils.log(Status.PASS, validar, "Acessar pagina do FAP");			
		}else {
			Utils.log(Status.FAIL, validar, "Erro ao acessar pagina do FAP. Esperado por '"+("Gest�o FAP: estrat�giapara diminuir custos").toUpperCase().trim()+"'.");			
		}
		return validar.getText();
	}

	// Preenche o campo com o nome da empresa
	public void preencherEmpresa(String empresa) {
		Fap.empresa = empresa;
		WebElement campoEmpresa = driver.findElement(By.name("nomeEmpresa"));
		campoEmpresa.sendKeys(empresa);
		Utils.log(Status.PASS, campoEmpresa, "Preencher campo empresa com = " + empresa);			
	}

	// Digita o valor do FAP
	public void preencherFap(int fap) {
		Fap.fap = fap;
		WebElement campoFap = driver.findElement(By.name("fap"));
		campoFap.sendKeys(Integer.toString(fap));
		Utils.log(Status.PASS, campoFap, "Preencher campo FAP com = " + fap);
	}

	// Seleciona o valor do RAT
	public void preencherRat(int rat) {
		Fap.rat = rat;
		WebElement campoRat = driver.findElement(By.className("selectric"));
		campoRat.click();
		driver.findElement(By.cssSelector("li[data-index='" + Integer.toString(rat) + "']")).click();
		Utils.log(Status.PASS, campoRat, "Selecionar RAT = " + rat);
	}

	// Preenche o campo com o valor do salario
	public void preencherSalario(String salario) {
		Fap.salario = salario;
		WebElement campoSalario = driver.findElement(By.name("projecao"));
		campoSalario.sendKeys(salario);
		Utils.log(Status.PASS, campoSalario, "Preencher campo de projecao de massa salarial com = " + salario);
	}

	// Enviar formulario
	public void estimarFormulario() {
		WebElement botao = driver.findElement(By.className("wpcf7-submit"));
		Utils.log(Status.PASS, botao, "Clicar em estimar");
		botao.click();
	}
}