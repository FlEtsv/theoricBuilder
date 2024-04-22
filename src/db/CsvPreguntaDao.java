/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para manejar la escritura de archivos CSV.
 *implementando interfaz PreguntaDao
 * @author steve
 */
public class CsvPreguntaDao implements PreguntaDao{
    private String csvArchivo = "data.csv";
public CsvPreguntaDao() {
    // al instanciar vemos si existe
        crearArchivoSiNoExiste();
    }
/**
 * crea el archivo si no existe ya y le añade el header no es necesario
 */
    private void crearArchivoSiNoExiste() {
        File file = new File(csvArchivo);
        if (!file.exists()) {
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvArchivo))) {
                String[] header = {"Pregunta", "Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta Correcta"};
                writer.writeNext(header);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * crea una List en la que recopila todas las preguntas recorriendo el archivo csv
     * @return preguntas 
     * @throws IOException
     * @throws CsvValidationException
     */
    @Override
    public List<Pregunta> obtenerTodasPreguntas() throws IOException, CsvValidationException {
        List<Pregunta> preguntas = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(csvArchivo))) {
            String[] siguienteLinea;
            reader.readNext(); // Saltar el encabezado
            while ((siguienteLinea = reader.readNext()) != null) {
                String pregunta = siguienteLinea[0];
                List<String> respuestas = List.of(siguienteLinea[1], siguienteLinea[2], siguienteLinea[3]);
                String respuestaCorrecta = siguienteLinea[4];
                preguntas.add(new Pregunta(pregunta, respuestas, respuestaCorrecta));
            }
        } catch (CsvValidationException e) {
            System.err.println("Error de validación del CSV: " + e.getMessage());
            throw e;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
            throw e;
        }
        return preguntas;
    }
/**
 * con una instacia de pregunta podemos agregar una nueva linea a nuestro archivo csv, se asegura de que haya 3 respuestas como minimo sumando la correcta
 * @param pregunta
 * @throws IOException 
 */
      @Override
    public void agregarPregunta(Pregunta pregunta) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvArchivo, true))) {
            String[] nuevaPregunta = new String[5]; // Asumiendo que hay cuatro respuestas y una correcta de 0-4
            nuevaPregunta[0] = pregunta.getPregunta();
            List<String> respuestas = pregunta.getRespuestas();
            if (respuestas.size() >= 3) { // Asegura que hay al menos tres respuestas opcional
                nuevaPregunta[1] = respuestas.get(0);
                nuevaPregunta[2] = respuestas.get(1);
                nuevaPregunta[3] = respuestas.get(2);
            }
            nuevaPregunta[4] = pregunta.getRespuestaCorrecta();
            writer.writeNext(nuevaPregunta);
        }
    }

    /**
     *encuentra la pregunta de estre todas y nos permite modificarla 
     * @param pregunta
     * @throws IOException
     */
    @Override
    public void actualizarPregunta(Pregunta pregunta) throws IOException {
        List<Pregunta> preguntas = null;
        try {
            preguntas = obtenerTodasPreguntas(); // Obtén todas las preguntas para buscar la que deseamos.
        } catch (CsvValidationException ex) {
            Logger.getLogger(CsvPreguntaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Encuentra la pregunta que quieres actualizar o editar
        int index = -1;
        for (int i = 0; i < preguntas.size(); i++) {
            if (preguntas.get(i).getPregunta().equals(pregunta.getPregunta())) {
                index = i;
                break;
            }
        }

        if (index != -1) { // Si se encuentra la pregunta -1 valor imposible.
            preguntas.set(index, pregunta); // Actualiza la pregunta en la lista cambiandola por la instancia que le damos.
            reescribirArchivo(preguntas); // Reescribe el archivo con la lista actualizada.
        }
    }
/**
 * 
 * @param preguntas
 * @throws IOException 
 */
    private void reescribirArchivo(List<Pregunta> preguntas) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvArchivo, false))) {
            String[] header = {"Pregunta", "Respuesta 1", "Respuesta 2", "Respuesta 3", "Respuesta Correcta"};
            writer.writeNext(header);
            for (Pregunta p : preguntas) {
                String[] entries = new String[]{
                    p.getPregunta(),
                    p.getRespuestas().get(0),
                    p.getRespuestas().get(1),
                    p.getRespuestas().get(2),
                    p.getRespuestaCorrecta()
                };
                writer.writeNext(entries);
            }
        }
    }
    /**
     * Elimina la pregunta específica, suponiendo que la igualdad se basa en el texto solo de la pregunta
     * Reescribe el archivo con la lista actualizada
     * @param pregunta
     * @throws IOException 
     */
      @Override
    public void eliminarPregunta(Pregunta pregunta) throws IOException {
        List<Pregunta> preguntas = null;
        try {
            preguntas = obtenerTodasPreguntas();
        } catch (CsvValidationException ex) {
            Logger.getLogger(CsvPreguntaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        preguntas.removeIf(p -> p.getPregunta().equals(pregunta.getPregunta()));//elimina la que coincida con pregunta.getPregunta() de la instacia actual
        reescribirArchivo(preguntas); 
    }
    }


