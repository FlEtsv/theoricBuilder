/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.JLabel;

/**
 * Clase de prueba para ControlDepuracion.
 * Esta clase proporciona casos de prueba para los métodos de la clase ControlDepuracion.
 *
 * @author Fishb0ness
 */
public class ControlDepuracionTest {
    private ControlDepuracion controlDepuracion;
    private JLabel mensajeLabel;

    /**
     * Configura los objetos necesarios para las pruebas.
     * Se ejecuta antes de cada prueba.
     */
    @BeforeEach
    public void configurar() {
        mensajeLabel = new JLabel();
        controlDepuracion = new ControlDepuracion(mensajeLabel);
    }

    /**
     * Prueba que el método mostrarMensaje muestra el mensaje correcto.
     * Se espera que el texto del mensajeLabel sea igual al mensaje proporcionado.
     */
    @Test
    public void deberiaMostrarMensaje() {
        controlDepuracion.mostrarMensaje("Prueba", 255, 255, 255, 1000);
        assertEquals("Prueba", mensajeLabel.getText());
    }

    /**
     * Prueba que el método mostrarMensaje maneja correctamente los mensajes nulos.
     * Se espera que el texto del mensajeLabel esté vacío si el mensaje es nulo.
     */
    @Test
    public void noDeberiaMostrarMensajeSiEsNulo() {
        controlDepuracion.mostrarMensaje(null, 255, 255, 255, 1000);
        assertEquals("", mensajeLabel.getText());
    }

    /**
     * Prueba que el método mostrarMensaje maneja correctamente los mensajes vacíos.
     * Se espera que el texto del mensajeLabel esté vacío si el mensaje está vacío.
     */
    @Test
    public void noDeberiaMostrarMensajeSiEstaVacio() {
        controlDepuracion.mostrarMensaje("", 255, 255, 255, 1000);
        assertEquals("", mensajeLabel.getText());
    }
}