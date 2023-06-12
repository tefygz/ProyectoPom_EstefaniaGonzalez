package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class CambioPassPage extends ClaseBase {
    public CambioPassPage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
    By locatorPassActual = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By locatorPassNueva = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By locatorConfirmPass = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By locatorBtnGuardarPass = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/button[2]");
    By locatorSinPassActual = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/span[1]");

    //acciones del page
    public void completarFormularioCambioPass(String passActual, String passNueva, String passConfirma) {
        agregarTexto(esperaExplicitaPresenciaElemento(locatorPassActual), passActual);
        agregarTexto(esperaExplicitaPresenciaElemento(locatorPassNueva), passNueva);
        agregarTexto(esperaExplicitaPresenciaElemento(locatorConfirmPass), passConfirma);
        click(esperaExplicitaElementoAClickear(locatorBtnGuardarPass));
    }
    public void completarFormularioSinPassA(String passNueva, String passConfirma) {
        agregarTexto(esperaExplicitaPresenciaElemento(locatorPassNueva), passNueva);
        agregarTexto(esperaExplicitaPresenciaElemento(locatorConfirmPass), passConfirma);
        click(esperaExplicitaElementoAClickear(locatorBtnGuardarPass));
    }
    public String obtenerTextoImput(){
       return obtenerTexto(esperaExplicitaPresenciaElemento(locatorSinPassActual));
    }

}