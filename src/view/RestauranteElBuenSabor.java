package view;
import java.util.Scanner;

import dominio.Pedido;
import dominio.Producto;
import persistencia.Datos;

import java.util.List;

public class RestauranteElBuenSabor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pedido pedidoActual = new Pedido(); 
        boolean salir = false;

        System.out.println("========================================");
        System.out.println("    " + Datos.NOMBRE_RESTAURANTE);
        System.out.println("    " + Datos.DIRECCION);
        System.out.println("    NIT: " + Datos.NIT);
        System.out.println("========================================");

        while (!salir) {
            mostrarMenuOpciones();
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    Imprimir.mostrarCarta();
                    break;
                case 2:
                    procesarAgregarProducto(sc, pedidoActual);
                    break;
                case 3:
                    if (!pedidoActual.estaVacio()) {
                        Imprimir.mostrarPedido(pedidoActual);
                    } else {
                        System.out.println("\nNo hay productos en el pedido actual. Use la opcion 2.\n");
                    }
                    break;
                case 4:
                    if (!pedidoActual.estaVacio()) {
                        int numFactura = Datos.generarNumeroFactura();
                        Imprimir.imprimirFacturaCompleta(pedidoActual, numFactura);
                        
                        pedidoActual.vaciar(); 
                    } else {
                        System.out.println("\nNo se puede generar factura. El pedido esta vacio.\n");
                    }
                    break;
                case 5:
                    pedidoActual.vaciar();
                    System.out.println("\nMesa reiniciada. Lista para nuevo cliente.\n");
                    break;
                case 0:
                    salir = true;
                    System.out.println("\nHasta luego");
                    break;
                default:
                    System.out.println("\nOpción no valida. Seleccione entre 0 y 5.\n");
                    break;
            }
        }
        sc.close();
    }

    private static void mostrarMenuOpciones() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Seleccione una opcion: ");
    }

    private static void procesarAgregarProducto(Scanner sc, Pedido pedido) {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        List<Producto> menu = Datos.getMenu();
        
        System.out.print("Numero de producto (1-" + menu.size() + "): ");
        int indiceProducto = sc.nextInt();
        
        if (indiceProducto < 1 || indiceProducto > menu.size()) {
            System.out.println("Producto no existe. La carta tiene " + menu.size() + " productos.\n");
            return;
        }

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        if (cantidad <= 0) {
            System.out.println("Cantidad invalida. Ingrese un valor mayor a cero.\n");
            return;
        }

        if (!pedido.isEstado()) {
            System.out.print("Ingrese numero de mesa: ");
            int numMesa = sc.nextInt();
            pedido.iniciarMesa(numMesa > 0 ? numMesa : 1); 
        }

        Producto productoSeleccionado = menu.get(indiceProducto - 1);
        pedido.agregarProducto(productoSeleccionado, cantidad);
        
        System.out.println("Producto agregado al pedido.");
        System.out.println("  -> " + productoSeleccionado.getNombre() + " x" + cantidad + "\n");
    }
}