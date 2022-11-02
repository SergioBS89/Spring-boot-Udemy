package formularios.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formularios.demo.editores.HabilidadesPropertiesEditor;
import formularios.demo.editores.MayusculasEditor;
import formularios.demo.models.entities.Habilidades;
import formularios.demo.models.entities.StarWars;
import formularios.demo.services.HabilidadesImplementacion;

@Controller
public class FormController {

    /* -------------------------------------------------------------------------- */
    /*          USANDO COMPONENTES PARA LISTAR HABILIDADES (INSTANCIAS)         */
    /* -------------------------------------------------------------------------- */
    @Autowired
    private HabilidadesImplementacion habilidadesImpl;

    @Autowired 
    private HabilidadesPropertiesEditor habilidadesProper;

    /* -------------------------------------------------------------------------- */
    /* ASIGNACION DE INIT BINDER */
    /* -------------------------------------------------------------------------- */
    // Esta anotacion es usada para customizar diferentes formatos ya sean fechas,
    // validadores o conversiones enviadas por el usuario
    @InitBinder
    public void InitBinder(WebDataBinder wd) {
        /* ------------------- COSTUMIZANDO EL FORMATO DE LA FECHA ------------------ */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);//Formato extricto 
        //(parametro 1= tipo, parametro 2 = Instancia de customizador de fechas)
        wd.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

        /* ------------ MODIFICANDO RESULTADO DE STRINGS EN EL FORMULARIO ----------- */
        // (parametro 1 = tipo, parametro 2 = atributo clase 'opcional', parametro 3 =
        // instancia de la regla)

        // En este ejemplo, convertimos en mayusculas todos los strings del formulario
        // wd.registerCustomEditor(String.class, new MayusculasEditor());

