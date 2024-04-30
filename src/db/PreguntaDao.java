/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package db;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.List;

/**
 * conjunto de metodos predefinidos para una implementacion.
 *
 * @author steve
 */
public interface PreguntaDao {

    List<Pregunta> obtenerTodasPreguntas() throws IOException, CsvValidationException;

    void reescribirArchivo(List<Pregunta> preguntas) throws IOException;

}
