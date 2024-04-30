/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.opencsv.exceptions.CsvValidationException;
import db.Pregunta;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static utility.Sesion.getInstance;
import utility.Utility;
import utility.Sesion;

/**
 *
 * @author USER
 */
public class PanelPreguntas extends javax.swing.JPanel {

    private List<JPanel> paneles = new ArrayList<>();
    private List<JLabel> botones = new ArrayList<>();
    int cantidadPanelesPreguntaFront = 0;

    public PanelPreguntas() {
        initComponents();
        panelPrincipal.addContainerListener(new ContainerHandler());
        panelPrincipal.add(new VistaSelectorSimulador(this));

    }

    /**
     * escuchador para cambios en los componentes added or removed
     */
    private class ContainerHandler implements ContainerListener {

        @Override
        public void componentAdded(ContainerEvent e) {
            ajustarTamaño();
        }

        @Override
        public void componentRemoved(ContainerEvent e) {
            ajustarTamaño();
        }
    }

    /**
     * ajusta tamaño de el panel principal segun los componentes que tiene y
     * inicializa la cantidad de componentes para la clase sesion
     */
    public void ajustarTamaño() {
        int totalWidth = panelPrincipal.getWidth();
        int x = 0;
        int y = 0;
        int maxHeight = 0;
        int contadorComponentes = 0;

        for (Component comp : panelPrincipal.getComponents()) {
            Dimension compPrefSize = comp.getPreferredSize();
            if (x + compPrefSize.width > totalWidth) {
                x = 0;
                if (contadorComponentes < 4) {
                    y += maxHeight + 20;
                } else if (contadorComponentes <= 7) {
                    y += maxHeight + 17;
                } else {
                    y += maxHeight + 4;
                }
                maxHeight = 0;
            }
            x += compPrefSize.width;
            maxHeight = Math.max(maxHeight, compPrefSize.height);
            contadorComponentes += 1;
        }
        Component[] components = panelPrincipal.getComponents();
        Sesion.getInstance().setCantidadcomponentes(components.length);
        int newHeight = y + maxHeight;
        Dimension newSize = new Dimension(totalWidth, newHeight);
        panelPrincipal.setPreferredSize(newSize);
        panelPrincipal.setSize(newSize);
        panelPrincipal.setMaximumSize(newSize);
        this.setPreferredSize(newSize);
        this.setSize(newSize);
        this.setMaximumSize(newSize);
        // Ajustar el tamaño preferido del panelPrincipal
        this.revalidate();
        this.repaint();
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public void CambioSize(Dimension nuevaDimension) {
        panelPrincipal.getComponent(0).setPreferredSize(nuevaDimension);
        ajustarTamaño();
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }

    public void setPaneles(List<JPanel> paneles) {
        this.paneles = paneles;
    }

    public void setBotones(List<JLabel> botones) {
        this.botones = botones;
    }

    /**
     * crea panel nuevo funcionalidad "Boton mas"
     */
    public void crearPanelNuevo() {

        final int indice = cantidadPanelesPreguntaFront;
        JPanel nuevoPanel = panelPreguntaCom(indice);
        // Agregar componentes al panel
        paneles.add(nuevoPanel);
        panelPrincipal.add(nuevoPanel);
        cantidadPanelesPreguntaFront++;
        Sesion.getInstance().setBlanco("Pregunta añadida (actualmente " + (Sesion.getInstance().getCantidadcomponentes() - 1) + ")");
    }

    /**
     * carga los paneles segun el valor numerico del CSV se obtiene de Sesion
     */
    public void cargarPanelesInicio() {
        for (int i = 0; i < Sesion.getInstance().getCantidadPreguntas(); i++) {
            final int indice = i;
            paneles.add(panelPreguntaCom(indice));
            cantidadPanelesPreguntaFront++;
        }

        List<Pregunta> preguntasLista = List.of();
        try {
            preguntasLista = getInstance().obtenerDatos();
        } catch (CsvValidationException | IOException e) {
            // TODO menajar el posible error
        }
        getInstance().actualizarPreguntasEnPaneles(paneles, preguntasLista, paneles.size());

        for (JPanel panel : paneles) {
            panelPrincipal.add(panel);
            panelPrincipal.revalidate();
        }
    }

    /**
     * elimina la pregunta seleccionada filtra por nombre de componente
     *
     * @param nombre
     */
    public void eliminarPregunta(String nombre) {
        Component[] componentes = panelPrincipal.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JPanel && nombre.equals(componente.getName())) {
                panelPrincipal.remove(componente);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                if (cantidadPanelesPreguntaFront > 0) {
                    cantidadPanelesPreguntaFront--;
                }
                break;
            }
        }
    }

    /**
     * obtiene los componentes y remueve la totalidad menos
     * VistaSelectorSimulador
     */
    public void eliminarTodasPreguntas() {
        paneles.clear();
        Component[] componentes = panelPrincipal.getComponents();
        if (componentes.length > 1 && componentes[0] instanceof VistaSelectorSimulador) {
            for (int i = 1; i < componentes.length; i++) {
                if (componentes[i] instanceof JPanel) {
                    panelPrincipal.remove(componentes[i]);
                    panelPrincipal.revalidate();
                    panelPrincipal.repaint();
                }
            }
        }
    }

    /**
     * retorna el panel de preguntas ya configurado
     *
     * @param indice
     * @return
     */
    public JPanel panelPreguntaCom(int indice) {

        //Creación del panel con ÍNDICE.
        JPanel panelNuevo = new JPanel(); // Inicializa el JPanel antes de usarlo
        panelNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelNuevo.setName("contenedorPregunta" + indice);
        panelNuevo.setMaximumSize(new java.awt.Dimension(380, 250));
        panelNuevo.setMinimumSize(new java.awt.Dimension(380, 250));
        panelNuevo.setPreferredSize(new java.awt.Dimension(380, 250));
        panelNuevo.setOpaque(false);

        //Generar icono eliminar pregunta
        JLabel botonNuevo = new JLabel();
        botonNuevo.setName("iconoEliminar" + indice);
        botonNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonNuevo.setMaximumSize(new java.awt.Dimension(12, 12));
        botonNuevo.setMinimumSize(new java.awt.Dimension(12, 12));
        botonNuevo.setPreferredSize(new java.awt.Dimension(12, 12));
        Utility.SetImageLabel(botonNuevo, "src/imagenes/InterfazMobile/Menos_Off.png", new Dimension(14, 14));
        panelNuevo.add(botonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 12, 12));
        // Agregar MouseListener al segundo JLabel
        botonNuevo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Acción al clicar el label2
                //JOptionPane.showMessageDialog(null, "Has hecho click en el botón del panel " + paneles[indice].getName());
                eliminarPregunta(panelNuevo.getName());
                Sesion.getInstance().setBlanco("Pregunta elimidada (quedan " + (Sesion.getInstance().getCantidadcomponentes() - 1) + ")");
            }
        });

        //Generamos y creamos el JLabel del título de "Pregunta"
        JLabel preguntatxt = new JLabel("Pregunta");
        preguntatxt.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        preguntatxt.setForeground(new java.awt.Color(255, 255, 255));
        panelNuevo.add(preguntatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

        //Generamos y creamos el JTextField de la pregunta
        JTextField preguntaescribe = new JTextField();
        preguntaescribe.setName("jLabelPregunta" + indice);
        preguntaescribe.setBackground(new java.awt.Color(0, 0, 0, 1));
        preguntaescribe.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        preguntaescribe.setForeground(new java.awt.Color(255, 255, 255));
        preguntaescribe.setBorder(null);
        preguntaescribe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        preguntaescribe.setOpaque(false);
        panelNuevo.add(preguntaescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 34, 320, -1));

        //Generamos el fondo del JLabel
        JLabel fondoPregunta = new JLabel();
        fondoPregunta.setMaximumSize(new java.awt.Dimension(340, 30));
        fondoPregunta.setMinimumSize(new java.awt.Dimension(340, 30));
        fondoPregunta.setPreferredSize(new java.awt.Dimension(340, 30));
        Utility.SetImageLabel(fondoPregunta, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(340, 30));
        panelNuevo.add(fondoPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 29, 340, -1));

        //Generamos y creamos el JLabel del título de "Respuesta correcta"
        JLabel respuestaCorrectaTXT = new JLabel("Respuesta correcta");
        respuestaCorrectaTXT.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        respuestaCorrectaTXT.setForeground(new java.awt.Color(255, 255, 255));
        panelNuevo.add(respuestaCorrectaTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 165, -1));

        //Generamos y creamos el JTextField de la respuesta correcta
        JTextField respuestacorrecta = new JTextField();
        respuestacorrecta.setName("jLabelCorrecta" + indice);
        respuestacorrecta.setBackground(new java.awt.Color(0, 0, 0, 1));
        respuestacorrecta.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        respuestacorrecta.setForeground(new java.awt.Color(255, 255, 255));
        respuestacorrecta.setBorder(null);
        respuestacorrecta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        respuestacorrecta.setOpaque(false);
        panelNuevo.add(respuestacorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 84, 320, -1));

        //Generamos el fondo del JLabel
        JLabel fondoRespuestaCorrecta = new JLabel();
        fondoRespuestaCorrecta.setMaximumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaCorrecta.setMinimumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaCorrecta.setPreferredSize(new java.awt.Dimension(340, 30));
        Utility.SetImageLabel(fondoRespuestaCorrecta, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(340, 30));
        panelNuevo.add(fondoRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 79, 340, -1));

        //Generamos y creamos el JLabel del título de "Respuestas incorrectas"
        JLabel respuestasIncorrectasTXT = new JLabel("Respuestas incorrectas");
        respuestasIncorrectasTXT.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        respuestasIncorrectasTXT.setForeground(new java.awt.Color(255, 255, 255));
        panelNuevo.add(respuestasIncorrectasTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 115, 165, -1));

        //Generamos y creamos el JTextField de la respuesta incorrecta 1
        JTextField respuestaIncorrecta1 = new JTextField();
        respuestaIncorrecta1.setName("jLabelIncorrecta1");
        respuestaIncorrecta1.setBackground(new java.awt.Color(0, 0, 0, 1));
        respuestaIncorrecta1.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        respuestaIncorrecta1.setForeground(new java.awt.Color(255, 255, 255));
        respuestaIncorrecta1.setBorder(null);
        respuestaIncorrecta1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        respuestaIncorrecta1.setOpaque(false);
        panelNuevo.add(respuestaIncorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 139, 320, -1));

        //Generamos el fondo del incorrecta 1
        JLabel fondoRespuestaIncorrecta1 = new JLabel();
        fondoRespuestaIncorrecta1.setMaximumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaIncorrecta1.setMinimumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaIncorrecta1.setPreferredSize(new java.awt.Dimension(340, 30));
        Utility.SetImageLabel(fondoRespuestaIncorrecta1, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(340, 30));
        panelNuevo.add(fondoRespuestaIncorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 134, 340, -1));

        //Generamos y creamos el JTextField de la respuesta incorrecta 2
        JTextField respuestaIncorrecta2 = new JTextField();
        respuestaIncorrecta2.setName("jLabelIncorrecta2");
        respuestaIncorrecta2.setBackground(new java.awt.Color(0, 0, 0, 1));
        respuestaIncorrecta2.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        respuestaIncorrecta2.setForeground(new java.awt.Color(255, 255, 255));
        respuestaIncorrecta2.setBorder(null);
        respuestaIncorrecta2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        respuestaIncorrecta2.setOpaque(false);
        panelNuevo.add(respuestaIncorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, 320, -1));

        //Generamos el fondo del incorrecta 2
        JLabel fondoRespuestaIncorrecta2 = new JLabel();
        fondoRespuestaIncorrecta2.setMaximumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaIncorrecta2.setMinimumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaIncorrecta2.setPreferredSize(new java.awt.Dimension(340, 30));
        Utility.SetImageLabel(fondoRespuestaIncorrecta2, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(340, 30));
        panelNuevo.add(fondoRespuestaIncorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 171, 340, -1));

        //Generamos y creamos el JTextField de la respuesta incorrecta 3
        JTextField respuestaIncorrecta3 = new JTextField();
        respuestaIncorrecta3.setName("jLabelIncorrecta3");
        respuestaIncorrecta3.setBackground(new java.awt.Color(0, 0, 0, 1));
        respuestaIncorrecta3.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        respuestaIncorrecta3.setForeground(new java.awt.Color(255, 255, 255));
        respuestaIncorrecta3.setBorder(null);
        respuestaIncorrecta3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        respuestaIncorrecta3.setOpaque(false);
        panelNuevo.add(respuestaIncorrecta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 213, 320, -1));

        //Generamos el fondo del incorrecta 3
        JLabel fondoRespuestaIncorrecta3 = new JLabel();
        fondoRespuestaIncorrecta3.setMaximumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaIncorrecta3.setMinimumSize(new java.awt.Dimension(340, 30));
        fondoRespuestaIncorrecta3.setPreferredSize(new java.awt.Dimension(340, 30));
        Utility.SetImageLabel(fondoRespuestaIncorrecta3, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(340, 30));
        panelNuevo.add(fondoRespuestaIncorrecta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 208, 340, -1));

        //Generamos el fondo de la tarjeta
        JLabel fondoTarjeta12 = new JLabel();
        fondoTarjeta12.setName("fondoTarjeta" + indice);
        fondoTarjeta12.setMaximumSize(new java.awt.Dimension(380, 250));
        fondoTarjeta12.setMinimumSize(new java.awt.Dimension(380, 250));
        fondoTarjeta12.setName(""); // NOI18N
        fondoTarjeta12.setOpaque(false);
        fondoTarjeta12.setPreferredSize(new java.awt.Dimension(380, 250));
        Utility.SetImageLabel(fondoTarjeta12, "src/imagenes/InterfazMobile/Cuadrado_Off.png", new Dimension(380, 250));
        panelNuevo.add(fondoTarjeta12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 250));

        return panelNuevo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();

        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        setMaximumSize(new java.awt.Dimension(430, 2631));
        setMinimumSize(new java.awt.Dimension(430, 788));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(430, 788));

        panelPrincipal.setMaximumSize(new java.awt.Dimension(430, 2700));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(430, 788));
        panelPrincipal.setOpaque(false);
        panelPrincipal.setPreferredSize(new java.awt.Dimension(430, 788));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private Component buscarComponentePorNombre(JPanel panelPrincipal, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
