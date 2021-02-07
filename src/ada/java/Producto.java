package ada.java;

public class Producto {
    private String nombre;
    private String descripcion;
    private Double precioUnitario;
    private String clasificacion;
    private Integer stock;

    public Producto(String nombre, String descripcion, Double precioUnitario, String clasificacion,Integer stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.clasificacion = clasificacion;
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void sacarStock(Integer stock) {
        this.stock -= stock;
    }

    public void agregarStock(Integer stock) {
        this.stock += stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void mostrarDatos(){
        System.out.printf("%-20s%-15s%5.2f$",nombre,clasificacion,precioUnitario);
    }

    public void mostrarDatosConStock(){
        System.out.printf("%-20s%-15s%5.2f$%5d",nombre,clasificacion,precioUnitario, stock);
    }

    public static void mostrarDatosEncabezado(){
        System.out.printf("%-20s%-15s%-7s","Nombre","Clasificación","Precio");
    }

    public static void mostrarDatosEncabezadoConStock(){
        System.out.printf("%-20s%-15s%-7s%-5s","Nombre","Clasificación","Precio", "Stock");
    }
}
