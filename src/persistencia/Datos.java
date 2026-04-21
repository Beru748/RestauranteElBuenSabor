package persistencia;

import java.util.ArrayList;
import java.util.List;
import dominio.Producto;

public class Datos {

    public final static String NOMBRE_RESTAURANTE = "RESTAURANTE EL BUEN SABOR";
    public final static String DIRECCION = "Calle 15 #8-32, Valledupar";
    public final static String NIT = "NIT: 900.123.456-7";

    private static List<Producto> menu = new ArrayList<>();

    public static int numeroMesa = 0;
    public static int estadoMesa = 0;
    public static double totalVenta = 0;
    public static int proximoNumeroFactura = 1;

    static {
        menu.add(new Producto("Bandeja Paisa", 32000, 0));
        menu.add(new Producto("Sancocho de Gallina", 28000, 0));
        menu.add(new Producto("Arepa con Huevo", 8000, 0));
        menu.add(new Producto("Jugo Natural", 7000, 0));
        menu.add(new Producto("Gaseosa", 4500, 0));
        menu.add(new Producto("Cervesa Poker", 6000, 0));
        menu.add(new Producto("Agua Panela", 3500, 0));
        menu.add(new Producto("Arroz con Pollo", 25000, 0));
    }

    public static List<Producto> getMenu() {
        return menu;
    }

    public static int getNumeroMesa() {
        return numeroMesa;
    }

    public static void setNumeroMesa(int mesa) {
        numeroMesa = mesa;
    }

    public static int getEstadoMesa() {
        return estadoMesa;
    }

    public static void setEstadoMesa(int estado) {
        estadoMesa = estado;
    }

    public static int generarNumeroFactura() {
        return proximoNumeroFactura++;
    }
}
