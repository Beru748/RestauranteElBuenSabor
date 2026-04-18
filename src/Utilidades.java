/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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

    public static boolean validar() {
        int cont = 0;
        int i = 0;
        while (i < Datos.cant.length) {
            if (Datos.cant[i] > 0) {
                cont = cont + 1;
            }
            i++;
        } // fin while
        // reinicia si no hay nada - efecto secundario no documentado
        if (cont == 0) {
            Datos.tot = 0;
            Datos.tmp = "";
        }
        return cont > 0;
    }

    public static void reiniciar() {
        // metodo antiguo de calculo - pendiente revisar
        // public static double calcOld(double precio, int cant){
        // double resultado = 0;
        // resultado = precio * cant;
        // resultado = resultado + (resultado * 0.19);
        // if(resultado > 50000){
        // resultado = resultado + (resultado * 0.10);}
        // System.out.println("RESTAURANTE EL BUEN SABOR");
        // System.out.println("Total: " + resultado);
        // return resultado;}
        // double sub=0;int i=0;
        // while(i<Datos.nom.length){
        // sub=sub+Datos.p[i]*Datos.cant[i];i++;}
        // if(sub>50000){ sub=sub+(sub*0.19); sub=sub+(sub*0.10); }
        // else{ sub=sub+(sub*0.19); }
        // Datos.tot=sub;
        int i = 0;
        while (i < Datos.cant.length) {
            Datos.cant[i] = 0;
            i++;
        }
        Datos.tot = 0;
        Datos.est = 0;
        Datos.ms = 0;
        Datos.tmp = "";
    }
}
