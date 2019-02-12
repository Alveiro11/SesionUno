package com.qvision.mavencapacitacion;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejecucion {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.get("http://developsupport.com/qIntranet/login/index.php");
			WebElement txtUsuario = driver.findElement(By.id("username"));
			txtUsuario.sendKeys("jrubio");
			WebElement txtPassword = driver.findElement(By.id("password"));
			txtPassword.sendKeys("Creaturas.24");
			WebElement btnLogin = driver.findElement(By.id("loginbtn"));
			btnLogin.click();
			WebElement lblMensaje = driver
					.findElement(By.xpath("//*[@id='region-main']/div[2]/div/div/div/div[1]/span"));
			if (lblMensaje.isDisplayed()) {
				System.out.println("Error de Usuario y Contraseña");
			}
		} catch (NoSuchElementException e) {
			// TODO: handle exception
		}
		driver.quit();
	}

}
