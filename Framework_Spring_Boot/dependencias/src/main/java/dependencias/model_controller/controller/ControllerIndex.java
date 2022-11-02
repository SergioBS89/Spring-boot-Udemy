package dependencias.model_controller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dependencias.model_controller.model.service.ClaseServicio;
import dependencias.model_controller.model.service.IClaseServicio;

@Controller
public class ControllerIndex {

    // CREANDO UNA INSTANCIA DEL OBJETO SERVICIO (DEL MODELO), PARA INTERACTUAR CON LA VISTA,SIN INYECCION DE DEPENDECIAS (NO RECOMENDABLE)
    private ClaseServicio miServicio = new ClaseServicio();

    //CREANDO UNA INSTANCIA DEL OBJETO SERVICIO, INYECTANDO LA DEPENDENCIA 
    @Autowired //Anotecion para inyeccion de dependencias
    private ClaseServicio miServicioInyection;

    //CREANDO UNA INSTANCIA DEL OBJETO MEDIANTE INTERFACE, PARA EVITAR REDUNDANCIA-ACOPLAMIENTO Y SER MAS ABSTRACATOS  (RECOMENDABLE!!!!)
    @Autowired//Anotecion para inyeccion de dependencias
    private IClaseServicio miServivioInterface;

    //CREANDO UNA INSTANCIA DEL OBJETO MEDIANTE INTERFACE, USANDO EL CONSTRUCTOR DE LA CLASE
    @Autowired
    @Qualifier("miServicio-B") //AL TENER DOS CLASES CON UNA MISMA INTERFACE, SE USA ESTA NOTACION PARA ELEGIR ENTRE UNA U OTRA
    private IClaseServicio miServicioConstructor;
    //PODEMOS ENVIAR A LA VISTA LOS DATOS DESDE UN CONSTRUCTOR    
    public ControllerIndex(IClaseServicio cs){
        this.miServicioConstructor = cs;
    }

     //CREANDO UNA INSTANCIA DEL OBJETO Y USANDO COMPONENTE CREADO COMO BEAN EN APPCONFIG.JAVA
     @Autowired
     @Qualifier("miServicio-C") //AL TENER DOS CLASES CON UNA MISMA INTERFACE, SE USA ESTA NOTACION PARA ELEGIR ENTRE UNA U OTRA
     private IClaseServicio miServicioBean;

    @GetMapping({"/","","index"})
    public String index(Model model){
        
        //Envio de los datos a la vista de los dos objetos 
        model.addAttribute("servicio",miServicio.operacion());
        model.addAttribute("servicioInyec",miServicioInyection.operacion());
        model.addAttribute("servicioInter",miServivioInterface.operacionInterface());
        model.addAttribute("servicioConst",miServicioConstructor.operacionInterface());
        model.addAttribute("servicioBean",miServicioBean.operacionInterface());
        
        return "index";
    }

    
}