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

package com.studyscarlet.media.plotgraph.interfaces;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.util.EventListener;
import java.util.EventObject;
import javax.swing.event.MouseInputListener;

/**
 * com.studyscarlet.media.plotgraph.interfaces.IController.
 * Esta interfaz representa [TODO]
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface IController extends ActionListener, MouseInputListener, KeyListener, EventListener, FocusListener {

    /**
     * Método para inicializar y mostrar la vista.
     */
    void initView();

    /**
     * Método para obtener la vista principal de este controlador.
     * @return La vista principal del controlador.
     */
    IView getView();
    
    /**
     * Método para obtener el modelo principal de este controlador.
     * @return El modelo principal del controlador.
     */
    IModel getModel();
    
    /**
     * Método para obtener el controller padre, el que manda llamar
     * a este controlador.
     * @return El controlador padre de este controlador
     */
    IController getParent();
    
    /**
     * Método para enviar un evento al controlador padre.
     * @param event 
     */
    void sendToParent(EventObject event);
    
}
