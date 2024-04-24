/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Clase de utilidad que proporciona métodos estáticos para manipular componentes de la interfaz de usuario.
 *
 * @author Fishb0ness
 */
public class theUltimateUtility {

    /**
     * Suma las dimensiones de los componentes proporcionados.
     *
     * @param args Los componentes cuyas dimensiones se sumarán.
     * @return Dimension La suma de las dimensiones de los componentes.
     */
    public static Dimension sumaDimension(Component args[]){
        int width = 430;
        int height = 5;
        for (Component component: args){
            if (component.isVisible()){
                if(component.getSize().height < 1){
                    height += component.getPreferredSize().height +5;
                } else {
                    height += component.getSize().height +5;
                }
            }
        }
        return new Dimension(width, height);
    }

    /**
     * Establece la imagen de un JLabel.
     *
     * @param jLabel El JLabel al que se le establecerá la imagen.
     * @param path La ruta de la imagen.
     * @param dimension Las dimensiones de la imagen.
     */
    public static void setImageLabel(JLabel jLabel, String path, Dimension dimension) {
        ImageIcon imageIcon = new ImageIcon(path);
        Icon icon = new ImageIcon( imageIcon.getImage().getScaledInstance((int)(dimension.getWidth()), (int)(dimension.getHeight()), Image.SCALE_SMOOTH));
        jLabel.setIcon(icon);
        jLabel.repaint();
    }
}

