package dependencias.model_controller.model.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// PARA COMPARTIR UN COMPONENTE EN OTRAS PARTES DEL PROYECTO, USAMOS LAS NOTACIÓN DE @COMPONENT o @SERVICE (Hacen lo mismo)
@Component("miServicio-A")//IDENTIFICADOR DEL COMPONENTE
@Primary //Cuando tenemos varias clases que implementan desde una misma interfaz, necesitamos deferenciar los componentes de la clase
//con un identificador. Sin embargo, podemos poner por default (@primary), un componente y asi evitar controversia. 

public class ClaseServicio implements IClaseServicio {

    public String operacion(){

        return "Ejecutando algun servicio";
    }
    @Override
    public String operacionInterface(){
        return "Ejecutando desde una interface el proceso A";
    }
  
  
    
}