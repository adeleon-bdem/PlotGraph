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

import javax.swing.JComponent;

/**
 * com.studyscarlet.media.plotgraph.interfaces.IView.
 * Esta interfaz representa [TODO]
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public interface IView {
    
    /**
     * Método para pasarle el controller como un listener de ciertos
     * eventos.
     * @param controller El controller que va a manejar los eventos
     * de la vista.
     */
    void setListeners(IController controller);
    
    /**
     * Método para mostrar la vista. Usualmente es hacer visible
     * el frame y ponerlo hasta arriba.
     */
    void showView();
    
    /**
     * Método para ocultar la vista. Usualmente es hacer invisible
     * el frame.
     */
    void hideView();
    
    /**
     * Método para limpiar la vista.
     */
    void cleanView();
    
    /**
     * Método para validar si la vista ya es visible o no.
     * @return Verdadero si la vista ya se puede ver, falso en otro caso.
     */
    boolean isVisible();
    
    /**
     * Método para eliminar la vista del sistema.
     */
    void destroyView();
    
    /**
     * Método para convertir una instancia de este tipo al componente
     * swing que representa.
     * @return el componente a convertir.
     */
    JComponent toComponent();
    
    /**
     * Método para obtener el componente principal de esta vista
     * @return El componente principal.
     */
    JComponent getMainComponent();
    
}
