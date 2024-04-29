/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import com.opencsv.exceptions.CsvValidationException;
import db.Pregunta;
import java.awt.Dimension;
import java.io.IOException;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import utility.Sesion;
import static utility.Sesion.getInstance;
import static utility.theUltimateUtility.sumaDimension;
import static utility.theUltimateUtility.setImageLabel;
import views.PanelPreguntas;

/**
 * Esta clase extiende JPanel para crear un panel personalizado para seleccionar un simulador.
 * Incluye un desplegable para la selección del simulador, un botón para añadir preguntas y un botón de información.
 * El panel también incluye un panel de información que puede ser visible o invisible.
 *
 * @author Fishb0ness
 */
public class VistaSelectorSimulador extends javax.swing.JPanel {

    // Dimensiones para varios componentes en el panel
    private final Dimension selectorDimension = new Dimension(380, 46);
    private final Dimension iconButtonDimension = new Dimension(25, 25);
    private final Dimension infoPanelDimension = new Dimension(380, 95);
    private Dimension contenedorDimension = new Dimension(380, 130);
    private PanelPreguntas instanciaPanelPreguntas;
    
    
    /**
     * Constructor para la clase VistaSelectorSimulador.
     * Inicializa los componentes y configura el estado inicial del panel.
     */
    public VistaSelectorSimulador(PanelPreguntas instanciaPanelPreguntas) {
        this.instanciaPanelPreguntas = instanciaPanelPreguntas;
        initComponents();
        
        // Inicia el panel de lista como no visible
        listaSimuladoresPanel.setVisible(false);

        // Establece la imagen del desplegable del selector de simuladores
        setImageLabel(selectorSimuladoresImg, "src/imagenes/InterfazMobile/Desplegable_Off.png", selectorDimension);

        // Establece los iconos de añadir pregunta y de información sobre el simulador
        setImageLabel(anadirPreguntaButton, "src/imagenes/InterfazMobile/Mas_Off.png", iconButtonDimension);
        setImageLabel(simuladorInfoButton, "src/imagenes/InterfazMobile/info_Off.png", iconButtonDimension);

        // Establece el panel de información como invisible y establece la imagen de fondo
        infoPanel.setVisible(false);
        setImageLabel(infoBackImg, "src/imagenes/InterfazMobile/Panel_Info.png", infoPanelDimension);

        // Establece el tamaño del contenedor
        this.setSize(contenedorDimension);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoSimuladorPanel = new javax.swing.JPanel();
        tipoSimuladorLabel = new javax.swing.JLabel();
        selectorPanel = new javax.swing.JPanel();
        selectorSimuladoresTxt = new javax.swing.JLabel();
        selectorSimuladoresImg = new javax.swing.JLabel();
        listaSimuladoresPanel = new RoundedPanel(25);
        simuladorLabel0 = new javax.swing.JLabel();
        simuladorLabel1 = new javax.swing.JLabel();
        simuladorLabel2 = new javax.swing.JLabel();
        simuladorLabel3 = new javax.swing.JLabel();
        simuladorLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        textAnadirPregunta = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        anadirPreguntaButton = new javax.swing.JLabel();
        simuladorInfoButton = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        infoText = new javax.swing.JLabel();
        infoBackImg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(10, 38, 72));
        setMinimumSize(new java.awt.Dimension(430, 0));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(430, 129));

        tipoSimuladorPanel.setMinimumSize(new java.awt.Dimension(380, 25));
        tipoSimuladorPanel.setOpaque(false);
        tipoSimuladorPanel.setPreferredSize(new java.awt.Dimension(380, 30));

        tipoSimuladorLabel.setFont(new java.awt.Font("Raleway Medium", 0, 18)); // NOI18N
        tipoSimuladorLabel.setForeground(new java.awt.Color(247, 247, 247));
        tipoSimuladorLabel.setText("Tipo de Simulador");
        tipoSimuladorLabel.setMaximumSize(new java.awt.Dimension(380, 20));
        tipoSimuladorLabel.setMinimumSize(new java.awt.Dimension(380, 15));
        tipoSimuladorLabel.setPreferredSize(new java.awt.Dimension(380, 20));
        tipoSimuladorPanel.add(tipoSimuladorLabel);

        add(tipoSimuladorPanel);

        selectorPanel.setMinimumSize(new java.awt.Dimension(380, 46));
        selectorPanel.setOpaque(false);
        selectorPanel.setPreferredSize(new java.awt.Dimension(380, 46));
        selectorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectorSimuladoresTxt.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        selectorSimuladoresTxt.setForeground(new java.awt.Color(247, 247, 247));
        selectorSimuladoresTxt.setText("Seleccione el Simulador");
        selectorSimuladoresTxt.setAlignmentY(0.0F);
        selectorSimuladoresTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectorSimuladoresTxt.setMaximumSize(new java.awt.Dimension(400, 46));
        selectorSimuladoresTxt.setMinimumSize(new java.awt.Dimension(400, 46));
        selectorSimuladoresTxt.setPreferredSize(new java.awt.Dimension(400, 46));
        selectorSimuladoresTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectorSimuladoresTxtMouseClicked(evt);
            }
        });
        selectorPanel.add(selectorSimuladoresTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 390, 40));

        selectorSimuladoresImg.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        selectorSimuladoresImg.setForeground(new java.awt.Color(247, 247, 247));
        selectorSimuladoresImg.setToolTipText("");
        selectorSimuladoresImg.setAlignmentY(0.0F);
        selectorSimuladoresImg.setMaximumSize(new java.awt.Dimension(400, 46));
        selectorSimuladoresImg.setMinimumSize(new java.awt.Dimension(400, 46));
        selectorSimuladoresImg.setPreferredSize(new java.awt.Dimension(400, 46));
        selectorPanel.add(selectorSimuladoresImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(selectorPanel);

        listaSimuladoresPanel.setBackground(new java.awt.Color(111, 114, 113));
        listaSimuladoresPanel.setMaximumSize(new java.awt.Dimension(380, 32767));
        listaSimuladoresPanel.setMinimumSize(new java.awt.Dimension(380, 0));
        listaSimuladoresPanel.setOpaque(false);
        listaSimuladoresPanel.setPreferredSize(new java.awt.Dimension(380, 150));
        listaSimuladoresPanel.setVerifyInputWhenFocusTarget(false);
        listaSimuladoresPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 13));

        simuladorLabel0.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        simuladorLabel0.setForeground(new java.awt.Color(247, 247, 247));
        simuladorLabel0.setText("Simulador1");
        simuladorLabel0.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simuladorLabel0.setMaximumSize(new java.awt.Dimension(400, 15));
        simuladorLabel0.setMinimumSize(new java.awt.Dimension(400, 15));
        simuladorLabel0.setPreferredSize(new java.awt.Dimension(400, 15));
        simuladorLabel0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simuladorLabel0MouseClicked(evt);
            }
        });
        listaSimuladoresPanel.add(simuladorLabel0);

        simuladorLabel1.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        simuladorLabel1.setForeground(new java.awt.Color(247, 247, 247));
        simuladorLabel1.setText("Simulador2");
        simuladorLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simuladorLabel1.setMaximumSize(new java.awt.Dimension(400, 15));
        simuladorLabel1.setMinimumSize(new java.awt.Dimension(400, 15));
        simuladorLabel1.setPreferredSize(new java.awt.Dimension(400, 15));
        simuladorLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simuladorLabel1MouseClicked(evt);
            }
        });
        listaSimuladoresPanel.add(simuladorLabel1);

        simuladorLabel2.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        simuladorLabel2.setForeground(new java.awt.Color(247, 247, 247));
        simuladorLabel2.setText("Atrapa los Univercoins");
        simuladorLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simuladorLabel2.setMaximumSize(new java.awt.Dimension(400, 15));
        simuladorLabel2.setMinimumSize(new java.awt.Dimension(400, 15));
        simuladorLabel2.setPreferredSize(new java.awt.Dimension(400, 15));
        simuladorLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simuladorLabel2MouseClicked(evt);
            }
        });
        listaSimuladoresPanel.add(simuladorLabel2);

        simuladorLabel3.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        simuladorLabel3.setForeground(new java.awt.Color(247, 247, 247));
        simuladorLabel3.setText("BAAM");
        simuladorLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simuladorLabel3.setMaximumSize(new java.awt.Dimension(400, 15));
        simuladorLabel3.setMinimumSize(new java.awt.Dimension(400, 15));
        simuladorLabel3.setPreferredSize(new java.awt.Dimension(400, 15));
        simuladorLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simuladorLabel3MouseClicked(evt);
            }
        });
        listaSimuladoresPanel.add(simuladorLabel3);

        simuladorLabel4.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        simuladorLabel4.setForeground(new java.awt.Color(247, 247, 247));
        simuladorLabel4.setText("PiensoPalabra");
        simuladorLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simuladorLabel4.setMaximumSize(new java.awt.Dimension(400, 15));
        simuladorLabel4.setMinimumSize(new java.awt.Dimension(400, 15));
        simuladorLabel4.setPreferredSize(new java.awt.Dimension(400, 15));
        simuladorLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simuladorLabel4MouseClicked(evt);
            }
        });
        listaSimuladoresPanel.add(simuladorLabel4);

        add(listaSimuladoresPanel);

        jPanel1.setMaximumSize(new java.awt.Dimension(380, 32767));
        jPanel1.setMinimumSize(new java.awt.Dimension(380, 35));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(380, 35));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        textAnadirPregunta.setFont(new java.awt.Font("Raleway", 0, 18)); // NOI18N
        textAnadirPregunta.setForeground(new java.awt.Color(247, 247, 247));
        textAnadirPregunta.setText("Añadir una pregunta");
        textAnadirPregunta.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        textAnadirPregunta.setPreferredSize(new java.awt.Dimension(173, 20));
        jPanel1.add(textAnadirPregunta, java.awt.BorderLayout.CENTER);

        buttonsPanel.setOpaque(false);
        buttonsPanel.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        anadirPreguntaButton.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        anadirPreguntaButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        anadirPreguntaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anadirPreguntaButtonMouseClicked(evt);
            }
        });
        buttonsPanel.add(anadirPreguntaButton);

        simuladorInfoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simuladorInfoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simuladorInfoButtonMouseClicked(evt);
            }
        });
        buttonsPanel.add(simuladorInfoButton);

        jPanel1.add(buttonsPanel, java.awt.BorderLayout.EAST);

        add(jPanel1);

        infoPanel.setMaximumSize(new java.awt.Dimension(380, 32767));
        infoPanel.setMinimumSize(new java.awt.Dimension(380, 0));
        infoPanel.setOpaque(false);
        infoPanel.setPreferredSize(new java.awt.Dimension(380, 100));
        infoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infoText.setFont(new java.awt.Font("Raleway Medium", 0, 14)); // NOI18N
        infoText.setForeground(new java.awt.Color(247, 247, 247));
        infoText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoText.setText("<html><center>Añade las preguntas que quieras que aparezcan durante la simulación. Luego, pulsa el botón crear para exportar el archivo zip que deberas subir a SharePoint.</center> </html>");
        infoText.setAlignmentY(0.0F);
        infoText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        infoText.setMaximumSize(new java.awt.Dimension(360, 0));
        infoText.setMinimumSize(new java.awt.Dimension(360, 0));
        infoText.setPreferredSize(new java.awt.Dimension(360, 0));
        infoPanel.add(infoText, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 360, 100));

        infoBackImg.setAlignmentY(0.0F);
        infoBackImg.setMaximumSize(new java.awt.Dimension(380, 32767));
        infoBackImg.setMinimumSize(new java.awt.Dimension(380, 0));
        infoBackImg.setPreferredSize(new java.awt.Dimension(380, 0));
        infoPanel.add(infoBackImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 100));

        add(infoPanel);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este método se activa cuando se hace clic en el texto del selector de simuladores.
     * Si el panel de la lista de simuladores está visible, lo oculta y cambia la imagen del botón del selector.
     * Si el panel de la lista de simuladores no está visible, lo hace visible y cambia la imagen del botón del selector.
     * Después de cambiar la visibilidad del panel de la lista de simuladores, recalcula y ajusta el tamaño del contenedor.
     *
     * @param evt El evento de clic del mouse que activó este método.
     */
    private void selectorSimuladoresTxtMouseClicked(java.awt.event.MouseEvent evt) {
        if (listaSimuladoresPanel.isShowing()) {
            listaSimuladoresPanel.setVisible(false);
            setImageLabel(selectorSimuladoresImg, "src/imagenes/InterfazMobile/Desplegable_Off.png", selectorDimension);
        } else {
            listaSimuladoresPanel.setVisible(true);
            setImageLabel(selectorSimuladoresImg, "src/imagenes/InterfazMobile/Desplegable_On.png", selectorDimension);           
        }
        contenedorDimension = sumaDimension(this.getComponents());
        this.setSize(contenedorDimension);
        instanciaPanelPreguntas.CambioSize(contenedorDimension);
    }       
    
    /**
     * Este método se activa cuando se hace clic en el texto del selector de simuladores.
     * Después de cambiar la visibilidad del panel de la lista de simuladores (metodo selectorSimuladoresTxtMouseClicked), recalcula y ajusta el tamaño del contenedor. 
     * Llama al metodo mostrarPreguntas del simulador
     *
     * @param evt El evento de clic del mouse que activó este método.
     */
    private void simuladorSeleccionado(java.awt.event.MouseEvent evt){
        JLabel clickedLabel = (JLabel) evt.getSource();
        selectorSimuladoresTxt.setText(clickedLabel.getText());
        selectorSimuladoresTxtMouseClicked(evt);
        mostrarPreguntas(clickedLabel.getText());
    }
    
    /**
     * Muestra las preguntas existentes del simulador dado.
     *
     * @param nombreSimulador El nombre del simulador elegido para mostrar sus preguntas.
     */
    private void mostrarPreguntas(String nombreSimulador) {
        getInstance().setSimuladorName(nombreSimulador);
        try{
            List<Pregunta> preguntas = getInstance().obtenerDatos();
        } catch(CsvValidationException | IOException e){
            // TODO menajar el posible error
        }
        int cantidadPreguntas = getInstance().getCantidadPreguntas();
        /*JPanel[] paneles = new JPanel[cantidadPreguntas];
        JLabel[] botones = new JLabel[cantidadPreguntas];
        instanciaPanelPreguntas.setPaneles(paneles);
        instanciaPanelPreguntas.setBotones(botones);*/
        instanciaPanelPreguntas.eliminarTodasPreguntas();
        instanciaPanelPreguntas.cargarPanelesInicio();
    }
    

    /**
     * Este método se activa cuando se hace clic en el botón de información del simulador.
     * Si el panel de información está visible, lo oculta y cambia la imagen del botón de información.
     * Si el panel de información no está visible, lo hace visible y cambia la imagen del botón de información.
     * También cambia la imagen del botón del selector de simuladores.
     * Después de cambiar la visibilidad del panel de información, recalcula y ajusta el tamaño del contenedor.
     *
     * @param evt El evento de clic del mouse que activó este método.
     */
    private void simuladorInfoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simuladorInfoButtonMouseClicked
        if (infoPanel.isShowing()) {
            infoPanel.setVisible(false);
            setImageLabel(simuladorInfoButton, "src/imagenes/InterfazMobile/info_Off.png", iconButtonDimension);
        } else {
            infoPanel.setVisible(true);
            setImageLabel(simuladorInfoButton, "src/imagenes/InterfazMobile/info_On.png", iconButtonDimension);
        }
        contenedorDimension = sumaDimension(this.getComponents());
        this.setSize(contenedorDimension);
        instanciaPanelPreguntas.CambioSize(contenedorDimension);
    }//GEN-LAST:event_simuladorInfoButtonMouseClicked

    /**
     * Este método se activa cuando se hace clic en la etiqueta del simulador 0.
     * Obtiene la etiqueta en la que se hizo clic, establece el texto del selector de simuladores al texto de la etiqueta y activa el método de clic del selector de simuladores.
     *
     * @param evt El evento de clic del mouse que activó este método.
     */
    private void simuladorLabel0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simuladorLabel0MouseClicked
        simuladorSeleccionado(evt);
    }//GEN-LAST:event_simuladorLabel0MouseClicked

    private void simuladorLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simuladorLabel1MouseClicked
        simuladorSeleccionado(evt);
    }//GEN-LAST:event_simuladorLabel1MouseClicked

    private void simuladorLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simuladorLabel2MouseClicked
        simuladorSeleccionado(evt);
    }//GEN-LAST:event_simuladorLabel2MouseClicked

    private void simuladorLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simuladorLabel3MouseClicked
        simuladorSeleccionado(evt);
    }//GEN-LAST:event_simuladorLabel3MouseClicked

    private void simuladorLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simuladorLabel4MouseClicked
        simuladorSeleccionado(evt);
    }//GEN-LAST:event_simuladorLabel4MouseClicked

    private void anadirPreguntaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anadirPreguntaButtonMouseClicked
        // TODO add your handling code here:
        Sesion.getInstance().setBlanco("Pregunta añadida  (actualmente %d)" + instanciaPanelPreguntas.cantidadPanelesFront);
        instanciaPanelPreguntas.crearPanelNuevo();
    }//GEN-LAST:event_anadirPreguntaButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anadirPreguntaButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel infoBackImg;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel infoText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel listaSimuladoresPanel;
    private javax.swing.JPanel selectorPanel;
    private javax.swing.JLabel selectorSimuladoresImg;
    private javax.swing.JLabel selectorSimuladoresTxt;
    private javax.swing.JLabel simuladorInfoButton;
    private javax.swing.JLabel simuladorLabel0;
    private javax.swing.JLabel simuladorLabel1;
    private javax.swing.JLabel simuladorLabel2;
    private javax.swing.JLabel simuladorLabel3;
    private javax.swing.JLabel simuladorLabel4;
    private javax.swing.JLabel textAnadirPregunta;
    private javax.swing.JLabel tipoSimuladorLabel;
    private javax.swing.JPanel tipoSimuladorPanel;
    // End of variables declaration//GEN-END:variables

}
