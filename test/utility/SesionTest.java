/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import db.Pregunta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Arrays;
import java.util.List;

/**
 * Clase de prueba para Sesion.
 * Esta clase proporciona casos de prueba para los métodos de la clase Sesion.
 *
 * @author Fishb0ness
 */
public class SesionTest {
    private Sesion sesion;

    /**
     * Configura los objetos necesarios para las pruebas.
     * Se ejecuta antes de cada prueba.
     */
    @BeforeEach
    public void configurar() {
        sesion = Sesion.getInstance();
    }

    /**
     * Prueba que el método crearPreguntasDesdePaneles crea las preguntas correctamente desde los paneles.
     * Se espera que las preguntas creadas tengan los datos correctos.
     */
    @Test
    public void deberiaCrearPreguntasDesdePaneles() {
        JPanel panel = new JPanel();
        JTextField preguntaTextField = new JTextField("Pregunta");
        preguntaTextField.setName("jLabelPregunta0");
        panel.add(preguntaTextField);
        JTextField correctaTextField = new JTextField("Respuesta Correcta");
        correctaTextField.setName("jLabelCorrecta0");
        panel.add(correctaTextField);
        for (int i = 1; i <= 3; i++) {
            JTextField incorrectaTextField = new JTextField("Respuesta Incorrecta " + i);
            incorrectaTextField.setName("jLabelIncorrecta" + i);
            panel.add(incorrectaTextField);
        }

        List<Pregunta> preguntas = sesion.crearPreguntasConPaneles(Arrays.asList(panel));

        assertEquals(1, preguntas.size());
        Pregunta pregunta = preguntas.get(0);
        assertEquals("Pregunta", pregunta.getPregunta());
        assertEquals("Respuesta Correcta", pregunta.getRespuestaCorrecta());
        assertEquals(Arrays.asList("Respuesta Incorrecta 1", "Respuesta Incorrecta 2", "Respuesta Incorrecta 3"), pregunta.getRespuestas());
    }

    /**
     * Prueba que el método crearPreguntasDesdePaneles maneja correctamente una lista de paneles vacía.
     * Se espera que no se creen preguntas si la lista de paneles está vacía.
     */
    @Test
    public void deberiaManejarListaDePanelesVacia() {
        List<Pregunta> preguntas = sesion.crearPreguntasConPaneles(Arrays.asList());

        assertTrue(preguntas.isEmpty());
    }

    /**
     * Prueba que el método crearPreguntasDesdePaneles maneja correctamente un panel sin campos de texto.
     * Se espera que se cree una pregunta, pero con datos nulos.
     */
    @Test
    public void deberiaManejarPanelSinCamposDeTexto() {
        JPanel panel = new JPanel();

        List<Pregunta> preguntas = sesion.crearPreguntasConPaneles(Arrays.asList(panel));

        assertEquals(1, preguntas.size());
        Pregunta pregunta = preguntas.get(0);
        assertNull(pregunta.getPregunta());
        assertNull(pregunta.getRespuestaCorrecta());
        assertTrue(pregunta.getRespuestas().isEmpty());
    }
}
