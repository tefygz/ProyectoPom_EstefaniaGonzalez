package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilidades.ClaseBase;

public class PosteoBuzzPage extends ClaseBase {
    public PosteoBuzzPage(WebDriver driver) {
        super(driver);
    }
    //Identificar localizadores
    By locatorComentario = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/textarea[1]");
    By locatorBtnPost = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]");
    By locatorPublicacion = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/p[1]");
    By locatorClickEditComentario = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/li[1]/button[1]");
    By locatorEditComentario = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/li[1]/ul[1]/li[2]/p[1]");
    By locatorModificarComentario = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/textarea[1]");
    By locatorBtnPostEdit = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]");

    //acciones del page
    public void ingresarComentario(String comentario) {
        agregarTexto(esperaExplicitaPresenciaElemento(locatorComentario), comentario);
        click(esperaExplicitaElementoAClickear(locatorBtnPost));
    }
    public String comentarioPublicado(){
        return obtenerTexto(esperaExplicitaPresenciaElemento(locatorPublicacion));
    }

    public void seleccionarEditarComentario(){
        click(esperaExplicitaElementoAClickear(locatorClickEditComentario));
        click(esperaExplicitaElementoAClickear(locatorEditComentario));
    }
    public void borrarComentario(){
        click(esperaExplicitaElementoAClickear(locatorModificarComentario));
        borrarTexto(esperaExplicitaPresenciaElemento(locatorModificarComentario));
    }
    public void editarComentario(String nuevoComentario){
        agregarTexto(esperaExplicitaPresenciaElemento(locatorModificarComentario), nuevoComentario);
        click(locatorBtnPostEdit);
    }
}
