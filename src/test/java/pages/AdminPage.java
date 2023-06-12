package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class AdminPage extends ClaseBase {
    public AdminPage(WebDriver driver) {
        super(driver);
    }
    //Identificar localizadores
    By locatorBusquedaUserName = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By locatorBtnBuscar = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/button[2]");

    //locator mensajeError
    By locatormensajeErrorBusqueda = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]");

    //locator resultado busqueda
    By locatorResultadoBusqueda = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]");


    //acciones del page
    public void buscarPorUserName(String username){
        agregarTexto(esperaExplicitaPresenciaElemento(locatorBusquedaUserName), username);
        click(esperaExplicitaPresenciaElemento(locatorBtnBuscar));
    }
   public String obtenerMsjErrorBusqueda(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatormensajeErrorBusqueda));
   }
   public String obtenerResultadoBusqueda(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorResultadoBusqueda));
   }
}
