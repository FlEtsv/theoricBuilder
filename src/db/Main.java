/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *prueba de funcionamiento aprobado,recordad que solo debe haber un metodo main en el programa
 * @author steve
 */
public class Main {
    /*
public static void main(String[] args) throws IOException, CsvValidationException {
            CsvPreguntaDao preg = new CsvPreguntaDao();
    
    List<String> respuestas = List.of("pepe", "juan", "mateo");
    Pregunta pregunta1 = new Pregunta();
            pregunta1.setPregunta("¿que tiene 2 ruedas?");
            pregunta1.setRespuestas(respuestas);
            pregunta1.setRespuestaCorrecta("moto");
    preg.agregarPregunta(pregunta1);
    
    CsvPreguntaDao preg2 = new CsvPreguntaDao();
    List<String> respuestas2 = List.of("pepe", "juan", "mateo");
    Pregunta pregunta2 = new Pregunta();
            pregunta2.setPregunta("¿que tiene 3 ruedas?");
            pregunta2.setRespuestas(respuestas2);
            pregunta2.setRespuestaCorrecta("triciclo");

    // Añade la nueva pregunta al archivo CSV
    preg.agregarPregunta(pregunta2);
    
    List<String> respuestas3 = List.of("pepe", "juan", "mateo");
    Pregunta pregunta3 = new Pregunta();
            pregunta3.setPregunta("¿que tiene 4 ruedas?");
            pregunta3.setRespuestas(respuestas);
            pregunta3.setRespuestaCorrecta("coche");

    // Añade la nueva pregunta al archivo CSV
    preg.agregarPregunta(pregunta3);
    
    Pregunta preguntaEliminar = new Pregunta();
    preguntaEliminar.setPregunta("¿que tiene 4 ruedas?");
    preg.eliminarPregunta(preguntaEliminar);
    
    
    List<String> respuestas1 = List.of("alfonso", "OptimusPrime", "tarantino");
    Pregunta preguntaEditar = new Pregunta();
             preguntaEditar.setPregunta("¿que tiene 3 ruedas?");
             preguntaEditar.setRespuestas(respuestas1);
             preguntaEditar.setRespuestaCorrecta("tren");
             preg.actualizarPregunta(preguntaEditar);


    //lee todas las preguntas del archivo, incluyendo la recién añadida
    List<Pregunta> preguntas = preg.obtenerTodasPreguntas();
    for (Pregunta pregunta : preguntas) {
        System.out.println("Pregunta: " + pregunta.getPregunta());
        System.out.println("Respuestas: " + String.join(", ", pregunta.getRespuestas()));
        System.out.println("Respuesta Correcta: " + pregunta.getRespuestaCorrecta());
        System.out.println(); // Línea en blanco para separar preguntas
         }
    
    ManejoZip zip = new ManejoZip();
    String miCarpeta = zip.obtenerEscritorio() + File.separator + "MisArchivosZIP";
    zip.crearCarpetaSiNoExiste(miCarpeta); 

    String nombreArchivoZIP = "miArchivo.zip";
    String direccionArchivoZIP = miCarpeta + File.separator + nombreArchivoZIP;
    zip.comprimir("Simulador1", direccionArchivoZIP);
    */
   
}

/* proceso de base de datos a front
    metodo CsvPreguntaDao.ObtenerTodasPreguntas() retorna una lista List<Pregunta> preguntas 
    este return nos permite hacer un for para poder recorrer los objetos de la lista 
    dando sus valores a cada Label (los labels deben tener correlacion en sus nombres para 
    poder recorrerse en un for, para saber los labels que hay que crear es conveniente 
    obtenerlo con int canLabels = preguntas.size(); y luego recorrer cada el Array de label[index]
    con el for a la vez que le damos los valores a los componentes necesarios. haciendo esto tambien 
    tendriamos el prime debug Fail que es si el simulador no tiene preguntas en cuyo caso calLabels = 0
    
    se simplifica el acceso de la base de datos  teniendo solo dos accesos claros a ella, teniendo un
    acceso al principio de la aplicacion al selecciona un simulador que accederemos a leer el archivo que 
    hay dentro de su carpeta correspondiente,  y al final de la aplicacion para con el boton crear detonaremos
    el guardado de todas la informacion en la lista preguntas y posterior guardado en nuestro archivo csv para 
    su empaquetado en el escritorio. se determinaran 6 rutas distintas para la posible lectura de nuestro
    simulador elegido. se manejara las eliminaciones desde el front. se intentara implementar un boton de guardado 
    previo al crear que nos dejara los cambios de un simulador determinado sin generar el zip.

    se añadiran una clase sesion que almacenara nuestra int canLabels para obtenerlo donde necesitemos con facil acceso
    Pregunta nuevaPregunta = new Pregunta();  // Crear una nueva instancia en cada iteración
    nuevaPregunta.setPregunta(preguntaField.getText());
    nuevaPregunta.setRespuestas(Tratamiento para la lista de respuestas);
    nuevaPregunta.setRespuestaCorrecta(respuestasField.getText());
    preguntasList.add(nuevaPregunta);
*/
