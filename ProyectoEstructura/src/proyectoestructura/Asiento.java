/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

/**
 *
 * @author Jose
 */
public class Asiento {
    private int numAsiento;
    private boolean estado;
    private Persona persona;

    public Asiento(int numAsiento, boolean estado, Persona persona) {
        this.numAsiento = numAsiento;
        this.estado = estado;
        this.persona = persona;
    }
    
    public Asiento() {
        this.numAsiento = 0;
        this.estado = false;
        this.persona = null;
    }
    
    public int getNumAsiento() {
        return numAsiento;
    }

    public void setNumAsiento(int numAsiento) {
        this.numAsiento = numAsiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
