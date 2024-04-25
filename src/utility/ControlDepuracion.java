/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

/**
 *
 * @author steve
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlDepuracion {
    private JLabel messageLabel;
    private Timer messageTimer;

    public ControlDepuracion(JLabel messageLabel) {
        this.messageLabel = messageLabel;
        this.messageTimer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageLabel.setText(""); // Limpia el mensaje de la etiqueta
                messageTimer.stop(); // Detiene el timer
            }
        });
    }

    /**
     * Muestra un mensaje en la etiqueta por un período de tiempo específico si el mensaje no está vacío.
     * @param message El mensaje a mostrar.
     * @param displayDuration Duración en milisegundos durante la cual se mostrará el mensaje.
     */
    public void mostrarMensaje(String message, int displayDuration) {
        if (message != null && !message.isEmpty()) {
            messageLabel.setText(message); // Establece el mensaje en la etiqueta
            messageTimer.setInitialDelay(displayDuration); // Establece la duración de visualización
            messageTimer.restart(); // Reinicia el timer
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
}
