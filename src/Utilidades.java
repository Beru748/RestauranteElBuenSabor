/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;

/**
 *
 * @author alfre
 */
public class Utilidades {

    public static double calcular(double precio, double cantidad, double descuento, double iva, double propina, boolean aplicaPropina) {
        // calcula el resultado
        double subTotal = precio * cantidad;
        
        //se le aplica un descuendo teniendo en cuenta el porcentaje
        if (descuento > 0) {
            subTotal = subTotal - (subTotal * descuento);
        }

        //Se calula el iva y despues la propina
        double total = subTotal + (subTotal * iva);

        if (aplicaPropina) {
            total = total + (total * propina);
        }
        return total;
    }

    public static boolean validar(List<Producto> pedido) {

        if (pedido == null || pedido.isEmpty()) {
            return false;
        }
        for (Producto p : pedido) {
            if (p.getCantidad() > 0) {
                return true;
            }
        }

        return false;
    }

    public static void reiniciar() {

        Datos.getMenu().forEach(p -> p.setCantidad(0));
        Datos.setEstadoMesa(0);
        Datos.setNumeroMesa(0);
    }
}
