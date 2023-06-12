package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class DashboardPage extends ClaseBase {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    //Identificar localizadores
    By locatorAdmin = By.linkText("Admin");
    By locatorMyInfo = By.linkText("My Info");
    By locatorMenuHeader = By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/span[1]");
    By locatorCambioPass = By.xpath("//a[contains(text(),'Change Password')]");
    By locatorBuzz = By.linkText("Buzz");
    By locatorLogout = By.xpath("//a[contains(text(),'Logout')]");

    //localizadores elementos disponibles
    By locatorCard1 = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]");
    By locatorCard2 = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]");
    By locatorCard3 = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]");
    By locatorCard4 = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]");
    By locatorCard5 = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[5]/div[1]/div[1]");
    By locatorCard6 = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[6]/div[1]/div[1]");
    By locatorCard7 = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[7]/div[1]/div[1]");

    //acciones del page
    public void irAAdmin(){
        click(esperaExplicitaElementoAClickear(locatorAdmin));
    }
    public void irAMyInfo(){
        click(esperaExplicitaElementoAClickear(locatorMyInfo));
    }
    public String esperarPorElemento1(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorCard1));
    }
    public String esperarPorElemento2(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorCard2));
    }
    public String esperarPorElemento3(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorCard3));
    }
    public String esperarPorElemento4(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorCard4));
    }
    public String esperarPorElemento5(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorCard5));
    }
    public String esperarPorElemento6(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorCard6));
    }
    public String esperarPorElemento7(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorCard7));
    }
    public void irAMenuHeader(){
        click(esperaExplicitaElementoAClickear(locatorMenuHeader));
    }
    public void irACambioPass(){
        click(esperaExplicitaElementoAClickear(locatorCambioPass));
    }
    public void irABuzz(){
        click(esperaExplicitaElementoAClickear(locatorBuzz));
    }
    public void cerrarSesion(){
        click(esperaExplicitaElementoAClickear(locatorMenuHeader));
        click(esperaExplicitaElementoAClickear(locatorLogout));
    }
}