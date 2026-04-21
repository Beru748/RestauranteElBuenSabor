package dominio;
import java.util.List;

public class Proceso {

    private static final double PORCENTAJE_DESCUENTO = 0.05;
    private static final double PORCENTAJE_IVA = 0.19;
    private static final double UMBRAL_PROPINA = 50000;
    private static final double PORCENTAJE_PROPINA = 0.10;
    private static final int MIN_PRODUCTOS_DESCUENTO = 3;

    public static double calcularTotalFactura(List<Producto> pedido) {
        double subTotal = 0; 
        int cantidadProductos = 0;

        for (Producto p : pedido) {
            if (p.getCantidad() > 0) {
                subTotal += p.getSubtotal();
                cantidadProductos++;
            }
        }
        
        if (cantidadProductos > MIN_PRODUCTOS_DESCUENTO) {
            subTotal -= (subTotal * PORCENTAJE_DESCUENTO);
        }

        double totalConIva = subTotal + (subTotal * PORCENTAJE_IVA);

        double totalFinal = totalConIva;
        if (subTotal > UMBRAL_PROPINA) {
            totalFinal += (totalConIva * PORCENTAJE_PROPINA);
        }

        return totalFinal;
    }

    public static double procesar(double precioBase, double cantidad, double descuento, 
                double iva, double propina, int cantProductos, boolean aplicaPropina) {
        double total = precioBase * cantidad;
        
        if (descuento > 0) {
            total -= (total * descuento);
        }
        
        total += (total * iva);
        
        if (aplicaPropina) {
            total += (total * propina);
        }
        
        if (cantProductos > MIN_PRODUCTOS_DESCUENTO) {
            total -= (total * 0.01);
        }
        
        return total;
    }
}
