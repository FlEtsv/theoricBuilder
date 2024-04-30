/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import db.Pregunta;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import utility.ControlDepuracion;
import utility.Sesion;
import utility.Utility;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import views.PanelPreguntas;

/**
 * Clase Principal que extiende de JFrame.
 * Esta clase es la principal del proyecto y se encarga de la interfaz gráfica del usuario.
 * @author USER
 */
public final class Principal extends javax.swing.JFrame {

    private PanelPreguntas instanciaPanelPreguntas;
    private volatile boolean seguirEjecutando = true;
    private Thread threadDepuracion;
    /*
    String colorRojo = "#EB4151";
    String colorAmarillo = "#FF9C00";
    String colorVerde = "#86D295";
    String colorBlanco = "#F7F7F7";
    */
    
    /**
     * Constructor de la clase Principal.
     * Inicializa los componentes de la interfaz gráfica y configura la ventana principal.
     */
    public Principal() {
        initComponents();
        iniciarCuentaPanelesShow();
        ControlDepuracion txtWarningControl = new ControlDepuracion(txtWarning);
        txtWarningControl.iniciarDepuracion();

        //Ubicar y adaptar botón de "Crear".
        
        Utility.SetImageLabel(btnGuardar, "src/imagenes/InterfazMobile/Extra/Icon_Shield.png", new Dimension(45, 45));
        
        //Llamar al JPanel correspondiente de preguntas.
        PanelPreguntas p = new PanelPreguntas();
        ShowPanel(p.panelPrincipal);
        
        //Mantener el JFrame siempre en primera posición.
        setAlwaysOnTop(true);
        
        //Ubicar el JFrame a la derecha, y verticalmente en el centro.
        Dimension pantallaSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension thisFrameSize = getSize();
        
        int horizontal = (pantallaSize.width - thisFrameSize.width) - 20 ;
        int vertical = (pantallaSize.height - thisFrameSize.height) / 2;
        setLocation(horizontal, vertical);
    }
    
    
    public void revisarEstado(){
        txtBtnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        int numero = Sesion.getInstance().getCantidadcomponentes();
        System.out.println(numero);
        if(numero <= 1){
            
            Utility.SetImageLabel(btnExportar, "src/imagenes/InterfazMobile/Cilindrico_Off.png", new Dimension(240, 45));
            txtBtnCrear.setFont(new java.awt.Font("Raleway", 0, 22));
        } else {
            //BOTÓN ESTÁ ACTIVO
            Utility.SetImageLabel(btnExportar, "src/imagenes/InterfazMobile/Cilindrico_On.png", new Dimension(240, 45));
            btnExportar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    txtBtnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    Utility.SetImageLabel(btnExportar, "src/imagenes/InterfazMobile/Cilindrico_On.png", new Dimension(250, 50));
                    txtBtnCrear.setFont(new java.awt.Font("Raleway", 0, 24));
                }
                @Override
                public void mouseExited(MouseEvent e){
                    Utility.SetImageLabel(btnExportar, "src/imagenes/InterfazMobile/Cilindrico_On.png", new Dimension(240, 45));
                    txtBtnCrear.setFont(new java.awt.Font("Raleway", 0, 22));
                    txtBtnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                }
            });
        }
    }
    
    public void iniciarCuentaPanelesShow() {
        threadDepuracion = new Thread(() -> {
            while (seguirEjecutando) {
                try {
                    revisarEstado();
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        threadDepuracion.start();
    }
    
    
    /**
     * Método para mostrar un panel en la interfaz gráfica.
     * @param p JPanel a mostrar.
     */
    public void ShowPanel(JPanel p){
        JScrollPane scrollPane = new JScrollPane(p);

        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        
        // TODO PONER VELOCIDAD DISTINTA AL SCROLL
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        scrollPane.setPreferredSize(new Dimension(430, 788));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(-3, 0, 0, 0));
        
        contentPanel.removeAll();
        contentPanel.add(scrollPane);
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    
    /**
     * Método para obtener la imagen del icono de la aplicación.
     * @return Image del icono de la aplicación.
     */
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/InterfazMobile/Extra/Icon_Shield.png"));
        return retValue;
    }
    
    /**
    * Este método se utiliza para obtener una lista de paneles de preguntas de la interfaz gráfica.
    * Recorre todos los componentes del panel de contenido y agrega a la lista aquellos que son instancias de JPanel y no son instancias de VistaSelectorSimulador.
    * 
    * @return List<JPanel> Una lista de paneles de preguntas.
    */
    private List<JPanel> obtenerJPanlesPreguntas(){
        // Crea la Lista<JPanel> que queremos convertir a Pregunta
        List<JPanel> panelesPregunta = new ArrayList<>();
        if(contentPanel.getComponentCount() == 1){
            JScrollPane panelScroll = (JScrollPane) contentPanel.getComponent(0);
            JPanel variable = (JPanel) panelScroll.getViewport().getView();
            Component[] componentes = variable.getComponents();
            // Suponemos que el componente en la posición 0 es la vistaSelectoSimulador
            for (Component componente : componentes){
                if(componente instanceof JPanel  && !(componente instanceof VistaSelectorSimulador)){
                    panelesPregunta.add((JPanel)componente);
                }
            }
        }
        return panelesPregunta;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        txtTitulo = new javax.swing.JLabel();
        bottomPanel = new javax.swing.JPanel();
        txtBtnCrear = new javax.swing.JLabel();
        btnExportar = new javax.swing.JLabel();
        txtWarning = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TheoricBuilder");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(430, 932));
        setPreferredSize(new java.awt.Dimension(430, 932));
        setResizable(false);
        setSize(new java.awt.Dimension(430, 932));

        jPanel4.setBackground(new java.awt.Color(0, 11, 31));
        jPanel4.setMaximumSize(new java.awt.Dimension(430, 930));
        jPanel4.setMinimumSize(new java.awt.Dimension(430, 930));
        jPanel4.setPreferredSize(new java.awt.Dimension(430, 930));
        jPanel4.setLayout(new java.awt.BorderLayout());

        topPanel.setMaximumSize(new java.awt.Dimension(430, 56));
        topPanel.setMinimumSize(new java.awt.Dimension(430, 52));
        topPanel.setOpaque(false);
        topPanel.setPreferredSize(new java.awt.Dimension(430, 52));
        topPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setFont(new java.awt.Font("Raleway", 1, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(247, 247, 247));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo.setText("Crea tu simulador teórico");
        txtTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtTitulo.setMaximumSize(new java.awt.Dimension(430, 29));
        txtTitulo.setMinimumSize(new java.awt.Dimension(430, 29));
        txtTitulo.setPreferredSize(new java.awt.Dimension(430, 29));
        topPanel.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel4.add(topPanel, java.awt.BorderLayout.NORTH);

        bottomPanel.setMaximumSize(new java.awt.Dimension(430, 92));
        bottomPanel.setMinimumSize(new java.awt.Dimension(430, 92));
        bottomPanel.setOpaque(false);
        bottomPanel.setPreferredSize(new java.awt.Dimension(430, 92));
        bottomPanel.setRequestFocusEnabled(false);
        bottomPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtBtnCrear.setFont(new java.awt.Font("Raleway", 0, 24)); // NOI18N
        txtBtnCrear.setForeground(new java.awt.Color(7, 29, 57));
        txtBtnCrear.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtBtnCrear.setText("Exportar");
        txtBtnCrear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bottomPanel.add(txtBtnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 10, 250, 50));

        btnExportar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExportar.setToolTipText(null);
        btnExportar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExportar.setMaximumSize(new java.awt.Dimension(380, 52));
        btnExportar.setMinimumSize(new java.awt.Dimension(370, 50));
        btnExportar.setPreferredSize(new java.awt.Dimension(380, 52));
        btnExportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportarMouseClicked(evt);
            }
        });
        bottomPanel.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 10, 250, 50));

        txtWarning.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        txtWarning.setForeground(new java.awt.Color(255, 255, 255));
        txtWarning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bottomPanel.add(txtWarning, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 56, 420, 30));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });
        jPanel1.add(btnGuardar, java.awt.BorderLayout.CENTER);
        jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);
        jPanel1.add(jLabel2, java.awt.BorderLayout.SOUTH);
        jPanel1.add(jLabel3, java.awt.BorderLayout.WEST);
        jPanel1.add(jLabel4, java.awt.BorderLayout.EAST);

        bottomPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 70, 70));

        jPanel4.add(bottomPanel, java.awt.BorderLayout.SOUTH);

        contentPanel.setMaximumSize(new java.awt.Dimension(430, 788));
        contentPanel.setMinimumSize(new java.awt.Dimension(430, 788));
        contentPanel.setOpaque(false);
        contentPanel.setPreferredSize(new java.awt.Dimension(430, 788));
        contentPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));
        jPanel4.add(contentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * Método que se ejecuta cuando se hace clic en el botón "Exportar".
    * Este método crea una lista de paneles de preguntas, convierte estos paneles en objetos de tipo Pregunta,
    * guarda estas preguntas en un archivo CSV y luego exporta este archivo a un archivo ZIP.
    *
    * @param evt Evento del mouse que representa el clic en el botón.
    */
    private void btnExportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportarMouseClicked
        // Convierte los paneles de preguntas en objetos de tipo Pregunta
        List<Pregunta> preguntas = Sesion.getInstance().crearPreguntasConPaneles(obtenerJPanlesPreguntas());       
        // Guarda las preguntas en un archivo CSV y exporta este archivo a un archivo ZIP
        try {
            boolean isGuardado = Sesion.guardar(preguntas);
            if(isGuardado){
                Sesion.Exportar();
            }
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportarMouseClicked

    /**
    * Método que se ejecuta cuando se hace clic en el botón "Guardar".
    * Este método crea una lista de paneles de preguntas, convierte estos paneles en objetos de tipo Pregunta,
    * guarda estas preguntas en un archivo CSV.
    *
    * @param evt Evento del mouse que representa el clic en el botón.
    */
    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // Convierte los paneles de preguntas en objetos de tipo Pregunta
        List<Pregunta> preguntas = Sesion.getInstance().crearPreguntasConPaneles(obtenerJPanlesPreguntas());
        try {
            Sesion.guardar(preguntas);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarMouseClicked

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        // TODO add your handling code here:
        Utility.SetImageLabel(btnGuardar, "src/imagenes/InterfazMobile/Extra/Icon_Shield.png", new Dimension(50, 50));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        // TODO add your handling code here:
        Utility.SetImageLabel(btnGuardar, "src/imagenes/InterfazMobile/Extra/Icon_Shield.png", new Dimension(45, 45));
    }//GEN-LAST:event_btnGuardarMouseExited

    /**
     * Método principal de la aplicación.
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JLabel btnExportar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel txtBtnCrear;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JLabel txtWarning;
    // End of variables declaration//GEN-END:variables
}
