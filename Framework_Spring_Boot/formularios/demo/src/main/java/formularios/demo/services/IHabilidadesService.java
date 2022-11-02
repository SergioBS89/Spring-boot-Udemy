package formularios.demo.services;

import java.util.List;

import formularios.demo.models.entities.Habilidades;



/* -------- CREAMOS UNA INTERFAZ PARA GENERAR LA LISTA DE HABILIDADES ------- */
// El uso de las interfaces Java proporciona las siguientes ventajas: Organizar la programación.
//  permiten declarar constantes que van a estar disponibles para todas las clases que queramos (implementando esa interfaz) 
//  Obligar a que ciertas clases utilicen los mismos métodos (nombres y parámetros).

public interface IHabilidadesService {
    public List<Habilidades> lista();
    public Habilidades mostrar(Integer id);
    
}