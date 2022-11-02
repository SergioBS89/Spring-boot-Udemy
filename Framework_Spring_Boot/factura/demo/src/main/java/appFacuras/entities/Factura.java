package appFacuras.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Creamos el componente
@Component
public class Factura {

    @Value("${f.desc}")
 private String descripcion;
 //Injeccion de dependencia
 @Autowired
 private Cliente cliente;

 //Injecto el componenete BEAN creado en appConfig
@Autowired
@Qualifier("office")
 private List<Lista> list;
    





    /**
     * @return String return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return Cliente return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return List<DescProducto> return the list
     */
    public List<Lista> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Lista> list) {
        this.list = list;
    }

}