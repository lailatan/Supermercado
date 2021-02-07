package ada.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Item> items;
    private String nombre;
    private Boolean jubilado;
    private LocalDate fechaNacimiento;

    public Cliente(String nombre, LocalDate fechaNacimiento, Boolean jubilado) {
        this.items = new ArrayList<>();
        this.nombre = nombre;
        this.jubilado = jubilado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Item> getItems() {
        return items;
    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getJubilado() {
        return jubilado;
    }

    public void agregarItem(int cantidad, Producto producto){
        //Asumo que si el stock es menor a lo que el cliente quiere, lleva lo que hay,
        //Queda en 0 la cantidad si no hay stock para no generar errores.
        if (producto.getStock()<cantidad) cantidad=producto.getStock();
        items.add(new Item(cantidad, producto));
        producto.sacarStock(cantidad);
    }

    public void modificarItem(int cantidad, Producto producto){
        for (Item item : items){
            if (item.getProducto().equals(producto)) {
                if (item.getCantidad()>cantidad) producto.agregarStock(item.getCantidad()-cantidad);
                else producto.sacarStock(cantidad-item.getCantidad());
                item.setCantidad(cantidad);
                break;
            }
        }
    }

    public void borrarItem(Producto producto){
        for (Item item : items){
            if (item.getProducto().equals(producto)) {
                producto.agregarStock(item.getCantidad());
                items.remove(item);
                break;
            }
        }
    }

    public Double calcularTotalNeto(){
        Double total = calcularTotalBruto();
        Integer descuento = Integer.parseInt(calcularTipoDescuento()[0]);
        return total -= total * descuento/100;
    }

    public Double calcularTotalBruto(){
        Double total = 0.0;
        for(Item i: items)
            total += i.getCantidad() * i.getProducto().getPrecioUnitario();
        return total;
    }

    public Double calcularTotalDescuento(){
        return calcularTotalBruto() -  calcularTotalNeto();
    }

    public String[] calcularTipoDescuento(){
        Integer descuento = 0;
        String descuentotxt = "";

        if(jubilado) {
            descuento = 15;
            descuentotxt = "Jubilado";
        }

        LocalDate hoy = LocalDate.now();
        int esteAnio = hoy.getYear();
        int mesCumple = fechaNacimiento.getMonthValue();
        int diaCumple = fechaNacimiento.getDayOfMonth();
        Boolean cumpleAnios = hoy.equals(LocalDate.of(esteAnio,mesCumple, diaCumple));
        if(cumpleAnios) {
            if (descuentotxt!="") descuentotxt += " + ";
            descuentotxt += "Cumpleaños";
            descuento += 10;
        }
        String[] descuentos =  {descuento.toString(),(descuentotxt==""?"No Corresponde":descuentotxt)};
        return descuentos;
    }

    public void mostrarDatos(){
        System.out.print("Cliente: " + nombre + "      ");
        System.out.print(" F.N.:" + fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "      ");
        System.out.print("Jubilado: " + (jubilado?"Si":"No"));
        System.out.println();
        Item.mostrarDatosEncabezado();
        for (Item item: items){
            item.mostrarDatos();
        }
        System.out.print("Total Bruto: " + calcularTotalBruto() + "$");
        System.out.println("            Total Neto: " + calcularTotalNeto() + "$");
        String[] descuento =  calcularTipoDescuento();
        System.out.print("Descuento aplicado: " + calcularTotalDescuento() + "$");
        System.out.println("      Tipo: " +  descuento[1] + " ("+ descuento[0] + "%)");

    }
}
