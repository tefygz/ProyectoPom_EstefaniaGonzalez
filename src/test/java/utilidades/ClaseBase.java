package utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;


public class ClaseBase {
    //Atributos
    private WebDriver driver;
    private WebDriver wait;
    private TemporalUnit seconds;


    //Constructor
    public ClaseBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buscarElementoWeb(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> buscarElementosWeb(By localizador){
        return driver.findElements(localizador);
    }

    //click
    public void click(By localizador){
        this.driver.findElement(localizador).click();
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    //agregar texto
    public void agregarTexto(By localizador, String texto){
        this.driver.findElement(localizador).sendKeys(texto);
    }

    public void agregarTexto(WebElement elemento, String texto){elemento.sendKeys(texto);}

    //borrar texto
    public void borrarTexto(WebElement elemento){elemento.clear();}

  //public void borrarTexto(By localizador){this.driver.findElement(localizador).clear();}

    //combinacion de teclas
    public void agregarCombinacionTeclas(By localizador){this.driver.findElement(localizador).sendKeys(Keys.BACK_SPACE);}

    //obtener texto
    public String obtenerTexto(By localizador){
        return this.driver.findElement(localizador).getText();
    }

    public String obtenerTexto(WebElement elemento){
        return elemento.getText();
    }

    //cargar pagina
    public void cargarPagina(String url){
        this.driver.get(url);
    }

    //espera fija
    public void esperarXsegundos(int miliSegundos){
        try{
            Thread.sleep(miliSegundos);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //espera explicita
   public WebElement esperaExplicitaPresenciaElemento(By localizador){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.of( 50, ChronoUnit.SECONDS));
        return wait.until(ExpectedConditions.presenceOfElementLocated(localizador));
    }
    public WebElement esperaExplicitaElementoAClickear(By localizador){
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.of( 50, ChronoUnit.SECONDS));
        return wait.until(ExpectedConditions.elementToBeClickable(localizador));
    }

    public WebDriver conexionDriver(String ruta, String property, String browser){
        switch (browser) {
            case "chrome" -> {
                System.setProperty(property, ruta);
                this.driver = new ChromeDriver();
                return driver;
            }
            case "firefox" -> {
                System.setProperty(property, ruta);
                this.driver = new FirefoxDriver();
                return driver;
            }
            case "iexplorer" -> {
                System.setProperty(property, ruta);
                this.driver = new InternetExplorerDriver();
                return driver;
            }
            default -> {
                return driver;
            }
        }
    }

    public void maximizarVentana(){
        this.driver.manage().window().maximize();
    }

    public void cerrarBrowser(){
        this.driver.close();
    }

}
