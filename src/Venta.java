import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta {
    private int idVenta;
    private ArrayList<Producto> productosVendidos;
    private double totalVenta;
    private LocalDateTime fechaHora;

    public Venta(int idVenta) {
        this.idVenta = idVenta;
        this.productosVendidos = new ArrayList<>();
        this.totalVenta = 0.0;
        this.fechaHora = LocalDateTime.now();
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getCantidadEnStock() >= cantidad) {
            producto.actualizarStock(-cantidad);
            productosVendidos.add(new Producto(producto.getId(), producto.getNombre(), producto.getDescripcion(), producto.getPrecio(), cantidad));
            totalVenta += producto.getPrecio() * cantidad;
        } else {
            System.out.println("Stock insuficiente para el producto: " + producto.getNombre());
        }
    }

    public double calcularTotal() {
        return totalVenta;
    }

    public String toString() {
        StringBuilder detalleVenta = new StringBuilder("ID Venta: " + idVenta + "\nFecha y Hora: " + fechaHora + "\nProductos Vendidos:\n");
        for (Producto p : productosVendidos) {
            detalleVenta.append(p.toString()).append("\n");
        }
        detalleVenta.append("Total: $").append(totalVenta);
        return detalleVenta.toString();
    }
}

