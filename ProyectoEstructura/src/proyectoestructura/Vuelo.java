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
public class Vuelo {
    private int id;
    private String origen;
    private String destino;
    private ListaAsientos asientos;

    public Vuelo(int id, String origen, String destino, ListaAsientos asientos) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.asientos = asientos;
    }

    public Vuelo() {
        this.id = 0;
        this.origen = "";
        this.destino = "";
        this.asientos = null;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public ListaAsientos getAsientos() {
        return asientos;
    }

    public void setAsientos(ListaAsientos asientos) {
        this.asientos = asientos;
    }
    
    public void reservarAsiento(int numeroAsiento, Persona persona) {
        asientos.reservarAsiento(numeroAsiento, persona);
    }
    
    public void cancelarReservacion(int numeroAsiento){
        asientos.cancelarReservacion(numeroAsiento);
    }
    
    public void mostrarAsientosReservados(){
        asientos.mostrarAsientosReservados();
    }
    
    public void mostrarAsientos(){
        asientos.mostrarAsientos();
    }
    
     public void mostrarInformacion() {
         asientos.mostrarAsientos();
         JOptionPane.showMessageDialog(null, "\nID: " + this.id + "\nOrigen: " + this.origen + "\nDestino: " + this.destino);
     }
    
}
