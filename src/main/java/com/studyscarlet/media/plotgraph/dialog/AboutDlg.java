/*
 * Copyright (c) 2014, Estudio Escarlata. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 *   - Neither the name of Estudio Escarlata or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.studyscarlet.media.plotgraph.dialog;

import com.studyscarlet.media.plotgraph.enums.EEvents;
import com.studyscarlet.media.plotgraph.interfaces.IApplication;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.studyscarlet.media.plotgraph.dialog.AboutDlg:
 * Esta clase representa...
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class AboutDlg extends javax.swing.JDialog implements ActionListener {
    
    /**
     * Para el logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(AboutDlg.class);
    
    /**
     * Para el serializado
     */
    private static final long serialVersionUID = -6881534372403391373L;
    
    /**
     * Los tokens que se buscarán para reemplazar los valores
     * específicos de la aplicación.
     */
    private static final String TOKEN_APP_NAME     = "%ProductName%";
    private static final String TOKEN_APP_VERSION  = "%ProductVersion%";
    private static final String TOKEN_FILE_VERSION = "%FileVersion%";
    private static final String TOKEN_JAVA_VERSION = "%JavaVersion%";
    private static final String TOKEN_JRE_VERSION  = "%JreVersion%";
    private static final String TOKEN_SYSTEM_INFO  = "%SystemInfo%";
    private static final String TOKEN_USER_DIR     = "%UserDir%"; 
    
    /** 
     * Creates new form AboutDlg 
     * @param parent El marco en donde se centrará este diálogo
     * @param modal Indica si es modal o no. Siempre debería serlo
     * @param application Una clase que nos devuelva los datos específicos
     * de la aplicación.
     */
    public AboutDlg(java.awt.Frame parent, boolean modal, IApplication application) {
        super(parent, modal);
        initComponents();
        // cambiar los valores por los del sistema.
        lblVersion.setText(lblVersion.getText(
        ).replaceAll(
                TOKEN_APP_NAME, 
                application.getProductName()
        ).replaceAll(
                TOKEN_FILE_VERSION, 
                application.getFileVersion()));
        // Cambiar los de la caja de información
        txtPanInfo.setText(txtPanInfo.getText().replaceAll(
                TOKEN_APP_VERSION,
                application.getProductVersion()
        ).replaceAll(
                TOKEN_JAVA_VERSION,
                System.getProperty("java.version") + "; " + 
                        System.getProperty("java.vm.name") + " " +
                        System.getProperty("java.vm.version") + ", " +
                        System.getProperty("java.vm.info")
        ).replaceAll(
                TOKEN_JRE_VERSION,
                System.getProperty("java.runtime.name") + " " +
                        System.getProperty("java.runtime.version")
        ).replaceAll(
                TOKEN_SYSTEM_INFO,
                System.getProperty("os.name") + " version " +
                        System.getProperty("os.version") + "; " +
                        System.getProperty("file.encoding") + "; " +
                        System.getProperty("user.language") + "_" +
                        System.getProperty("user.country")
        ).replaceAll(
                TOKEN_USER_DIR, 
                System.getProperty("user.dir").replaceAll("\\\\", "&#92;")
        ));
        addListeners(this);          
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblVersion = new javax.swing.JLabel();
        panInfo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtPanInfo = new javax.swing.JTextPane();
        panBotones = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de");
        setModal(true);
        setResizable(false);

        panLogo.setLayout(new javax.swing.BoxLayout(panLogo, javax.swing.BoxLayout.PAGE_AXIS));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/studyscarlet/media/plotgraph/icons/banco-de-mexico.png"))); // NOI18N
        panLogo.add(lblLogo);

        lblVersion.setBackground(new java.awt.Color(51, 153, 255));
        lblVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVersion.setText("<html>\n<center>\n<P><B>%ProductName%</B></P>\n<P>Versión: %FileVersion%</P>\n</center>");
        lblVersion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panLogo.add(lblVersion);

        getContentPane().add(panLogo, java.awt.BorderLayout.NORTH);

        panInfo.setLayout(new java.awt.BorderLayout(10, 10));

        txtPanInfo.setContentType("text/html"); // NOI18N
        txtPanInfo.setText("<html>\r\n  <head>\r\n\r<style>\np {\n    display: block;\n    margin-top: 0;\n    margin-bottom: 0;\n    margin-left: 0;\n    margin-right: 0;\n}\n</style>\n  </head>\r\n  <body>\r\n<p ><b>Versión del Producto:</b> %ProductVersion%\n<p><b>Java:</b> %JavaVersion%\n<p><b>Runtime:</b> %JreVersion%\n<p><b>System:</b> %SystemInfo%\n<p><b>Directorio:</b> %UserDir%\n  </body>\r\n</html>\r\n");
        jScrollPane2.setViewportView(txtPanInfo);

        panInfo.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        getContentPane().add(panInfo, java.awt.BorderLayout.CENTER);

        btnSalir.setText("Cerrar");
        btnSalir.setActionCommand(EEvents.EV_CLOSE_ABOUT.getValue());
        panBotones.add(btnSalir);

        getContentPane().add(panBotones, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblVersion;
    private javax.swing.JPanel panBotones;
    private javax.swing.JPanel panInfo;
    private javax.swing.JPanel panLogo;
    private javax.swing.JTextPane txtPanInfo;
    // End of variables declaration//GEN-END:variables

    /**
     * Método para indicar un listener de eventos
     * @param listener 
     */
    public final void addListeners(ActionListener listener) {
        btnSalir.addActionListener(listener);
    }
    
    @Override
    public void actionPerformed(ActionEvent event) {
        // Obtener la cadena del evento.
        String actionCommand = event.getActionCommand();        
        EEvents eventCommand = EEvents.getEnumFromString(actionCommand);
        
        switch(eventCommand) {
            case EV_CLOSE_ABOUT: {
                // Cerrar esta ventana
                this.dispose();
                return;
            }
            default: {
                logger.error("Evento superdesconocido en acerca de: {}:{}", 
                        actionCommand, eventCommand);
            }
        }
    }

}
