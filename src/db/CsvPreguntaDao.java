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
 * Clase para manejar la escritura de archivos CSV. implementando interfaz
 * PreguntaDao
 *
 * @author steve
 */
public class CsvPreguntaDao implements PreguntaDao {

    private final String csvArchivo = Sesion.getInstance().getSimuladorName() + File.separator + "StreamingAssets/Preguntas.csv";

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
     * crea una List en la que recopila todas las preguntas recorriendo el
     * archivo csv
     *
     * @return preguntas
     * @throws IOException
     * @throws CsvValidationException
     */
    @Override
    public List<Pregunta> obtenerTodasPreguntas() throws IOException, CsvValidationException {
        List<Pregunta> preguntas = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(';') // Establecer el delimitador como punto y coma
                .build();

        try (CSVReader reader = new CSVReaderBuilder(new FileReader(csvArchivo))
                .withCSVParser(parser) // Usar el parser personalizado
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
    public void reescribirArchivo(List<Pregunta> preguntas) throws IOException {
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