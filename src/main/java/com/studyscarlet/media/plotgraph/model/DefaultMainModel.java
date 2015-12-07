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

import com.studyscarlet.media.plotgraph.interfaces.IController;
import java.util.ArrayList;
import java.util.List;

/**
 * com.studyscarlet.media.plotgraph.model.DefaultMainModel.
 * Esta clase representa...
 *
 * @author Angel Emilio de Le&oacute;n Guti&eacute;rrez (adeleon.bdem@gmail.com)
 * @version 1.0
 * @since 1.0
 */
public class DefaultMainModel extends DefaultModel {
    
    /**
     * Para el serializado.
     */
    private static final long serialVersionUID = 678085481715887126L;

    /**
     * Lista de los controladores internos.
     */
    private final List<IController> controllers = new ArrayList<>();
    
    /**
     * Método para buscar un controller del tipo especificado por la clase.
     * @param claseController La clase del controller a buscar.
     * @return El primer objeto de este tipo que se encuentre, o null si no
     * existe un objeto de este tipo.
     */    
    public IController searchController(Class<? extends IController> claseController) {
        // Buscar el controller dentro de la lista.
        for (IController controller : controllers) {
            if (controller.getClass().isAssignableFrom(claseController))
                return controller;
        }
        return null;
    }
    
    /**
     * Método para agregar un objeto de tipo derivado de RSP_Controller
     * @param controller El controlador que se va a agregar.
     * @return 
     */
    public IController addController(IController controller) {
        return addController(controller, controller.getClass());
    }
   
    /**
     * Método para agregar un controlador, dada la clase que se quiere 
     * instanciar.
     * @param claseController La clase del controlador que se quiere agregar.
     * @return El objeto añadido de la clase del controlador
     */
    public IController addController(Class<? extends IController> claseController) {
        try {
            logger.debug("Dentro de addController");
            logger.debug("Buscando instancia de tipo {}", claseController.getName());
            IController controller = searchController(claseController);
            if (null == controller) {
                logger.debug("Instancia no encontrada!");
                logger.debug("Creando nueva instancia:");
                controller = claseController.newInstance();
                logger.debug("Nueva instancia creada: {}", controller);
                logger.debug("Agregando instancia a la lista de controladores");
                controllers.add(controller);
            } 
            // si la búsqueda lo encuentra, regresar esa instancia,
            // si no la encuentra, agregar una nueva instancia.
            return controller;
        } catch (InstantiationException | IllegalAccessException exception) {
            logger.error("Error al instanciar un objeto de clase {}: {}", 
                    claseController.getName(), exception.getMessage());
            return null;
        }
    }    
    
    /**
     * Método para agregar un controlador a la lista de controladores.
     * Sólo se permite un controlador nuevo por cada clase de controladores.
     * @param controller El controlador a agregar.
     * @param claseController La clase del controlador a agregar.
     * @return El objeto controlador agregado, o el controlador existente.
     */
    public IController addController(IController controller, Class<? extends IController> claseController) {
        // Validar que el controlador sea de la clase dada
        if (!controller.getClass().isAssignableFrom(claseController)) {
            logger.error("El objeto controlador es de clase {} "
                    + "y no es asignable desde la clase {}", 
                    controller.getClass().getName(), 
                    claseController.getName());
        }
        IController theController = searchController(claseController);
        if (null != theController) {
            return theController;
        }
        controllers.add(controller);
        return controller;
    }
       
    /**
     * Método para eliminar el controlador de la lista de controladores
     * @param claseController La clase del controlador a eliminar. En teoría
     * solo hay una instancia de esta clase.
     * @return Verdadero si la pudo remover, falso en otro caso.
     */
    public boolean removeController(Class <? extends IController> claseController) {
        IController controller = searchController(claseController);
        if (null != controller) {
            controllers.remove(controller);
            return true;
        }
        return false;
    }    
    
    public void removeAllControllers() {
        controllers.clear();
    }
    
}
