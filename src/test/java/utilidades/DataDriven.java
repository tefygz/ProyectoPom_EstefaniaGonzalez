package utilidades;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDriven {

    public List<String> obtenerDatosPrueba(String tituloCp) throws IOException {

        ArrayList<String> datos = new ArrayList<String>();

        PropertiesDriven properties = new PropertiesDriven();

        FileInputStream file;

        //Crear un objeto de tipo file

        file = new FileInputStream(properties.obtenerProperty("rutaExcel"));
        XSSFWorkbook excel;
        //Crear un objeto de tipo excel

         excel = new XSSFWorkbook(file);


    int cantidadHojasExcel = excel.getNumberOfSheets();
   // System.out.println("Cantidad de hojas: " + cantidadHojasExcel);

    for (int i=0; i<cantidadHojasExcel; i++){
        if (excel.getSheetName(i).equalsIgnoreCase(properties.obtenerProperty("nombreHojaExcel"))){
            //Encontré la hoja
            XSSFSheet hojaExcel = excel.getSheetAt(i);

            Iterator<Row> filas = hojaExcel.iterator();

            //Se instancia una fila en base a la 1era fila de la hoja en excel con los datos
            Row primeraFila = filas.next();

            Iterator<Cell> celda = primeraFila.cellIterator();

            int k=0;
            int columna=0;

            while(celda.hasNext()){
                Cell celdaSeleccionada = celda.next();

                if (celdaSeleccionada.getStringCellValue().equalsIgnoreCase(properties.obtenerProperty("tituloCPs"))){
                    //identificamos la columna a trabajar
                    columna = k;
                }
                k++;
            }

            while(filas.hasNext()){
            Row r = filas.next();

            if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(tituloCp)){
                //Encontré el titulo del CP

                Iterator<Cell> cv = r.cellIterator();

                while (cv.hasNext()){
                    Cell c = cv.next();

                    if (c.getCellType() == CellType.STRING){
                        //System.out.println(c.getStringCellValue());
                        datos.add(c.getStringCellValue());
                    }else if (c.getCellType() == CellType.NUMERIC){
                        //System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
                        datos.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                    }
                }

            }

            }

        }
    }
        return datos;
    }

}


