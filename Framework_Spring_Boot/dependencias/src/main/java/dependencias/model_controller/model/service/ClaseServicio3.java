package dependencias.model_controller.model.service;

/* -------------------------------------------------------------------------- */
/*       PODEMOS CRREAR NUESTROS PROPIOS COMPONENTES CONOCIDOS COMO BEAN SIN NECESIDAD DE NOTACIONES  */
/* -------------------------------------------------------------------------- */
//IMPORTANTE CONFIGURAR EL COMPONENTE PERSONAL, ANTES DE USARLO (AppConfig.java)
// @Component("miServicio-B")
public class ClaseServicio3 implements IClaseServicio {  

    //Metodo que se implementa en la INTERFACE
    @Override
    public String operacionInterface(){
        return "Ejecutando desde una interface el proceso C (uso de @Bean)";
    }
  
  
    
}