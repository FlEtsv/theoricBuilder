/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author steve
 */
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlDepuracion {
    private Thread threadDepuracion;
    private volatile boolean seguirEjecutando = true;
    private JLabel mensajeLabel;
    private ControlDepuracion depuracion;
    private Timer mensajeTimer;

public ControlDepuracion(JLabel mensajeLabel) {
    this.mensajeLabel = mensajeLabel;
    this.mensajeTimer = new Timer(0, e -> mensajeLabel.setText(""));
    this.mensajeTimer.setRepeats(false);
}

    /**
     * Muestra un mensaje en la etiqueta por un período de tiempo específico si el mensaje no está vacío.
     * @param message El mensaje a mostrar.
     * @param displayDuration Duración en milisegundos durante la cual se mostrará el mensaje.
     */
public void mostrarMensaje(String message ,int r, int g, int b, int displayDuration) {
    if (message != null && !message.isEmpty()) {
        mensajeLabel.setText(message); // Establece el mensaje en la etiqueta
        mensajeLabel.setForeground(new Color(r,g,b));
        mensajeTimer.setInitialDelay(displayDuration); // Establece la duración de visualización
        mensajeTimer.start(); // Inicia o reinicia el timer
    }
}

    public void iniciarDepuracion() {
        threadDepuracion = new Thread(() -> {
            while (seguirEjecutando) {
                try {
                    verificarYMostrarMensajes();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        threadDepuracion.start();
    }

    private void verificarYMostrarMensajes() {
    String rojo = Sesion.getInstance().getRojo();
    String verde = Sesion.getInstance().getVerde();
    String amarillo = Sesion.getInstance().getAmarillo();
    String blanco = Sesion.getInstance().getBlanco();

    if (rojo != null && !rojo.isEmpty()) {
        this.mostrarMensaje(rojo,235,65,81, 3000); // 3 segundos para 'rojo'
        Sesion.getInstance().setRojo(""); // Limpia el valor después de mostrar
    }
    if (verde != null && !verde.isEmpty()) {
        this.mostrarMensaje(verde,134,210,149,2000); // 2 segundos para 'verde'
        Sesion.getInstance().setVerde(""); // Limpia el valor después de mostrar
    }
    if (amarillo != null && !amarillo.isEmpty()) {
        this.mostrarMensaje(amarillo,245,154,26,2000); // 2 segundos para 'amarillo'
        Sesion.getInstance().setAmarillo(""); // Limpia el valor después de mostrar
    }
        if (blanco != null && !blanco.isEmpty()) {
        this.mostrarMensaje(blanco,247,247,247,1000); // 2 segundos para 'amarillo'
        Sesion.getInstance().setBlanco(""); // Limpia el valor después de mostrar
    }
}

    public void detenerDepuracion() {
        seguirEjecutando = false;
        if (threadDepuracion != null) {
            threadDepuracion.interrupt();
        }
    }
}

    /*
    ControlDepuracion depuracion = new ControlDepuracion(messageLabel);

            String rojo = Sesion.getInstace().getRojo();
            String verde = Sesion.getInstace().getVerde();
            String amarillo = Sesion.getInstace().getAmarillo();

            if (!rojo.isEmpty()) {
                depuracion.mostrarMensaje(rojo, 3000); // 3 segundos para 'rojo'
                rojo = "";
            }
            if (!verde.isEmpty()) {
                depuracion.mostrarMensaje(verde, 2000); // 2 segundos para 'verde'
                verde = "";
            if (!amarillo.isEmpty()) {
                depuracion.mostrarMensaje(amarillo, 2000); // 2 segundos para 'amarillo'
                amarillo = ""; 
            }
    */

