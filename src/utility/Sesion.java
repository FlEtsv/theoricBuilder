/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author steve
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



import com.opencsv.exceptions.CsvValidationException;
import db.CsvPreguntaDao;
import db.ManejoZip;
import db.Pregunta;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author steve
 */
public class Sesion {
    private static Sesion instancia = null;
    private String rojo, amarillo, verde = null;
    private String simuladorName = null;
    private int cantidadPreguntas;
    private int nFinalPreguntas;
    private List<Pregunta> preguntasFront;

    
    private Sesion() {
        // Constructor privado para el patrón Singleton
    }
    
    public static Sesion getInstance() {
        if (instancia == null) {
            instancia = new Sesion();
        }
        return instancia;
    }
    
    public List<Pregunta> getPreguntas() {
        return preguntasFront;
    }

    public void setPreguntas(List<Pregunta> preguntasFront) {
        this.preguntasFront = preguntasFront;
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
    
    public String getRojo() {
        return rojo;
    }

    public void setRojo(String rojo) {
        this.rojo = rojo;
    }

    public String getAmarillo() {
        return amarillo;
    }

    public void setAmarillo(String amarillo) {
        this.amarillo = amarillo;
    }

    public String getVerde() {
        return verde;
    }

    public void setVerde(String verde) {
        this.verde = verde;
    }
        public int getnFinalPreguntas() {
        return nFinalPreguntas;
    }

    public void setnFinalPreguntas(int nFinalPreguntas) {
        this.nFinalPreguntas = nFinalPreguntas;
    }
    /**
     * 
     * @return datos para cargarlos directamente en las labels
     * @throws com.opencsv.exceptions.CsvValidationException
     * @throws java.io.IOException
     */
    public List<Pregunta> obtenerDatos() throws CsvValidationException, IOException {
        CsvPreguntaDao obtenerDatos = new CsvPreguntaDao();
        try {
            List<Pregunta> datos = obtenerDatos.obtenerTodasPreguntas();
            getInstance().setCantidadPreguntas(datos.size());
            String err = "Las preguntas han sido cargadas con éxito";
            getInstance().setVerde(err);
            return datos; 
        } catch (IOException e) { 
            System.err.println("Error al obtener preguntas: " + e.getMessage());
            return null;
        }
    }
    
     /**
     * Método final para guardar el archivo.
     * @param preguntasGuardado Lista de preguntas a guardar.
     * @throws java.io.IOException
     */
    public static void guardar(List<Pregunta> preguntasGuardado) throws IOException {
        // Crear una instancia de CsvPreguntaDao
        CsvPreguntaDao guardar = new CsvPreguntaDao();
         String simuladorName = getInstance().getSimuladorName();
        // Llamar al método reescribirArchivo con la lista de preguntas
        guardar.reescribirArchivo(preguntasGuardado,simuladorName);
        String err = "Las preguntas han sido guardadas (%d en total)" + getInstance().getnFinalPreguntas();
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
    String err = "Las preguntas se guardaron y se exportó el simulador en: "+ direccionArchivoZIP +".zip";
    getInstance().setVerde(err);
    }
    

    /**
     * Actualiza los JTextFields dentro de una lista de JPanels con preguntas de una lista de Pregunta.
     * 
     * @param paneles La lista de JPanels que se actualizarán con preguntas.
     * @param preguntas La lista de preguntas que contienen los datos a mostrar.
     * @param cantidadPaneles El número de paneles que corresponden al número de preguntas.
     */
    public void actualizarPreguntasEnPaneles(List<JPanel> paneles, List<Pregunta> preguntas, int cantidadPaneles) {
        for (int i = 0; i < Math.min(paneles.size(), preguntas.size()); i++) {
            JPanel panel = paneles.get(i);
            Pregunta pregunta = preguntas.get(i);

            // Buscar el JTextField por su nombre en el JPanel
            JTextField textField = (JTextField) EncontrarComponente(panel, "jLabelPregunta" + (i));
            if (textField != null) {
                textField.setText(pregunta.getPregunta());
            } else {
                System.err.println("No se encontró el JTextField con el nombre esperado en el panel " + (i));
            }
        }
    }

    /**
     * Busca un componente por nombre dentro de un contenedor.
     * 
     * @param container El contenedor donde buscar el componente.
     * @param name El nombre del componente a buscar.
     * @return El componente si se encuentra, de lo contrario null.
     */
    private Component EncontrarComponente(Container container, String name) {
        for (Component comp : container.getComponents()) {
            if (name.equals(comp.getName())) {
                return comp;
            } else if (comp instanceof Container) {
                Component foundComp = EncontrarComponente((Container) comp, name);
                if (foundComp != null) {
                    return foundComp;
                }
            }
        }
        return null;
    }
    
    /**
     * Crea una lista de preguntas instanciando Pregunta con los JTextFields de una lista de JPanels.
     * 
     * @param paneles La lista de JPanels de la que tomamos la información..
     * @return Una lista de Pregunta con la información tomada de los paneles.
     */
    public List<Pregunta> crearPreguntasConPaneles(List<JPanel> paneles) {
        List<Pregunta> preguntas = new ArrayList<>();
        for (int i = 0; i < paneles.size(); i++) {
            JPanel panel = paneles.get(i);
            Pregunta pregunta = new Pregunta();
            // Buscar el JTextField de la pregunta por su nombre en el JPanel
            JTextField preguntaTextField = (JTextField) EncontrarComponente(panel, "jLabelPregunta" + (i));
            if (preguntaTextField != null) {
                pregunta.setPregunta(preguntaTextField.getText());
            } else {
                System.err.println("No se encontró el JTextField con el nombre esperado en el panel " + (i));
            }
            // Busca el JTextField de la respuesta correcta por su nombre en el JPanel
            JTextField correctaTextField = (JTextField) EncontrarComponente(panel, "jLabelCorrecta" + (i));
            if (correctaTextField != null) {
                pregunta.setRespuestaCorrecta(correctaTextField.getText());
            } else {
                System.err.println("No se encontró el JTextField con el nombre esperado en el panel " + (i));
            }
            // Respuestas incorrectas.
            List<String> incorrectasList = new ArrayList<>();
            // Busca el JTextField cada una de las respuestas incorrectas por su nombre en el JPanel
            for (int j = 1; j <= 3; j++){
                JTextField incorrectaTextField = (JTextField) EncontrarComponente(panel, "jLabelIncorrecta"+j);
                if (correctaTextField != null) {
                    incorrectasList.add(incorrectaTextField.getText());
                } else {
                    System.err.println("No se encontró el JTextField con el nombre esperado en el panel " + (i));
                }
            }
            pregunta.setRespuestas(incorrectasList);
            // Añade cada una de las preguntas a la lista de preguntas
            preguntas.add(pregunta);
        }
        return preguntas;
    }
    //prueba
}


