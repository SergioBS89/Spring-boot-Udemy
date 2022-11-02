package appFacuras;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Primary;
import appFacuras.entities.Lista;
import appFacuras.entities.Producto;

@Configuration
public class AppConfig {

    /* -------------------------------------------------------------------------- */
    /*                             COMPONENETE BEAN 1                             */
    /* -------------------------------------------------------------------------- */

    //Creo el componente de LIST de los productos (Nombre y precio) que estan en la factura (cantidad)
    @Bean("gym")
    // @Primary
    public List<Lista> registrarListaGym(){

        //creo dos instancias de productos
        Producto pro1 = new Producto("Pesa Rusa", 200);
        Producto pro2 = new Producto("Tabla pesas", 500);
        
        //Creo dos instancias de lista de productos con los anteriores productos
        Lista d1 = new Lista(pro1, 2);
        Lista d2 = new Lista(pro2, 3);
             
       return Arrays.asList(d1,d2);
    }

         /* -------------------------------------------------------------------------- */
    /*                             COMPONENETE BEAN 2                          */
    /* -------------------------------------------------------------------------- */

    //Creo el componente de LIST de los productos (Nombre y precio) que estan en la factura (cantidad)
    @Bean("office")
    public List<Lista> registrarListaOffice(){

        //creo dos instancias de productos
        Producto pro1 = new Producto("Silla ergo", 100);
        Producto pro2 = new Producto("Monitor LCD",209);
        
        //Creo dos instancias de lista de productos con los anteriores productos
        Lista d1 = new Lista(pro1, 10);
        Lista d2 = new Lista(pro2, 20);
             
       return Arrays.asList(d1,d2);
    }
    
}