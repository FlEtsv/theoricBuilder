/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.opencsv.exceptions.CsvValidationException;
import db.Pregunta;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    
    //List<JPanel> preguntas = obtenerPreguntas();
    
    //private final java.util.List<JPanel> paneles = new java.util.ArrayList<>();
    //private final java.util.List<JLabel> botones = new java.util.ArrayList<>();
    
    int cantidadPanelesFront = 0;
    /**
     * Creates new form PanelPreguntas
     */
    
    public PanelPreguntas() {
        initComponents();
        panelPrincipal.addContainerListener(new ContainerHandler());
        
        /*
        try {
            List<Pregunta> preguntas = getInstance().obtenerDatos();
        } catch (CsvValidationException e) {
            System.err.println("Error de validación CSV: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de I/O: " + e.getMessage());
        }
        */
        
        
       panelPrincipal.add(new VistaSelectorSimulador(this));
        
            
        /*Ubicar y adaptar fondo de cada tarjeta de pregunta y respuestas.
        Utility.SetImageLabel(fondoTarjeta, "src/imagenes/InterfazMobile/Cuadrado_Off.png", new Dimension(410, 250));
        Utility.SetImageLabel(fondoTxtField1, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField2, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField3, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField4, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField5, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(iconoEliminar, "src/imagenes/InterfazMobile/Menos_Off.png", new Dimension (14,14));
        */
    }
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
                if(contadorComponentes < 4){
                    y += maxHeight + 20;
                } else if(contadorComponentes <= 7){
                    y += maxHeight + 17;
                } else {
                    y += maxHeight + 4;
                }
                maxHeight = 0;
            }
            x += compPrefSize.width;
            maxHeight = Math.max(maxHeight, compPrefSize.height);
            contadorComponentes+=1;
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
        System.out.println(newSize); // Debugging
        this.revalidate();
        this.repaint();
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    
    public void CambioSize(Dimension nuevaDimension){
        panelPrincipal.getComponent(0).setPreferredSize(nuevaDimension);
        ajustarTamaño();
        panelPrincipal.revalidate();
        panelPrincipal.repaint();
    }
    
    public void setPaneles(List<JPanel> paneles){
        this.paneles = paneles;
    }
    
    public void setBotones(List<JLabel> botones){
        this.botones = botones;
    }
    
    public void crearPanelNuevo() {
        
            final int indice = cantidadPanelesFront;
            
            //Creación del panel con ÍNDICE.
            JPanel panelNuevo = new JPanel(); // Inicializa el JPanel antes de usarlo
            panelNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            panelNuevo.setName("contenedorPregunta"+indice);
            panelNuevo.setMaximumSize(new java.awt.Dimension(380, 250));
            panelNuevo.setMinimumSize(new java.awt.Dimension(380, 250));
            panelNuevo.setPreferredSize(new java.awt.Dimension(380, 250));
            panelNuevo.setOpaque(false);
            


            //Generar icono eliminar pregunta
            JLabel botonNuevo = new JLabel();
            botonNuevo.setName("iconoEliminar"+indice);
            botonNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            botonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            botonNuevo.setMaximumSize(new java.awt.Dimension(12, 12));
            botonNuevo.setMinimumSize(new java.awt.Dimension(12, 12));
            botonNuevo.setPreferredSize(new java.awt.Dimension(12, 12));
            Utility.SetImageLabel(botonNuevo, "src/imagenes/InterfazMobile/Menos_Off.png", new Dimension (14,14));
            panelNuevo.add(botonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 12, 12));
            // Agregar MouseListener al segundo JLabel
            botonNuevo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Acción al clicar el label2
                    //JOptionPane.showMessageDialog(null, "Has hecho click en el botón del panel " + paneles[indice].getName());
                    eliminarPregunta(panelNuevo.getName());
                    Sesion.getInstance().setBlanco("Pregunta elimidada (quedan " + (Sesion.getInstance().getCantidadcomponentes()-1) + ")");
                }
            });
            
            
            
            
            //Generamos y creamos el JLabel del título de "Pregunta"
            JLabel preguntatxt = new JLabel("Pregunta");
            preguntatxt.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
            preguntatxt.setForeground(new java.awt.Color(255, 255, 255));
            panelNuevo.add(preguntatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

                    //Generamos y creamos el JTextField de la pregunta
                    JTextField preguntaescribe = new JTextField();
                    preguntaescribe.setName("jLabelPregunta"+indice);
                    preguntaescribe.setBackground(new java.awt.Color(0,0,0,1));
                    preguntaescribe.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    preguntaescribe.setForeground(new java.awt.Color(255, 255, 255));
                    preguntaescribe.setText("");
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
                    respuestacorrecta.setName("jLabelCorrecta"+indice);
                    respuestacorrecta.setBackground(new java.awt.Color(0,0,0,1));
                    respuestacorrecta.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestacorrecta.setForeground(new java.awt.Color(255, 255, 255));
                    respuestacorrecta.setText("");
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
                    respuestaIncorrecta1.setBackground(new java.awt.Color(0,0,0,1));
                    respuestaIncorrecta1.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestaIncorrecta1.setForeground(new java.awt.Color(255, 255, 255));
                    respuestaIncorrecta1.setText("");
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
                    respuestaIncorrecta2.setBackground(new java.awt.Color(0,0,0,1));
                    respuestaIncorrecta2.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestaIncorrecta2.setForeground(new java.awt.Color(255, 255, 255));
                    respuestaIncorrecta2.setText("");
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
                    respuestaIncorrecta3.setBackground(new java.awt.Color(0,0,0,1));
                    respuestaIncorrecta3.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestaIncorrecta3.setForeground(new java.awt.Color(255, 255, 255));
                    respuestaIncorrecta3.setText("");
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
            fondoTarjeta12.setName("fondoTarjeta"+indice);
            fondoTarjeta12.setMaximumSize(new java.awt.Dimension(380, 250));
            fondoTarjeta12.setMinimumSize(new java.awt.Dimension(380, 250));
            fondoTarjeta12.setName(""); // NOI18N
            fondoTarjeta12.setOpaque(false);
            fondoTarjeta12.setPreferredSize(new java.awt.Dimension(380, 250));
            Utility.SetImageLabel(fondoTarjeta12, "src/imagenes/InterfazMobile/Cuadrado_Off.png", new Dimension(380, 250));
            panelNuevo.add(fondoTarjeta12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 250));


            // Agregar componentes al panel
            paneles.add(panelNuevo);
            panelPrincipal.add(panelNuevo);
            cantidadPanelesFront++;
            Sesion.getInstance().setBlanco("Pregunta añadida (actualmente " + (Sesion.getInstance().getCantidadcomponentes()-1) + ")");
    }
    
    public void cargarPanelesInicio() {
        for (int i = 0; i < Sesion.getInstance().getCantidadPreguntas(); i++) {
            final int indice = i;
            
            //Creación del panel con ÍNDICE.
            JPanel panelNuevo = new JPanel(); // Inicializa el JPanel antes de usarlo
            panelNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            panelNuevo.setName("contenedorPregunta"+indice);
            panelNuevo.setMaximumSize(new java.awt.Dimension(380, 250));
            panelNuevo.setMinimumSize(new java.awt.Dimension(380, 250));
            panelNuevo.setPreferredSize(new java.awt.Dimension(380, 250));
            panelNuevo.setOpaque(false);
            


            //Generar icono eliminar pregunta
            JLabel botonNuevo = new JLabel();
            botonNuevo.setName("iconoEliminar"+indice);
            botonNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            botonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            botonNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            botonNuevo.setMaximumSize(new java.awt.Dimension(12, 12));
            botonNuevo.setMinimumSize(new java.awt.Dimension(12, 12));
            botonNuevo.setPreferredSize(new java.awt.Dimension(12, 12));
            Utility.SetImageLabel(botonNuevo, "src/imagenes/InterfazMobile/Menos_Off.png", new Dimension (14,14));
            panelNuevo.add(botonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 12, 12));
            // Agregar MouseListener al segundo JLabel
            botonNuevo.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Acción al clicar el label2
                    //JOptionPane.showMessageDialog(null, "Has hecho click en el botón del panel " + paneles[indice].getName());
                    eliminarPregunta(panelNuevo.getName());
                    Sesion.getInstance().setBlanco("Pregunta elimidada (quedan " + (Sesion.getInstance().getCantidadcomponentes()-1) + ")");
                }
            });
            
            
            
            
            //Generamos y creamos el JLabel del título de "Pregunta"
            JLabel preguntatxt = new JLabel("Pregunta");
            preguntatxt.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
            preguntatxt.setForeground(new java.awt.Color(255, 255, 255));
            panelNuevo.add(preguntatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, -1));

                    //Generamos y creamos el JTextField de la pregunta
                    JTextField preguntaescribe = new JTextField();
                    preguntaescribe.setName("jLabelPregunta"+indice);
                    preguntaescribe.setBackground(new java.awt.Color(0,0,0,1));
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
                    respuestacorrecta.setName("jLabelCorrecta"+indice);
                    respuestacorrecta.setBackground(new java.awt.Color(0,0,0,1));
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
                    respuestaIncorrecta1.setBackground(new java.awt.Color(0,0,0,1));
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
                    respuestaIncorrecta2.setBackground(new java.awt.Color(0,0,0,1));
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
                    respuestaIncorrecta3.setBackground(new java.awt.Color(0,0,0,1));
                    respuestaIncorrecta3.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestaIncorrecta3.setForeground(new java.awt.Color(255, 255, 255));                    respuestaIncorrecta3.setBorder(null);
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
            fondoTarjeta12.setName("fondoTarjeta"+indice);
            fondoTarjeta12.setMaximumSize(new java.awt.Dimension(380, 250));
            fondoTarjeta12.setMinimumSize(new java.awt.Dimension(380, 250));
            fondoTarjeta12.setName(""); // NOI18N
            fondoTarjeta12.setOpaque(false);
            fondoTarjeta12.setPreferredSize(new java.awt.Dimension(380, 250));
            Utility.SetImageLabel(fondoTarjeta12, "src/imagenes/InterfazMobile/Cuadrado_Off.png", new Dimension(380, 250));
            panelNuevo.add(fondoTarjeta12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 250));

            paneles.add(panelNuevo);
            cantidadPanelesFront++;
            System.out.println("creado panel con indice: " + indice);
        }

        List<Pregunta> preguntasLista = List.of();
        try{
            preguntasLista = getInstance().obtenerDatos();
        } catch(CsvValidationException | IOException e){
            // TODO menajar el posible error
        }
        getInstance().actualizarPreguntasEnPaneles(paneles, preguntasLista, paneles.size());
        
        for (JPanel panel : paneles) {
            panelPrincipal.add(panel);
            panelPrincipal.revalidate();
        }
    }
    public void eliminarPregunta(String nombre) {
        Component[] componentes = panelPrincipal.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JPanel && nombre.equals(componente.getName())) {
                panelPrincipal.remove(componente);
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                System.out.println("Eliminando el panel: " + nombre);
                return;
            }
        }
        System.out.println("No se encontró ningún panel con el nombre: " + nombre);
    }
    
    public void eliminarTodasPreguntas(){
        paneles.clear();
        Component[] componentes = panelPrincipal.getComponents();
        if (componentes.length > 1 && componentes[0] instanceof VistaSelectorSimulador){
            for (int i = 1; i < componentes.length; i++) {
                if (componentes[i] instanceof JPanel) {
                    panelPrincipal.remove(componentes[i]);
                    panelPrincipal.revalidate();
                    panelPrincipal.repaint();
                }
            }
        }
    }
    
    /*
    CÓDIGO ANTERIOR
    public void agregarNuevoPanel() {
        JPanel nuevoPanel = new JPanel();
        nuevoPanel.setLayout(new AbsoluteLayout());
        nuevoPanel.setName("contenedorPregunta"+cantidadPaneles);
        nuevoPanel.setMaximumSize(new java.awt.Dimension(410, 250));
        nuevoPanel.setMinimumSize(new java.awt.Dimension(410, 250));
        nuevoPanel.setPreferredSize(new java.awt.Dimension(410, 250));
        nuevoPanel.setOpaque(false);
        
        //Generamos y creamos el JLabel del título de "Pregunta"
        JLabel preguntatxt = new JLabel("Pregunta "+cantidadPaneles);
        preguntatxt.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        preguntatxt.setForeground(new java.awt.Color(255, 255, 255));
        nuevoPanel.add(preguntatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 165, -1));

                //Generamos y creamos el JTextField de la pregunta
                JTextField preguntaescribe = new JTextField();
                preguntaescribe.setName("jLabelPregunta"+cantidadPaneles);
                preguntaescribe.setBackground(new java.awt.Color(0,0,0,1));
                preguntaescribe.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                preguntaescribe.setForeground(new java.awt.Color(255, 255, 255));
                preguntaescribe.setText("¿Cuál de estos animales no es un reptil?");
                preguntaescribe.setBorder(null);
                preguntaescribe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                preguntaescribe.setOpaque(false);
                nuevoPanel.add(preguntaescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 34, 350, -1));
        
        //Generamos el fondo del JLabel
        JLabel fondoPregunta = new JLabel();
        fondoPregunta.setMaximumSize(new java.awt.Dimension(360, 30));
        fondoPregunta.setMinimumSize(new java.awt.Dimension(360, 30));
        fondoPregunta.setPreferredSize(new java.awt.Dimension(360, 30));
        Utility.SetImageLabel(fondoPregunta, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
        nuevoPanel.add(fondoPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 29, 360, -1));
        
        
        
        
        
        //Generamos y creamos el JLabel del título de "Respuesta correcta"
        JLabel respuestaCorrectaTXT = new JLabel("Respuesta correcta "+cantidadPaneles);
        respuestaCorrectaTXT.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        respuestaCorrectaTXT.setForeground(new java.awt.Color(255, 255, 255));
        nuevoPanel.add(respuestaCorrectaTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 165, -1));

                //Generamos y creamos el JTextField de la respuesta correcta
                JTextField respuestacorrecta = new JTextField();
                respuestacorrecta.setName("jLabelCorrecta"+cantidadPaneles);
                respuestacorrecta.setBackground(new java.awt.Color(0,0,0,1));
                respuestacorrecta.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                respuestacorrecta.setForeground(new java.awt.Color(255, 255, 255));
                respuestacorrecta.setText("Respuesta correcta");
                respuestacorrecta.setBorder(null);
                respuestacorrecta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                respuestacorrecta.setOpaque(false);
                nuevoPanel.add(respuestacorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 84, 350, -1));
        
        //Generamos el fondo del JLabel
        JLabel fondoRespuestaCorrecta = new JLabel();
        fondoRespuestaCorrecta.setMaximumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaCorrecta.setMinimumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaCorrecta.setPreferredSize(new java.awt.Dimension(360, 30));
        Utility.SetImageLabel(fondoRespuestaCorrecta, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
        nuevoPanel.add(fondoRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 79, 360, -1));
        
        
        
        
        
        //Generamos y creamos el JLabel del título de "Respuestas incorrectas"
        JLabel respuestasIncorrectasTXT = new JLabel("Respuestas incorrectas "+cantidadPaneles);
        respuestasIncorrectasTXT.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        respuestasIncorrectasTXT.setForeground(new java.awt.Color(255, 255, 255));
        nuevoPanel.add(respuestasIncorrectasTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 115, 165, -1));
        
                //Generamos y creamos el JTextField de la respuesta incorrecta 1
                JTextField respuestaIncorrecta1 = new JTextField();
                respuestaIncorrecta1.setName("jLabelIncorrecta1");
                respuestaIncorrecta1.setBackground(new java.awt.Color(0,0,0,1));
                respuestaIncorrecta1.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                respuestaIncorrecta1.setForeground(new java.awt.Color(255, 255, 255));
                respuestaIncorrecta1.setText("Respuesta incorrecta 1 del "+cantidadPaneles);
                respuestaIncorrecta1.setBorder(null);
                respuestaIncorrecta1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                respuestaIncorrecta1.setOpaque(false);
                nuevoPanel.add(respuestaIncorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 139, 350, -1));
        
        //Generamos el fondo del incorrecta 1
        JLabel fondoRespuestaIncorrecta1 = new JLabel();
        fondoRespuestaIncorrecta1.setMaximumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaIncorrecta1.setMinimumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaIncorrecta1.setPreferredSize(new java.awt.Dimension(360, 30));
        Utility.SetImageLabel(fondoRespuestaIncorrecta1, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
        nuevoPanel.add(fondoRespuestaIncorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 134, 360, -1));
        
                //Generamos y creamos el JTextField de la respuesta incorrecta 2
                JTextField respuestaIncorrecta2 = new JTextField();
                respuestaIncorrecta2.setName("jLabelIncorrecta2");
                respuestaIncorrecta2.setBackground(new java.awt.Color(0,0,0,1));
                respuestaIncorrecta2.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                respuestaIncorrecta2.setForeground(new java.awt.Color(255, 255, 255));
                respuestaIncorrecta2.setText("Respuesta incorrecta 2 del "+cantidadPaneles);
                respuestaIncorrecta2.setBorder(null);
                respuestaIncorrecta2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                respuestaIncorrecta2.setOpaque(false);
                nuevoPanel.add(respuestaIncorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, 350, -1));
        
        //Generamos el fondo del incorrecta 2
        JLabel fondoRespuestaIncorrecta2 = new JLabel();
        fondoRespuestaIncorrecta2.setMaximumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaIncorrecta2.setMinimumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaIncorrecta2.setPreferredSize(new java.awt.Dimension(360, 30));
        Utility.SetImageLabel(fondoRespuestaIncorrecta2, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
        nuevoPanel.add(fondoRespuestaIncorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 171, 360, -1));
        
                //Generamos y creamos el JTextField de la respuesta incorrecta 3
                JTextField respuestaIncorrecta3 = new JTextField();
                respuestaIncorrecta3.setName("jLabelIncorrecta3");
                respuestaIncorrecta3.setBackground(new java.awt.Color(0,0,0,1));
                respuestaIncorrecta3.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                respuestaIncorrecta3.setForeground(new java.awt.Color(255, 255, 255));
                respuestaIncorrecta3.setText("Respuesta incorrecta 3 del "+cantidadPaneles);
                respuestaIncorrecta3.setBorder(null);
                respuestaIncorrecta3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                respuestaIncorrecta3.setOpaque(false);
                nuevoPanel.add(respuestaIncorrecta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 213, 350, -1));
        
        //Generamos el fondo del incorrecta 3
        JLabel fondoRespuestaIncorrecta3 = new JLabel();
        fondoRespuestaIncorrecta3.setMaximumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaIncorrecta3.setMinimumSize(new java.awt.Dimension(360, 30));
        fondoRespuestaIncorrecta3.setPreferredSize(new java.awt.Dimension(360, 30));
        Utility.SetImageLabel(fondoRespuestaIncorrecta3, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
        nuevoPanel.add(fondoRespuestaIncorrecta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 208, 360, -1));
        
        
        //Generar icono eliminar pregunta
        JLabel iconoEliminarRespuesta = new JLabel();
        iconoEliminarRespuesta.setName("iconoEliminar"+cantidadPaneles);
        iconoEliminarRespuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoEliminarRespuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconoEliminarRespuesta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconoEliminarRespuesta.setMaximumSize(new java.awt.Dimension(12, 12));
        iconoEliminarRespuesta.setMinimumSize(new java.awt.Dimension(12, 12));
        iconoEliminarRespuesta.setPreferredSize(new java.awt.Dimension(12, 12));
        /*
        iconoEliminarRespuesta.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarPregunta(cantidadPaneles);
            }
        });
        */
        /*
        Utility.SetImageLabel(iconoEliminarRespuesta, "src/imagenes/InterfazMobile/Menos_Off.png", new Dimension (14,14));
        nuevoPanel.add(iconoEliminarRespuesta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 12, 12));
        
        
        //Generamos el fondo de la tarjeta
        JLabel fondoTarjeta12 = new JLabel();
        fondoTarjeta12.setName("fondoTarjeta"+cantidadPaneles);
        fondoTarjeta12.setMaximumSize(new java.awt.Dimension(410, 250));
        fondoTarjeta12.setMinimumSize(new java.awt.Dimension(410, 250));
        fondoTarjeta12.setName(""); // NOI18N
        fondoTarjeta12.setOpaque(false);
        fondoTarjeta12.setPreferredSize(new java.awt.Dimension(410, 250));
        Utility.SetImageLabel(fondoTarjeta12, "src/imagenes/InterfazMobile/Cuadrado_Off.png", new Dimension(410, 250));
        
        nuevoPanel.add(fondoTarjeta12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 250));

        
        
        panelPrincipal.add(nuevoPanel);
        panelPrincipal.revalidate();
        
        System.out.println("Recibido"+cantidadPaneles);
        cantidadPaneles ++;
    // Si deseas agregar el nuevoPanel a otro contenedor, descomenta las líneas siguientes
    // jPanel1.add(nuevoPanel);
    // jPanel1.revalidate();
    // jPanel1.repaint();
    }*/
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
