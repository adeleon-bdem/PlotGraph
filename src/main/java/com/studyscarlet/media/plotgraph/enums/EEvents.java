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

package com.studyscarlet.media.plotgraph.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * com.studyscarlet.media.plotgraph.enums.EEvents.
 * Esta enumeración representa los eventos del cliente.
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public enum EEvents {
    
    // Acerca de
    EV_ABOUT("ev:about", "Acerca de", "Muestra la ventana de acerca de"),
    
    // Cerrar el diálogo del about.
    EV_CLOSE_ABOUT("ev:about:close", "Cerrar", "Cerrar el diálogo del acerca de"),
    
    // Salir
    EV_QUIT("ev:quit", "Salir", "Sale de la aplicación"),

    // Evento desconocido
    EV_UNKNOWN("ev:unknown", "unknown", "unknown");
    
    /**
     * El valor de este evento.
     */
    private final String value;
    
    /**
     * La etiqueta de este evento.
     */
    private final String label;
    
    /**
     * El tooltip de este evento.
     */
    private final String tooltip;

    private EEvents(String value, String label, String tooltip) {
        this.value = value;
        this.label = label;
        this.tooltip = tooltip;
    }

    /**
     * Getter para recuperar el valor del evento.
     * @return El valor del evento.
     */
    public String getValue() {
        return value;
    }

    /**
     * Getter para recuperar la etiqueta del evento.
     * @return La etiqueta del evento.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Getter para recuperar el tooltip del evento.
     * @return El tooltip del evento.
     */
    public String getTooltip() {
        return tooltip;
    }

    @Override
    public String toString() {
        return value;
    }
    
    /**
     * Un mapa privado para asociar las cadenas a los elementos de la enumeración.
     */
    private static Map<String, EEvents> mappingStringToEEvents;
    
    /**
     * Método para inicializar el mapa de cadenas a elementos de la enumeración.
     */
    private static void initMapping() {
        if (null == mappingStringToEEvents) {
            mappingStringToEEvents = new HashMap<>();
            for (EEvents eventsEnum : values()) {
                mappingStringToEEvents.put(eventsEnum.getValue(), eventsEnum);
            }
        }
    }
    
    /**
     * Método para convertir de cadena a enum
     * @param value El valor a convertir
     * @return El valor del enum que corresponde a la cadena
     */
    public static EEvents getEnumFromString(String value) {
        // se inicializa por si acaso.
        initMapping();
        // se busca la cadena.
        if (mappingStringToEEvents.containsKey(value)) {
            return mappingStringToEEvents.get(value);
        }
        // si no se encuentra, regresar un objeto genérico
        return EV_UNKNOWN;
    }
    
}
