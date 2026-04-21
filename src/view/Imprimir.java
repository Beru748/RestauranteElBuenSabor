package view;
import java.util.List;

import dominio.Pedido;
import dominio.Producto;
import persistencia.Datos;

public class Imprimir {

    private static void imprimirCabeceraRestaurante() {
        System.out.println("========================================");
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION);
        System.out.println("    NIT: " + Datos.NIT);
        System.out.println("========================================");
    }

    public static void mostrarCarta() {
        System.out.println("========================================");
        System.out.println("    RESTAURANTE EL BUEN SABOR");
        System.out.println("    --- NUESTRA CARTA ---");
        System.out.println("========================================");

        List <Producto> menu = Datos.getMenu();
        
        for (int i = 0;i < menu.size(); i++ ) {
            Producto p = menu.get(i);
            System.out.printf("%d. %-20s $%,.0f%n", (i + 1), p.getNombre(), p.getPrecio());
        }
        System.out.println("========================================");
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("\n--- PEDIDO ACTUAL (Mesa " + pedido.getNumeroMesa() + ") ---");
        
        for (Producto p : pedido.getPedido()) {
            if (p.getCantidad() > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", p.getNombre(), p.getCantidad(), p.getSubtotal());
            }
        }
        System.out.println("--------------------");
        System.out.println("Subtotal:" + pedido.calcularSubtotal());
    }

    public static void imprimirFacturaCompleta(Pedido pedido, int numeroFactura) {
        imprimirCabeceraRestaurante();
        System.out.printf("FACTURA No. %03d%n", numeroFactura);
        System.out.println("----------------------");
        
        for (Producto p : pedido.getPedido()) {
            if (p.getCantidad() > 0) {
                System.out.printf("%-20s x%-6d $%,.0f%n", p.getNombre(), p.getCantidad(), p.getSubtotal());
            }
        }
        
        System.out.println("-------------------------");
        
        System.out.println("Subtotal:" + pedido.calcularSubtotal());
        
        double descuento = pedido.calcularDescuento();
        if (descuento > 0) {
            System.out.println("Descuento (5%):"+ -descuento);
        }
        
        System.out.println("IVA (19%):" + pedido.calcularIva());
        
        double propina = pedido.calcularPropina();
        if (propina > 0) {
            System.out.println("Propina (10%):" + propina);
        }
        
        System.out.println("----------------");
        System.out.println("TOTAL:" + pedido.calcularTotal());
        
        System.out.println("======================================================");
        System.out.println("Gracias por su visita!");
        System.out.println(Datos.NOMBRE_RESTAURANTE + " - Valledupar");
        System.out.println("======================================================");
        
    }
}
