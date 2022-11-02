package appFacuras.entities;

public class Lista{

    private Producto producto;
    private Integer cantidad;
    
    public Lista(Producto producto, Integer cantidad){
        this.producto = producto;
        this.cantidad =cantidad;
    }
    

    /**
     * @return Producto return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return int return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Integer sumaTotal(){

        return producto.getPrecio() * cantidad;
    }

}