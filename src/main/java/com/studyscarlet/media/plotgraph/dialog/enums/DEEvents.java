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
 * com.studyscarlet.media.plotgraph.dialog.enums.DEEvents.
 * Esta enumeración representa...
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public enum DEEvents {    
 
    DLG_EV_ACCEPT("dlg:ev:accept", DEResults.RES_ACCEPT),
    
    DLG_EV_CANCEL("dlg:ev:cancel", DEResults.RES_CANCEL),
    
    DLG_EV_IGNORE("dlg:ev:ignore", DEResults.RES_IGNORE),
    
    DLG_EV_UNKNOWN("dlg:ev:unknown", DEResults.RES_UNKNOWN),
    
    ;

    /**
     * El evento como cadena
     */
    private final String event;
    
    /**
     * El botón asociado al evento.
     */
    private final DEResults value;

    /**
     * Constructor que toma una cadena y un botón
     * @param event La cadena con el valor del evento
     * @param value El valor del evento
     */
    private DEEvents(String event, DEResults value) {
        this.event = event;
        this.value = value;
    }

    public String getEvent() {
        return event;
    }

    public DEResults getValue() {
        return value;
    }

    /**
     * Un mapa privado para asociar las cadenas a los elementos de la enumeración.
     */
    private static Map<String, DEEvents> mappingStringToDEEvents;
    
    /**
     * Método para inicializar el mapa de cadenas a elementos de la enumeración.
     */
    private static void initMapping() {
        if (null == mappingStringToDEEvents) {
            mappingStringToDEEvents = new HashMap<>();
            for (DEEvents eventsEnum : values()) {
                mappingStringToDEEvents.put(eventsEnum.getEvent(), eventsEnum);
            }
        }
    }
    
    /**
     * Método para convertir de cadena a enum
     * @param value El valor a convertir
     * @return El valor del enum que corresponde a la cadena
     */
    public static DEEvents getEnumFromString(String value) {
        // se inicializa por si acaso.
        initMapping();
        // se busca la cadena.
        if (mappingStringToDEEvents.containsKey(value)) {
            return mappingStringToDEEvents.get(value);
        }
        // si no se encuentra, regresar un objeto genérico
        return DLG_EV_UNKNOWN;
    }
    
}
