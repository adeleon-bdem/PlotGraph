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

package com.studyscarlet.media.plotgraph.dialog.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * com.studyscarlet.media.plotgraph.dialog.enums.DEResults.
 * Esta enumeración representa...
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public enum DEResults {

    /**
     * El resultado al pulsar el botón de aceptar.
     */
    RES_ACCEPT(1),
    
    /**
     * El resultado al pulsar el botón de cancelar.
     */
    RES_CANCEL(2),
    
    /**
     * El resultado al pulsar el botón de ignorar.
     */
    RES_IGNORE(4),
    
    /**
     * El resultado cuando es un botón desconocido.
     */
    RES_UNKNOWN(0);
    
    /**
     * El resultado representado en este enum
     */
    private final int result;
    
    /**
     * Constructor de enumeración resultado.
     * @param result El resultado representado en esta enumeración.
     */
    private DEResults(int result) {
        this.result = result;
    }

    /**
     * Getter para el resultado.
     * @return 
     */
    public int getResult() {
        return result;
    }

    /**
     * Un mapa privado para asociar las cadenas a los elementos de la enumeración.
     */
    private static Map<Integer, DEResults> mappingIntToDEResults;
    
    /**
     * Método para inicializar el mapa de cadenas a elementos de la enumeración.
     */
    private static void initMapping() {
        if (null == mappingIntToDEResults) {
            mappingIntToDEResults = new HashMap<>();
            for (DEResults eventsEnum : values()) {
                mappingIntToDEResults.put(eventsEnum.getResult(), eventsEnum);
            }
        }
    }
    
    /**
     * Método para convertir de cadena a enum
     * @param value El valor a convertir
     * @return El valor del enum que corresponde a la cadena
     */
    public static DEResults getEnumFromInteger(int value) {
        // se inicializa por si acaso.
        initMapping();
        // se busca la cadena.
        if (mappingIntToDEResults.containsKey(value)) {
            return mappingIntToDEResults.get(value);
        }
        // si no se encuentra, regresar un objeto genérico
        return RES_UNKNOWN;
    }
    
}
