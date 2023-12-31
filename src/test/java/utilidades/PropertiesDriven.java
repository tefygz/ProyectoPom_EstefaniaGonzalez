package utilidades;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesDriven {

    //atributos
    private Properties prop;

    public String obtenerProperty(String Key){
        //Instanciar un objeto de tipo properties
        prop = new Properties();

        try {
            InputStream input = new FileInputStream("C:\\Users\\Estefania.Gonzalez\\Documents\\CURSO Automation\\TrabajoPOM_GonzalezEstefania\\src\\test\\resources\\Setup.properties");
            prop.load(input);
        }catch (Exception e){
            System.out.println("No fue posible llamar al archivo properties");
            e.printStackTrace();

        }

        return prop.getProperty(Key);
    }
}
