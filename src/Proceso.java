import java.util.ArrayList;
import java.util.List;

public class Proceso {

    private static final double PORCENTAJE_DESCUENTO = 0.05;
    private static final double PORCENTAJE_IVA = 0.19;
    private static final double UMBRAL_PROPINA = 50000;
    private static final double PORCENTAJE_PROPINA = 0.10;

    public static double calcularTotalFactura(List<Producto> pedido) {
    }

    public static double procesar(double a, double b, double c, double d, double e, int f, boolean g) {
        double res = 0;
        double iva = 0;
        double prop = 0;
        double tmp = 0;
        // calcula subtotal con cantidad
        res = a * b;
        if (c > 0) {
            // aplica descuento
            res = res - (res * c);
        }
        // calcula iva
        iva = res * d;
        tmp = iva;
        res = res + tmp;
        if (g) {
            // aplica propina si corresponde
            prop = res * e;
            res = res + prop;
        }
        if (f > 3) {
            res = res - (res * 0.01);
        }
        return res;
    }
}
