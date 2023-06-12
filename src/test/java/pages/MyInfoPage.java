package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class MyInfoPage extends ClaseBase {
    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    //Identificar localizadores
    By locatorContactoEmergencia = By.xpath("//a[contains(text(),'Emergency Contacts')]");

    //acciones del page
    public void irAEmergencyContacts(){
        click(esperaExplicitaElementoAClickear(locatorContactoEmergencia));
    }

}