        // En este ejemplo, convertimos en mayusculas unicamente el campo personaje
        // formulario
        wd.registerCustomEditor(String.class, "personaje", new MayusculasEditor());
        wd.registerCustomEditor(Habilidades.class, habilidadesProper);
    }

    /* -------------------------------------------------------------------------- */
    /*                  RELLENANDO UN SELECT OPTION DINAMICAMENTE                 */
    /* -------------------------------------------------------------------------- */
    //Normamente hacemos una peticion a la base de datos para rellenar los option, en este ejmplo creamos un arrayList con diferentes
    //opciones para ver el funcionamiento

    @ModelAttribute("listaColores") //Esta anotacion permite mandar a la vista difernetes metodos y datos
    public List<String> listaColores(){
        return Arrays.asList("rojo","verde","lila","azul", "no tiene sable....");
    }
    
    /* ------------------- SELECT OPTION CON MAP (KEY & VALUE) ------------------ */
    @ModelAttribute("listaPlanetas") //Esta anotacion permite mandar a la vista difernetes metodos y datos (usar en th:)
    public Map<String,String> planetas(){

        Map<String,String> planet = new HashMap<String,String>();

        planet.put("COR", "Coruscant");
        planet.put("TAT", "Tatooine");
        planet.put("NAB", "Naboo");
        planet.put("EST", "Estrella de la muerte");
        planet.put("MUS", "Mustafar");
        planet.put("ALD", "Alderaan");
        planet.put("KAM", "Kamino");
         
        return planet;
    }

     /* -------------------------------------------------------------------------- */
    /*                  RELLENANDO UN SELECT OPTION CON INSTANCIAS                */
    /* -------------------------------------------------------------------------- */
    //Normamente hacemos una peticion a la base de datos para rellenar los option, en este ejmplo creamos un arrayList con diferentes
    //instancias de la clase Habilidades y usando un componenete para listar las instancias con sus respectivos atributos en la vista

    @ModelAttribute("listaHabilidades") //Esta anotacion permite mandar a la vista difernetes metodos y datos
    public List<Habilidades> listaHabilidades(){
        return habilidadesImpl.lista();
    }

    /* -------------------------------------------------------------------------- */
    /*                        CHECKBOX CON ARRAY DE STRINGS                       */
    /* -------------------------------------------------------------------------- */

    @ModelAttribute("listaRoles")
    public List<String> listaRoles(){
        List<String> roles = new ArrayList<>();

        roles.add("HEROE");
        roles.add("VILLANO");
        roles.add("ANDROIDE");
        roles.add("CONTRABANDISTA");

        return roles;
    }
    


    /* -------------------------------------------------------------------------- */
    /* FORMULARIO STANDART SIMPLE, TOMA LOS DATOS DE LA URL*/
    /* -------------------------------------------------------------------------- */
    @GetMapping("/form")
    public String formulario(Model model) {
        model.addAttribute("titulo", "Formulario para el envio de datos MVC");
        return "formulario";
    }

    @PostMapping("/form")
    // CAPTURO DE LA URL LOS PARAMETROS ENVIADOS CON EL FORMULARIO
    public String resultadoForm(Model model, @RequestParam String username, @RequestParam String pass,
            @RequestParam String email, @RequestParam String age) {

        // Paso la instancia de la clase a la vista para usar los validadores de spring
        // boot
        StarWars starWars = new StarWars();
        model.addAttribute("sw", starWars);

        model.addAttribute("user", username);
        model.addAttribute("password", pass);
        model.addAttribute("email", email);
        model.addAttribute("age", age);
        return "resultado";
    }

    /* -------------------------------------------------------------------------- */
    /* FORMULARIO CON CLASES */
    /* -------------------------------------------------------------------------- */

    // FORMULARIO QUE ENVIA LOS DATOS (ATRIBUTOS DE UNA INSTANICA)
    // Super importante que los parametros de la vista(name o th:field del
    // formulario)sean iguales a los atributos de la clase

    @GetMapping("/form/starWars")
    public String formularioStarWars(Model model) {

        StarWars starWars = new StarWars();
        // Modifico datos del objeto para mostralos en la vista
        starWars.setGenero("Por ver");

        // Es importante recordar, que para el uso de thymeleaf con instancias, hay que
        // pasarlas del controlador a la vista
        model.addAttribute("sw", starWars);
        return "formStarWars";
    }

    @PostMapping("/form/starWars")
    // Notacion @Valid para la validacion de los campos
    // SUPER IMPORTANTE: EL CONTROLADOR NECESITA LA ANOTACION @MODEL ATRIBUTE CON EL
    // NOMBRE DE LA ETIQUETA QUE USAMOS EN LA VISTA (sw) COMO TH:OBJECT
    // BindigResult tambien se usa para comprobar los campos y sus validaciones
    // (IMPORTANTE: el binding result a de colocarse como
    // argumento justo despues del Objeto que validamos, en este caso despues de
    // starwars)

    public String resultadoStarWars(@Valid @ModelAttribute("sw") StarWars starWars, BindingResult br, Model model) {

        model.addAttribute("sw", starWars);

        /* --------------------- VALIDACION DE CAMPOS FORMULARIO -------------------- */
        if (br.hasErrors()) {

            // FORMA MANUAL DE VALIDACION DE ERRORES (CON SPRING BOOT YA NO ES NECESARIO)
            // Map<String,String> errores = new HashMap<>();
            // br.getFieldErrors().forEach(err ->{
            // errores.put(err.getField(), "El campo ".concat(err.getField()).concat("
            // ").concat(err.getDefaultMessage()));
            // });
            // model.addAttribute("error", errores);
            return "formStarwars"; // SI hay error en la validacion, retorna la vista al formulario
        }

        // Muestro el valor ID en resultado.html, valor que no ha sido enviado desde el
        // formulario(para mostrar datos)
        starWars.setId("id_3421");

        // PREGUNTO SI ES TRUE O FALSE EL ATRIBUTO JEDI (es boolean), para retornar una
        // respuesta
        if (starWars.isJedi()) {
            model.addAttribute("isJedi", "Es un Jedi o un Sith");
        } else {
            model.addAttribute("isJedi", "No es ni Jedi ni Sith...lastima");
        }

        return "resultado";
    }

}