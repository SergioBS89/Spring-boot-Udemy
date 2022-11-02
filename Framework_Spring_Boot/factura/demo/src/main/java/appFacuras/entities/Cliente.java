package appFacuras.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Creamos el componente
@Component
public class Cliente {
  
    //Definimos en el property los dos atributos
    @Value("${cliente.nombre}")
    private String nombre;
    @Value("${cliente.apellidos}")
    private String apellidos;
    

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

}