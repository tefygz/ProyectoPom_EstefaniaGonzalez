package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;


public class EmergencyContactsPage extends ClaseBase {
    public EmergencyContactsPage(WebDriver driver) {
        super(driver);
    }
    //Identificar localizadores
    By locatorAgregarContacto = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]");

    //Localizadores formulario
    By locatorName = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By locatorRelationShip = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By locatorHomePhone = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By locatotMobile = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By locatorWorkPhone = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[3]/div[1]/div[2]/input[1]");

    //Localizador boton
    By locatorBtnSave = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/button[2]");

    //localizador mensaje exitoso
    By locatorMsjToast = By.xpath("//div[@id='oxd-toaster_1']");

    //localizador para editar
    By locatorContactoAEditar = By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container div.orangehrm-edit-employee div.orangehrm-edit-employee-content div.orangehrm-container:nth-child(3) div.oxd-table div.oxd-table-body div.oxd-table-card:nth-child(1) div.oxd-table-row.oxd-table-row--with-border div.oxd-table-cell.oxd-padding-cell:nth-child(2) > div:nth-child(1)");
    By locatorClickEditarContacto = By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container div.orangehrm-edit-employee div.orangehrm-edit-employee-content div.orangehrm-container:nth-child(3) div.oxd-table div.oxd-table-body div.oxd-table-card:nth-child(1) div.oxd-table-row.oxd-table-row--with-border div.oxd-table-cell.oxd-padding-cell:nth-child(7) div.oxd-table-cell-actions > button.oxd-icon-button.oxd-table-cell-action-space:nth-child(2)");
    By locatorEditarNameContacto = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By locatorEditarRelationShip = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By locatorBtnSaveEditar = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/button[2]");

    //localizadores para eliminar
    By locatorContactoAEliminar = By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container div.orangehrm-edit-employee div.orangehrm-edit-employee-content div.orangehrm-container:nth-child(3) div.oxd-table div.oxd-table-body div.oxd-table-card:nth-child(1) > div.oxd-table-row.oxd-table-row--with-border");
    By locatorClickELiminarContacto = By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container div.orangehrm-edit-employee div.orangehrm-edit-employee-content div.orangehrm-container:nth-child(3) div.oxd-table div.oxd-table-body div.oxd-table-card:nth-child(1) div.oxd-table-row.oxd-table-row--with-border div.oxd-table-cell.oxd-padding-cell:nth-child(7) div.oxd-table-cell-actions > button.oxd-icon-button.oxd-table-cell-action-space:nth-child(1)");
    By locatorBtnEliminar = By.cssSelector("div.oxd-overlay.oxd-overlay--flex.oxd-overlay--flex-centered div.oxd-dialog-container-default div.oxd-dialog-container-default--inner div.oxd-sheet.oxd-sheet--rounded.oxd-sheet--white.oxd-dialog-sheet.oxd-dialog-sheet--shadow.oxd-dialog-sheet--gutters.orangehrm-dialog-popup div.orangehrm-modal-footer > button.oxd-button.oxd-button--medium.oxd-button--label-danger.orangehrm-button-margin:nth-child(2)");

    //acciones del page

    public void irAAddContact(){
        click(esperaExplicitaElementoAClickear(locatorAgregarContacto));
    }

    public void completarFormularioContact(String name, String relation, String homephone, String mobile, String workphone){
        agregarTexto(esperaExplicitaPresenciaElemento(locatorName), name);
        agregarTexto(esperaExplicitaPresenciaElemento(locatorRelationShip), relation);
        agregarTexto(esperaExplicitaPresenciaElemento(locatorHomePhone), homephone);
        agregarTexto(esperaExplicitaPresenciaElemento(locatotMobile), mobile);
        agregarTexto(esperaExplicitaPresenciaElemento(locatorWorkPhone), workphone);
        click(esperaExplicitaElementoAClickear(locatorBtnSave));
    }
    public String obtenerMsjExitoso(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorMsjToast));
    }
    public void contactoAEditar(){
        esperaExplicitaPresenciaElemento(locatorContactoAEditar);
    }
    public void clickeditarContacto(){
        click(esperaExplicitaPresenciaElemento(locatorClickEditarContacto));
    }
    public void borrarNameContacto(){
        click(esperaExplicitaPresenciaElemento(locatorEditarNameContacto));
        click(esperaExplicitaPresenciaElemento(locatorEditarNameContacto));
       for (int i=0; i<7; i++){
           agregarCombinacionTeclas(locatorEditarNameContacto);
       }
    }
    public void editarNameContacto(String nameContact){
        agregarTexto(esperaExplicitaPresenciaElemento(locatorEditarNameContacto), nameContact);
    }
    public void borrarRelationShip(){
        click(esperaExplicitaPresenciaElemento(locatorEditarRelationShip));
        click(esperaExplicitaPresenciaElemento(locatorEditarRelationShip));
        for (int i=0; i<7; i++){
            agregarCombinacionTeclas(locatorEditarRelationShip);
        }
    }
    public void editarRelationShip(String relationShip){
        agregarTexto(esperaExplicitaPresenciaElemento(locatorEditarRelationShip), relationShip);
        click(esperaExplicitaElementoAClickear(locatorBtnSaveEditar));
    }
    public void contactoAEliminar(){
        esperaExplicitaPresenciaElemento(locatorContactoAEliminar);
    }
    public void clickEliminarContacto(){
       click(esperaExplicitaPresenciaElemento(locatorClickELiminarContacto));
    }
    public void confirmaEliminarContacto(){
        click(esperaExplicitaPresenciaElemento(locatorBtnEliminar));
    }
}
