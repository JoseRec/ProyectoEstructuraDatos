/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose
 */
public class ListaAsientos {

    private NodoListaSimple inicio;

    public ListaAsientos() {
        this.inicio = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarAsientosRandom() {
        Random r = new Random();
        int cantidad = r.nextInt(600 - 37 + 1) + 37;
        for (int i = 1; i <= cantidad; i++) {
            Asiento a = new Asiento(i, false, null);
            NodoListaSimple nuevo = new NodoListaSimple();
            nuevo.setAsiento(a);
            if (vacia()) {
                inicio = nuevo;
            } else if (a.getNumAsiento() < inicio.getAsiento().getNumAsiento()) {
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
            } else if (inicio.getSiguiente() == null) {
                inicio.setSiguiente(nuevo);
            } else {
                NodoListaSimple aux = inicio;
                while ((aux.getSiguiente() != null)
                        && (aux.getSiguiente().getAsiento().getNumAsiento() < a.getNumAsiento())) {
                    aux = aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
        }
    }

    public void reservarAsiento(int numeroAsiento, Persona p) {
        NodoListaSimple aux = inicio;
        boolean hay = false;
        while (aux != null) {
            if (aux.getAsiento().getNumAsiento() == numeroAsiento) {
                if (!aux.getAsiento().isEstado()) {
                    aux.getAsiento().setEstado(true);
                    aux.getAsiento().setPersona(p);
                    JOptionPane.showMessageDialog(null, "Asiento " + numeroAsiento + " reservado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Asiento " + numeroAsiento + " ocupado.");
                }
                hay = true;
                break;
            }
            aux = aux.getSiguiente();
        }

        if (!hay) {
            JOptionPane.showMessageDialog(null, "El asiento no existe.");
        }
    }
    
    public void cancelarReservacion(int numeroAsiento) {
        NodoListaSimple aux = inicio;
        boolean hay = false;
        while (aux != null) {
            if (aux.getAsiento().getNumAsiento() == numeroAsiento) {
                hay = true;
                if (aux.getAsiento().isEstado()) {
                    aux.getAsiento().setEstado(false);
                    aux.getAsiento().setPersona(null);
                    JOptionPane.showMessageDialog(null, "Asiento " + numeroAsiento + " cancelada correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Asiento " + numeroAsiento + " esta libre.");
                }
                break;
            }
            aux = aux.getSiguiente();
        }

        if (!hay) {
            JOptionPane.showMessageDialog(null, "El asiento con numero " + numeroAsiento + " no existe.");
        }
    }

    public void mostrarAsientosReservados() {
        NodoListaSimple aux = inicio;
        boolean hay = false;
        while (aux != null) {
            Asiento a = aux.getAsiento();
            if (a.isEstado() && a.getPersona() != null) {
                Persona persona = a.getPersona();
                System.out.println("----------------------------------------------");
                System.out.println("                 Asiento " + a.getNumAsiento() + ":");
                System.out.println("Nombre: " + persona.getNombre());
                System.out.println("Cedula: " + persona.getCedula());
                System.out.println("Correo electronico: " + persona.getCorreoElectronico());
                System.out.println("Nmero de Telefono: " + persona.getNumero());
                System.out.println("----------------------------------------------");
                hay = true;
            }
            aux = aux.getSiguiente();
        }
        if (!hay) {
            System.out.println("No hay reservas realizadas.");
        }
    }

    public void mostrarAsientos() {
        if (!vacia()) {
            NodoListaSimple aux = inicio;
            while (aux != null) {
                Asiento asiento = aux.getAsiento();
                String estado = "";
                if(asiento.isEstado()){
                    estado = "Ocupado";
                } else {
                    estado = "Libre";
                }
                System.out.println("Asiento " + asiento.getNumAsiento() + ": " + estado);
                aux = aux.getSiguiente();
            }
        } else {
            System.out.println("No hay asientos disponibles.");
        }
    }
}
