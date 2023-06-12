package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilidades.DataDriven;
import utilidades.PropertiesDriven;

import java.io.IOException;
import java.util.List;

public class Tests {

    //atributos
    private WebDriver driver;
    private DataDriven data;
    private List<String> datosCp;
    private PropertiesDriven properties;

    //atributos (pages)
    private HomePage homepage;
    private DashboardPage dashboardPage;
    private AdminPage adminPage;
    private MyInfoPage myInfoPage;
    private EmergencyContactsPage emergencyContactsPage;
    private CambioPassPage cambioPassPage;
    private PosteoBuzzPage posteoBuzzPage;


    @BeforeSuite
    public void inicioSuiteDePruebas(){
        properties = new PropertiesDriven();
        System.out.println("Inicio de suit de pruebas automatizadas");

    }
    @BeforeClass
    public void preparacionClase(){

        data = new DataDriven();
        homepage = new HomePage(driver);
        homepage.conexionDriver(properties.obtenerProperty("rutaDriver"),properties.obtenerProperty("browserProperty"), properties.obtenerProperty("browser"));
        dashboardPage = new DashboardPage(homepage.getDriver());
        adminPage = new AdminPage(homepage.getDriver());
        myInfoPage = new MyInfoPage(homepage.getDriver());
        emergencyContactsPage = new EmergencyContactsPage(homepage.getDriver());
        cambioPassPage = new CambioPassPage(homepage.getDriver());
        posteoBuzzPage = new PosteoBuzzPage(homepage.getDriver());
    }
    @BeforeMethod
    public void preparacionTests(){
        String url = properties.obtenerProperty("url");
        homepage.cargarPagina(url);
        homepage.maximizarVentana();
    }
    @Test
    public void CP001_loginFallido() throws IOException {
        datosCp = data.obtenerDatosPrueba("CP001_loginFallido");
        homepage.completarFormularioLogin(datosCp.get(1),datosCp.get(2));
        Assert.assertEquals(homepage.obtenerMsjErrorLogin(), datosCp.get(3));
    }
    @Test
    public void CP002_loginOk() throws IOException {
        datosCp = data.obtenerDatosPrueba("CP002_loginOk");
        homepage.completarFormularioLogin(datosCp.get(1),datosCp.get(2));
    }
    @Test
    public void CP003_elementosPresentes() throws IOException {
        datosCp = data.obtenerDatosPrueba("CP003_elementosPresentes");
        Assert.assertEquals(dashboardPage.esperarPorElemento1(), datosCp.get(1));
        Assert.assertEquals(dashboardPage.esperarPorElemento2(), datosCp.get(2));
        Assert.assertEquals(dashboardPage.esperarPorElemento3(), datosCp.get(3));
        Assert.assertEquals(dashboardPage.esperarPorElemento4(), datosCp.get(4));
        Assert.assertEquals(dashboardPage.esperarPorElemento5(), datosCp.get(5));
        Assert.assertEquals(dashboardPage.esperarPorElemento6(), datosCp.get(6));
        Assert.assertEquals(dashboardPage.esperarPorElemento7(), datosCp.get(7));
    }
    @Test
    public void CP004_busquedaSinResultado() throws IOException {
        dashboardPage.irAAdmin();
        datosCp = data.obtenerDatosPrueba("CP004_busquedaSinResultado");
        adminPage.buscarPorUserName(datosCp.get(1));
        Assert.assertEquals(adminPage.obtenerMsjErrorBusqueda(), datosCp.get(2));
    }
   @Test
    public void CP005_busquedaConResultado() throws IOException {
        dashboardPage.irAAdmin();
        datosCp = data.obtenerDatosPrueba("CP005_busquedaConResultado");
        adminPage.buscarPorUserName(datosCp.get(1));
        Assert.assertEquals(adminPage.obtenerResultadoBusqueda(), datosCp.get(2));
    }
   @Test
    public void CP006_agregarContactoEmergencia() throws IOException {
        dashboardPage.irAMyInfo();
        myInfoPage.irAEmergencyContacts();
        emergencyContactsPage.irAAddContact();
        datosCp = data.obtenerDatosPrueba("CP006_agregarContactoEmergencia");
        emergencyContactsPage.completarFormularioContact(datosCp.get(1), datosCp.get(2), datosCp.get(3), datosCp.get(4), datosCp.get(5));
        //Assert.assertEquals(emergencyContactsPage.obtenerMsjExitoso(), datosCp.get(6));
    }
    @Test
    public void CP007_editarContactoEmergencia() throws IOException {
        dashboardPage.irAMyInfo();
        myInfoPage.irAEmergencyContacts();
        emergencyContactsPage.contactoAEditar();
        emergencyContactsPage.clickeditarContacto();
        emergencyContactsPage.borrarNameContacto();
        datosCp = data.obtenerDatosPrueba("CP007_editarContactoEmergencia");
        emergencyContactsPage.editarNameContacto(datosCp.get(1));
        emergencyContactsPage.borrarRelationShip();
        datosCp = data.obtenerDatosPrueba("CP007_editarContactoEmergencia");
        emergencyContactsPage.editarRelationShip(datosCp.get(2));
    }
    @Test
    public void CP008_eliminarContactoEmergencia() throws IOException {
        dashboardPage.irAMyInfo();
        myInfoPage.irAEmergencyContacts();
        emergencyContactsPage.contactoAEliminar();
        emergencyContactsPage.clickEliminarContacto();
        emergencyContactsPage.confirmaEliminarContacto();
    }
    @Test
    public void CP009_cambioDePassErroneo() throws IOException {
        dashboardPage.irAMenuHeader();
        dashboardPage.irACambioPass();
        datosCp = data.obtenerDatosPrueba("CP009_cambioDePassErroneo");
        cambioPassPage.completarFormularioSinPassA(datosCp.get(1), datosCp.get(2));
        Assert.assertEquals(cambioPassPage.obtenerTextoImput(), datosCp.get(3));
    }
    @Test
    public void CP010_cambioDePassOK() throws IOException {
        dashboardPage.irAMenuHeader();
        dashboardPage.irACambioPass();
        datosCp = data.obtenerDatosPrueba("CP010_cambioDePassOK");
        cambioPassPage.completarFormularioCambioPass(datosCp.get(1), datosCp.get(2), datosCp.get(3));
    }
    @Test
    public void CP011_postearComentario() throws IOException {
        dashboardPage.irABuzz();
        datosCp = data.obtenerDatosPrueba("CP011_postearComentario");
        posteoBuzzPage.ingresarComentario(datosCp.get(1));
        Assert.assertEquals(posteoBuzzPage.comentarioPublicado(), datosCp.get(2));
    }
    @Test
    public void CP012_editarComentario() throws IOException {
        dashboardPage.irABuzz();
        posteoBuzzPage.seleccionarEditarComentario();
        posteoBuzzPage.borrarComentario();
        datosCp = data.obtenerDatosPrueba("CP012_editarComentario");
        posteoBuzzPage.editarComentario(datosCp.get(1));
    }
    @Test
    public void CP013_cerrarSesion() throws IOException {
        dashboardPage.cerrarSesion();
    }
    @AfterTest
    private void cerrarBrowser() { homepage.cerrarBrowser();
    }
}
