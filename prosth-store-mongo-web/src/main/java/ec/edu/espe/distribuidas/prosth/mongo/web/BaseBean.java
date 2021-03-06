/*
 * Protesis Store
 * Aplicaciones Distribuidas
 * NRC: 2434 
 * Tutor: HENRY RAMIRO CORAL CORAL 
 * 2017 (c) Protesis Store Corp.
 */
package ec.edu.espe.distribuidas.prosth.mongo.web;

import java.io.Serializable;

/**
 *
 * @author Protesis Store Corp.
 */
public class BaseBean implements Serializable{
    
    protected boolean enAgregar;
    protected boolean enModificar;
    protected boolean enDetalles;
    protected boolean enContacto;
    protected String titulo;

    public boolean isEnAgregar() {
        return enAgregar;
    }

    public boolean isEnModificar() {
        return enModificar;
    }

    public boolean isEnDetalles() {
        return enDetalles;
    }

    public boolean isEnContacto() {
        return enContacto;
    }
    public String getTitulo() {
        return titulo;
    }
    
    public void agregar() {
        this.enAgregar = true;
        this.titulo = "Agregar ";
    }
    
    public void modificar() {
        this.enModificar = true;
        this.titulo = "Modificar ";
    }
    
    public void detalles() {
        this.enDetalles = true;
        this.titulo = "Detalles - ";
    }
    public void contacto() {
        this.enContacto = true;
        this.titulo = "Contactos - ";
    }
    public void reset() {
        this.enAgregar = false;
        this.enModificar = false;
        this.enDetalles = false;
    }
    
    public boolean isHabilitaForm() {
        return this.enAgregar || this.enContacto || this.enModificar;
    }
}
