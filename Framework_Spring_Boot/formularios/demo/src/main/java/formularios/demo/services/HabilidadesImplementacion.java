package formularios.demo.services;

import java.util.Arrays;
import java.util.List;


import org.springframework.stereotype.Service;

import formularios.demo.models.entities.Habilidades;

/* -------------------------------------------------------------------------- */
/*                             CRENDO COMPONENETE                             */
/* -------------------------------------------------------------------------- */

@Service
public class HabilidadesImplementacion implements IHabilidadesService {

    private List<Habilidades> lista;

    // Generamos el constructor con diferentes instancias de habilidades
    public HabilidadesImplementacion(List<Habilidades> lista) {
        this.lista = Arrays.asList(
                new Habilidades(1, "Excelente uso de la fuerza", "Excelente uso de armas de fuego",
                        "Uso de sable laser"),
                new Habilidades(2, "Bueno para el combate con armas de fuego, pero si armas", "Excelente uso de armas de fuego",
                        "No usa sable laser"),
                new Habilidades(3, "Completo inutil en el combate", "No maneja armas de fuego",
                        "No maneja sable laser"));
    }

    @Override
    public List<Habilidades> lista() {

        return this.lista;
    }

    @Override
    public Habilidades mostrar(Integer id) {

        // Itermos la lista en busca del id de cada instancia para posteriormente
        // mostrarlo en la vista
        Habilidades resultado = null;
        for (Habilidades habilidades : this.lista) {

            if (habilidades.getId() == id) {
                resultado = habilidades;
            }
        }
        return resultado;
    }

  

}