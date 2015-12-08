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

package com.studyscarlet.media.plotgraph.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * com.studyscarlet.media.plotgraph.model.GraphModel:
 * Esta clase representa [TODO]
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (angel.deleon@banxico.org.mx)
 * @version 1.0
 * @since 1.0
 */
public class GraphModel extends DefaultModel {
    
    /**
     * Para el serializado
     */
    private static final long serialVersionUID = -1884765679591124203L;
    
    // Lista de puntos del polígono.
    private List<Point> vertices = new ArrayList<>();
    
    // Número de puntos del polígono.
    private int numVertices;
    
    // Radio del círculo circunscrito.
    private int radio;
    
    /**
     * Llena los vértices.
     * @param numVertices El número de vértices.
     * @param radio El radio del círculo circunscrito.
     */
    public void llenaVertices(int numVertices, int radio) {
        this.numVertices = numVertices;
        this.radio = radio;
        vertices.clear();
        for (int i=0; i<numVertices; i++) {
            vertices.add(
                    new Point(
                            (int)(radio * Math.cos(i * 2 * Math.PI / numVertices)), 
                            (int)(radio * Math.sin(i * 2 * Math.PI / numVertices))
                    )
            );
        }
    }

    /**
     * Getter para recuperar el número de vértices.
     * @return El número de vértices.
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * Getter para recuperar el radio del círculo circunscrito.
     * @return El radio del círculo circunscrito.
     */
    public int getRadio() {
        return radio;
    }

    /**
     * Getter para recuperar el número de vértices.
     * @return La lista con el número de vértices.
     */
    public List<Point> getVertices() {
        return vertices;
    }
    
}
