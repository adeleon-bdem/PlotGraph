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
 * com.studyscarlet.media.plotgraph.dialog.enums.DEButtons.
 * Esta enumeración representa...
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public enum DEButtons {
    
    /**
     * El valor del botón aceptar.
     */
    DLG_ACCEPT(DEResults.RES_ACCEPT),
    
    /**
     * El valor del botón cancelar.
     */
    DLG_CANCEL(DEResults.RES_CANCEL),
    
    /**
     * El valor del botón ignorar.
     */
    DLG_IGNORE(DEResults.RES_IGNORE),
    
    /**
     * El valor cuando no hay botón.
     */
    DLG_UNKNOWN(DEResults.RES_UNKNOWN);

    private final DEResults result;
    
    private DEButtons(DEResults result) {
        this.result = result;
    }

    public DEResults getResults() {
        return result;
    }

    /**
     * Un mapa privado para asociar los códigos a los elementos de la enumeración.
     */
    private static Map<Integer, DEButtons> mappingIntToDEButtons;
    
    /**
     * Método para inicializar el mapa de cadenas a elementos de la enumeración.
     */
    private static void initMapping() {
        if (null == mappingIntToDEButtons) {
            mappingIntToDEButtons = new HashMap<>();
            for (DEButtons dEButtonsEnum : values()) {
                mappingIntToDEButtons.put(dEButtonsEnum.getResults().getResult(), dEButtonsEnum);
            }
        }
    }
    
    /**
     * Método para convertir de cadena a enum
     * @param value El valor a convertir
     * @return El valor del enum que corresponde a la cadena
     */
    public static DEButtons getEnumFromInteger(int value) {
        // se inicializa por si acaso.
        initMapping();
        // se busca la cadena.
        if (mappingIntToDEButtons.containsKey(value)) {
            return mappingIntToDEButtons.get(value);
        }
        // si no se encuentra, regresar un objeto genérico
        return DLG_UNKNOWN;
    }   
    
}
