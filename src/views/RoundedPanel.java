/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase extiende JPanel para crear un panel con esquinas redondeadas.
 * El radio de las esquinas se puede establecer durante la instanciación.
 *
 * @author Fishb0ness
 */
public class RoundedPanel extends JPanel {

    private final int radius;

    /**
     * Constructor para la clase RoundedPanel.
     *
     * @param radius El radio de las esquinas redondeadas.
     */
    public RoundedPanel(int radius) {
        super();
        this.radius = radius;
    }

    /**
     * Sobrescribe el método paintComponent de JPanel.
     * Aquí es donde se dibujan las esquinas redondeadas.
     *
     * @param g El objeto Graphics a proteger.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(radius, radius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el panel redondeado con bordes.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint background
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); //paint border
    }
}
