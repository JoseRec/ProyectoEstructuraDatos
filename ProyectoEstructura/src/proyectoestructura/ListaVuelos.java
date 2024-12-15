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
public class ListaVuelos {

    private NodoListaDobleCircular inicio;
    private NodoListaDobleCircular fin;

    public ListaVuelos() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean vacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar(int idVuelo, String origen, String destino, ListaAsientos lista) {
        
        if (buscarVueloPorID(idVuelo) != null) {
            JOptionPane.showMessageDialog(null, "No se puede agregar el vuelo porque ya hay uno existente.");
            return;
        }
        
        lista.agregarAsientosRandom();
        Vuelo v = new Vuelo(idVuelo, origen, destino, lista);
        NodoListaDobleCircular nuevo = new NodoListaDobleCircular();
        nuevo.setElemento(v);

        if (vacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (v.getID() < inicio.getElemento().getID()) {
            nuevo.setSiguiente(inicio);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (v.getID() > fin.getElemento().getID()) {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else {
            NodoListaDobleCircular aux = inicio;
            while (aux.getSiguiente().getElemento().getID() < v.getID()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }

    public void extraerVuelo() {
        if (!vacia()) {
            inicio = inicio.getSiguiente();
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
            JOptionPane.showMessageDialog(null, "Se ha extraido el vuelo");
        } else {
            JOptionPane.showMessageDialog(null, "Error a extraer: la lista esta vacia");
        }
    }

    public void mostrarVuelosDisponibles() {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "No hay vuelos disponibles.");
            return;
        }
        String s = " ";
        NodoListaDobleCircular aux = inicio;
        do {
            Vuelo v = aux.getElemento();
            s += "ID Vuelo: " + v.getID() + " / "
                    + "Origen: " + v.getOrigen() + " / "
                    + "Destino: " + v.getDestino() + " ↔ ";
            aux = aux.getSiguiente();
        } while (aux != inicio);

        JOptionPane.showMessageDialog(null, "Vuelos disponibles: \n\n" + s);
    }

    public Vuelo buscarVueloPorID(int idVuelo) {
        if (vacia()) {
            JOptionPane.showMessageDialog(null, "No hay vuelos disponibles.");
            return null;
        }
        NodoListaDobleCircular aux = inicio;
        while (true) {
            if (aux.getElemento().getID() == idVuelo) {
                return aux.getElemento();
            }
            aux = aux.getSiguiente();
            if (aux == inicio) {
                break;
            }
        }
        return null;
    }

}
