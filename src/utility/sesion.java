/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import com.opencsv.exceptions.CsvValidationException;
import db.CsvPreguntaDao;
import db.ManejoZip;
import db.Pregunta;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author steve
 */
public class Sesion {
    private static Sesion instancia = null;
    private String simuladorName = null;
    private int cantidadPreguntas;
    
    private Sesion() {
        // Constructor privado para el patrón Singleton
    }
    
    public static Sesion getInstance() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }
    
    public int getCantidadPreguntas() {
        return cantidadPreguntas;
    }
    
    public void setCantidadPreguntas(int cantidadPreguntas) {
        this.cantidadPreguntas = cantidadPreguntas;
    }
        public  String getSimuladorName() {
        return simuladorName;
    }

    public void setSimuladorName(String simuladorName) {
        this.simuladorName = simuladorName;
    }
    /**
     * 
     * @return datos para cargarlos directamente en las labels
     */
    public List<Pregunta> obtenerDatos() throws CsvValidationException {
        CsvPreguntaDao obtenerDatos = new CsvPreguntaDao();
        try {
            List<Pregunta> datos = obtenerDatos.obtenerTodasPreguntas();
            getInstance().setCantidadPreguntas(datos.size());
            return datos; 
        } catch (IOException e) { 
            System.err.println("Error al obtener preguntas: " + e.getMessage());
            return null;
        }
    }
    
     /**
     * Método final para guardar el archivo.
     * @param preguntasGuardado Lista de preguntas a guardar.
     */
    public static void guardar(List<Pregunta> preguntasGuardado) throws IOException {
        // Crear una instancia de CsvPreguntaDao
        CsvPreguntaDao guardar = new CsvPreguntaDao();
         String simuladorName = getInstance().getSimuladorName();
        // Llamar al método reescribirArchivo con la lista de preguntas
        guardar.reescribirArchivo(preguntasGuardado,simuladorName);
    }
    /**
     * nos genera el archivo final solo necesita el nombre del simulador elegido
     * @throws IOException 
     */
    public static void Exportar() throws IOException{
        String simuladorName = getInstance().getSimuladorName();
        db.ManejoZip exportar = new ManejoZip();
        ManejoZip zip = new ManejoZip();
    String miCarpeta = exportar.obtenerEscritorio() + File.separator + "Test";
    zip.crearCarpetaSiNoExiste(miCarpeta); 

    String nombreArchivoZIP =  simuladorName + ".zip";
    String direccionArchivoZIP = miCarpeta + File.separator + nombreArchivoZIP;
    exportar.comprimir(simuladorName, direccionArchivoZIP);
    }


}
