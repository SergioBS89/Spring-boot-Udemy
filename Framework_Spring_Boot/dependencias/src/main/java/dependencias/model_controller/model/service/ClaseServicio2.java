package dependencias.model_controller.model.service;

import org.springframework.stereotype.Component;

// PARA COMPARTIR UN COMPONENTE EN OTRAS PARTES DEL PROYECTO, USAMOS LAS NOTACIÓN DE @COMPONENT o @SERVICE (Hacen lo mismo)
@Component("miServicio-B")//Indicamos un nombre del componente
public class ClaseServicio2 implements IClaseServicio {

    public String operacion(){

        return "Ejecutando algun servicio";
    }

    //Metodo que se implementa en la INTERFACE
    @Override
    public String operacionInterface(){
        return "Ejecutando desde una interface el proceso B";
    }
  
  
    
}