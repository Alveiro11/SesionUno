package com.qvision.datadriven;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainDataDriven {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		File data = new File("data.txt");
		FileReader fr;
		try {
			fr = new FileReader(data);
			BufferedReader br = new BufferedReader(fr);
	        String linea = "";
	        while((linea=br.readLine())!=null){
	        	try {
	        		String[] datos = linea.split(",");
	    			driver.get("http://developsupport.com/qIntranet/login/index.php");
	    			WebElement txtUsuario = driver.findElement(By.id("username"));
	    			txtUsuario.sendKeys(datos[0]);
	    			WebElement txtPassword = driver.findElement(By.id("password"));
	    			txtPassword.sendKeys(datos[1]);
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
	        }	           
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.close();
	}

}
