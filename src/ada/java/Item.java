package ada.java;

public class Item {
        private int cantidad;
        private Producto producto;

        public Item(int cantidad, Producto producto) {
                this.cantidad = cantidad;
                this.producto = producto;
        }

        public int getCantidad() {
                return cantidad;
        }

        public void setCantidad(int cantidad) {
                this.cantidad = cantidad;
        }

        public Producto getProducto() {
                return producto;
        }

        public void setProducto(Producto producto) {
                this.producto = producto;
        }

        public Double getTotal(){
                return cantidad * producto.getPrecioUnitario();
        }
        public void mostrarDatos(){
                System.out.printf("%-9d" , cantidad);
                producto.mostrarDatos();
                System.out.print("      ");
                System.out.printf("%7.2f$" , getTotal());
                System.out.println();
        }

        public static void mostrarDatosEncabezado(){
                System.out.printf("%-9s" , "Cantidad");
                Producto.mostrarDatosEncabezado();
                System.out.printf("     %-9s" , "SubTotal");
                System.out.println();
        }
}
