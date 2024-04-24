/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.view;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteLayout;
import utility.Utility;

/**
 *
 * @author USER
 */
public class PanelPreguntas extends javax.swing.JPanel {

    
    int cantidadPaneles = 1;
    /**
     * Creates new form PanelPreguntas
     */
    public PanelPreguntas() {
        initComponents();
        
        setPreferredSize(new Dimension(430, 788));
        
        //Ubicar y adaptar fondo de cada tarjeta de pregunta y respuestas.
        Utility.SetImageLabel(fondoTarjeta, "src/imagenes/InterfazMobile/Cuadrado_Off.png", new Dimension(410, 250));
        Utility.SetImageLabel(fondoTxtField1, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField2, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField3, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField4, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(fondoTxtField5, "src/imagenes/InterfazMobile/Panel_Info.png", new Dimension (360,30));
        Utility.SetImageLabel(iconoEliminar, "src/imagenes/InterfazMobile/Menos_Off.png", new Dimension (14,14));
    }
    
    public void agregarNuevoPanel() {
        cantidadPaneles ++;
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
        iconoEliminarRespuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoEliminarRespuesta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconoEliminarRespuesta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconoEliminarRespuesta.setMaximumSize(new java.awt.Dimension(12, 12));
        iconoEliminarRespuesta.setMinimumSize(new java.awt.Dimension(12, 12));
        iconoEliminarRespuesta.setPreferredSize(new java.awt.Dimension(12, 12));
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
        
        System.out.print("Recibido"+cantidadPaneles);
    // Si deseas agregar el nuevoPanel a otro contenedor, descomenta las líneas siguientes
    // jPanel1.add(nuevoPanel);
    // jPanel1.revalidate();
    // jPanel1.repaint();
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
        contenedorPregunta1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelPregunta = new javax.swing.JPanel();
        txtPregunta = new javax.swing.JTextField();
        fondoTxtField1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRespuestaCorrecta = new javax.swing.JPanel();
        txtRespuestaCorrecta = new javax.swing.JTextField();
        fondoTxtField2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRespuestasIncorrectas = new javax.swing.JPanel();
        panelRespuestasIncorrectas1 = new javax.swing.JPanel();
        txtRespuestaInc1 = new javax.swing.JTextField();
        fondoTxtField3 = new javax.swing.JLabel();
        panelRespuestasIncorrectas2 = new javax.swing.JPanel();
        txtRespuestaInc2 = new javax.swing.JTextField();
        fondoTxtField4 = new javax.swing.JLabel();
        panelRespuestasIncorrectas3 = new javax.swing.JPanel();
        txtRespuestaInc3 = new javax.swing.JTextField();
        fondoTxtField5 = new javax.swing.JLabel();
        iconoEliminar = new javax.swing.JLabel();
        fondoTarjeta = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

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

        contenedorPregunta1.setMaximumSize(new java.awt.Dimension(430, 250));
        contenedorPregunta1.setMinimumSize(new java.awt.Dimension(430, 250));
        contenedorPregunta1.setOpaque(false);
        contenedorPregunta1.setPreferredSize(new java.awt.Dimension(430, 250));
        contenedorPregunta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pregunta");
        contenedorPregunta1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 170, -1));

