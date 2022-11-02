package formularios.demo.models.entities;

public class Habilidades {
    
    private Integer id;
    private String poderFuerza;
    private String usoArmasFuego;
    private String usoSable;

    
    public Habilidades() {
    }

    public Habilidades(Integer id, String poderFuerza, String usoArmasFuego, String usoSable) {
        this.poderFuerza = poderFuerza;
        this.usoArmasFuego = usoArmasFuego;
        this.usoSable = usoSable;
        this.id = id;
    }

    /**
     * @return String return the poderFuerza
     */
    public String getPoderFuerza() {
        return poderFuerza;
    }

    /**
     * @param poderFuerza the poderFuerza to set
     */
    public void setPoderFuerza(String poderFuerza) {
        this.poderFuerza = poderFuerza;
    }

    /**
     * @return String return the usoArmasFuego
     */
    public String getUsoArmasFuego() {
        return usoArmasFuego;
    }

    /**
     * @param usoArmasFuego the usoArmasFuego to set
     */
    public void setUsoArmasFuego(String usoArmasFuego) {
        this.usoArmasFuego = usoArmasFuego;
    }

    /**
     * @return String return the usoSable
     */
    public String getUsoSable() {
        return usoSable;
    }

    /**
     * @param usoSable the usoSable to set
     */
    public void setUsoSable(String usoSable) {
        this.usoSable = usoSable;
    }


    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

}