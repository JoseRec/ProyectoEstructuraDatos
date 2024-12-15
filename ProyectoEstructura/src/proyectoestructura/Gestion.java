/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class Gestion {

    private ListaVuelos listaVuelos;

    public Gestion() {
        this.listaVuelos = new ListaVuelos();
    }

    // Métodos para gestionar vuelos
    public void agregarVuelo() {
        int idVuelo = Integer.parseInt(JOptionPane.showInputDialog("ID del vuelo: "));
        String origen = JOptionPane.showInputDialog("Origen del vuelo: ");
        String destino = JOptionPane.showInputDialog("Destino del vuelo: ");
        ListaAsientos listaAsientos = new ListaAsientos();
        listaVuelos.agregar(idVuelo, origen, destino, listaAsientos);
        JOptionPane.showMessageDialog(null, "Vuelo agregado correctamente.");
    }

    public Vuelo buscarVuelo(int idVuelo) {
        Vuelo vuelo = listaVuelos.buscarVueloPorID(idVuelo);
        return vuelo;
    }

    public void mostrarVuelos() {
        listaVuelos.mostrarVuelosDisponibles();
    }

    public void eliminarVuelo() {
        listaVuelos.extraerVuelo();
    }

    // Métodos para gestionar asientos de un vuelo
    public void reservarAsientoEnVuelo() {
        int idVuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del vuelo: "));
        Vuelo vuelo = buscarVuelo(idVuelo);
        if (vuelo != null) {
            int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de asiento a reservar: "));
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pasajero:");
            String cedula = JOptionPane.showInputDialog("Ingrese la cedula del pasajero:");
            String correo = JOptionPane.showInputDialog("Ingrese el correo del pasajero:");
            String telefono = JOptionPane.showInputDialog("Ingrese el telefono del pasajero:");
            Persona p = new Persona(nombre, cedula, correo, telefono);

            vuelo.getAsientos().reservarAsiento(numeroAsiento, p);
        }
    }

    public void cancelarReservacion() {
        int idVuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del vuelo: "));
        Vuelo vuelo = buscarVuelo(idVuelo);

        if (vuelo != null) {
            int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de asiento a cancelar: "));
            vuelo.getAsientos().cancelarReservacion(numeroAsiento);
        }
    }

    public void mostrarAsientosDeVuelo() {
        int idVuelo = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del vuelo: "));
        Vuelo vuelo = buscarVuelo(idVuelo);

        if (vuelo != null) {
            vuelo.getAsientos().mostrarAsientos();
        }
    }

    public void mostrarAsientosReservadosDeVuelo() {
        int idVuelo = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID del vuelo: "));
        Vuelo vuelo = buscarVuelo(idVuelo);

        if (vuelo != null) {
            vuelo.getAsientos().mostrarAsientosReservados();
        }
    }

    public void cargarVuelosPredefinidos() {
        ListaAsientos listaAsientos1 = new ListaAsientos();
        listaVuelos.agregar(1, "San Jose", "Boston", listaAsientos1);
        
        ListaAsientos listaAsientos2 = new ListaAsientos();
        listaVuelos.agregar(2, "Boston", "Bogota", listaAsientos2);
        
        ListaAsientos listaAsientos3 = new ListaAsientos();
        listaVuelos.agregar(3, "Bogota", "Panama", listaAsientos3);
        
        ListaAsientos listaAsientos4 = new ListaAsientos();
        listaVuelos.agregar(4, "Panama", "San Jose", listaAsientos4);
    }
}
