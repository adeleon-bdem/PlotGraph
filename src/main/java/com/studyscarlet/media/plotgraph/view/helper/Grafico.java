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

package com.studyscarlet.media.plotgraph.view.helper;

import com.studyscarlet.media.plotgraph.model.GraphModel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.studyscarlet.media.plotgraph.view.helper.Grafico:
 * Esta clase representa [TODO]
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (angel.deleon@banxico.org.mx)
 * @version 1.0
 * @since 1.0
 */
public class Grafico extends Canvas {
    
    /**
     * Para el logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(Grafico.class);
    
    /**
     * Para el serializado
     */
    private static final long serialVersionUID = 1343733581513495033L;

    private GraphModel model = null;

    public Grafico() {
    }
    
    public Grafico(GraphModel model) {
        this.model = model;
    }
    
    @Override
    public void paint(Graphics g) {
        int len;
        len = Math.min(this.getWidth(), this.getHeight()) / 3;
        
        if (model != null) {
            logger.debug("Antes de llenar los vértices.");
            model.llenaVertices(10, len);
            Polygon polygon = new Polygon();
            for (Point point : model.getVertices()) {
                polygon.addPoint(
                        point.x + getWidth() / 2,
                        point.y + getHeight() / 2);
            }
            // el polígono generado:
            logger.debug("El polígono:");
            logger.debug("----- BEGIN POLY -----");
            for (int i=0; i<polygon.npoints; i++) {
                logger.debug("{}: ({}, {})", i, polygon.xpoints[i], polygon.ypoints[i]);
            }
            logger.debug("----- END POLY -----");
            logger.debug("El canvas: ({}, {})", getWidth(), getHeight());
            g.drawPolygon(polygon);
            if (model.getNumVertices() % 2 != 0) {
                // Ahora el polígono interno.
                Polygon innerPoly = new Polygon();
                for (int i=0; i < model.getVertices().size(); i++) {
                    // Agregar cada 2 vértices, módulo el número de vertices.
                    Point point = model.getVertices().get(2 * i % model.getNumVertices());
                    innerPoly.addPoint(
                            point.x + getWidth() / 2,
                            point.y + getHeight() / 2);
                }
                g.setColor(Color.RED);
                g.drawPolygon(innerPoly);
            } else {
                // Ahora dos polígonos internos.
                Polygon innerPoly1 = new Polygon();
                Polygon innerPoly2 = new Polygon();
                for (int i=0; i < model.getVertices().size(); i++) {
                    // Agregar cada 2 vértices, módulo el número de vertices.
                    Point point1 = model.getVertices().get(2 * i % model.getNumVertices());
                    innerPoly1.addPoint(
                            point1.x + getWidth() / 2,
                            point1.y + getHeight() / 2);
                    
                    Point point2 = model.getVertices().get((2 * i + 1) % model.getNumVertices());
                    innerPoly2.addPoint(
                            point2.x + getWidth() / 2,
                            point2.y + getHeight() / 2);
                    
                }
                g.setColor(Color.RED);
                g.drawPolygon(innerPoly1);
                g.setColor(Color.BLUE);
                g.drawPolygon(innerPoly2);
            }
        } else {
            g.setColor(Color.BLUE);
            g.fillOval(
                    this.getWidth() / 2 - len / 4, 
                    this.getHeight() / 2 - len / 4, 
                    len / 4, 
                    len / 4);
        }
    }

    public void setModel(GraphModel model) {
        this.model = model;
    }
    
}
