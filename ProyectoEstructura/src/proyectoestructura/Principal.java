/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        gestion.cargarVuelosPredefinidos();
        while (true) {
            int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Seleccione una opción:\n"
                    + "1. Agregar vuelo\n"
                    + "2. Mostrar vuelos\n"
                    + "3. Reservar asiento\n"
                    + "4. Cancelar asiento\n"
                    + "5. Mostrar asientos de un vuelo\n"
                    + "6. Mostrar asientos reservados de un vuelo\n"
                    + "7. Eliminar vuelo\n"
                    + "8. Salir"));

            switch (opcion) {
                case 1 ->
                    gestion.agregarVuelo();
                case 2 ->
                    gestion.mostrarVuelos();
                case 3 ->
                    gestion.reservarAsientoEnVuelo();
                case 4 ->
                    gestion.cancelarReservacion();
                case 5 ->
                    gestion.mostrarAsientosDeVuelo();
                case 6 ->
                    gestion.mostrarAsientosReservadosDeVuelo();
                case 7 ->
                    gestion.eliminarVuelo();
                case 8 ->
                    System.exit(0);
                default ->
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
