package dominio;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static final int MIN_PRODUCTOS_DESCUENTO = 3;
    private static final double PORCENTAJE_DESCUENTO = 0.05;
    private static final double PORCENTAJE_IVA = 0.19;
    private static final double UMBRAL_PROPINA = 50000;
    private static final double PORCENTAJE_PROPINA = 0.10;

    private int numeroMesa;
    private List<Producto> pedido;
    private boolean estado;

    public Pedido() {
        this.pedido = new ArrayList<>();
        this.estado = estado = false;
    }

    public void iniciarMesa(int numeroMesa){
        this.numeroMesa = numeroMesa;
        this.estado = true;
    }

    public int getNumeroMesa() {
        return numeroMesa; 
    }

    public boolean isEstado() { 
        return estado; 
    }

    public List<Producto> getPedido() { 
        return pedido;
    }

    public void agregarProducto(Producto producto, int cantidad){
        producto.agregarCantidad(cantidad);

        if (!pedido.contains(producto)) {
            pedido.add(producto);
        }
    }

    public boolean estaVacio(){
        if (pedido.isEmpty())return true;

        for (Producto producto : pedido) {
            if (producto.getCantidad() > 0) return false;
        }

        return true;
    }

    public void vaciar() {
        for (Producto p : pedido) {
            p.setCantidad(0);
        }
        this.pedido.clear();
        this.numeroMesa = 0;
        this.estado = false;
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (Producto p : pedido) {
            subtotal += p.getSubtotal();
        }
        return subtotal;
    }

    public int contarProductosDiferentes() {
        int contador = 0;
        for (Producto p : pedido) {
            if (p.getCantidad() > 0) contador++;
        }
        return contador;
    }

    public double calcularDescuento() {
        double subtotal = calcularSubtotal();
        if (contarProductosDiferentes() > MIN_PRODUCTOS_DESCUENTO) {
            return subtotal * PORCENTAJE_DESCUENTO;
        }
        return 0;
    }

    public double calcularIva() {
        double subtotalConDescuento = calcularSubtotal() - calcularDescuento();
        return subtotalConDescuento * PORCENTAJE_IVA;
    }

    public double calcularPropina() {
        double subtotalBase = calcularSubtotal();
        double totalConIva = (calcularSubtotal() - calcularDescuento()) + calcularIva();
        
        if (subtotalBase > UMBRAL_PROPINA) {
            return totalConIva * PORCENTAJE_PROPINA;
        }
        return 0;
    }

    public double calcularTotal() {
        double subtotalConDescuento = calcularSubtotal() - calcularDescuento();
        double iva = calcularIva();
        double propina = calcularPropina();
        
        return subtotalConDescuento + iva + propina;
    }
}
