package ada.java;

import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private List<Cliente> clientes;
    private List<Producto> productos ;

    public Supermercado(List<Cliente> clientes, List<Producto> productos) {
        this.clientes = clientes;
        this.productos = productos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void listarComprasClientes(){
        for (Cliente c : clientes) {
            c.mostrarDatos();
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public void listarProductosPorCategoria(String categoria) {
        Producto.mostrarDatosEncabezadoConStock();
        System.out.println();
        for (Producto p : productos) {
            if (p.getClasificacion() == categoria) {
                p.mostrarDatosConStock();
                System.out.println();
            }
        }
    }

    public void listarProductos() {
        Producto.mostrarDatosEncabezadoConStock();
        System.out.println();
        for (Producto p : productos) {
            p.mostrarDatosConStock();
            System.out.println();
        }
    }

    public void listarProductosConStock() {
        Producto.mostrarDatosEncabezado();
        System.out.println();
        for (Producto p : productos) {
            if (p.getStock()>0) {
                p.mostrarDatos();
                System.out.println();
            }
        }
    }
}
