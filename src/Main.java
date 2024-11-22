import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        ArrayList<Venta> ventas = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        usuarios.add(new Usuario("admin", "admin123", "Administrador"));
        usuarios.add(new Usuario("vendedor1", "pass123", "Vendedor"));
        usuarios.add(new Usuario("gerente1", "gerente123", "Gerente"));

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- Sistema de Gestión de Inventario ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Ver Inventario");
            System.out.println("3. Realizar Venta");
            System.out.println("4. Generar Informes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();
                    System.out.print("Cantidad en stock: ");
                    int cantidad = scanner.nextInt();
                    productos.add(new Producto(id, nombre, descripcion, precio, cantidad));
                    System.out.println("Producto agregado correctamente.");
                    break;

                case 2:
                    Informe.generarInformeInventario(productos);
                    break;

                case 3:
                    System.out.print("ID de la venta: ");
                    int idVenta = scanner.nextInt();
                    Venta nuevaVenta = new Venta(idVenta);
                    boolean anadirProductos = true;

                    while (anadirProductos) {
                        System.out.print("ID del producto a vender: ");
                        int idProducto = scanner.nextInt();
                        Producto productoSeleccionado = null;

                        for (Producto p : productos) {
                            if (p.getId() == idProducto) {
                                productoSeleccionado = p;
                                break;
                            }
                        }

                        if (productoSeleccionado == null) {
                            System.out.println("Producto no encontrado.");
                        } else {
                            System.out.print("Cantidad a vender: ");
                            int cantidadVenta = scanner.nextInt();
                            nuevaVenta.agregarProducto(productoSeleccionado, cantidadVenta);
                        }

                        System.out.print("¿Desea agregar más productos a la venta? (1 = Sí, 0 = No): ");
                        anadirProductos = scanner.nextInt() == 1;
                    }

                    ventas.add(nuevaVenta);
                    System.out.println("Venta realizada correctamente.");
                    break;

                case 4:
                    Informe.generarInformeVentas(ventas);
                    break;

                case 5:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
