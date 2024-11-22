import java.util.ArrayList;

public class Informe {
    public static void generarInformeVentas(ArrayList<Venta> ventas) {
        System.out.println("---- Informe de Ventas ----");
        for (Venta venta : ventas) {
            System.out.println(venta.toString());
            System.out.println("---------------------------");
        }
    }

    public static void generarInformeInventario(ArrayList<Producto> productos) {
        System.out.println("---- Informe de Inventario ----");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
    }
}

