package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class HomePage extends ClaseBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
    By locatorInputAdmin = By.name("username");
    By locatorInputPass = By.name("password");
    By locatorBtnLogin = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]");

    //locator mensajeError
    By locatorMsjErrorLogin = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]");

    //acciones del page
    public void completarFormularioLogin(String username, String password){
        agregarTexto(esperaExplicitaPresenciaElemento(locatorInputAdmin), username);
        agregarTexto(esperaExplicitaPresenciaElemento(locatorInputPass), password);
        click(esperaExplicitaElementoAClickear(locatorBtnLogin));
    }
    public String obtenerMsjErrorLogin(){
       return obtenerTexto(esperaExplicitaPresenciaElemento(locatorMsjErrorLogin));
       //return obtenerTexto(locatorMsjErrorLogin);
    }
}