        panelPregunta.setMaximumSize(new java.awt.Dimension(360, 30));
        panelPregunta.setMinimumSize(new java.awt.Dimension(360, 30));
        panelPregunta.setOpaque(false);
        panelPregunta.setPreferredSize(new java.awt.Dimension(360, 30));
        panelPregunta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPregunta.setBackground(new java.awt.Color(0,0,0,1));
        txtPregunta.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        txtPregunta.setForeground(new java.awt.Color(255, 255, 255));
        txtPregunta.setText("¿Cuál de estos animales no es un reptil?");
        txtPregunta.setBorder(null);
        txtPregunta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPregunta.setOpaque(false);
        txtPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPreguntaActionPerformed(evt);
            }
        });
        panelPregunta.add(txtPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 20));

        fondoTxtField1.setMaximumSize(new java.awt.Dimension(360, 40));
        fondoTxtField1.setMinimumSize(new java.awt.Dimension(360, 40));
        fondoTxtField1.setPreferredSize(new java.awt.Dimension(360, 40));
        panelPregunta.add(fondoTxtField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        contenedorPregunta1.add(panelPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 22, 360, 40));

        jLabel2.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Respuesta correcta");
        contenedorPregunta1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 62, 165, -1));

        panelRespuestaCorrecta.setMaximumSize(new java.awt.Dimension(360, 30));
        panelRespuestaCorrecta.setMinimumSize(new java.awt.Dimension(360, 30));
        panelRespuestaCorrecta.setOpaque(false);
        panelRespuestaCorrecta.setPreferredSize(new java.awt.Dimension(360, 30));
        panelRespuestaCorrecta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRespuestaCorrecta.setBackground(new java.awt.Color(0,0,0,1));
        txtRespuestaCorrecta.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        txtRespuestaCorrecta.setForeground(new java.awt.Color(255, 255, 255));
        txtRespuestaCorrecta.setText("Salamandra");
        txtRespuestaCorrecta.setBorder(null);
        txtRespuestaCorrecta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRespuestaCorrecta.setOpaque(false);
        txtRespuestaCorrecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuestaCorrectaActionPerformed(evt);
            }
        });
        panelRespuestaCorrecta.add(txtRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 20));

        fondoTxtField2.setMaximumSize(new java.awt.Dimension(360, 40));
        fondoTxtField2.setMinimumSize(new java.awt.Dimension(360, 40));
        fondoTxtField2.setPreferredSize(new java.awt.Dimension(360, 40));
        panelRespuestaCorrecta.add(fondoTxtField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        contenedorPregunta1.add(panelRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 77, 360, 40));

        jLabel3.setFont(new java.awt.Font("Raleway Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Respuestas incorrectas");
        contenedorPregunta1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 114, 165, -1));

        panelRespuestasIncorrectas.setMaximumSize(new java.awt.Dimension(360, 92));
        panelRespuestasIncorrectas.setMinimumSize(new java.awt.Dimension(360, 92));
        panelRespuestasIncorrectas.setOpaque(false);
        panelRespuestasIncorrectas.setPreferredSize(new java.awt.Dimension(360, 100));
        panelRespuestasIncorrectas.setLayout(new java.awt.GridLayout(0, 1, 0, 1));

        panelRespuestasIncorrectas1.setMaximumSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas1.setMinimumSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas1.setOpaque(false);
        panelRespuestasIncorrectas1.setPreferredSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRespuestaInc1.setBackground(new java.awt.Color(0,0,0,1));
        txtRespuestaInc1.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        txtRespuestaInc1.setForeground(new java.awt.Color(255, 255, 255));
        txtRespuestaInc1.setText("Gecko");
        txtRespuestaInc1.setBorder(null);
        txtRespuestaInc1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRespuestaInc1.setOpaque(false);
        txtRespuestaInc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuestaInc1ActionPerformed(evt);
            }
        });
        panelRespuestasIncorrectas1.add(txtRespuestaInc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 20));

        fondoTxtField3.setMaximumSize(new java.awt.Dimension(360, 40));
        fondoTxtField3.setMinimumSize(new java.awt.Dimension(360, 40));
        fondoTxtField3.setPreferredSize(new java.awt.Dimension(360, 40));
        panelRespuestasIncorrectas1.add(fondoTxtField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        panelRespuestasIncorrectas.add(panelRespuestasIncorrectas1);

        panelRespuestasIncorrectas2.setMaximumSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas2.setMinimumSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas2.setOpaque(false);
        panelRespuestasIncorrectas2.setPreferredSize(new java.awt.Dimension(360, 370));
        panelRespuestasIncorrectas2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRespuestaInc2.setBackground(new java.awt.Color(0,0,0,1));
        txtRespuestaInc2.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        txtRespuestaInc2.setForeground(new java.awt.Color(255, 255, 255));
        txtRespuestaInc2.setText("Iguana");
        txtRespuestaInc2.setBorder(null);
        txtRespuestaInc2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRespuestaInc2.setOpaque(false);
        txtRespuestaInc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuestaInc2ActionPerformed(evt);
            }
        });
        panelRespuestasIncorrectas2.add(txtRespuestaInc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 20));

        fondoTxtField4.setMaximumSize(new java.awt.Dimension(360, 40));
        fondoTxtField4.setMinimumSize(new java.awt.Dimension(360, 40));
        fondoTxtField4.setPreferredSize(new java.awt.Dimension(360, 40));
        panelRespuestasIncorrectas2.add(fondoTxtField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        panelRespuestasIncorrectas.add(panelRespuestasIncorrectas2);

        panelRespuestasIncorrectas3.setMaximumSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas3.setMinimumSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas3.setOpaque(false);
        panelRespuestasIncorrectas3.setPreferredSize(new java.awt.Dimension(360, 30));
        panelRespuestasIncorrectas3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRespuestaInc3.setBackground(new java.awt.Color(0,0,0,1));
        txtRespuestaInc3.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        txtRespuestaInc3.setForeground(new java.awt.Color(255, 255, 255));
        txtRespuestaInc3.setText("Varano");
        txtRespuestaInc3.setBorder(null);
        txtRespuestaInc3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtRespuestaInc3.setOpaque(false);
        txtRespuestaInc3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRespuestaInc3ActionPerformed(evt);
            }
        });
        panelRespuestasIncorrectas3.add(txtRespuestaInc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 20));

        fondoTxtField5.setMaximumSize(new java.awt.Dimension(360, 40));
        fondoTxtField5.setMinimumSize(new java.awt.Dimension(360, 40));
        fondoTxtField5.setPreferredSize(new java.awt.Dimension(360, 40));
        panelRespuestasIncorrectas3.add(fondoTxtField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        panelRespuestasIncorrectas.add(panelRespuestasIncorrectas3);

        contenedorPregunta1.add(panelRespuestasIncorrectas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 127, 360, 110));

        iconoEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconoEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconoEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        iconoEliminar.setMaximumSize(new java.awt.Dimension(12, 12));
        iconoEliminar.setMinimumSize(new java.awt.Dimension(12, 12));
        iconoEliminar.setPreferredSize(new java.awt.Dimension(12, 12));
        contenedorPregunta1.add(iconoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 12, 12));

        fondoTarjeta.setMaximumSize(new java.awt.Dimension(430, 250));
        fondoTarjeta.setMinimumSize(new java.awt.Dimension(430, 250));
        fondoTarjeta.setName(""); // NOI18N
        fondoTarjeta.setPreferredSize(new java.awt.Dimension(430, 250));
        contenedorPregunta1.add(fondoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 410, 250));

        panelPrincipal.add(contenedorPregunta1);

        add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 88, 410, 700));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("jLabel4");
        jLabel4.setOpaque(true);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 390, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void txtPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPreguntaActionPerformed

    private void txtRespuestaCorrectaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuestaCorrectaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespuestaCorrectaActionPerformed

    private void txtRespuestaInc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuestaInc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespuestaInc1ActionPerformed

    private void txtRespuestaInc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuestaInc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespuestaInc2ActionPerformed

    private void txtRespuestaInc3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRespuestaInc3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRespuestaInc3ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        agregarNuevoPanel();
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorPregunta1;
    private javax.swing.JLabel fondoTarjeta;
    private javax.swing.JLabel fondoTxtField1;
    private javax.swing.JLabel fondoTxtField2;
    private javax.swing.JLabel fondoTxtField3;
    private javax.swing.JLabel fondoTxtField4;
    private javax.swing.JLabel fondoTxtField5;
    private javax.swing.JLabel iconoEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelPregunta;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRespuestaCorrecta;
    private javax.swing.JPanel panelRespuestasIncorrectas;
    private javax.swing.JPanel panelRespuestasIncorrectas1;
    private javax.swing.JPanel panelRespuestasIncorrectas2;
    private javax.swing.JPanel panelRespuestasIncorrectas3;
    private javax.swing.JTextField txtPregunta;
    private javax.swing.JTextField txtRespuestaCorrecta;
    private javax.swing.JTextField txtRespuestaInc1;
    private javax.swing.JTextField txtRespuestaInc2;
    private javax.swing.JTextField txtRespuestaInc3;
    // End of variables declaration//GEN-END:variables
}
