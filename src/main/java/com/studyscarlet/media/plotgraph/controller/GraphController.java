/*
 * Copyright (c) 2014, Banco de Mexico. All rights reserved.
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
 *   - Neither the name of Banco de Mexico or the names of its
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

import com.studyscarlet.media.plotgraph.enums.EEvents;
import com.studyscarlet.media.plotgraph.interfaces.IController;
import com.studyscarlet.media.plotgraph.interfaces.IModel;
import com.studyscarlet.media.plotgraph.interfaces.IView;
import com.studyscarlet.media.plotgraph.model.GraphModel;
import com.studyscarlet.media.plotgraph.view.GraphView;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * com.studyscarlet.media.plotgraph.controller.GraphController:
 * Esta clase representa [TODO]
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (angel.deleon@banxico.org.mx)
 * @version 1.0
 * @since 1.0
 */
public class GraphController extends DefaultController {
    
    /**
     * Para el serializado
     */
    private static final long serialVersionUID = 3305631637595451884L;

    /**
     * El modelo del gráfico.
     */
    private GraphModel model;
    
    /**
     * La vista del gráfico.
     */
    private GraphView view;

    public GraphController(IController parent) {
        this(new GraphModel(), new GraphView(), parent);
    }

    public GraphController(GraphModel model, GraphView view, IController parent) {
        super(parent);
        this.model = model;
        this.view = view;
        
        this.view.getGrafico().setModel(model);
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
        
        logger.debug("Evento recibido en el GraphController: {}, objeto: {}", eventCommand, source);
        
        switch (eventCommand) {
            
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

}
