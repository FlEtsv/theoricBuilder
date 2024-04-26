/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utility.Sesion;

/**
 * Clase para manejar la escritura de archivos CSV.
 *implementando interfaz PreguntaDao
 * @author steve
 */
public class CsvPreguntaDao implements PreguntaDao{
    private final String csvArchivo = Sesion.getInstance().getSimuladorName() + File.separator + "StreamingAssets\\Preguntas.csv";
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
            String err = "No se encontró el archivo preguntas";
            Sesion.getInstance().setRojo(err);
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvArchivo))) {
            } catch (IOException e) {
                err = "No se pudo crear el archivo Preguntas";
                Sesion.getInstance().setRojo(err);
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
    CSVParser parser = new CSVParserBuilder()
            .withSeparator(';')  // Establecer el delimitador como punto y coma
            .build();

    try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvArchivo))
            .withCSVParser(parser)  // Usar el parser personalizado
            .build()) {
        String[] siguienteLinea;

        while ((siguienteLinea = reader.readNext()) != null) {
            if (siguienteLinea.length < 5) {
                // Si no hay suficientes columnas, imprimir error y continuar con la siguiente línea
                System.err.println("Línea incompleta ignorada: " + Arrays.toString(siguienteLinea));
                continue;
            }
            String pregunta = siguienteLinea[0];
            List<String> respuestas = Arrays.asList(siguienteLinea[1], siguienteLinea[2], siguienteLinea[3]);
            String respuestaCorrecta = siguienteLinea[4];
            preguntas.add(new Pregunta()
                .setPregunta(pregunta)
                .setRespuestas(respuestas)
                .setRespuestaCorrecta(respuestaCorrecta));
        }
    } catch (CsvValidationException e) {
        System.err.println("Error en la estructura del archivo de preguntas: " + e.getMessage());
        String err = "Error en la estructura del archivo de preguntas";
        Sesion.getInstance().setRojo(err);
        throw e;
    } catch (IOException e) {
        System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        throw e;
    }

    // Verificación para comprobar si la lista de preguntas está vacía
    if (preguntas.isEmpty()) {
        System.err.println("No se encontraron preguntas en el archivo.");
        String err = "Este simulador no tiene preguntas";
        Sesion.getInstance().setAmarillo(err);
    }

    return preguntas;
}



/**
 * 
 * @param preguntas
 * @throws IOException 
 */
    public void reescribirArchivo(List<Pregunta> preguntas, String csvArchivo) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(csvArchivo, false),
                ';', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END)) {
            for (Pregunta pregunta : preguntas) {
                String[] entries = new String[]{pregunta.getPregunta(),
                    pregunta.getRespuestas().get(0),
                    pregunta.getRespuestas().get(1),
                    pregunta.getRespuestas().get(2),
                    pregunta.getRespuestaCorrecta()};
                writer.writeNext(entries);
            }
        }
    }
}


    /*
    
     * Elimina la pregunta específica, suponiendo que la igualdad se basa en el texto solo de la pregunta
     * Reescribe el archivo con la lista actualizada
     * @param pregunta
     * @throws IOException 

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
     * Con una instancia de pregunta podemos agregar una nueva línea a nuestro archivo CSV, se asegura de que haya 3 respuestas como mínimo sumando la correcta.
     * @param pregunta Pregunta a agregar
     * @throws IOException si ocurre un error al escribir en el archivo
     
    public void agregarPregunta(Pregunta pregunta) throws IOException {
        // Define el delimitador y el caracter de comillas
        char customSeparator = ';';
        char noQuoteChar = CSVWriter.NO_QUOTE_CHARACTER;

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvArchivo, true), 
                                              customSeparator, 
                                              noQuoteChar, 
                                              CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                              CSVWriter.DEFAULT_LINE_END)) {
            String[] nuevaPregunta = new String[5];  // Asumiendo que hay una pregunta y cuatro respuestas, incluyendo la correcta
            nuevaPregunta[0] = pregunta.getPregunta();
            List<String> respuestas = pregunta.getRespuestas();
            if (respuestas.size() >= 3) {  // Asegura que hay al menos tres respuestas opcionales
                nuevaPregunta[1] = respuestas.get(0);
                nuevaPregunta[2] = respuestas.get(1);
                nuevaPregunta[3] = respuestas.get(2);
            }
            nuevaPregunta[4] = pregunta.getRespuestaCorrecta();
            writer.writeNext(nuevaPregunta);
        }
    }

     *encuentra la pregunta de estre todas y nos permite modificarla 
     * @param pregunta
     * @throws IOException

    @Override
    public void actualizarPregunta(Pregunta pregunta) throws IOException {
        List<Pregunta> preguntas = null;
        try {
            preguntas = obtenerTodasPreguntas(); // Obtén todas las preguntas para buscar la que deseamos.
        } catch (CsvValidationException ex) {
            Logger.getLogger(CsvPreguntaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Encuentra la pregunta que quieres editar
        int index = -1;
        for (int i = 0; i < preguntas.size(); i++) {
            if (preguntas.get(i).getPregunta().equals(pregunta.getPregunta())) {
                index = i;
                break;
            }
        }

        if (index != -1) { // Si se encuentra la pregunta
            preguntas.set(index, pregunta); // Actualiza la pregunta en la lista.
            reescribirArchivo(preguntas); // Reescribe el archivo con la lista actualizada.
        }
    }
     */


