/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

/**
 *
 * @author Jose
 */
public class NodoListaDobleCircular {
    private Vuelo elemento;
    private NodoListaDobleCircular siguiente;
    private NodoListaDobleCircular anterior;

    public NodoListaDobleCircular() {
        this.siguiente = null;
        this.anterior = null;
    }

    public Vuelo getElemento() {
        return elemento;
    }

    public void setElemento(Vuelo elemento) {
        this.elemento = elemento;
    }


    public NodoListaDobleCircular getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaDobleCircular siguiente) {
        this.siguiente = siguiente;
    }

    public NodoListaDobleCircular getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDobleCircular anterior) {
        this.anterior = anterior;
    }
}
