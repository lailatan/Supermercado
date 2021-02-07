package ada.java;
/*
	En una cadena de supermercados se manejan distintos tipos de productos:
		comidas, artículos de limpieza, bazar, librería y perfumería.
	Cada producto tiene un nombre, una descripción y precio unitario.

	Se desea crear un carrito de compras online en el que los clientes puedan seleccionar los productos a comprar
	(cantidad por producto).
	El sistema debe informar el precio total de la compra.
	Nota: los jubilados tienen un 15% de descuento.
	Nota2: si es el cumpleaños del cliente, tiene un 10% de descuento adicional.

Tarea adicional para el Supermercado:
a) Permitir borrar o actualizar ítems del carrito.
b) Permitir listar todos los productos disponibles.
c) Permitir filtrar por categoría de producto.
d) Los productos tienen un stock. Sólo mostrar los productos con stock.
e) Cuando se agrega un producto al carrito de un cliente, cambiar el stock.
f) Permitir consultar los descuentos aplicados a un cliente en particular: Tipo y monto.
g) Permitir consultar el precio sin descuento.

*/

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Supermercado supermercado;

        List<Cliente> clientes = new ArrayList<>();

        clientes.add(new Cliente("pablo", LocalDate.of(2020,9,01),false));
        clientes.add(new Cliente("eric", LocalDate.of(2019,1,30),true));
        clientes.add(new Cliente("ana", LocalDate.of(2015,2,7),false));
        clientes.add(new Cliente("samantha", LocalDate.of(2010,2,7),true));

        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("banana","desc",20.0,"comidas",100));
        productos.add(new Producto("manzana","desc",25.0,"comidas",100));
        productos.add(new Producto("plato","desc",80.0,"bazar",100));
        productos.add(new Producto("lavandina","desc",15.0,"limpieza",100));

        clientes.get(0).agregarItem(10, productos.get(1));
        clientes.get(0).agregarItem(25, productos.get(0));
        clientes.get(1).agregarItem(20, productos.get(0));

        clientes.get(0).modificarItem(55, productos.get(0));
        clientes.get(0).agregarItem(2, productos.get(3));
        clientes.get(0).borrarItem( productos.get(1));

        clientes.get(2).agregarItem(101, productos.get(2));
        clientes.get(2).agregarItem(10, productos.get(3));

        clientes.get(3).agregarItem(1, productos.get(2));
        clientes.get(3).agregarItem(10, productos.get(3));

        supermercado = new Supermercado(clientes,productos);

        System.out.println("************************************************************************");
        System.out.println("        LISTADO COMPRA CLIENTE");
        System.out.println("************************************************************************");
        supermercado.listarComprasClientes();

        System.out.println("************************************************************************");
        System.out.println("        LISTADO PRODUCTOS");
        System.out.println("************************************************************************");
        supermercado.listarProductos();

        System.out.println("************************************************************************");
        System.out.println("        LISTADO PRODUCTOS CATEGORIA BAZAR");
        System.out.println("************************************************************************");
        supermercado.listarProductosPorCategoria("bazar");

        System.out.println("************************************************************************");
        System.out.println("        LISTADO PRODUCTOS CON STOCK");
        System.out.println("************************************************************************");
        supermercado.listarProductosConStock();
    }

}
