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

package com.studyscarlet.media.plotgraph.controller;

import com.studyscarlet.media.plotgraph.dialog.MessageDlg;
import com.studyscarlet.media.plotgraph.dialog.enums.DEButtons;
import com.studyscarlet.media.plotgraph.dialog.enums.DEIcons;
import com.studyscarlet.media.plotgraph.enums.EEvents;
import com.studyscarlet.media.plotgraph.interfaces.IController;
import com.studyscarlet.media.plotgraph.interfaces.IModel;
import com.studyscarlet.media.plotgraph.interfaces.IView;
import com.studyscarlet.media.plotgraph.interfaces.IWindowController;
import com.studyscarlet.media.plotgraph.log.AbstractLoggable;
import com.studyscarlet.media.plotgraph.model.MainModel;
import com.studyscarlet.media.plotgraph.view.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.EnumSet;
import java.util.EventObject;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * com.studyscarlet.media.plotgraph.controller.MainController:
 * Esta clase representa [TODO]
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class MainController extends DefaultController implements IWindowController {
    
    /**
     * Para el serializado
     */
    private static final long serialVersionUID = 6500007605125693394L;

    /**
     * Para el modelo
     */
    private final MainModel model;
    
    /**
     * Para la vista.
     */
    private final MainView view;

    public MainController() {
        this(new MainModel(), new MainView(), null);
    }
    
    public MainController(MainModel model, MainView view, IController parent) {
        super(parent);
        this.model = model;
        this.view = view;
        
        this.view.setListeners(this);
    }    
    
    @Override
    public void initView() {
        view.showView();
    }

    @Override
    public IView getView() {
        return view;
    }

    @Override
    public IModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String stringCommand = event.getActionCommand();        
        EEvents eventCommand = EEvents.getEnumFromString(stringCommand);
        Object source = event.getSource();
        
        // logger.debug("Evento recibido en el MainController: {}, objeto: {}", eventCommand, source);
        
        switch (eventCommand) {
            
            case EV_QUIT: {
                // eliminar todas las vistas.
                model.removeAllControllers();
                view.destroyView();
                // terminar la ejecución
                logger.info("STOP RUN.");
                break;
            }
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusGained(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postQuitMessage() {
        java.awt.EventQueue.invokeLater(new Runnable() {            
            @Override
            public void run() {
                actionPerformed(new ActionEvent(
                        this, 
                        ActionEvent.ACTION_FIRST, 
                        EEvents.EV_QUIT.getValue()));
            }
        });
    }

    @Override
    public void finalMessage(JFrame frame, JComponent component, String message, String titulo) {
        // Mostrar el dialogo
        logger.debug("[finalMessage] -> {}", message);
        // estamos por salir. Ya no mostrar otro mensaje
        MessageDlg.showMessageDlg(
                (MainView)view, view.toComponent(), true, 
                message, EnumSet.of(DEButtons.DLG_ACCEPT),
                titulo, DEIcons.DLG_ERROR);
        logger.debug("Antes de postQuitMessage");
        postQuitMessage();
    }

    @Override
    public void showErrorMessage(String message, String title) {
        MessageDlg.showMessageDlg(
                view, 
                view.toComponent(), 
                true, message,
                EnumSet.of(DEButtons.DLG_ACCEPT), 
                title,
                DEIcons.DLG_ERROR);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosing(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
