package formularios.demo.models.entities;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

// import org.springframework.format.annotation.DateTimeFormat;

public class StarWars {

    /* ---------- VALIDACION DE CAMPOS FORMULARIOS MEDIANTE NOTACIONES ---------- */

    // Si queremos que se muestre una instancia de la base de datos en el
    // formulario, podemos hacer lo siguiente:
    @NotEmpty(message = "EOOOOOOO")
    private String genero; // Desde el controlador, le damos un valor con set y se muestra en los input del
                           // formulario

    @NotEmpty // Valida que no este vacio el campo
    @Size(min = 3, max = 15) // Valida el largo de la cadena
    // @email tambien valida que el email introducido sea correcto
    private String personaje;

    @NotEmpty
    private String raza;
    
    @NotEmpty
    private List<String> roles;

    //Booleano para preguntar si el sujeto es un jedi
    private boolean jedi;


    // En el caso de querer mostrar un dato al cliente, pero que este no sea
    // modificado por el formulario (Ejem un ID), desde el controlador
    // lo paso a la vista en el postmapping
    private String id;

    /* ------------------------- VALIDANDO LISTAS SELECT ------------------------ */
    @NotEmpty
    private String sableLaser;

    /* -------------------------- EXPREIONES REGULARES -------------------------- */
    // Podemos validar con @Pattern
    @Pattern(regexp = "^[0-1]*$", message = "Ingresar solo ceros y unos")
    @NotEmpty
    private String binario;

    /* ---------------------------- CAMPOS NUMERICOS ---------------------------- */
    @Max(100)
    @Min(18)
    @NotNull
    private Integer edad;

    /* ---------------------------- VALIDANDO FECHAS ---------------------------- */
    @NotNull
    // @DateTimeFormat(pattern = "yyyy-MM-dd") Es similar al uso de INITBINDER en el
    // controlador
    @Past // Solo fechas anterires al dia actual
    private Date fechaNacimiento;

    @NotEmpty
    private String planeta;

    @NotNull(message = "Elije una habilidad!")
    private Habilidades habilidades;



    /* -------------------------------------------------------------------------- */
    /* GETTER AND SETTER */
    /* -------------------------------------------------------------------------- */

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isJedi() {
        return jedi;
    }

    public void setJedi(boolean jedi) {
        this.jedi = jedi;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return int return the binario
     */
    public String getBinario() {
        return binario;
    }

    /**
     * @param binario the binario to set
     */
    public void setBinario(String binario) {
        this.binario = binario;
    }

    /**
     * @return Integer return the edad
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return Date return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return String return the sableLaser
     */
    public String getSableLaser() {
        return sableLaser;
    }

    /**
     * @param sableLaser the sableLaser to set
     */
    public void setSableLaser(String sableLaser) {
        this.sableLaser = sableLaser;
    }


    /**
     * @return String return the planeta
     */
    public String getPlaneta() {
        return planeta;
    }

    /**
     * @param planeta the planeta to set
     */
    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }


    /**
     * @return Habilidades return the habilidades
     */
    public Habilidades getHabilidades() {
        return habilidades;
    }

    /**
     * @param habilidades the habilidades to set
     */
    public void setHabilidades(Habilidades habilidades) {
        this.habilidades = habilidades;
    }


    /**
     * @return List<String> return the roles
     */
    public List<String> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}