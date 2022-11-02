package appFacuras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import appFacuras.entities.Factura;

@Controller
@RequestMapping("/bill")  //http://localhost:8080/bill/show     URL para ver el programa
public class FacturaController {

    //Injeccion de la dependencia de factura
    @Autowired 
    private Factura factura;

    @GetMapping("/show")
    public String mostrarFacura(Model model){
        
        model.addAttribute("titulo", "Detalles de la factura");
        model.addAttribute("factura", factura);

        return "/ver";
    }
 
     
    
}