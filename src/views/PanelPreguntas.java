/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static utility.Sesion.getInstance;
import utility.Utility;


/**
 *
 * @author USER
 */
public class PanelPreguntas extends javax.swing.JPanel {

    private final JPanel[] paneles = new JPanel[getInstance().getCantidadPreguntas()];
    private final JLabel[] botones = new JLabel[getInstance().getCantidadPreguntas()];
    //List<JPanel> preguntas = obtenerPreguntas();
    
    //private final java.util.List<JPanel> paneles = new java.util.ArrayList<>();
    //private final java.util.List<JLabel> botones = new java.util.ArrayList<>();
    
    int cantidadPanelesFront = 0;
    /**
     * Creates new form PanelPreguntas
     */
    public PanelPreguntas() {
        initComponents();
        
        cargarPanelesInicio();
        
        setPreferredSize(new Dimension(430, 788));
        
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
    public void cargarPanelesInicio() {
        for (int i = 0; i < paneles.length; i++) {
            final int indice = i;
            
            
            //Creación del panel con ÍNDICE.
            paneles[indice] = new JPanel(); // Inicializa el JPanel antes de usarlo
            paneles[indice].setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
            paneles[indice].setName("contenedorPregunta"+indice);
            paneles[indice].setMaximumSize(new java.awt.Dimension(410, 250));
            paneles[indice].setMinimumSize(new java.awt.Dimension(410, 250));
            paneles[indice].setPreferredSize(new java.awt.Dimension(410, 250));
            paneles[indice].setOpaque(false);


            //Generar icono eliminar pregunta
            botones[indice] = new JLabel();
            botones[indice].setName("iconoEliminar"+indice);
            botones[indice].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            botones[indice].setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            botones[indice].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            botones[indice].setMaximumSize(new java.awt.Dimension(12, 12));
            botones[indice].setMinimumSize(new java.awt.Dimension(12, 12));
            botones[indice].setPreferredSize(new java.awt.Dimension(12, 12));
            Utility.SetImageLabel(botones[indice], "src/imagenes/InterfazMobile/Menos_Off.png", new Dimension (14,14));
            paneles[indice].add(botones[indice], new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 12, 12));
            // Agregar MouseListener al segundo JLabel
            botones[indice].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Acción al clicar el label2
                    //JOptionPane.showMessageDialog(null, "Has hecho click en el botón del panel " + paneles[indice].getName());
                    eliminarPregunta(paneles[indice].getName());
                }
            });
            
            
            
            
            //Generamos y creamos el JLabel del título de "Pregunta"
            JLabel preguntatxt = new JLabel("Pregunta");
            preguntatxt.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
            preguntatxt.setForeground(new java.awt.Color(255, 255, 255));
            paneles[indice].add(preguntatxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 165, -1));

                    //Generamos y creamos el JTextField de la pregunta
                    JTextField preguntaescribe = new JTextField();
                    preguntaescribe.setName("jLabelPregunta"+indice);
                    preguntaescribe.setBackground(new java.awt.Color(0,0,0,1));
                    preguntaescribe.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    preguntaescribe.setForeground(new java.awt.Color(255, 255, 255));
                    preguntaescribe.setText("¿Cuál de estos animales no es un reptil?");
                    preguntaescribe.setBorder(null);
                    preguntaescribe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                    preguntaescribe.setOpaque(false);
                    paneles[indice].add(preguntaescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 34, 350, -1));

            //Generamos el fondo del JLabel
            JLabel fondoPregunta = new JLabel();
            fondoPregunta.setMaximumSize(new java.awt.Dimension(360, 30));
            fondoPregunta.setMinimumSize(new java.awt.Dimension(360, 30));
            fondoPregunta.setPreferredSize(new java.awt.Dimension(360, 30));
            Utility.SetImageLabel(fondoPregunta, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
            paneles[indice].add(fondoPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 29, 360, -1));
            
            //Generamos y creamos el JLabel del título de "Respuesta correcta"
            JLabel respuestaCorrectaTXT = new JLabel("Respuesta correcta");
            respuestaCorrectaTXT.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
            respuestaCorrectaTXT.setForeground(new java.awt.Color(255, 255, 255));
            paneles[indice].add(respuestaCorrectaTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 165, -1));

                    //Generamos y creamos el JTextField de la respuesta correcta
                    JTextField respuestacorrecta = new JTextField();
                    respuestacorrecta.setName("jLabelCorrecta"+indice);
                    respuestacorrecta.setBackground(new java.awt.Color(0,0,0,1));
                    respuestacorrecta.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestacorrecta.setForeground(new java.awt.Color(255, 255, 255));
                    respuestacorrecta.setText("Respuesta correcta prueba "+indice);
                    respuestacorrecta.setBorder(null);
                    respuestacorrecta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                    respuestacorrecta.setOpaque(false);
                    paneles[indice].add(respuestacorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 84, 350, -1));

            //Generamos el fondo del JLabel
            JLabel fondoRespuestaCorrecta = new JLabel();
            fondoRespuestaCorrecta.setMaximumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaCorrecta.setMinimumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaCorrecta.setPreferredSize(new java.awt.Dimension(360, 30));
            Utility.SetImageLabel(fondoRespuestaCorrecta, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
            paneles[indice].add(fondoRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 79, 360, -1));
            
            //Generamos y creamos el JLabel del título de "Respuestas incorrectas"
            JLabel respuestasIncorrectasTXT = new JLabel("Respuestas incorrectas");
            respuestasIncorrectasTXT.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
            respuestasIncorrectasTXT.setForeground(new java.awt.Color(255, 255, 255));
            paneles[indice].add(respuestasIncorrectasTXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 115, 165, -1));

                    //Generamos y creamos el JTextField de la respuesta incorrecta 1
                    JTextField respuestaIncorrecta1 = new JTextField();
                    respuestaIncorrecta1.setName("jLabelIncorrecta1");
                    respuestaIncorrecta1.setBackground(new java.awt.Color(0,0,0,1));
                    respuestaIncorrecta1.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestaIncorrecta1.setForeground(new java.awt.Color(255, 255, 255));
                    respuestaIncorrecta1.setText("Respuesta incorrecta 1 del "+indice);
                    respuestaIncorrecta1.setBorder(null);
                    respuestaIncorrecta1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                    respuestaIncorrecta1.setOpaque(false);
                    paneles[indice].add(respuestaIncorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 139, 350, -1));

            //Generamos el fondo del incorrecta 1
            JLabel fondoRespuestaIncorrecta1 = new JLabel();
            fondoRespuestaIncorrecta1.setMaximumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaIncorrecta1.setMinimumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaIncorrecta1.setPreferredSize(new java.awt.Dimension(360, 30));
            Utility.SetImageLabel(fondoRespuestaIncorrecta1, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
            paneles[indice].add(fondoRespuestaIncorrecta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 134, 360, -1));

                    //Generamos y creamos el JTextField de la respuesta incorrecta 2
                    JTextField respuestaIncorrecta2 = new JTextField();
                    respuestaIncorrecta2.setName("jLabelIncorrecta2");
                    respuestaIncorrecta2.setBackground(new java.awt.Color(0,0,0,1));
                    respuestaIncorrecta2.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestaIncorrecta2.setForeground(new java.awt.Color(255, 255, 255));
                    respuestaIncorrecta2.setText("Respuesta incorrecta 2 del "+indice);
                    respuestaIncorrecta2.setBorder(null);
                    respuestaIncorrecta2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                    respuestaIncorrecta2.setOpaque(false);
                    paneles[indice].add(respuestaIncorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 176, 350, -1));

            //Generamos el fondo del incorrecta 2
            JLabel fondoRespuestaIncorrecta2 = new JLabel();
            fondoRespuestaIncorrecta2.setMaximumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaIncorrecta2.setMinimumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaIncorrecta2.setPreferredSize(new java.awt.Dimension(360, 30));
            Utility.SetImageLabel(fondoRespuestaIncorrecta2, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
            paneles[indice].add(fondoRespuestaIncorrecta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 171, 360, -1));

                    //Generamos y creamos el JTextField de la respuesta incorrecta 3
                    JTextField respuestaIncorrecta3 = new JTextField();
                    respuestaIncorrecta3.setName("jLabelIncorrecta3");
                    respuestaIncorrecta3.setBackground(new java.awt.Color(0,0,0,1));
                    respuestaIncorrecta3.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
                    respuestaIncorrecta3.setForeground(new java.awt.Color(255, 255, 255));
                    respuestaIncorrecta3.setText("Respuesta incorrecta 3 del "+indice);
                    respuestaIncorrecta3.setBorder(null);
                    respuestaIncorrecta3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                    respuestaIncorrecta3.setOpaque(false);
                    paneles[indice].add(respuestaIncorrecta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 213, 350, -1));

            //Generamos el fondo del incorrecta 3
            JLabel fondoRespuestaIncorrecta3 = new JLabel();
            fondoRespuestaIncorrecta3.setMaximumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaIncorrecta3.setMinimumSize(new java.awt.Dimension(360, 30));
            fondoRespuestaIncorrecta3.setPreferredSize(new java.awt.Dimension(360, 30));
            Utility.SetImageLabel(fondoRespuestaIncorrecta3, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension(360, 30));
            paneles[indice].add(fondoRespuestaIncorrecta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 208, 360, -1));
            
            
            
            
            
            
            
            //Generamos el fondo de la tarjeta
            JLabel fondoTarjeta12 = new JLabel();
            fondoTarjeta12.setName("fondoTarjeta"+indice);
            fondoTarjeta12.setMaximumSize(new java.awt.Dimension(410, 250));
            fondoTarjeta12.setMinimumSize(new java.awt.Dimension(410, 250));
            fondoTarjeta12.setName(""); // NOI18N
            fondoTarjeta12.setOpaque(false);
            fondoTarjeta12.setPreferredSize(new java.awt.Dimension(410, 250));
            Utility.SetImageLabel(fondoTarjeta12, "src/imagenes/InterfazMobile/Cuadrado_Off.png", new Dimension(410, 250));
            

            // Agregar componentes al panel
            paneles[indice].add(fondoTarjeta12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 250));
            cantidadPanelesFront++;
        }

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
                return; // Terminamos el método luego de eliminar el panel
            }
        }
        // Si llegamos aquí, significa que no se encontró ningún panel con el nombre especificado
        System.out.println("No se encontró ningún panel con el nombre: " + nombre);
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
        setMaximumSize(new java.awt.Dimension(430, 788));
        setMinimumSize(new java.awt.Dimension(430, 788));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(430, 788));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setMaximumSize(new java.awt.Dimension(430, 788));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(430, 788));
        panelPrincipal.setOpaque(false);
        panelPrincipal.setPreferredSize(new java.awt.Dimension(430, 788));
        add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -2, 410, 790));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables

    private Component buscarComponentePorNombre(JPanel panelPrincipal, String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
