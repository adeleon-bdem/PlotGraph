/*
 * Copyright (c) 2014, 2105; Estudio Escarlata. All rights reserved.
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

package com.studyscarlet.media.plotgraph.model;

import com.studyscarlet.media.plotgraph.interfaces.IModel;
import com.studyscarlet.media.plotgraph.log.AbstractLoggable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * com.studyscarlet.media.plotgraph.model.DefaultModel.
 * Esta clase representa un modelo por omisión, con un mapeo
 * entre atributos y nombres.
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class DefaultModel extends AbstractLoggable implements IModel {
    
    /**
     * Para el serializado
     */
    private static final long serialVersionUID = -890388184081013076L;
    
    /**
     * Un mapa con los atributos del modelo.
     */
    protected Map<String, Object> mapAtribs = new ConcurrentHashMap<>();
    
    /**
     * Método para agregar atributos al mapa. Los objetos debieran ser
     * campos de esta clase o de una clase derivada.
     * @param attribName El nombre del atributo
     * @param attribObject El atributo en sí.
     */
    protected void addMapping(String attribName, Object attribObject) {
        // sólo si no se ha agregado...
        if (!mapAtribs.containsKey(attribName)) {
            mapAtribs.put(attribName, attribObject);
            return;
        }
        // si ya se agregó, no permitir agregar dos veces.
        logger.error("Ya se agrego el atributo {}", attribName);
        throw new IllegalArgumentException("Atributo duplicado: [" + 
                attribName + "]");
    }
    
    /**
     * Método para obtener el valor de un atributo
     * @param valueName El nombre del atributo
     * @return El valor del atributo
     * @throws IllegalArgumentException Cuando el nombre del atributo 
     * no existe en el mapa.
     */
    @Override
    public Object getValue(String valueName) {
        // obtener del mapa el objeto.
        if (mapAtribs.containsKey(valueName)) {
            return mapAtribs.get(valueName);
        }
        // no está? lanzar una excepción.
        logger.error("El valor solicitado {}, no existe en el mapa", valueName);
        throw new IllegalArgumentException("Error, valor solicitado [" + 
                valueName + "] no existe");
    }

    /**
     * Método para fijar el valor de un atributo
     * @param valueName El nombre del atributo
     * @param newValue  El nuevo valor del atributo.
     * @throws IllegalArgumentException Cuando el nombre del atributo
     * no existe en el mapa.
     */
    @Override
    public void setValue(String valueName, Object newValue) {
        // validar que el atributo exista.
        if (mapAtribs.containsKey(valueName)) {
            mapAtribs.put(valueName, newValue);
            return;
        }
        // si no existe, lanzar una excepción
        logger.error("El valor solicitado {}, no existe en el mapa", valueName);
        throw new IllegalArgumentException("Error, valor solicitado [" + 
                valueName + "] no existe");
    }

    @Override
    public void clean() {
        logger.debug("[clean] Del DefaultModel");
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
